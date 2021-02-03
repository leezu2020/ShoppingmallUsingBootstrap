package com.leezu.web.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.notice.dao.NoticeDAOImp;
import com.leezu.web.notice.entity.Notice;

@Service
public class NoticeServiceImp implements INoticeService {

	@Autowired
	private NoticeDAOImp noticeDAO;
	
	@Override
	public List<Notice> getList() throws Exception {
		System.out.println("공지사항 목록 가져오기");
		return noticeDAO.getList();
	}

}
