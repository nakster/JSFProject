package com.geog.Controller;

import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.geog.DAO.DAO;
import com.geog.Model.Country;
import com.geog.Model.Region;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
public class RegionController {
	
	ArrayList<Region> regions;
	private DAO dao;

	public RegionController() {
		super();
		regions = new ArrayList<Region>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RegionController(ArrayList<Region> regions) {
		super();
		this.regions = regions;
	}

	public ArrayList<Region> getProducts() {
		return regions;
	}

	public void setProducts(ArrayList<Region> regions) {
		this.regions = regions;
	}
	
	
	public void loadRegion() throws Exception {
		regions.clear();
		if (dao != null) {
			try {
				regions = dao.loadRegions();
				System.out.println(regions.size());
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
