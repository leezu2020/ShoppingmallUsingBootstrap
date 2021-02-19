package com.leezu.web.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.notice.dao.NoticeDAOImp;
import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

@Service
public class NoticeServiceImp implements INoticeService {

	@Autowired
	private NoticeDAOImp noticeDAO;
	
	@Override
	public List<Notice> getList(PagingDAO paging) throws Exception {
		System.out.println("공지사항 목록 가져오기");
		return noticeDAO.getList(paging);
	}
	
	@Override
	public int getNoticeNum() {
		System.out.println("공지사항 수 가져오기");
		return noticeDAO.getNoticeNum();
	}

	@Override
	public Notice getNotice(int noticeID) throws Exception {
		System.out.println("공지사항 글 가져오기");
		return noticeDAO.getNotice(noticeID);
	}

	@Override
	public void regNotice(preNotice notice) {
		System.out.println("공지사항 등록");
		noticeDAO.regNotice(notice);
	}

	@Override
	public void modNotice(Notice notice) {
		System.out.println("공지사항 수정");
		noticeDAO.modNotice(notice);
	}

	@Override
	public Notice getPre(int id) {
		return noticeDAO.getPre(id);
	}

	@Override
	public Notice getNext(int id) {
		return noticeDAO.getNext(id);
	}

	@Override
	public void delNoticeById(int id) {
		// TODO Auto-generated method stub
		noticeDAO.delNoticeById(id);
	}

}
