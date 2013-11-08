package com.yun.homeplusplus;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String Email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(Email);
		System.out.println(password);

		List<Manager> managers = OfyService.ofy().load().type(Manager.class)
				.list();
		if (!managers.isEmpty()) {
			for (Manager m : managers) {
				System.out.println(m.getEmail() + " " + m.getPassword());
				if (m.getEmail().trim().equals(Email.trim())
						&& m.getPassword().trim().equals(password.trim())) {
					System.out.println("Log in successfully");
					resp.sendRedirect("/index.html");
					return;
				}
			}
		}
		System.out.println("Invalid Email or password");
		resp.sendRedirect("/index.html");
	}
}
