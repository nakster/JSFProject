package com.geog.Model;

import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class Region {
	
	private String coCode;
	private String regCode;
	private String regName;
	private String regDesc;
	
	
	public Region() {
	}
	
	public Region(String coCode, String regCode, String regName, String regDesc) {
		super();
		this.coCode = coCode;
		this.regCode = regCode;
		this.regName = regName;
		this.regDesc = regDesc;
	}
	///////////getters and setters 
	public String getCoCode() {
		return coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getRegDesc() {
		return regDesc;
	}

	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}

}
