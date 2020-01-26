package com.fastsloth.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;
import com.fastsloth.dao.DAO;

@WebServlet("/GetDog")
public class GetDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		DAO daoDog = new DAO();
		dogs = daoDog.getDog();
		
		request.setAttribute("dogs", dogs);
		
		request.getRequestDispatcher("viewList.jsp").forward(request, response);	
	}

}
