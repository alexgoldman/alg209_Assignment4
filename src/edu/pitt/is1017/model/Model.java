package edu.pitt.is1017.model;

import java.util.Vector;
import java.sql.*;

public class Model {
	
	
	
	private Vector<ListItem> todoList;
	
	public Model(){
		todoList= new Vector<ListItem>();
	}
	
	public void addListItem(String text, int id){
		todoList.addElement(new ListItem(text, id));
	}
	
	public int addDatabaseItem(String text){
		int dataID=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Connecting to database...");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu:3306/alg209is1017","alg209is1017","alg209@pitt.edu");
			
			System.out.println(connection);
			
	        System.out.println("Creating statement...");
	        
	        

	        
			Statement statement = connection.createStatement();
			String insert = "INSERT INTO todoList(todoList) VALUES('"+text+"')";
			statement.executeUpdate(insert);
			System.out.println(insert);
			PreparedStatement stmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
	           while(rs.next()){
	            dataID = rs.getInt(1);
	            System.out.println(dataID);
	}
			
			
			/*
			String query = "CREATE TABLE ";
			Statement statement =  connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return dataID;
		
	}
	
	

	
	public void deleteListItem(int i){
		todoList.removeElement(i);
	}
	
	public void deleteDatabaseItem(int i){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Connecting to database...");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://sis-teach-01.sis.pitt.edu:3306/alg209is1017","alg209is1017","alg209@pitt.edu");
			
			System.out.println(connection);
			
	        System.out.println("Creating statement...");
	    
	        String delete = "DELETE FROM todoList WHERE id=("+(i)+")";
	        PreparedStatement stmt = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			
			Statement statement = connection.createStatement();

			

			String query  = "SELECT * FROM todoList";
			statement.executeQuery(query);
			
			
			statement.executeUpdate(delete);
			System.out.println(delete);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Vector<ListItem> getList(){
		return todoList;
	}
	


}
