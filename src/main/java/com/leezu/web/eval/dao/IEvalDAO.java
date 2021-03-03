package com.leezu.web.eval.dao;

import java.util.List;

import com.leezu.web.eval.entity.Eval;

public interface IEvalDAO {
	public void addEval(Eval eval);
	
	public List<Eval> getEvalList(String id);
}
