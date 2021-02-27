package com.leezu.web.notice.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.NoticeView;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

@Repository
public class NoticeDAOImp implements INoticeDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	// 게시판 목록 출력
	@Override
	public List<NoticeView> getList(PagingDAO paging) throws Exception{
		return sqlSession.selectList(namespace + ".noticeList", paging);
	}
	@Override
	public Notice getNotice(int noticeID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".noticeById", noticeID);
	}
	@Override
	public void regNotice(preNotice notice) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".regNotice", notice);
	}
	@Override
	public int getNoticeNum(String condition, String keyword) {
		HashMap<String, String> key = new HashMap<String, String>();
		key.put("condition", condition);
		key.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".getNoticeNum", key);
	}
	@Override
	public void modNotice(Notice notice) {
		sqlSession.update(namespace + ".modNotice", notice);
	}
	@Override
	public Notice getPre(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getPre", id);
	}
	@Override
	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getNext", id);
	}
	@Override
	public void delNoticeById(int id) {
		sqlSession.delete(namespace + ".delNoticeById", id);
		
	}
	@Override
	public List<String> getPrivateNotice(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getPrivateNotice", userID);
	}	
}
