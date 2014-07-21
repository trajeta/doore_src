package com.bit.java54th.softdrink.doore.dao;

import java.util.List;

public interface ProductDAO {
	public List<ProductVO> findAllProducts();	  // 모든 물품 가져오기
	public List<ProductVO> findIDProdcuts(int customer_id);		// customerid 값에대한 모든 물품 찾기
	public List<ProductVO> findProductByVillageID(int village_id); //물품을 마을아이디로 찾기 
	public ProductVO findProductByID(int product_id);// 물품을 물품 아이디로 찾기
	
	public CategoryVO findCategoryID(int category_id);// 카테고리 아이디로 카테고리 찾기
	
	public int createProduct(String product_name, byte[] product_picture,int customer_id,int category_id,
			String detail_text_1,String detail_text_2, String detail_text_3, String detail_decription,
			int village_id);   	//마을 페이지에서 물품입력
	
	public int createProduct(String product_name, byte[] product_picture,int customer_id,int category_id,
			String detail_text_1,String detail_text_2, String detail_text_3, String detail_decription);
					//메인 페이지에서 물품입력
	
	public int updateProduct(int product_id, String product_name, byte[] product_picture,
							String detail_field1,String detail_field2,String detail_field3,
							String detail_decription, int village_id);
							//물품 수정
	
	public int deleteProduct(int product_id);
							//물품 삭제
		


	
	
	
}
