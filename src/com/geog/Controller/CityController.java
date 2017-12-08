package com.geog.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.geog.DAO.CityDao;
import com.geog.DAO.DAO;
import com.geog.Model.City;
import com.geog.Model.Country;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class CityController {
	
	ArrayList<City> cities;
	private CityDao dao;
	private City city;

	public CityController() {
		super();
		cities = new ArrayList<City>();
		try {
			dao = new CityDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CityController(ArrayList<City> cities) {
		super();
		this.cities = cities;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	public void loadCities() throws Exception {
		cities.clear();
		if (dao != null) {
			try {
				cities = dao.loadCities();
				System.out.println(cities.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	
//	public String getCo_code() {
//		return city.getCocode();
//	}
//	
//	public void setCo_code(String co_code) {
//		city.setCocode(co_code);
//	}
//	
//	public String getCty_code() {
//		return city.getCtycode();
//	}
//	
//	public void setCty_code(String cty_code) {
//		city.setCtycode(cty_code);
//	}
//	
//	
//	public String displayCity(City city) {
//		this.city.setCocode(city.getCocode());
//		this.city.setCtyname(city.getCtyname());
//		return "display_city.xhtml";
//	}
	
	public String addCity(City city) {
		if (dao != null) {
			try {
				dao.addCity(city);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Product ID " + city.getCtycode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Product " + city.getCtycode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	public String displayCity(City city) {
		try {
			System.out.println(city.getCocode()+ ""+ city.getRegcode());
			this.city = city;
			//System.out.println("P=>" + city.toString());		
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Error: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		
		return "FullCityDetails";
	}
	
//	public String loadProduct(String productID) {
//		try {
//			cities = dao.loadProduct(productID);
//			System.out.println("P=>" + cities.toString());
//			return "view_product";
//		} catch (Exception e) {
//			FacesMessage message = new FacesMessage("Error: " + e.getMessage());
//			FacesContext.getCurrentInstance().addMessage(null, message);
//			return null;
//		}
//	}

}
