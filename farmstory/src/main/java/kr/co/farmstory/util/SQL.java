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
	
	public static final String SELECT_USER_UID = "SELECT `name`, `uid`, `email`, `regDate` "
												+ "FROM `user` "
												+ "WHERE `name`=? AND `email`=?";
	public static final String SELECT_USER_PASS = "SELECT `uid` FROM `user` WHERE `email`=?;";
	public static final String SELECT_USER = "select * from `user` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String UPDATE_USER_PASS = "UPDATE `user` SET `pass`=SHA2(?,256) WHERE `uid` =?";
	
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
	// community
	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `Community`";
	public static final String SELECT_COUNT_COMMUNITY = "SELECT COUNT(*) FROM `Community`";
	public static final String SELECT_COMMUNITY_WITH_FILE = "select "
																+ "a.*,"
																+ "f.*,"
																+ "u.`nick` "
																+ "FROM `Community` AS a "
																+ "LEFT JOIN `file` AS f ON a.no = f.ano "
																+ "JOIN `user` AS u ON a.writer = u.uid "
																+ "where a.`no`=?";
			
	public static final String SELECT_ALL_COMMUNITY = "SELECT "
														+ "a.*,"
														+ "u.`nick` "
														+ "FROM `Community` AS a "
														+ "JOIN `user` AS u "
														+ "ON a.writer = u.uid "
														+ "ORDER BY `no` desc "
														+ "LIMIT ?, 10";
		
	public final static String SELECT_ALL_COMMUNITY_BY_SEARCH = "SELECT "
																	+ "a.*, "
																	+ "u.`nick` "
																	+ "FROM `Community` AS a "
																	+ "JOIN `user` AS u ON a.writer = u.uid ";
		
	public final static String SELECT_COUNT_COMMUNITY_FOR_SEARCH = "select count(*) from `Community` as a ";
	public final static String JOIN_FOR_SEARCH_NICK  = "JOIN `user` as u ON a.writer = u.uid ";
	public final static String WHERE_FOR_SEARCH_TITLE   = "WHERE `title` LIKE ? ";
	public final static String WHERE_FOR_SEARCH_CONTENT = "WHERE `content` LIKE ? ";
	public final static String WHERE_FOR_SEARCH_WRITER  = "WHERE `nick` LIKE ? ";	
	public final static String ORDER_FOR_SEARCH  = "ORDER BY `no` DESC ";
	public final static String LIMIT_FOR_SEARCH  = "LIMIT ?, 10";
															
												
	public static final String INSERT_COMMUNITY = "insert into `Community` set "
														+ "`cate`=?,"
														+ "`title`=?,"
														+ "`content`=?,"
														+ "`file`=?,"
														+ "`writer`=?,"
														+ "`regip`=?,"
														+ "`wdate`=NOW()";
		
		
		
		
		
		// comment
		public static final String INSERT_COMMENT = "insert into `comment` set "
													+ "`parent`=?,"
													+ "`content`=?,"
													+ "`file`=?,"
													+ "`writer`=?,"
													+ "`regip`=?,";
													
		
	
	public static final String SELECT_ALL_COMMENT_BY_PARENT = "SELECT "
																+ "c.*, "
																+ "u.`nick` "
																+ "FROM `comment` AS c "
																+ "JOIN `user` AS u ON c.writer = u.uid "
																+ "WHERE `parent`=? "
																+ "ORDER BY `cno` ASC";
	
	public static final String SELECT_COMMENT_BY_CNO = "SELECT "
														+ "c.*, "
														+ "u.`nick` "
														+ "FROM `comment` AS c "
														+ "JOIN `user` AS u ON c.writer = u.uid "
														+ "WHERE `cno`=?";
	
	// file
	public static final String INSERT_FILE = "insert into `file` set "
												+ "`ano`=?,"
												+ "`oName`=?,"
												+ "`sName`=?,"
												+ "`rdate`=NOW()";
	
	public final static String SELECT_FILE_BY_FNO = "select * from `file` where `fno`=?";
	public final static String UPDATE_FILE_DOWNLOAD_COUNT = "UPDATE `file` SET `download` = `download` + 1 WHERE `fno`=?";
	
			
}