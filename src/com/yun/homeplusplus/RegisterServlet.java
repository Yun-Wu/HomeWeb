package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String Email = req.getParameter("email");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		String aptName = req.getParameter("aptName");

		//for test
//		System.out.println(Email + " " + password);
//		if(city == null) System.out.println("city is null");
//		if(city.isEmpty()) System.out.println("city is empty");
//		System.out.println(city + " " + state);
		
		List<Manager> managers = OfyService.ofy().load().type(Manager.class)
				.list();

		if (!password.equals(password2)) {
			System.out.println("password not confirmed");
			resp.sendRedirect("/register.html");
			return;
		}
		if (Email.isEmpty() || password.isEmpty() || password2.isEmpty()
				|| state.isEmpty() || city.isEmpty() || aptName.isEmpty()) {
			System.out.println("please fill in the form completely");
			resp.sendRedirect("/register.html");
			return;
		}
		

		Manager m = new Manager(Email, password, state, city, aptName);
		if(managers.contains(m)){
			System.out.println("Manager Already Exists");
			resp.sendRedirect("/register.html");
			return;
		}
		
		ofy().save().entity(m).now();
		System.out.println("Register Successfully");
		resp.sendRedirect("/index.html"); 
	}
}
