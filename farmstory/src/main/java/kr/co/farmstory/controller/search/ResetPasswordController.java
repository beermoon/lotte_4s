package kr.co.farmstory.controller.search;

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

@WebServlet("/search/resetPassword.do")
public class ResetPasswordController extends HttpServlet{

	private static final long serialVersionUID = -1737697803147669951L;
	
	private UserService service = UserService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId"); // 로그인 전이라서 세션정보가 없기때문에 필요하다
		
		req.setAttribute("uid", userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/search/reset-password.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass1");
		
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		
		int result = service.modifyUserPass(dto);
		
		req.setAttribute("result", result);
		
		if(result > 0) {
			resp.sendRedirect("/farmstory/user.login.do");
		}
	}
}
