package com.geog.DAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.geog.Model.HeadOfState;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {
	
	private MongoClient mongoC;
	private MongoDatabase data;
	
	public MongoDAO() {
		mongoC = new MongoClient();
		data = mongoC.getDatabase("test");
	}
	
	
	public ArrayList<HeadOfState> loadStates() throws Exception{
		MongoCollection<Document> MongDoc = data.getCollection("headsOfState");
		ArrayList<HeadOfState> headList = new ArrayList<HeadOfState>();
		FindIterable<Document> dockable = MongDoc.find();
		Gson gson = new Gson();
		
		for(Document docs:dockable){
			HeadOfState hos = gson.fromJson(docs.toJson(), HeadOfState.class);
			headList.add(hos);
		}		
		return headList;	
	}
	

}
