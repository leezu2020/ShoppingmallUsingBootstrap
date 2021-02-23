package com.leezu.web.controller.admin;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;
import com.leezu.web.product.service.IProductService;

@Controller("adminProductController")
@RequestMapping("/admin/")
public class ProductController {
	
	@Autowired
	private ServletContext ctx;
	
	@Inject
	private IProductService prodService;
	
	@RequestMapping("productList")
	public String productList(Model model,
			@RequestParam(defaultValue = "all") String size,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int minprice,
			@RequestParam(defaultValue = "2147483647") int maxprice) throws Exception {
		model.addAttribute("productList", prodService.getList(keyword, size, minprice, maxprice));
		System.out.println("productList 조회");
		return "admin.product.productList";
	}
	
	@RequestMapping("productDetail")
	public String productDetail(Model model, String id) {
		int ID = Integer.parseInt(id);
		System.out.println(ID);
		model.addAttribute("product", prodService.get(ID));
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
		
		preProduct product = new preProduct(name, intprice, description, size, fileName, intea); 
		
		prodService.regProduct(product);
		
		return "redirect:productList";
	}
	
	@GetMapping("delProduct")
	public String delProduct(@RequestParam(required=false)Integer id,
			@RequestParam(required=false)List<Integer> productChecked) {
		
		if(id != null)
			prodService.delProductById(id);
		
		if(productChecked != null) {
			for(Integer productId : productChecked) {
				prodService.delProductById(productId);
			}
		}
		
		return "redirect:productList";
	}
	
	@GetMapping("modProduct")
	public String modProduct(String id, Model model) {
		
		model.addAttribute("product", prodService.get(Integer.parseInt(id)));
		
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
		prodService.modProduct(product);
		
		return "redirect:productDetail?id="+product.getProductID();
	}
}
