package com.leezu.web.notice.service;

import java.util.List;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

public interface INoticeService {
	
	// 공지사항 목록 출력
	public List<Notice> getList(PagingDAO paging) throws Exception;

	// 공지사항 가져오기
	public Notice getNotice(int noticeID) throws Exception;

	// 공지사항 등록
	public void regNotice(preNotice notice) throws Exception;

	// 공지사항 개수 가져오기
	public int getNoticeNum();

	// 공지사항 수정하기
	public void modNotice(Notice notice);
}
