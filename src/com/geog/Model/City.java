package com.geog.Model;

public class City {
	
	private String cty_code;
	private String co_code;
	private String reg_code;
	private String cty_name;
	private int population;
	private boolean isCoastal;
	private double areaKM;
	
	public City(String cty_code, String co_code, String reg_code, String cty_name, int population, boolean isCoastal,
			double areaKM) {
		super();
		this.cty_code = cty_code;
		this.co_code = co_code;
		this.reg_code = reg_code;
		this.cty_name = cty_name;
		this.population = population;
		this.isCoastal = isCoastal;
		this.areaKM = areaKM;
	}

	public City() {
		super();
	}

	public String getCtycode() {
		return cty_code;
	}

	public void setCtycode(String cty_code) {
		this.cty_code = cty_code;
	}

	public String getCocode() {
		return co_code;
	}

	public void setCocode(String co_code) {
		this.co_code = co_code;
	}

	public String getRegcode() {
		return reg_code;
	}

	public void setRegcode(String reg_code) {
		this.reg_code = reg_code;
	}

	public String getCtyname() {
		return cty_name;
	}

	public void setCtyname(String cty_name) {
		this.cty_name = cty_name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isCoastal() {
		return isCoastal;
	}

	public void setCoastal(boolean isCoastal) {
		this.isCoastal = isCoastal;
	}

	public double getAreaKM() {
		return areaKM;
	}

	public void setAreaKM(double areaKM) {
		this.areaKM = areaKM;
	}
	
	
	
}
