package com.fastsloth.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastsloth.beans.ShowList;
import com.fastsloth.dao.DAO;

@WebServlet("/ShowList")
public class CreateShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<ShowList> groupOne = new ArrayList<ShowList>();
		ArrayList<ShowList> groupTwo = new ArrayList<ShowList>();
		ArrayList<ShowList> groupThree = new ArrayList<ShowList>();
		ArrayList<ShowList> groupFour = new ArrayList<ShowList>();
		ArrayList<ShowList> groupFive = new ArrayList<ShowList>();
		ArrayList<ShowList> groupSix = new ArrayList<ShowList>();
		ArrayList<ShowList> groupSeven = new ArrayList<ShowList>();

		int date = Integer.parseInt(request.getParameter("date"));
		DAO daoDog = new DAO();
		
		groupOne = daoDog.getShowList(date, 1);
		groupTwo = daoDog.getShowList(date, 2);
		groupThree = daoDog.getShowList(date, 3);
		groupFour = daoDog.getShowList(date, 4);
		groupFive = daoDog.getShowList(date, 5);
		groupSix = daoDog.getShowList(date, 6);
		groupSeven = daoDog.getShowList(date, 7);

		request.setAttribute("date", date);
		
		request.setAttribute("groupOne", groupOne);
		request.setAttribute("groupTwo", groupTwo);
		request.setAttribute("groupThree", groupThree);
		request.setAttribute("groupFour", groupFour);
		request.setAttribute("groupFive", groupFive);
		request.setAttribute("groupSix", groupSix);
		request.setAttribute("groupSeven", groupSeven);
		
		request.getRequestDispatcher("viewShowList.jsp").forward(request, response);

	}

	
}
