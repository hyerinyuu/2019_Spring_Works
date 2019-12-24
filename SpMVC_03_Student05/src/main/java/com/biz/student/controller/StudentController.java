package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.domain.StudentVO;
import com.biz.student.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/student")
@Controller
public class StudentController {
	
	
	//@Inject : javaEE(EJB)에서 제공하는 기능
	@Autowired  // springframework의 고유 기능
	// 이미 생성(초기화)되어서 container에 보관중인 studentService의 instance를 가져다가
	// sService를 사용할 수 있도록 만들어 주는 역할
	StudentService sService;
	
	/*
	 * studentService의 getStdList() method를 호출하여
	 * 학생정보가 담긴 List를 가져오고
	 * view화면에 rendering할 수 있도록 공급하기
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY", "STUDENT-LIST");
		List<StudentDTO> stdList = sService.getStdList();

		model.addAttribute("STDLIST", stdList);
		
		log.debug("여기는 학생 컨트롤러");
		// return null; // "/student.list.jsp"
		return "home";
	}
	
	@RequestMapping(value="/list/vo", method=RequestMethod.GET)
	public String list(Model model, String s) {
		
		model.addAttribute("BODY", "STUDENT-LIST");
		List<StudentVO> stdList = sService.getStdAllLis();

		model.addAttribute("STDLIST", stdList);
		
		log.debug("여기는 학생 컨트롤러");
		// return null; // "/student.list.jsp"
		return "home";
	}
	
	
}
