package com.biz.ems.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/props")
@RestController
public class PropsRestController {

	/*
	 * properties는 프로젝트의 여러 클래스들이 
	 * 공통적으로 사용하고자 특별히 저장해 놓은 변수들
	 * 
	 * properties로 등록한 프로젝트 변수를
	 * 프로젝트에서 참조하여 사용하는 방법
	 * 
	 *  @Value(문자열)
	 *  String(변수명)
	 *  ==> project에 등록된 properties를 참조하여 해당 문자열을 검색하고
	 *  	문자열이 검색되면 문자열 = 값 형식으로 저장된 곳에서 값을 가져와서 
	 *  	변수명에 저장하여 일반 문자열 변수처럼 사용할 수 있도록 해준다.
	 */
	
	// 얘네는 final 붙이면 안됨(@Required와 충돌함/required 안쓰면 가능) 대신 value Annotation을 붙여줌
	@Value("${naver.username}")
	private String naver_username;
	
	@Value("${mysql.user}")
	private String mysql_username;
	
	/*
	@Value("#{app_props['app.name']}")
	private String app_name;
	
	@Value("#{app_props['app.since']}")
	private String app_since;

	@Value("#{res_props['app.res.name']}")
	private String res_name;
	
	@Value("#{res_props['app.res.since']}")
	private String res_since;
	*/

	
	@RequestMapping(value="/system", method=RequestMethod.GET)
	public Properties system() {
		
		Properties props = System.getProperties();
		return props;
	}
	
	@RequestMapping(value="/enc", method=RequestMethod.GET)
	public String enc() {
		
		String ret = String.format("naver : %s, mysql : %s", naver_username, mysql_username);
		return ret;
		
	}
	
	/*
	@RequestMapping(value="/app", method=RequestMethod.GET)
	public String app() {
		
		String ret = String.format("app_name : %s, app_since : %s", app_name, app_since);
		return ret;
	}

	@RequestMapping(value="/res", method=RequestMethod.GET)
	public String res() {
		
		String ret = String.format("app_res_name : %s, app_res_since : %s", res_name, res_since);
		return ret;
	}
	*/
	
}
