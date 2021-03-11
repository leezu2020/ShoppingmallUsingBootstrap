package com.leezu.web.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leezu.web.notice.entity.Notice;
import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.paging.DAO.PagingDAO;

@Controller("adminNoticeController")
@RequestMapping("/admin/")
public class AdminNoticeController {
	
	@Autowired
	private INoticeService noticeService;
	
	// 공지사항 목록 출력
	@GetMapping("notices")
	public String noticeList(Model model, PagingDAO paging,
			
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "") String condition,
			
			@RequestParam(defaultValue = "1")int nowPage,
			@RequestParam(defaultValue = "5")int cntPerPage) throws Exception {
		

		int noticeNum = noticeService.getNoticeNum(condition, keyword);

		paging = new PagingDAO(noticeNum, nowPage, cntPerPage, condition, keyword);

		model.addAttribute("noticeList", noticeService.getList(paging));
		model.addAttribute("page", paging);
		return "admin.notice.noticeList";
	}
	
	// 공지사항 세부 조회
	@GetMapping("notice/{id}")
	public String noticedetail(Model model, @PathVariable int id) throws Exception{
		model.addAttribute("notice", noticeService.getNotice(id));
		
		model.addAttribute("pre", noticeService.getPre(id));
		model.addAttribute("next", noticeService.getNext(id));
		return "admin.notice.noticeDetail";
	}
	
	// 공지사항 등록 페이지 이동
	@GetMapping("reg-notice")
	public String regNotice() {
		return "admin.notice.regNotice";
	}
	
	// 공지사항 등록
	@PostMapping("notice")
	public String regNotice(Notice notice, HttpSession session, RedirectAttributes rttr) throws Exception {
		noticeService.regNotice(notice);
		rttr.addFlashAttribute("result", "noticeRegSuccess");
		return "redirect:noticeList";
	}
	
	// 공지사항 수정
	@GetMapping("mod-notice")
	public String modNotice(Model model, int id) throws Exception {
		model.addAttribute("notice", noticeService.getNotice(id));
		return "admin.notice.modNotice";
	}
	
	@PutMapping("notice/{id}")
	public String modNotice(@PathVariable int id, Notice notice) {
		System.out.println("modnotice");
		noticeService.modNotice(notice);
		return "redirect:noticeDetail?id="+notice.getNoticeID();
	}
	
	// 공지사항 삭제
	@DeleteMapping("notice/{id}")
	public String delNotice(@RequestParam(required = false)Integer id,
			@RequestParam(required = false)List<Integer> noticeChecked) {
		System.out.println("delnotice");
		if(id != null)
			noticeService.delNoticeById(id);
		
		if(noticeChecked != null) {
			for(Integer noticeId : noticeChecked) {
				noticeService.delNoticeById(noticeId);
			}
		}
		return "redirect:noticeList";
	}
}
