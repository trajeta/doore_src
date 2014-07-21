package com.bit.java54th.softdrink.doore.dao;



public class CategoryVO {
	private int category_id;
	private String category_name;
	private String category_text1;
	private String category_text2;
	private String category_text3;
	private String category_last_update;
	
	public  CategoryVO(int category_id,String category_name,String category_text1,String category_text2,String category_text3){
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_text1 = category_text1;
		this.category_text2 = category_text2;
		this.category_text3 = category_text3;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_text1() {
		return category_text1;
	}
	public void setCategory_text1(String category_text1) {
		this.category_text1 = category_text1;
	}
	public String getCategory_text2() {
		return category_text2;
	}
	public void setCategory_text2(String category_text2) {
		this.category_text2 = category_text2;
	}
	public String getCategory_text3() {
		return category_text3;
	}
	public void setCategory_text3(String category_text3) {
		this.category_text3 = category_text3;
	}
	public String getCategory_last_update() {
		return category_last_update;
	}
	public void setCategory_last_update(String category_last_update) {
		this.category_last_update = category_last_update;
	}
	
	
	

}
