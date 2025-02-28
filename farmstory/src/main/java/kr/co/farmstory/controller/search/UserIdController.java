package kr.co.farmstory.controller.search;

import java.io.IOException;

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

@WebServlet("/search/userId.do")
public class UserIdController extends HttpServlet{

	private static final long serialVersionUID = 3504820318656829516L;
	
	private UserService service = UserService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name"); // 이름
		String email = req.getParameter("email"); // 이메일

		UserDTO dto = new UserDTO(); // DTO 생성
		dto.setName(name);
		dto.setEmail(email);
		
		UserDTO userIdDTO = service.findUserId(dto); // ID찾기 DAO로 보내기
		
		String code = service.sendEmailCode(email); // 이메일 전송한 인증번호 반환
		
		HttpSession session = req.getSession(); // 인증번호 세션에 저장
		session.setAttribute("sessAuthCode", code);
		
		if(userIdDTO !=  null) { // userId가 있을 경우 sessionUid에 저장
			HttpSession sessionUid = req.getSession();
			sessionUid.setAttribute("sessUser", userIdDTO);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/search/find-id.jsp");
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