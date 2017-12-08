package com.geog.DAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.geog.Model.headOfState;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {
	
	private MongoClient mongoC;
	MongoDatabase data;
	//for the users 
	MongoCollection<Document> MongDoc;
	private List<headOfState> headList;
	private headOfState instaceHead;
	
	
	public List<headOfState> loadStates() throws Exception{
		
		mongoC = new MongoClient();
		data = mongoC.getDatabase("headsOfStateDB");
		//name of the collection
		MongDoc = data.getCollection("headsOfState");
		headList = new ArrayList<headOfState>();	
		FindIterable<Document> dockable = MongDoc.find();
		
		
		for(Document docs:dockable){
			
			instaceHead = new headOfState();
			String id = docs.getString("_id");
			String headState = docs.getString("headOfState");
			
			instaceHead.setId(id);
			instaceHead.setHeadOfState(headState);
			
			headList.add(instaceHead);	
			System.out.println(id + headState);
			
		}		
		return headList;	
	}
	

}
