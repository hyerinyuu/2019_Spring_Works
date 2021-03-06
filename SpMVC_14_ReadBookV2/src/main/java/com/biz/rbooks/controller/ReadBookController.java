package com.biz.rbooks.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.service.BookService;
import com.biz.rbooks.service.ReadBookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/rbook")
@Controller
public class ReadBookController {

	private final ReadBookService rBookService;
	private final BookService bService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<ReadBookVO> rBookList = rBookService.selectAll();
		model.addAttribute("RBOOKS", rBookList);
		return "rbooks/list";
	}
	
	
	// 독서록 추가 버튼을 입력했을때 rbooks/write로 넘어가서 입력form을 보여주기 위한 method(GET)
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		ReadBookVO rBookVO = new ReadBookVO();
		

		// Java 1.8이상에서 사용하는 날짜 class
		LocalDate localDate = LocalDate.now();
		String curDate = localDate.toString();
		
		// 시간을 시:분:초 만 보이도록 설정
		// HH가 대문자이면 24시간
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now();
		String curTime = localTime.format(dt).toString();
		
		rBookVO.setRb_date(curDate);
		rBookVO.setRb_stime(curTime);
		
		model.addAttribute("rBookVO", rBookVO);
		return "rbooks/input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ReadBookVO rBookVO) {
		int ret = rBookService.insert(rBookVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/view/{rb_seq}", method=RequestMethod.GET)
	public String view(@PathVariable("rb_seq") long rb_seq, Model model) {
		
		ReadBookVO rBookVO = rBookService.findBySeq(rb_seq);
		model.addAttribute("RBOOK", rBookVO);
		
		String b_code = rBookVO.getRb_bcode();
		BookVO bookVO = bService.findByBCode(b_code);
		
		model.addAttribute("BOOK", bookVO);
		
		List<ReadBookVO> rBookList = rBookService.findByBCode(b_code);
		model.addAttribute("RBOOKS", rBookList);
		
		return "rbooks/view";
	}
	
	@RequestMapping(value="/update/{rb_seq}", method=RequestMethod.GET)
	public String update(@PathVariable("rb_seq") long rb_seq, Model model) {
		
		ReadBookVO rBookVO = rBookService.findBySeq(rb_seq);
		model.addAttribute("rBookVO", rBookVO);
		
		return "rbooks/input";
	}
	
	@RequestMapping(value="/update/{rb_seq}", method=RequestMethod.POST)
	public String update(@ModelAttribute ReadBookVO rBookVO) {

		int ret = rBookService.update(rBookVO);
		return "redirect:/rbooks/list";
	}
	
	@RequestMapping(value="/delete/{rb_seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("rb_seq") String rb_seq) {
		
		int ret = rBookService.delete(Long.valueOf(rb_seq));
		
		return "redirect:/rbook/list";
	}
	
}
