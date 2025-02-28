package kr.co.farmstory.controller.search;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.UserService;

@WebServlet("/search/password.do")
public class PasswordController extends HttpServlet{

	private static final long serialVersionUID = 2771122766910939326L;
	
	private UserService service = UserService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("uid"); // 아이디
		String email = req.getParameter("email"); // 이메일

		UserDTO dto = new UserDTO(); // DTO 생성
		dto.setName(uid);
		dto.setEmail(email);
		
		String userId= service.findUserPass(dto); // Pass 찾기 DAO로 보내기
		
		String code = service.sendEmailCode(email); // 이메일 전송한 인증번호 반환
		
		HttpSession session = req.getSession(); // 인증번호 세션에 저장
		session.setAttribute("sessAuthCode", code);
		
		req.setAttribute("uid", userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/search/find-password.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String authCode = req.getParameter("authCode");
		
		HttpSession session = req.getSession();
		String sessAuthCode = (String) session.getAttribute("sessAuthCode");
		
		if(authCode.equals(sessAuthCode)) {
			JsonObject json = new JsonObject();
			json.addProperty("result", 1);
			resp.getWriter().println(json);
		}else {
			JsonObject json = new JsonObject();
			json.addProperty("result",0);
			resp.getWriter().println(json);
		}
		
		
	}

}
