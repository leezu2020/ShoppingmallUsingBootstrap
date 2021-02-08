package com.leezu.web.notice.service;

import java.util.List;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.preNotice;

public interface INoticeService {
	
	// 공지사항 목록 출력
	public List<Notice> getList() throws Exception;

	// 공지사항 가져오기
	public Notice getNotice(int noticeID) throws Exception;

	// 공지사항 등록
	public void regNotice(preNotice notice) throws Exception;

	// 공지사항 개수 가져오기
	public int getNoticeNum();
}
