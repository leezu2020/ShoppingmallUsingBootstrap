package com.leezu.web.notice.dao;

import java.util.List;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.NoticeView;
import com.leezu.web.notice.entity.PrivateNotice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

public interface INoticeDAO {

	// 공지사항 목록 출력
	public List<NoticeView> getList(PagingDAO paging) throws Exception;
	
	// 공지사항 세부 조회
	public Notice getNotice(int noticeID) throws Exception;

	// 공지사항 개수 출력
	public int getNoticeNum(String condition, String keyword);
	
	// 공지사항 등록
	public void regNotice(preNotice notice);

	// 공지사항 수정
	public void modNotice(Notice notice);

	// 공지사항 이전글 다음글 가져오기
	public Notice getPre(int id);
	public Notice getNext(int id);
	
	// 공지사항 삭제
	public void delNoticeById(int id);
	
	// 개인 장바구니 공지사항 가져오기
	public List<PrivateNotice> getPrivateNotice(String userID);
	
	// 개인 주문목록 공지사항 가져오기
	public List<PrivateNotice> getPrivateOrderNotice(String userID);
}
