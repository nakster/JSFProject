package com.geog.Controller;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.geog.DAO.DAO;
import com.geog.Model.City;
import com.geog.Model.Country;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
public class CityController {
	
	ArrayList<City> products;
	private DAO dao;

	public CityController() {
		super();
		products = new ArrayList<City>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CityController(ArrayList<City> products) {
		super();
		this.products = products;
	}

	public ArrayList<City> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<City> products) {
		this.products = products;
	}
	
	
	public void loadCountry() throws Exception {
		products.clear();
		if (dao != null) {
			try {
				products = dao.loadCities();
				System.out.println(products.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public String addProduct(Product product) {
//		if (dao != null) {
//			try {
//				dao.addProduct(product);
//				return "index";
//			} catch (MySQLIntegrityConstraintViolationException e) {
//				FacesMessage message = new FacesMessage("Error: Product ID " + product.getProductID() + " already exists");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			} catch (CommunicationsException e) {
//				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			} catch (Exception e) {
//				FacesMessage message = new FacesMessage("Error while trying to insert Product " + product.getProductID());
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			}
//		}
//		return null;
//	}


}
