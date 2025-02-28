package kr.co.farmstory.controller.search;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.UserService;

@WebServlet("/search/userId.do")
public class UserIdController extends HttpServlet{

	private static final long serialVersionUID = 3504820318656829516L;
	
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		String value = req.getParameter("value");
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/search/find-id.jsp");
		dispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		UserDTO dto = new UserDTO();
		dto.setName(name);
		dto.setEmail(email);
		
		UserDTO userDTO = service.searchUser(dto);
		
	}

}