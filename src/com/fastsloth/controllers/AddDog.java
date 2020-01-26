package com.fastsloth.controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.Dog;
import com.fastsloth.dao.DAO;
import com.fastsloth.general.SendEmail;

@WebServlet("/AddDog")
public class AddDog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int number = 0;
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
			if (day1==null) {
				day1 = "off";
			}
			
			if (day2==null) {
				day2 = "off";
			}
			
			if (day3==null) {
				day3 = "off";
			}
		Dog dog = new Dog(number, name, ownerName, breed, group, gender, dogClass, day1, day2, day3, email, password, membership);
		
		DAO dao = new DAO();
		dao.addDog(dog);
				
		SendEmail send = new SendEmail(dog);
			try {
				send.mailing(name, ownerName, breed, group, gender, dogClass, day1, day2, day3, email, membership);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("index.html").forward(request,response);
	}
}
