package com.leezu.web.eval.service;

import com.leezu.web.eval.entity.Eval;

public interface IEvalService {

	public void addEval(Eval eval);

	public Object getEvalList(String id);
	
}
