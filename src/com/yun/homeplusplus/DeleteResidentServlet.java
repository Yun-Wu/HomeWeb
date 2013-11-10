package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteResidentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Resident> th = OfyService.ofy().load().type(Resident.class).list();
		for (Resident r : th ) {
			if(req.getParameter(r.getId().toString())!=null)
				ofy().delete().entity(r).now(); 
			
		}
		String aptIdString = req.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		String name = m.getAptName();
		resp.sendRedirect("/Manage.jsp?AptName=" + name + "&AptId=" + aptIdString);
	}
}
