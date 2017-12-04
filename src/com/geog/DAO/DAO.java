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

public class DAO {
	private DataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/geography";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	//shows all the countries 
	public ArrayList<Country> loadProducts() throws Exception {
		ArrayList<Country> products = new ArrayList<Country>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from country";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String co_code = myRs.getString("co_code");
			String co_name = myRs.getString("co_name");
			String co_details = myRs.getString("co_details");

			// create new student object
			Country product = new Country(co_code,co_name, co_details);

			products.add(product);
		}	
		myRs.close();
		myStmt.close();
		return products;
	}
	
	public void addProduct(Country country) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into product values (?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, country.getCode());
		myStmt.setString(2, country.getName());
		myStmt.setString(3, country.getDetails());
		myStmt.execute();			
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
	
	//show all cities 
	public ArrayList<City> loadCities() throws Exception {
		ArrayList<City> cityList = new ArrayList<City>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from city";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String cty_code = myRs.getString("cty_code");
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String cty_name = myRs.getString("cty_name");	
			int population = myRs.getInt("population");			
			boolean isCoastal = myRs.getBoolean("isCoastal");
			double areaKM = myRs.getDouble("areaKM");
			
			// create new student object
			City city = new City(cty_code,co_code, reg_code,cty_name,population,isCoastal,areaKM);

			cityList.add(city);
		}	
		myRs.close();
		myStmt.close();
		return cityList;
	}



}
