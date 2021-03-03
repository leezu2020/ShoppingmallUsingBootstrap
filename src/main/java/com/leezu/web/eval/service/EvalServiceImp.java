package com.leezu.web.eval.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.eval.dao.EvalDAOImp;
import com.leezu.web.eval.entity.Eval;

@Service
public class EvalServiceImp implements IEvalService{
	
	@Autowired
	private EvalDAOImp evalDAO;
	
	@Override
	public void addEval(Eval eval) {
		// TODO Auto-generated method stub
		evalDAO.addEval(eval);
	}

	@Override
	public List<Eval> getEvalList(String id) {
		// TODO Auto-generated method stub
		return evalDAO.getEvalList(id);
	}

}
