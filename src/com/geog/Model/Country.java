package com.geog.Model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Country {
	
	private String co_code;
	private String co_name;
	private String co_details;
	
	public Country() {
	}	
	
	public Country(String code, String name,String details) {
		super();
		this.co_code = code;
		this.co_name = name;
		this.co_details = details;
	}
	
	public String getCode() {
		return co_code;
	}
	public void setCode(String code) {
		this.co_code = code;
	}
	//////////////////////
	public String getName() {
		return co_name;
	}
	public void setName(String description) {
		this.co_name = description;
	}
	/////////////////////////////
	public String getDetails() {
		return co_details;
	}
	public void setDetails(String description) {
		this.co_details = description;
	}
	
}
