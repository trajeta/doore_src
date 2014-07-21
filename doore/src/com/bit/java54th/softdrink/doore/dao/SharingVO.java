package com.bit.java54th.softdrink.doore.dao;

public class SharingVO {

	public int getSharingID() {
		return sharingID;
	}

	public void setSharingID(int sharingID) {
		this.sharingID = sharingID;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public int getReturnCheck() {
		return returnCheck;
	}

	public void setReturnCheck(int returnCheck) {
		this.returnCheck = returnCheck;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	int sharingID;
	String startDay;
	String endDay;
	int returnCheck;
	int applicationID;
	int productID;

	public SharingVO(int sharingID, String startDay, String endDay,
			int returnCheck, int applicationID, int productID) {
		this.sharingID = sharingID;

		this.startDay = startDay;
		this.endDay = endDay;
		this.returnCheck = returnCheck;
		this.applicationID = applicationID;
		this.productID = productID;
	}

}
