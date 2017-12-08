package com.geog.Controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geog.DAO.MongoDAO;
import com.geog.Model.headOfState;
import com.mongodb.MongoClient;

@ManagedBean
@SessionScoped
public class MongoController {
	
	ArrayList<headOfState> state;
	private MongoDAO dao;
	private headOfState instaceHead;
	
	
	public ArrayList<headOfState> getState() {
		
		dao = new MongoDAO();
		instaceHead =  new headOfState();
		System.out.println(instaceHead.getId());
		try {
			state = new ArrayList<headOfState>(dao.loadStates());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
