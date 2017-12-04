package com.geog.Model;

public class Region {
	
	private String co_code;
	private String reg_code;
	private String reg_name;
	private String reg_desc;
	
	public Region(String co_code, String reg_code, String reg_name, String reg_desc) {
		super();
		this.co_code = co_code;
		this.reg_code = reg_code;
		this.reg_name = reg_name;
		this.reg_desc = reg_desc;
	}

	public Region() {
		super();
	}
	
	///////////getters and setters 
	public String getCode() {
		return co_code;
	}

	public void setCode(String co_code) {
		this.co_code = co_code;
	}

	public String getRegcode() {
		return reg_code;
	}

	public void setRegcode(String reg_code) {
		this.reg_code = reg_code;
	}

	public String getRegname() {
		return reg_name;
	}

	public void setRegname(String reg_name) {
		this.reg_name = reg_name;
	}

	public String getRegdesc() {
		return reg_desc;
	}

	public void setRegdesc(String reg_desc) {
		this.reg_desc = reg_desc;
	}

}
