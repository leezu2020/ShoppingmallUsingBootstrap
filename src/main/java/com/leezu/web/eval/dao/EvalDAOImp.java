package com.leezu.web.eval.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.eval.entity.Eval;

@Repository
public class EvalDAOImp implements IEvalDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";


	public void addEval(Eval eval) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".addEval", eval);
	}


	public List<Eval> getEvalList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getEvalList", id);
	}


	public void delEvalByProductId(Integer productId) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delEvalByProductId", productId);
	}


	public int getEvalCnt(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getEvalCnt", id);
	}

}
