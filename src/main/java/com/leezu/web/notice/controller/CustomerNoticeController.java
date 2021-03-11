package com.leezu.web.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.paging.DAO.PagingDAO;

@Controller
@RequestMapping("/customer/")
public class CustomerNoticeController {

	@Autowired
	private INoticeService noticeService;
	
	@GetMapping("notices")
	public String noticeList(Model model, PagingDAO paging,
			
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String condition,
			
			@RequestParam(defaultValue = "1")int nowPage,
			@RequestParam(defaultValue = "5")int cntPerPage) throws Exception {
		
		
		System.out.println("갯수");
		int noticeNum = noticeService.getNoticeNum(condition, keyword);
		System.out.println("페이징");
		paging = new PagingDAO(noticeNum, nowPage, cntPerPage, condition, keyword);
		System.out.println("공지사항 어트리뷰트");
		model.addAttribute("noticeList", noticeService.getList(paging));
		System.out.println("페이지 어트리뷰트");
		model.addAttribute("page", paging);
		return "customer.notice.noticeList";
	}
	
	@RequestMapping("notice/{id}")
	public String noticedetail(Model model, @PathVariable int id) throws Exception{
		// 세부 내용 가져오기
		model.addAttribute("notice", noticeService.getNotice(id));
		// 이전글 다음글 Notice 가져오기
		model.addAttribute("pre", noticeService.getPre(id));
		model.addAttribute("next", noticeService.getNext(id));
		return "customer.notice.noticeDetail";
	}
	
}
