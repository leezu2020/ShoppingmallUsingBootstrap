package com.leezu.web.product.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@GetMapping("products")
	public String productList(Model model,
			@RequestParam(defaultValue = "all") String size,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int minprice,
			@RequestParam(defaultValue = "2147483647") int maxprice) throws Exception {
		List<Product> list = productService.getList(keyword, size, minprice, maxprice);
		
		for(Product p : list) {
			p.setEvalAvg(productService.calEvalRateById(p.getProductID()));
		}
		model.addAttribute("productList", list);
		System.out.println("productList 조회");
		return "admin.product.productList";
	}
	
	@GetMapping("product/{id}")
	public String productDetail(Model model, @PathVariable int id) {
		String ID = Integer.toString(id);
		System.out.println("product ID : " + id);
		List<Eval> evalList =  evalService.getEvalList(ID);
		int avgRate = productService.calEvalRateById(id);
		
		model.addAttribute("cnt", evalService.getEvalCnt(id));
		model.addAttribute("avgRate", avgRate);
		model.addAttribute("evalList", evalList);
		model.addAttribute("product", productService.get(id));
		return "admin.product.productDetail";
	}

	@GetMapping("reg-product")
	public String regProduct() {
		return "admin.product.regProduct";
	}
	
	@PostMapping("product")
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
		
		return "redirect:products";
	}
	
	@DeleteMapping("product")
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
		
		return "redirect:products";
	}
	
	@GetMapping("mod-product/{id}")
	public String modProduct(@PathVariable String id, Model model) {
		
		model.addAttribute("product", productService.get(Integer.parseInt(id)));
		
		return "admin.product.modProduct";
	}
	
	@PutMapping("product/{id}")
	public ModelAndView modProduct(@PathVariable String id, Product product, MultipartFile file, ModelAndView mv) {
		
		
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		// 파일을 새로 추가했을경우
		if(fileSize != 0) {
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
		} else {
			// 파일을 새로 추가하지 않았을 경우, 기존 파일 유지
			String originalUrl = productService.get(product.getProductID()).getImageUrl();
			product.setImageUrl(originalUrl);
		}
		productService.modProduct(product);
		
		// redirect 시 parameter(interceptor에서 오는 aside의 number) 숨기기
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("redirect:product/"+product.getProductID());
		redirectView.setExposeModelAttributes(false);
		
		mv.setView(redirectView);
		return mv;
	}
}
