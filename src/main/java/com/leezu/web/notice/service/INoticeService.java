package com.leezu.web.notice.service;

import java.util.List;

import com.leezu.web.notice.entity.Notice;

public interface INoticeService {
	
	// 게시판 목록 출력
	public List<Notice> getList() throws Exception;

	// 게시글 가져오기
	public Notice getNotice(int noticeID) throws Exception;
}
