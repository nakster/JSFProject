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
import com.geog.Model.Region;

public class CityDao {
	
private DataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public CityDao() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/geography";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	//show all cities 
	public ArrayList<City> loadCities() throws Exception {
		ArrayList<City> cityList = new ArrayList<City>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

//		String sql = "select * from city";
		String sql = "SELECT * FROM CITY "
				+ "INNER JOIN COUNTRY ON COUNTRY.CO_CODE = CITY.CO_CODE "
				+ "INNER JOIN REGION ON REGION.REG_CODE = CITY.REG_CODE";
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
			String countryName = myRs.getString("co_name");
			String reg_name = myRs.getString("reg_name");
			City city = new City(cty_code, co_code,reg_code,cty_name,population,isCoastal,areaKM, countryName, reg_name);
			//// create new student object
			//City city = new City(cty_code,co_code, reg_code,cty_name,population,isCoastal,areaKM);

			cityList.add(city);
		}	
		myRs.close();
		myStmt.close();
		return cityList;
	}
	
	//add a city to the database
	public void addCity(City city) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into city values (?, ?, ?, ?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, city.getCtycode());
		myStmt.setString(2, city.getCocode());
		myStmt.setString(3, city.getRegcode());
		myStmt.setString(4, city.getCtyname());
		myStmt.setInt(5, city.getPopulation());
		myStmt.setString(6, String.valueOf(city.getCoastal()));
		myStmt.setDouble(7, city.getAreaKM());
		myStmt.execute();			
	}
	
	//find city
	public void findCity(City city) {
		
		
		
		
	}
}
