package kr.co.farmstory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.dto.FileDTO;
import kr.co.farmstory.util.DBHelper;
import kr.co.farmstory.util.SQL;

public class CommunityDAO extends DBHelper {	
	private static final CommunityDAO INSTANCE = new CommunityDAO();
	public static CommunityDAO getInstance() {
		return INSTANCE;
	}
	private CommunityDAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertCommunity(CommunityDTO dto) {
		
		int no = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMUNITY);
			psmt.setString(1,dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			
			// 글 번호 조회 쿼리 실행
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return no;
	}
	
	public CommunityDTO selectCommunity(String no) {
		CommunityDTO dto = null;
		List<FileDTO> files = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMUNITY_WITH_FILE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				if(dto == null) {
					dto = new CommunityDTO();
					dto.setNo(rs.getInt(1));
					dto.setCate(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setComment(rs.getInt(5));
					dto.setFile(rs.getInt(6));
					dto.setHit(rs.getInt(7));
					dto.setWriter(rs.getString(8));
					dto.setRegip(rs.getString(9));
					dto.setWdate(rs.getString(10));
					dto.setNick(rs.getString(17));
				}
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFno(rs.getInt(11));
				fileDTO.setAno(rs.getInt(12));
				fileDTO.setoName(rs.getString(13));
				fileDTO.setsName(rs.getString(14));
				fileDTO.setDownload(rs.getInt(15));
				fileDTO.setRdate(rs.getString(16));
				files.add(fileDTO);				
			} // while end
			
			dto.setFiles(files);
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	public int selectCountCommunity() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_COUNT_COMMUNITY);
			if(rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	public List<CommunityDTO> selectAllCommunity(int start) {
		
		List<CommunityDTO> communitys = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ALL_COMMUNITY);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommunityDTO dto = new CommunityDTO();
				dto.setNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				communitys.add(dto);
			}
			closeAll();		
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return communitys;
	}// selectAllCommunity end
	
	public int selectCountCommunityBySearch(CommunityDTO communityDTO) {
		
		int count = 0;
		StringBuilder sql = new StringBuilder(SQL.SELECT_COUNT_COMMUNITY_FOR_SEARCH);
		
		if(communityDTO.getSearchType().equals("title")) {
			sql.append(SQL.WHERE_FOR_SEARCH_TITLE);
		}else if(communityDTO.getSearchType().equals("content")) {
			sql.append(SQL.WHERE_FOR_SEARCH_CONTENT);
		}else if(communityDTO.getSearchType().equals("writer")) {
			sql.append(SQL.JOIN_FOR_SEARCH_NICK);
			sql.append(SQL.WHERE_FOR_SEARCH_WRITER);	
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%"+communityDTO.getKeyword()+"%");
			logger.debug(psmt.toString());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);				
			}
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return count;
	}
	
	public List<CommunityDTO> selectAllCommunityBySearch(CommunityDTO communityDTO, int start) {
		
		List<CommunityDTO> communitys = new ArrayList<CommunityDTO>();
		
		StringBuilder sql = new StringBuilder(SQL.SELECT_ALL_COMMUNITY_BY_SEARCH);
		
		if(communityDTO.getSearchType().equals("title")) {
			sql.append(SQL.WHERE_FOR_SEARCH_TITLE);
			sql.append(SQL.ORDER_FOR_SEARCH);
			sql.append(SQL.LIMIT_FOR_SEARCH);			
		}else if(communityDTO.getSearchType().equals("content")) {
			sql.append(SQL.WHERE_FOR_SEARCH_CONTENT);
			sql.append(SQL.ORDER_FOR_SEARCH);
			sql.append(SQL.LIMIT_FOR_SEARCH);			
		}else if(communityDTO.getSearchType().equals("writer")) {
			sql.append(SQL.WHERE_FOR_SEARCH_WRITER);
			sql.append(SQL.ORDER_FOR_SEARCH);
			sql.append(SQL.LIMIT_FOR_SEARCH);			
		}
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%"+communityDTO.getKeyword()+"%");
			psmt.setInt(2, start);
			logger.debug(psmt.toString());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommunityDTO dto = new CommunityDTO();
				dto.setNo(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment(rs.getInt(5));
				dto.setFile(rs.getInt(6));
				dto.setHit(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				communitys.add(dto);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}			
		return communitys;		
	}
	
	
	
	public void updateCommunity(CommunityDTO dto) {
		
	}
	
	public void deleteCommunity(int no) {
		
	}
}