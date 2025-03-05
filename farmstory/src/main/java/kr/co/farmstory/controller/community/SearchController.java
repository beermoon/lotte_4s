package kr.co.farmstory.controller.community;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.dto.PageGroupDTO;
import kr.co.farmstory.service.CommunityService;

@WebServlet("/community/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 4384445431360960261L;

	private CommunityService service = CommunityService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String pg = req.getParameter("pg");
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		// DTO 생성
		CommunityDTO dto = new CommunityDTO();
		dto.setSearchType(searchType);
		dto.setKeyword(keyword);
		
		// 페이징 처리 관련 서비스 호출
		int total = service.getCountCommunityBySearch(dto);
		int lastPageNum = service.getLastPageNum(total);
		int currentPage = service.getCurrentPage(pg);		
		int start = service.getStartNum(currentPage);
		
		PageGroupDTO pageGroupDTO = service.getCurrentPageGroup(currentPage, lastPageNum);
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// 서비스 호출
		List<CommunityDTO> communitys = service.searchAllCommunity(dto, start);
						
		// 데이터 참조 공유
		req.setAttribute("communitys", communitys);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroupDTO", pageGroupDTO);
		req.setAttribute("searchType", searchType);
		req.setAttribute("keyword", keyword);
		
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/searchList.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}


