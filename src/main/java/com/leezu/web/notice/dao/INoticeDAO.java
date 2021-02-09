package com.leezu.web.notice.dao;

import java.util.List;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

public interface INoticeDAO {

	// 공지사항 목록 출력
	public List<Notice> getList(PagingDAO paging) throws Exception;
	
	// 공지사항 세부 조회
	public Notice getNotice(int noticeID) throws Exception;

	// 공지사항 개수 출력
	public int getNoticeNum();
	
	// 공지사항 등록
	void regNotice(preNotice notice);

	// 공지사항 수정
	void modNotice(Notice notice);

}
