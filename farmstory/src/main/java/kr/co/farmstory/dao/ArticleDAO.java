package kr.co.farmstory.dao;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.util.DBHelper;
import kr.co.farmstory.util.SQL;

public class ArticleDAO extends DBHelper{
	
	private static final ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}
	private ArticleDAO() {}
	
	public void insertArticle(ArticleDTO dto) {
	
		try {
			conn = getConnection();
            String sql = "INSERT INTO Article (title, content, file, writer, regip, wdate) VALUES (?, ?, ?, ?, ?, NOW())";
            psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
            psmt.setString(1,dto.getTitle());
            psmt.setString(2,dto.getContent());
            psmt.setString(3,dto.getFile());
            psmt.setString(4,"testUser");
            psmt.setString(5,"127.0.0.1");
            
           
            psmt.executeUpdate(); 
            closeAll();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
