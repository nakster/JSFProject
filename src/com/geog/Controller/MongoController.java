package com.geog.Controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geog.DAO.MongoDAO;
import com.geog.Model.Country;
import com.geog.Model.headOfState;
import com.mongodb.MongoClient;

@ManagedBean
@SessionScoped
public class MongoController {
	
	ArrayList<headOfState> state;
	private MongoDAO dao;
	
	public MongoController() {
		state = new ArrayList<headOfState>();
		try {
			dao = new MongoDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MongoController(ArrayList<headOfState> state){
		super();
		this.state = state;
	}

	public ArrayList<headOfState> getHeadsOfState() {
		return state;
	}
	
	public ArrayList<headOfState> getState() {
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
	
	public void setState(ArrayList<headOfState> state) {
		this.state = state;
	}
	public MongoDAO getDao() {
		return dao;
	}
	public void setDao(MongoDAO dao) {
		this.dao = dao;
	}
	
	
	
	

}
