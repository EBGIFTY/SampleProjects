package com.pages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class SqlToJavaDB  {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/medicare";
			String username="admin";
			String password="admin";
			String img="./Image/Image.png";
			
			Connection cn=DriverManager.getConnection(url, username, password);
			String query="INSERT INTO Category (name, description,image_url,is_active) VALUES ('Cough Medicines', 'This is for dealing with Cough', 'Image.png', true)";
			
			PreparedStatement st=cn.prepareStatement(query);
			int rowsUpdated=st.executeUpdate();
			
			if(rowsUpdated>0) {
				System.out.println("New Category Added Successfully");
			}
			st.close();
			cn.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}
