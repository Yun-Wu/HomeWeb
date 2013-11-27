package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Message> th = OfyService.ofy().load().type(Message.class).list();
		for (Message m : th ) {
			if(req.getParameter(m.getId().toString())!=null)
				ofy().delete().entity(m).now(); 
			
		}
		String aptIdString = req.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		String name = m.getAptName();
		resp.sendRedirect("/SentMessage.jsp?AptName=" + name + "&AptId=" + aptIdString);
	}
}