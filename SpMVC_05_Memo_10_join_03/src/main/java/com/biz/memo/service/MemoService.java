package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.persistence.MemoDao;

//@Repository 를 사용할 수도 있다.
@Service
public class MemoService {

	@Autowired
	SqlSession sqlSession;
	
	MemoDao mDao;
	
	// service를 사용하려고 시도하면 sqlSession으로부터 MemoDao mapper를 추출하여
	// mDao 객체를 사용할 수 있도록 초기화 하라
	@Autowired
	public void getMapper() {
		mDao = sqlSession.getMapper(MemoDao.class);
	}

	public List<MemoDTO> getAllList() {
		// TODO 전체 메모 리스트를 DB로부터 가져와서 controller로 return
		return mDao.selectAll();
	}

	public List<MemoDTO> getSearchList(String m_subject) {
		// TODO 제목으로 검색하기
		MemoDTO memoDTO = MemoDTO.builder().m_subject(m_subject).build();
		return mDao.findBySearch(memoDTO);
	}

	public int insert(MemoDTO memoDTO) {
		return mDao.insert(memoDTO);
		
	}

	public MemoDTO getMemo(long m_seq) {

		MemoDTO memoDTO = mDao.findById(m_seq);
		return memoDTO;
	}

	public int update(MemoDTO memoDTO) {
		
		return mDao.update(memoDTO);
	}

	public int delete(long m_seq) {
		return mDao.delete(m_seq);
	}
	
	
}
