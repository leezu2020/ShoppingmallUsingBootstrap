package com.leezu.web.notice.service;

import java.util.List;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.NoticeView;
import com.leezu.web.notice.entity.PrivateNotice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

public interface INoticeService {
	
	// 공지사항 목록 출력
	public List<NoticeView> getList(PagingDAO paging) throws Exception;

	// 공지사항 가져오기
	public Notice getNotice(int noticeID) throws Exception;

	// 공지사항 등록
	public void regNotice(preNotice notice) throws Exception;

	// 공지사항 개수 가져오기
	public int getNoticeNum(String condition, String keyword);

	// 공지사항 수정하기
	public void modNotice(Notice notice);

	// 공지사항 이전, 다음 제목 가져오기
	public Notice getPre(int id);
	public Notice getNext(int id);

	// 공지사항 삭제
	public void delNoticeById(int id);

	// 유저 개인 장바구니 공지사항 가져오기
	public List<PrivateNotice> getPrivateNotice(String userID);

	// 유저 개인 주문목록 공지사항 가져오기
	public List<PrivateNotice> getPrivateOrderNotice(String userID);
}
