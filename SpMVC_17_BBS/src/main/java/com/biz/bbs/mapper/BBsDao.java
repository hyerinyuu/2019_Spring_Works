package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.BBsVO;

public interface BBsDao {

	@Select("SELECT * FROM tbl_bbs ORDER BY bbs_date DESC, bbs_time DESC")
	public List<BBsVO> selectAll();
	
	public List<BBsVO> selectMain();
	
	@Select("SELECT * FROM tbl_bbs WHERE BBS_ID = #{bbs_id}")
	public BBsVO findById(long bbs_id);
	public void update(BBsVO bbsVO);
	public void insert(BBsVO bbsVO);
	
}
