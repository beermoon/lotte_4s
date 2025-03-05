package kr.co.farmstory.service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory.dao.UserDAO;
import kr.co.farmstory.dto.UserDTO;

public enum UserService {
	
	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private UserDAO dao = UserDAO.getInstance();
	
	public void registerUser(UserDTO dto) { // 회원가입
		dao.insertUser(dto);
	}
	
	public int countUser(String type, String value) { // 유효성
		return dao.selectCountUser(type, value); 
	}
	
	public UserDTO findUser(UserDTO dto) { // 로그인
		return dao.selectUser(dto);
	}
	
	public UserDTO findUserId(UserDTO dto) { // 아이디 찾기
		return dao.selectUserId(dto);
	}
	
	public String findUserPass(UserDTO dto) { // 비밀번호 찾기
		return dao.selectUserPass(dto);
	}
	
	public List<UserDTO> findAllUser() {
		return dao.selectAllUser();
	}

	public int modifyUserPass(UserDTO dto) { // 새 비밀번호 설정
		
		return dao.updateUserPass(dto);
	}
	


	public void modifyUser(UserDTO dto) {
		logger.debug(dto.toString());
		dao.updateUser(dto);
		
	}
	
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
	
	// 이메일 발송
	public String sendEmailCode(String receiver) {
		
		// 인증번호 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		// Gmail 기본정보
		String sender = "Feathermoon@gmail.com";
		String title = "jboard 인증코드 입니다.";
		String content = "<h1>인증코드는 " + code + "입니다.</h1>";
		String appPassword = "ixrp ntly zgft xkiv";
		
		// Gmail SMTP 서버 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Gmail SMTP 세션 생성
		Session gmailSession = Session.getInstance(prop, new Authenticator(){
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sender, appPassword);
			}
		});
		
		// 메일 발송
		Message message = new MimeMessage(gmailSession);
		
		try {
			message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=UTF-8");
			
			Transport.send(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ""+code; // 인증번호 반환
	}
	
	
}
	
	
