package com.leezu.web.notice.dao;

import java.util.List;

import com.leezu.web.notice.entity.Notice;

public interface INoticeDAO {

	// 게시판 목록 출력
	public List<Notice> getList() throws Exception;
}
