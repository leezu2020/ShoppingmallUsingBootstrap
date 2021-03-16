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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.eval.service.IEvalService;
import com.leezu.web.product.dto.ProductDto;
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
	public String productList(Model model, @RequestParam(defaultValue = "all") String size,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int minprice,
			@RequestParam(defaultValue = "2147483647") int maxprice) throws Exception {
		List<Product> list = productService.getList(keyword, size, minprice, maxprice);

		for (Product p : list) {
			p.setEvalAvg(productService.calEvalRateById(p.getProductID()));
		}
		model.addAttribute("productList", list);
		System.out.println("productList 조회");
		return "admin.product.productList";
	}

	@GetMapping("products/{id}")
	public String productDetail(Model model, @PathVariable int id) {
		String ID = Integer.toString(id);
		System.out.println("product ID : " + id);
		List<Eval> evalList = evalService.getEvalList(ID);
		int avgRate = productService.calEvalRateById(id);

		model.addAttribute("cnt", evalService.getEvalCnt(id));
		model.addAttribute("avgRate", avgRate);
		model.addAttribute("evalList", evalList);
		model.addAttribute("product", productService.get(id));
		return "admin.product.productDetail";
	}

	@GetMapping("products/form")
	public String regProduct() {
		return "admin.product.regProduct";
	}

	@PostMapping("products")
	public String regProduct(ProductDto productDto) {

		System.out.println(productDto.getProductID());
		
		String fileName = productDto.getFile().getOriginalFilename();
		long fileSize = productDto.getFile().getSize();
		System.out.printf("fileName : %s, fileSize : %d\n", fileName, fileSize);

		String webPath = "/resources/images";
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);

		try {
			new File(realPath).mkdir();
			realPath += File.separator + fileName;
			File saveFile = new File(realPath);
			productDto.getFile().transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		int intprice = Integer.parseInt(price);
//		int intea = Integer.parseInt(ea);

		Product product = new Product(0, productDto.getName(), productDto.getPrice(), productDto.getDescription(), productDto.getSize(), fileName, new Date(), 0, 0, productDto.getEa());

		productService.regProduct(product);

		return "redirect:products";
	}

	/*
	 * @DeleteMapping("product") public String
	 * delProduct(@RequestParam(required=false)Integer id,
	 * 
	 * @RequestParam(required=false)List<Integer> productChecked) {
	 * 
	 * if(id != null) productService.delProductById(id);
	 * 
	 * if(productChecked != null) { for(Integer productId : productChecked) { //
	 * 해당상품 후기 삭제 int cnt = evalService.getEvalCnt(productId); for(int i=0; i<cnt;
	 * i++) { evalService.delEvalByProductId(productId); } // 해당상품 삭제
	 * productService.delProductById(productId); } }
	 * 
	 * return "redirect:products"; }
	 */

	@DeleteMapping("products/{id}")
	public String delProduct(@PathVariable int id) {

		evalService.delEvalByProductId(id);
		productService.delProductById(id);

		return "admin.product.productList";
	}

	@GetMapping("products/{id}/form")
	public String modProduct(@PathVariable String id, Model model) {

		model.addAttribute("product", productService.get(Integer.parseInt(id)));

		return "admin.product.modProduct";
	}
	
	@ResponseBody
	@PostMapping(value="products/{id}/mod")
	public  String modProduct(@PathVariable int id, ProductDto productDto) {

		System.out.println("putmapping 상품 수정 시작");
		System.out.println("url id : " + id + " product id : " + productDto.getProductID());
//		System.out.println("product name : " + productDto.getName());

		
		Product product = new Product();
		product.setProductID(productDto.getProductID());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setSize(productDto.getSize());
		product.setEa(productDto.getEa());
		product.setDescription(productDto.getDescription());

		// 파일을 새로 추가했을경우
		if (productDto.getFile() != null) {
			String fileName = productDto.getFile().getOriginalFilename();
			long fileSize = productDto.getFile().getSize();
			System.out.printf("수정한 fileName : %s, fileSize : %d\n", fileName, fileSize);

			String webPath = "/resources/images";
			String realPath = ctx.getRealPath(webPath);
			System.out.printf("realPath : %s\n", realPath);

			try {
				new File(realPath).mkdir();
				realPath += File.separator + fileName;
				File saveFile = new File(realPath);
				productDto.getFile().transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setImageUrl(fileName);

		} else

		{ // 파일을 새로 추가하지 않았을 경우, 기존 파일 유지
			String originalUrl = productService.get(id).getImageUrl();
			product.setImageUrl(originalUrl);
		}

		product.setProductID(id);

		System.out.println("----product----");
		System.out.println(product.getName());
		System.out.println(product.getDescription());

		productService.modProduct(product);
		  
		  
		  System.out.println("modProduct 실행");
		 
		return Integer.toString(id);
	}
}
