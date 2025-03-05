package kr.co.farmstory.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.util.DBHelper;
import kr.co.farmstory.util.SQL;

public class UserDAO extends DBHelper{
	private static final UserDAO INSTANCE = new UserDAO(); 
	public static UserDAO getInstance() {return INSTANCE;}
	private UserDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getRegip());
			psmt.executeUpdate();
			closeAll();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public int  selectCountUser(String type, String value) {
		int count = 0;
		
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_USER);
		
		if(type.equals("uid")) {sql.append(SQL.WHERE_UID);} 
		else if(type.equals("nick")) {sql.append(SQL.WHERE_NICK);} 
		else if(type.equals("email")) {sql.append(SQL.WHERE_EMAIL);} 
		else if(type.equals("hp")) {sql.append(SQL.WHERE_HP);} 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, value); 
			rs = psmt.executeQuery();
			if(rs.next()) 
				count = rs.getInt(1); 
			closeAll();
		}catch(Exception e) {logger.error(e.getMessage());}
		return count;
	}
	
	public UserDTO selectUserId(UserDTO dto) { // 아이디 찾기
		int count = 0;
		UserDTO userDTO = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER_UID);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getEmail());
			rs = psmt.executeQuery();
			if(rs.next()) {
				userDTO = new UserDTO();
				userDTO.setUid(rs.getString(1));
				userDTO.setName(rs.getString(2));
				userDTO.setEmail(rs.getString(3));
				userDTO.setRegDate(rs.getString(4));
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return userDTO;
	}
	
	public String selectUserPass(String email) { // 비밀번호 찾기
		String uid = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER_PASS);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			if(rs.next()) {
				uid = rs.getString(1);
			}
			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return uid;
	}
	
	public UserDTO selectUser(UserDTO dto) {
		UserDTO userDTO = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			rs = psmt.executeQuery();
			if(rs.next()) {
				userDTO = new UserDTO();
				userDTO.setUid(rs.getString(1));
				userDTO.setPass(rs.getString(2));
				userDTO.setName(rs.getString(3));
				userDTO.setNick(rs.getString(4));
				userDTO.setEmail(rs.getString(5));
				userDTO.setHp(rs.getString(6));
				userDTO.setLevel(rs.getString(7));
				userDTO.setZip(rs.getString(8));
				userDTO.setAddr1(rs.getString(9));
				userDTO.setAddr2(rs.getString(10));
				userDTO.setRegip(rs.getString(11));
				userDTO.setRegDate(rs.getString(12));
				userDTO.setLeaveDate(rs.getString(13));
			}
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}
	
	public List<UserDTO> selectAllUser(){
		return null;
	}
	
	public int updateUserPass(UserDTO dto) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_USER_PASS);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getUid());
			result = psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateUser(UserDTO dto) {
	    try {
	        conn = getConnection();
	        psmt = conn.prepareStatement(SQL.UPDATE_USER);
	        psmt.setString(1, dto.getPass());
	        psmt.setString(2, dto.getName());
	        psmt.setString(3, dto.getNick());
	        psmt.setString(4, dto.getEmail());
	        psmt.setString(5, dto.getHp());
	        psmt.setString(6, dto.getZip());
	        psmt.setString(7, dto.getAddr1());
	        psmt.setString(8, dto.getAddr2());
	        psmt.setString(9, dto.getUid());
	        psmt.executeUpdate();
	        closeAll();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public void deleteUser(String uid) {
	    try {
	        conn = getConnection();
	        psmt = conn.prepareStatement(SQL.DELETE_USER);
	        psmt.setString(1, uid);
	        psmt.executeUpdate();
	        closeAll();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

