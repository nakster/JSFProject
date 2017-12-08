package com.geog.Controller;

import java.util.ArrayList;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.geog.DAO.DAO;
import com.geog.DAO.RegionDao;
import com.geog.Model.Country;
import com.geog.Model.Region;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class RegionController {
	
	ArrayList<Region> regions;
	private RegionDao dao;

	public RegionController() {
		super();
		regions = new ArrayList<Region>();
		try {
			dao = new RegionDao();
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
	
	//add a region to database 
	public String addRegion(Region region) {
		if (dao != null) {
			try {
				dao.addRegion(region);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Product ID " + region.getCoCode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Product " + region.getCoCode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	public String deleteRegion(Region region){
		try {
			dao.deleteRegion(region);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list_regions.xhtml";
	}


}
