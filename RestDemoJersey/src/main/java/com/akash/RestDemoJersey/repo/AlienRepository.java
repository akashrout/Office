package com.akash.RestDemoJersey.repo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.akash.RestDemoJersey.Alien;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AlienRepository {
	
	List<Alien> aliens;
	Connection con;
	
	public AlienRepository() {
		aliens = new ArrayList<>();
		
		Alien a1=new Alien();
		a1.setId(101);
		a1.setName("Akash");
		a1.setPoint(60);
		
		Alien a2=new Alien();
		a2.setId(102);
		a2.setName("niraj");
		a2.setPoint(50);
		
		Alien a3=new Alien();
		a3.setId(103);
		a3.setName("Abhishek");
		a3.setPoint(70);
		
		Alien a4=new Alien();
		a4.setId(104);
		a4.setName("Raghab");
		a4.setPoint(90);
		
		Alien a5=new Alien();
		a5.setId(109);
		a5.setName("abhi");
		a5.setPoint(85);
		
		aliens.add(a1);
		aliens.add(a2);
		aliens.add(a3);
		aliens.add(a4);
		aliens.add(a5);
		String url="jdbc:mysql://smartcity.chtvslcfju6w.us-east-2.rds.amazonaws.com:3306/Testing1?autoReconnect=true&useSSL=false";
		String user="chipmonk";
		String password="Ch!pm0nk";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection) DriverManager.getConnection(url, user, password);
				System.out.println("Db connected");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("classnot found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			
			} 
			
		
	}
	
	public List<Alien> getAliens(){
		return aliens;
	}
	public Alien getAlien(int id) {
		
		for(Alien a:aliens) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}
	public List<Alien> getDbAlien() {
		List<Alien> aliens=new ArrayList<>();
		String sql="SELECT * FROM Testing1.empdata;";
		try {
			Statement statement=(Statement) con.createStatement();
			ResultSet  resultSet= statement.executeQuery(sql);
			while (resultSet.next()) {
				Alien a=new Alien();
				a.setId(resultSet.getInt(1));
				a.setName(resultSet.getString(2));
				a.setAddr(resultSet.getString(3));
				aliens.add(a);
				System.out.println();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("statement error"); 
		}
		
		return aliens;
		
	}

	public Alien getcreate() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Testing1.empdata where id=104;";
		Alien a=new Alien();
		try {
			Statement statement=(Statement) con.createStatement();
			ResultSet  resultSet= statement.executeQuery(sql);
			if (resultSet.next()) {
				
				a.setId(resultSet.getInt(1));
				a.setName(resultSet.getString(2));
				a.setAddr(resultSet.getString(3));
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("statement error"); 
		}
		return a;	
		
		
	}
	public void create(Alien a1) {
		String sql="insert into Testing1.empdata values(?,?,?)";
		Alien a=new Alien();
		try {
			PreparedStatement st=(PreparedStatement) con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setString(3, a1.getAddr());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("statement error"); 
		}
	}
	

}
