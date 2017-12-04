package com.geog.Controller;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.geog.DAO.DAO;
import com.geog.Model.Country;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@SessionScoped
@ManagedBean
public class CountryController {
	
	ArrayList<Country> products;
	private DAO dao;

	public CountryController() {
		super();
		products = new ArrayList<Country>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CountryController(ArrayList<Country> products) {
		super();
		this.products = products;
	}

	public ArrayList<Country> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Country> products) {
		this.products = products;
	}
	
	
	public void loadCountry() throws Exception {
		products.clear();
		if (dao != null) {
			try {
				products = dao.loadProducts();
				System.out.println(products.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public String addCountry(Country product) {
		if (dao != null) {
			try {
				dao.addCountry(product);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Product ID " + product.getCode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Product " + product.getCode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}


}
