package kr.co.farmstory.service;

import java.util.List;

import kr.co.farmstory.dao.CommunityDAO;
import kr.co.farmstory.dto.CommunityDTO;
import kr.co.farmstory.dto.PageGroupDTO;

public enum CommunityService {
	
	INSTANCE;
	private CommunityDAO dao = CommunityDAO.getInstance();
	
	public int registeCommunity(CommunityDTO dto) {
		return dao.insertCommunity(dto);
	}
	
	public CommunityDTO findCommunity(String no) {
		return dao.selectCommunity(no);
	}
	
	public int getCountCommunity() {
		return dao.selectCountCommunity();
	}
	
	public List<CommunityDTO> findAllCommunity(int start) {
		return dao.selectAllCommunity(start);
	}
	
	public int getCountCommunityBySearch(CommunityDTO dto) {
		return dao.selectCountCommunityBySearch(dto);
	}
	
	public List<CommunityDTO> searchAllCommunity(CommunityDTO dto, int start) {
		return dao.selectAllCommunityBySearch(dto, start);
	}
	
	public void modifyCommunity(CommunityDTO dto) {
		dao.updateCommunity(dto);
	}
	
	public void deleteCommunity(int no) {
		dao.deleteCommunity(no);
	}
	
	// 마지막 페이지 번호 계산
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;	
		}
		return lastPageNum;
	}
	
	// 현재 페이지 번호 구하기 
	public int getCurrentPage(String pg) {
		
		int currentPage = 1; 
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	// 페이지 시작번호 구하기(LIMIT 용)
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	// 페이지 그룹 계산하기
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
		int currentPageGroup = (int) Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1; 
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum) {			
			pageGroupEnd = lastPageNum;
		}
		
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	// 페이지 시작번호 구하기
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;		
	}
	
}