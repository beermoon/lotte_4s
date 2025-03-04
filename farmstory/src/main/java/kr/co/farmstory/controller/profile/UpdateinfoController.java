package kr.co.farmstory.controller.profile;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.UserDTO;

@WebServlet("/profile/updateinfo.do")
public class UpdateinfoController extends HttpServlet{

	private static final long serialVersionUID = -3568609080669717772L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
		
		
		req.setAttribute("sessUser", sessUser);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/profile/update-info.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("uid");
	}
	

}
