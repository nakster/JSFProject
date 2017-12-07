package com.geog.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.geog.Model.City;
import com.geog.Model.Country;
import com.geog.Model.Region;

public class RegionDao {
	
private DataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public RegionDao() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/geography";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	//show all regions 
	public ArrayList<Region> loadRegions() throws Exception {
		ArrayList<Region> regionList = new ArrayList<Region>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from region";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String reg_name = myRs.getString("reg_name");
			String reg_desc = myRs.getString("reg_desc");

			// create new student object
			Region region = new Region(co_code,reg_code, reg_name,reg_desc);

			regionList.add(region);
		}	
		myRs.close();
		myStmt.close();
		return regionList;
	}
	//add a region to the database
	public void addRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into region values (?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, region.getCoCode());
		myStmt.setString(2, region.getRegCode());
		myStmt.setString(3, region.getRegName());
		myStmt.setString(4, region.getRegDesc());
		myStmt.execute();			
	}
	//delete a region of the database
	public void deleteRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from region where reg_code like ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, region.getRegCode());
		myStmt.execute();			
	}
	//delete a region of the database
	public void updateRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "delete from region where reg_code like ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, region.getRegCode());
		myStmt.execute();			
	}

}
