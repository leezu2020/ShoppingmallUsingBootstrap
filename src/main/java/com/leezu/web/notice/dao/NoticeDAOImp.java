package com.leezu.web.notice.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.entity.preNotice;

@Repository
public class NoticeDAOImp implements INoticeDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	// 게시판 목록 출력
	@Override
	public List<Notice> getList() throws Exception{
		return sqlSession.selectList(namespace + ".noticeList");
	}
	@Override
	public Notice getNotice(int noticeID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".noticeById", noticeID);
	}
	@Override
	public void regNotice(preNotice notice) {
		// TODO Auto-generated method stub
		sqlSession.selectOne(namespace + ".regNotice", notice);
	}
	
}
