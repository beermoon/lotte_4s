package kr.co.farmstory.controller.user;

import java.io.IOException;
import java.io.PrintWriter;


import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.farmstory.service.UserService;

@WebServlet("/user/check.do")
public class CheckController extends HttpServlet{

	private static final long serialVersionUID = -7352101126477426010L;
	private UserService service = UserService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String type = req.getParameter("type");
		String value = req.getParameter("value");
		
		int count = service.countUser(type, value);
		
		if(type.equals("email") && count == 0) {
			String code = service.sendEmailCode(value);
			
			HttpSession session = req.getSession();
			session.setAttribute("sessAuthCode", code);
		}
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count);
		
		PrintWriter writer = resp.getWriter();
		writer.println(json);
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
			json.addProperty("result", 0);
			resp.getWriter().println(json);
		}
		
	}
}
