package kr.co.farmstory.controller.community;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.dto.FileDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.CommunityService;
import kr.co.farmstory.service.FileService;

@WebServlet("/community/today-menu.do")
public class TodaymenuController extends HttpServlet{
	
private static final long serialVersionUID = 6702814985301369938L;
	


	private CommunityService service = CommunityService.INSTANCE;
	private FileService fileService = FileService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/today-menu.jsp");
		dispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트 데이터 수신 
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// 파일 업로드 서비스 호
		List<FileDTO> files = fileService.uploadFile(req);
		
		// DTO 생성 
		CommunityDTO dto = new CommunityDTO();
		dto.setCate(cate);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(files.size());
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		
		logger.debug(dto.toString());
		

		// 서비스 호출 
		int no = service.registeCommunity(dto);
		
		
		
		
		
		// 파일 등록 서비스 호출
				for(FileDTO fileDTO : files) {
					fileDTO.setAno(no);
					fileService.registeFile(fileDTO);
				}
				
		
		// 이동
		resp.sendRedirect("/farmstory/community/notices.do");
		
	}
}
