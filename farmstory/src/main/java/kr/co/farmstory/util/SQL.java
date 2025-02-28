package kr.co.farmstory.util;

public class SQL {
	
	// terms 
	public static final String SELECT_TERMS = "select * from `terms` where `no`=?";

	// user
	public static final String SELECT_COUNT_USER = "select COUNT(*) from `user` ";
	public static final String WHERE_UID = "where `uid`=?";
	public static final String WHERE_NICK = "where `nick`=?";
	public static final String WHERE_EMAIL = "where `email`=?";
	public static final String WHERE_HP = "where `hp`=?";
	public static final String DELETE_USER = "DELETE FROM users WHERE uid = ?";
	
	public static final String SELECT_USER = "select * from `user` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String INSERT_USER = "insert into `user` set "
											+ "`uid`=?,"
											+ "`pass`=SHA2(?, 256),"
											+ "`name`=?,"
											+ "`nick`=?,"
											+ "`email`=?,"
											+ "`hp`=?,"
											+ "`zip`=?,"
											+ "`addr1`=?,"
											+ "`addr2`=?,"
											+ "`regip`=?,"
											+ "`regDate`=NOW()";
	
	public static final String SEARCH_USER = "SELECT `name`, `uid`, `email`, `regDate` "
											+ "FROM `user` "
											+ "WHERE `name`=? AND `email`=?";
						
			
	
}
