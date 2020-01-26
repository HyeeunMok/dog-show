package com.fastsloth.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;
import com.fastsloth.dao.DAO;

@WebServlet("/EditDog")
public class EditDog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("dogName");
		String ownerName = request.getParameter("ownerName");
		String breed = request.getParameter("breed");
		String group = request.getParameter("group");
		String gender = request.getParameter("genderChoice");
		String dogClass = request.getParameter("classChoice");
		String day1 = request.getParameter("day1");
		String day2 = request.getParameter("day2");
		String day3 = request.getParameter("day3");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String membership = "member";
		System.out.println(number);
		
		if (day1==null) {
			day1 = "off";
		}
		
		if (day2==null) {
			day2 = "off";
		}
		
		if (day3==null) {
			day3 = "off";
		}
		
        Dog d = new Dog();
        d.setNumber(number);
        d.setName(name);  
        d.setOwnerName(ownerName);
        d.setBreed(breed);
        d.setGroup(group);
        d.setGender(gender);
        d.setDogClass(dogClass);
        d.setDay1(day1);
        d.setDay2(day2);
        d.setDay3(day3);
        d.setEmail(email);
        d.setPassword(password);
        d.setMembership(membership);
        
        int status = DAO.updateDog(d);
        String link = "GetForEditForm?num=" + number;
        if (status>0) {
        	request.getRequestDispatcher(link).forward(request, response);
//            response.sendRedirect("GetDog");  
        } else {  
            out.println("Sorry! unable to update record");  
        }
        out.close();  
    }
}
