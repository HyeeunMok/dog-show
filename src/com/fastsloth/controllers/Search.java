package com.fastsloth.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		try {	
			String number = request.getParameter("number");
			String name = request.getParameter("dogname");
			String ownerName = request.getParameter("ownerName");
			String breed = request.getParameter("breed");
			String dogGroup = request.getParameter("dogGroup");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
				
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "root");
			
			String q = "SELECT * FROM dog_list"; 
					
		
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append("SELECT * FROM dog_list WHERE ");
			
			if(!number.equals("")){
				if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("EntryNumber") && !stringBuilder.toString().contains("Name") && 
						!stringBuilder.toString().contains("OwnerName") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("DogGroup"))) {
					stringBuilder.append("EntryNumber= '" + number + "'");
				} else {
					stringBuilder.append(" AND EntryNumber= '" + number + "'");
				}
			} 
			
			if(!name.equals("")){
				if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("EntryNumber") && !stringBuilder.toString().contains("Name") && 
						!stringBuilder.toString().contains("OwnerName") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("DogGroup"))) {
					stringBuilder.append("Name= '" + name + "'");
				} else {
					stringBuilder.append(" AND Name= '" + name + "'");
				}
			} 
			
			if(!ownerName.equals("")){
				if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("EntryNumber") && !stringBuilder.toString().contains("Name") && 
						!stringBuilder.toString().contains("OwneName") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("DogGroup"))) {
					stringBuilder.append("OwnerName= '" + ownerName + "'");
				} else {
					stringBuilder.append(" AND OwnerName= '" + ownerName + "'");
				}
			}  
			
			if(!breed.equals("")){
				if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("EntryNumber") && !stringBuilder.toString().contains("Name") && 
						!stringBuilder.toString().contains("OwnerName") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("DogGroup"))) {
					stringBuilder.append("Breed= '" + breed + "'");
				} else {
					stringBuilder.append(" AND Breed= '" + breed + "'");
				}
			}
			
			if(!dogGroup.equals("")){
				if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("EntryNumber") && !stringBuilder.toString().contains("Name") && 
						!stringBuilder.toString().contains("OwnerName") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("DogGroup"))) {
					stringBuilder.append("DogGroup= '" + dogGroup  + "'");
				} else {
					stringBuilder.append(" AND DogGroup= '" + dogGroup  + "'");
				}
			} 
			
			if(number.equals("") && name.equals("") && ownerName.equals("") && breed.equals("") && dogGroup.equals("")) {
				stringBuilder.delete(0, stringBuilder.length());
				stringBuilder.append("SELECT * FROM dog_list");
			}

			q = stringBuilder.toString();
			
			System.out.println(q);
			
			Statement st = conn.createStatement();
				
			ResultSet rs = st.executeQuery(q);	
			
			while(rs.next()) {
				Dog dog = new Dog();
				dog.setNumber(rs.getInt(1));
				dog.setName(rs.getString(2));
				dog.setOwnerName(rs.getString(3));
				dog.setBreed(rs.getString(4));
				dog.setGroup(rs.getString(5));
				dog.setGender(rs.getString(6));
				dog.setDogClass(rs.getString(7));
				dog.setDay1(rs.getString(8));
				dog.setDay2(rs.getString(9));
				dog.setDay3(rs.getString(10));
				
				if (rs.getString(8).equals("on")) {
					dog.setDay1("Fri");
				} else {
					dog.setDay1("");
				}
					
				if (rs.getString(9).equals("on")) {
					dog.setDay2("Sat");
				} else {
					dog.setDay2("");
				}
				
				if (rs.getString(10).equals("on")) {
					dog.setDay3("Sun");
				} else {
					dog.setDay3("");
				}
				
				dogs.add(dog);
			}
			
			request.setAttribute("dogs", dogs);
			
			//Request Dispatch to Search JSP
			request.getRequestDispatcher("viewList.jsp").forward(request, response);
			
		System.out.println("Connection Success");
		conn.close();
	} catch (Exception e) {
		System.out.println("Connection Failed");
		System.out.println(e);
	}
	
	}
}