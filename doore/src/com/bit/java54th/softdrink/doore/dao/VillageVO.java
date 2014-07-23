package com.bit.java54th.softdrink.doore.dao;

public class VillageVO {
	private int id;
	private String name;
	private String registry;

	public VillageVO(int id, String name, String registry) {
		this.id = id;
		this.name = name;
		this.registry = registry;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}
	
}
