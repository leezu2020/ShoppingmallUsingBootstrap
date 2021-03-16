package com.leezu.web.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.NoticeView;
import com.leezu.web.notice.entity.PrivateNotice;
import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.paging.DAO.PagingDAO;

@Repository
public class NoticeDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.noticeMapper";
	private static final String namespacePrivate = "com.leezu.mapper.privateNoticeMapper";
	
	// 게시판 목록 출력

	public List<NoticeView> getList(PagingDAO paging) throws Exception{
		return sqlSession.selectList(namespace + ".noticeList", paging);
	}

	public Notice getNotice(int noticeID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".noticeById", noticeID);
	}

	public void regNotice(Notice notice) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".regNotice", notice);
	}

	public int getNoticeNum(String condition, String keyword) {
		HashMap<String, String> key = new HashMap<String, String>();
		key.put("condition", condition);
		key.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".getNoticeNum", key);
	}

	public void modNotice(Notice notice) {
		sqlSession.update(namespace + ".modNotice", notice);
	}

	public Notice getPre(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getPre", id);
	}

	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getNext", id);
	}

	public void delNoticeById(int id) {
		sqlSession.delete(namespace + ".delNoticeById", id);
		
	}

	public List<PrivateNotice> getPrivateNotice(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespacePrivate + ".getPrivateNotice", userID);
	}

	public List<PrivateNotice> getPrivateOrderNotice(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespacePrivate + ".getPrivateOrderNotice", userID);
	}	
}
