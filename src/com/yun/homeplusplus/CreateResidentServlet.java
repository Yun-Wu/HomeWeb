package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateResidentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String Email = req.getParameter("email");
		String name = req.getParameter("name");
		String ageString = req.getParameter("age");
		String gender = req.getParameter("gender");
		String roomString = req.getParameter("room");
		
		String aptIdString = req.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);

		//for test
//		System.out.println(Email + " " + password);
//		if(city == null) System.out.println("city is null");
//		if(city.isEmpty()) System.out.println("city is empty");
//		System.out.println(city + " " + state);

		if (Email.isEmpty() || name.isEmpty() || ageString.isEmpty() 
				|| gender.isEmpty() || roomString.isEmpty()) {
			System.out.println("please fill in the form completely");
			resp.sendRedirect("/Create.jsp?AptId=" + aptId);
			return;
		}
		Integer age = Integer.parseInt(ageString);
		Integer room = Integer.parseInt(roomString);

		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		
		Resident r = new Resident(room, Email, name, m.getState(), m.getCity(), 
				m.getAptName(), gender, age, m.getAptId());
		
		ofy().save().entity(r).now();
		System.out.println("Create a resident successfully");
		resp.sendRedirect("/Manage.jsp?AptName=" + m.getAptName() 
				+ "&AptId=" + m.getAptId()); 
	}
}
