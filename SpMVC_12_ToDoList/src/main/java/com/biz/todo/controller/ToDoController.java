package com.biz.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.service.ToDoService;

@Controller
public class ToDoController {
	
	// interface를 implement해서 사용하다가 version upgrade를 위해 extends해서 Service가 2개 이상이 되는 경우 사용함.
	// ToDoService interface를 toServiceV2를 객체로 toService라고 명명하여 사용하겠다는 의미
	@Autowired
	@Qualifier("toServiceV2")
	ToDoService toService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
	
		/*
		 * 팀프로젝트에서 Controller 개발자와 Service 개발자가 다를 경우,
		 * Service는 interface가 정의 되어 있기 때문에 
		 * 아직 기능은 구현되지 않았어도
		 * Controller 개발자는 당연히 Service의 method를 호출해 결과가 return 될 것이다 라고 계획하고
		 * 나머지 코드를 구현할 수 있게 된다.  
		 */
		List<ToDoList> todoList = toService.selectAll();
		model.addAttribute("todoList", todoList);
		return "home";
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public String insert(@ModelAttribute ToDoList toDoList, Model model) {
		
		int ret = toService.insert(toDoList);
		if(ret < 1) {
			model.addAttribute("INSERT_ERROR", "NOT_INSERT");
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value="complete", method=RequestMethod.GET)
	public String complete(@RequestParam("tdSeq") String strSeq, @RequestParam("tdComplete") String tdComplete) {
		
		toService.complete(strSeq, tdComplete);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="alarm", method=RequestMethod.GET)
	public String alarm(@RequestParam("tdSeq") String strSeq, @RequestParam("tdAlarm") String tdAlarm) {
		
		toService.alarm(strSeq, tdAlarm);
		return "redirect:/list";
	}
	
	
}
