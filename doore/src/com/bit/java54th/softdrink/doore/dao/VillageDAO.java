package com.bit.java54th.softdrink.doore.dao;

import java.util.List;


public interface VillageDAO {
	public List<VillageVO> getVillageByCustID(int customer_id);
	public void createVillage(int customer_id, String village_name);
	public void modifyVillage(int village_id, String village_name);
	public void deleteVillage(int village_id);
	public List<CustomerVO> viewVillageCust(int village_id);
	public void inviteCustomer(int customer_id, int village_id);
	public void deleteCustomer(int customer_id, int village_id);
	public List<CustomerVO> searchCustomer(String searchWord, int village_id);
	public void trustLeader(int customer_id, int village_id);
}