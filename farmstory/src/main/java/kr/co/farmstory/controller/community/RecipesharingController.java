package kr.co.farmstory.controller.community;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.service.CommentService;
import kr.co.farmstory.service.CommunityService;
import kr.co.farmstory.service.FileService;

@WebServlet("/community/recipe-sharing.do")
public class RecipesharingController extends HttpServlet{
	
private static final long serialVersionUID = 6702814985301369938L;


private CommentService commentService = CommentService.INSTANCE; 


private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/recipe-sharing.jsp");
		dispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		

		
		//이동
		resp.sendRedirect("/farmstory/community/recipe-sharing.do");

		
	}
}

	
	


