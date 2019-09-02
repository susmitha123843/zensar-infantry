package com.facebook3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebook3.entity.FacebookEmployee;

public class FacebookDAO implements FacebookDAOInterface {
	private FacebookDAO() {
		
	}

	public static FacebookDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new FacebookDAO();
	}

	@Override
	public int createObject(FacebookEmployee fe) {
		
		int i=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into facebookemployee values(?,?,?,?)");
			ps.setString(1, fe.getName());
			ps.setString(2, fe.getPassword());
			ps.setString(3, fe.getEmail());
			ps.setString(4, fe.getAddress());
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i ;
	}

}
