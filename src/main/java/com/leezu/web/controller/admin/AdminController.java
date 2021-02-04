package com.leezu.web.controller.admin;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.leezu.web.product.service.IProductService;
import com.leezu.web.user.service.IUserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private ServletContext ctx;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IProductService prodService;

	@GetMapping("userList")
	public String userList(Model model) throws Exception {
		model.addAttribute("userList", userService.userList());
		System.out.println("userList 조회");
		return "admin.user.userList";
	}
	
	@RequestMapping("productList")
	public String productList(Model model) throws Exception {
		model.addAttribute("productList", prodService.getList());
		System.out.println("productList 조회");
		return "admin.product.productList";
	}

	@GetMapping("regProduct")
	public String regProduct() {
		return "admin.product.regProduct";
	}
	
	@PostMapping("regProduct")
	public String regProduct(String name, String price, String description, String size, MultipartFile file, HttpServletRequest request){
		
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
		
		prodService.regProduct(name, intprice, description, size, fileName);
		
		return "redirect:productList";
	}
	
	@GetMapping("eventList")
	public String eventList() throws Exception {
		return "admin.event.eventList";
	}
	
	@GetMapping("noticeList")
	public String noticeList() throws Exception {
		return "admin.notice.noticeList";
	}
}
