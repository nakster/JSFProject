package com.geog.Model;

public class headOfState {
	
	private String id;
	private String headOfState;
	
	public headOfState() {
		
	}

	public headOfState(String id, String headOfState) {
		super();
		this.id = id;
		this.headOfState = headOfState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
}
