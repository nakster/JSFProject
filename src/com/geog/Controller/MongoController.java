package com.geog.Controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geog.DAO.MongoDAO;
import com.geog.Model.Country;
import com.geog.Model.HeadOfState;
import com.mongodb.MongoClient;

@ManagedBean
@SessionScoped
public class MongoController {
	
	ArrayList<HeadOfState> state;
	private MongoDAO dao;
	
	public MongoController() {
		state = new ArrayList<HeadOfState>();
		try {
			dao = new MongoDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MongoController(ArrayList<HeadOfState> state){
		super();
		this.state = state;
	}

	public ArrayList<HeadOfState> getHeadsOfState() {
		return state;
	}
	
	public ArrayList<HeadOfState> getState() {
		if(dao != null) {
			try {
				state = dao.loadStates();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return state;
	}
	
	public void setState(ArrayList<HeadOfState> state) {
		this.state = state;
	}
	public MongoDAO getDao() {
		return dao;
	}
	public void setDao(MongoDAO dao) {
		this.dao = dao;
	}	

}
