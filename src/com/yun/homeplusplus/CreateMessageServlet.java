package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String[] receivers = req.getParameterValues("to");
		String title = req.getParameter("subject");
		String content = req.getParameter("content");

		String aptIdString = req.getParameter("AptId");
		String aptName = req.getParameter("AptName");

		if (receivers.length == 0 || title.isEmpty() || content.isEmpty()) {
			System.out.println("please fill in the form completely");
			return;
		}

		for (String receiver : receivers) {
			Message m = new Message(aptName, receiver, title, content);
			ofy().save().entity(m).now();
		}
		resp.sendRedirect("/Message.jsp?AptName=" + aptName + "&AptId="
				+ aptIdString);
	}
}
