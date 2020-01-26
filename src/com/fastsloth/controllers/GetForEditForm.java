package com.fastsloth.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;
import com.fastsloth.dao.DAO;

@WebServlet("/GetForEditForm")
public class GetForEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int num = Integer.parseInt(request.getParameter("num"));

		Dog dog = new Dog();
		DAO dao = new DAO();
		dog = dao.getForEdit(num);
		
		if (dog.getGroup().equals("Group 1: Sporting Dogs")) {
			request.setAttribute("g1Selected", "selected");
		} else if (dog.getGroup().equals("Group 2: Hounds")) {
			request.setAttribute("g2Selected", "selected");
		} else if (dog.getGroup().equals("Group 3: Working Dogs")) {
			request.setAttribute("g3Selected", "selected");
		} else if (dog.getGroup().equals("Group 4: Terriers")) {
			request.setAttribute("g4Selected", "selected");
		} else if (dog.getGroup().equals("Group 5: Toys")) {
			request.setAttribute("g5Selected", "selected");
		} else if (dog.getGroup().equals("Group 6: Non-sporting Dogs")) {
			request.setAttribute("g6Selected", "selected");
		} else {
			request.setAttribute("g7Selected", "selected");
		}
		System.out.println(dog.getGroup());

        if (dog.getGender().equals("Male")) {
        	request.setAttribute("maleSelected", "checked");
        } else {
        	request.setAttribute("femaleSelected", "checked");
        }
        
        if (dog.getDogClass().equals("Class")) {
        	request.setAttribute("classSelected", "checked");
        } else {
        	request.setAttribute("specialtySelected", "checked");
        }
        
       
        	if (dog.getDay1().equals("on")) {
            	request.setAttribute("day1On", "checked");
        	}
     
        if (!dog.getDay2().equals(null)) {
        	if (dog.getDay2().equals("on")) {
        	request.setAttribute("day2On", "checked");
        	}
        }
        if (!dog.getDay3().equals(null)) {
        	if (dog.getDay3().equals("on")) {
        	request.setAttribute("day3On", "checked");
        	}
        }
        
		request.setAttribute("dog", dog);
		request.getRequestDispatcher("editForm.jsp").forward(request, response);

	}
}
