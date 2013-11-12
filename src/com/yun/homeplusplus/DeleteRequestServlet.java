package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteRequestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<RepairRequest> th = OfyService.ofy().load().type(RepairRequest.class).list();
		for (RepairRequest r : th ) {
			if(req.getParameter(r.getRequestId().toString())!=null)
				ofy().delete().entity(r).now(); 
			
		}
		String aptIdString = req.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		String name = m.getAptName();
		resp.sendRedirect("/Repair.jsp?AptName=" + name + "&AptId=" + aptIdString);
	}
}