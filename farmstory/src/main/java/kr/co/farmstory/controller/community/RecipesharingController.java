package kr.co.farmstory.controller.community;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.farmstory.dto.CommentDTO;
import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.service.CommentService;
import kr.co.farmstory.service.CommunityService;
import kr.co.farmstory.service.FileService;

@WebServlet("/community/recipesharing.do")
public class RecipesharingController extends HttpServlet{
	
private static final long serialVersionUID = 6702814985301369938L;

private CommunityService service = CommunityService.INSTANCE;
private CommentService commentService = CommentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String no = req.getParameter("no");
				
		// 글 조회 서비스 호출
		CommunityDTO communityDTO = service.findCommunity(no);
				
		// 댓글 조회 서비스 호출
		List<CommentDTO> comments = commentService.findAllComment(no);
				
		// 데이터 공유 참조
		req.setAttribute("communityDTO", communityDTO);
		req.setAttribute("comments", comments);
				
		// View forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/recipe-sharing.jsp");
		dispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

	
	


