package com.bit.java54th.softdrink.doore.dao;

public class ProductVO {
	private int product_id;
	private String product_name;
	private byte[] product_picture;
	private String product_registry;
	private String product_last_update;
	private int customer_id;
	private int category_id;
	private String detail_text_1;
	private String detail_text_2;
	private String detail_text_3;
	private String detail_decription;

	public ProductVO(int product_id, String product_name,
			byte[] product_picture, String product_registry,
			String product_last_update, int customer_id, int category_id
			,String detail_text_1,String detail_text_2,String detail_text_3, String detail_decription) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_picture = product_picture;
		this.product_registry = product_registry;
		this.product_last_update = product_last_update;
		this.customer_id = customer_id;
		this.category_id = category_id;
		this.detail_text_1 = detail_text_1;
		this.detail_text_2 = detail_text_2;
		this.detail_text_3 = detail_text_3;
		this.detail_decription=detail_decription;
	}

	public String getDetail_decription() {
		return detail_decription;
	}

	public void setDetail_decription(String detail_decription) {
		this.detail_decription = detail_decription;
	}

	public String getDetail_text_1() {
		return detail_text_1;
	}

	public void setDetail_text_1(String detail_text_1) {
		this.detail_text_1 = detail_text_1;
	}

	public String getDetail_text_2() {
		return detail_text_2;
	}

	public void setDetail_text_2(String detail_text_2) {
		this.detail_text_2 = detail_text_2;
	}

	public String getDetail_text_3() {
		return detail_text_3;
	}

	public void setDetail_text_3(String detail_text_3) {
		this.detail_text_3 = detail_text_3;
	}

	public String getProduct_last_update() {
		return product_last_update;
	}

	public void setProduct_last_update(String product_last_update) {
		this.product_last_update = product_last_update;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public byte[] getProduct_picture() {
		return product_picture;
	}

	public void setProduct_picture(byte[] product_picture) {
		this.product_picture = product_picture;
	}

	public String getProduct_registry() {
		return product_registry;
	}

	public void setProduct_registry(String product_registry) {
		this.product_registry = product_registry;
	}

	public int getProduct_id() {
		return product_id;
	}

}
