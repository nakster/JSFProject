package com.geog.DAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.geog.Model.headOfState;
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
	
	
	public ArrayList<headOfState> loadStates() throws Exception{
		MongoCollection<Document> MongDoc = data.getCollection("headsOfState");
		ArrayList<headOfState> headList = new ArrayList<headOfState>();
		FindIterable<Document> dockable = MongDoc.find();
		Gson gson = new Gson();
		
		for(Document docs:dockable){
			headOfState hos = gson.fromJson(docs.toJson(), headOfState.class);
			headList.add(hos);
		}		
		return headList;	
	}
	

}
