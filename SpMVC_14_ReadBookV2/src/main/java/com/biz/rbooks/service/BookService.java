package com.biz.rbooks.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.repository.BookDao;

import lombok.RequiredArgsConstructor;

/*
 * private final로 설정된 필드변수들의
 * 생성자를 생성하고 자동 inject(@Autowired)를 수행해준다.
 */
@RequiredArgsConstructor
@Service
public class BookService {

	// 필요한 interface를 private final로 선언하고 
	// RequiredArgsConstructor Annotation을 붙여주면
	// lombok이 알아서 inject해줌
	private final BookDao bookDao;

	public List<BookVO> selectAll(){
		return bookDao.selectAll();
	}
	
	public int insert(BookVO bookVO) {
	
		Random rnd = new Random();
		
		String b_code = rnd.nextGaussian() + "";
		
		bookVO.setB_code(b_code);
		bookVO.setB_name("연습하기");
		bookVO.setB_auther("홍길동");
		
		return bookDao.insert(bookVO);
	}

	public List<BookVO> findByBNames(String strText) {

		/*
		 * strText를 빈칸으로 분해해서 문자열 배열을 만들고
		 * 그 배열을 List<String> 형으로 변환한 다음 names List에 담아라
		 */
		List<String> names = Arrays.asList(strText.split(""));
		List<BookVO> bookList = bookDao.findByBNames(names);
		return bookList;

	}

	public BookVO findByBCode(String b_code) {
		return bookDao.findByBCode(b_code);
	}
	
	
}