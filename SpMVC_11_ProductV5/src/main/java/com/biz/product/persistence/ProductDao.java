package com.biz.product.persistence;

import java.util.List;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	
	public long proTotalCount();
	
	// offset부터 limit까지의 데이터만 추출하라
	public List<ProductDTO> selectPagination(PageDTO pageDTO);
	
	public ProductDTO findByPCode(String p_code);
	
	public List<ProductDTO> findByPNames(String p_name);
	
	//insert를 수행하기 위해 가장 마지막 pCode값을 가져오는 method
	public String getMaxPcode();
	
	public int insert(ProductDTO proDTO);
	public int update(ProductDTO proDTO);
	public int delete(String p_code);
	
}
