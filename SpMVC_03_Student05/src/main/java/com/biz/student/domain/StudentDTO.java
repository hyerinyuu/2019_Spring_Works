package com.biz.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 1. DB 설계를 수행한 후
 * 설계된 TABLE과 연계되는 DTO(vo)클래스를 선언
 * 
 * <추상화 단계> 
 * 객체지향에서 DTO, VO를 설계하는 단계
 * 실제상황에서 사용되는 데이터를 특징적인 부분들만 추출하여 특정한 클래스로 서례하는 단계
 * 
 *  학번, 학생이름, 학과, 학년, 전화번호, 주소, 담임교수
 *  st_num, st_name, st_dept, st_grade, st_tel, st_addr, st_pro
 *  
 */
@Getter
@Setter
@ToString
@NoArgsConstructor   // 모든 필드 생성자
@AllArgsConstructor  // super(기본)생성자
@Builder
public class StudentDTO {
	
	/*
	 * ST_NUM	VARCHAR2(3 BYTE)
	 * ST_NAME	NVARCHAR2(50 CHAR)
	 * ST_TEL	VARCHAR2(20 BYTE)
	 * ST_ADDR	NVARCHAR2(125 CHAR)
	 * ST_GRADE	NUMBER(1,0)
	 * ST_DEPT	VARCHAR2(3 BYTE)
	 */

	private String st_num;
	private String st_name;
	private String st_dept;
	private int st_grade;
	private String st_tel;
	private String st_addr;
	private String st_pro;
	
	
	
	
	
}
