package com.leezu.web.eval.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leezu.web.eval.entity.Eval;

@Repository
public class EvalDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.evalMapper";


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
