package com.leezu.web.product.service;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductService {
	// 상품 목록 출력
	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception;

	public void regProduct(preProduct product);

	public Product get(int id);

	// 상품 갯수
	public int getProductNum();

	// 상품 삭제
	public void delProductById(int id);
	
	// 상품 수정
	public void modProduct(Product product);

	// 상품 재고 수량 수정
	public void modProductCnt(HashMap<String, Object> map);

	// 상품 평가 수정
	public void modLike(Eval eval);

	// 상품 평가 평균값 가져오기
	public int calEvalRateById(int id);

}
