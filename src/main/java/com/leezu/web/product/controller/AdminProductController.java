package com.leezu.web.product.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.eval.service.IEvalService;
import com.leezu.web.product.entity.Product;
import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/admin/")
public class AdminProductController {
	
	@Autowired
	private ServletContext ctx;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IEvalService evalService;
	
	@GetMapping("productList")
	public String productList(Model model,
			@RequestParam(defaultValue = "all") String size,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int minprice,
			@RequestParam(defaultValue = "2147483647") int maxprice) throws Exception {
		List<Product> list = productService.getList(keyword, size, minprice, maxprice);
		
		for(Product p : list) {
			p.setEvalAvg(productService.calEvalRateById(p.getProductID()));
		}
		System.out.println(list.get(0).getEvalAvg());
		model.addAttribute("productList", list);
		System.out.println("productList 조회");
		return "admin.product.productList";
	}
	
	@GetMapping("productDetail")
	public String productDetail(Model model, String id) {
		int ID = Integer.parseInt(id);
		System.out.println("product ID : " + ID);
		List<Eval> evalList =  evalService.getEvalList(id);
		int avgRate = productService.calEvalRateById(ID);
		
		model.addAttribute("cnt", evalService.getEvalCnt(ID));
		model.addAttribute("avgRate", avgRate);
		model.addAttribute("evalList", evalList);
		model.addAttribute("product", productService.get(ID));
		return "admin.product.productDetail";
	}

	@GetMapping("regProduct")
	public String regProduct() {
		return "admin.product.regProduct";
	}
	
	@PostMapping("regProduct")
	public String regProduct(String name, String price, String description, String size, MultipartFile file, String ea){
		
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		System.out.printf("fileName : %s, fileSize : %d\n", fileName, fileSize);
		
		String webPath = "/resources/images";
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);
		
		try {
			new File(realPath).mkdir();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
		} catch(Exception e){
			e.printStackTrace();
		}
		int intprice = Integer.parseInt(price);
		int intea = Integer.parseInt(ea);
		
		Product product = new Product(0, name, intprice, description, size, fileName, new Date() , 0, 0, intea); 

		productService.regProduct(product);
		
		return "redirect:productList";
	}
	
	@GetMapping("delProduct")
	public String delProduct(@RequestParam(required=false)Integer id,
			@RequestParam(required=false)List<Integer> productChecked) {
		
		if(id != null)
			productService.delProductById(id);
		
		if(productChecked != null) {
			for(Integer productId : productChecked) {
				// 해당상품 후기 삭제
				int cnt = evalService.getEvalCnt(productId);
				for(int i=0; i<cnt; i++) {
					evalService.delEvalByProductId(productId);
				}
				// 해당상품 삭제
				productService.delProductById(productId);
			}
		}
		
		return "redirect:productList";
	}
	
	@GetMapping("modProduct")
	public String modProduct(String id, Model model) {
		
		model.addAttribute("product", productService.get(Integer.parseInt(id)));
		
		return "admin.product.modProduct";
	}
	
	@PostMapping("modProduct")
	public String modProduct(Product product, MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		System.out.printf("수정한 fileName : %s, fileSize : %d\n", fileName, fileSize);
		
		String webPath = "/resources/images";
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);
		
		try {
			new File(realPath).mkdir();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
		} catch(Exception e){
			e.printStackTrace();
		}
		product.setImageUrl(fileName);
		productService.modProduct(product);
		
		return "redirect:productDetail?id="+product.getProductID();
	}
}
