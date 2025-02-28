package kr.co.farmstory.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.UserService;

@WebServlet("/user/login.do")
public class LoginCotroller extends HttpServlet{

	private static final long serialVersionUID = 6702814985301369927L;
	
	private UserService service = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/login.jsp");
		dispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		
		UserDTO userDTO = service.findUser(dto);
		
		if(userDTO != null) {
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", userDTO);
			
			resp.sendRedirect("/farmstory/main/main.do");
			
		}else {
			resp.sendRedirect("/farmstory/user/login.do");
		}
	}
}
