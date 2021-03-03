package com.leezu.web.eval.service;

import java.util.List;

import com.leezu.web.eval.entity.Eval;

public interface IEvalService {

	public void addEval(Eval eval);

	public List<Eval> getEvalList(String id);
	
}
