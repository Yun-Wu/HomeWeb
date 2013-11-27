package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAllServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<Message> th = OfyService.ofy().load().type(Message.class).list();
		for (Message m : th ) {
			if(req.getParameter(m.getId().toString())!=null)
				ofy().delete().entity(m).now(); 
			
		}
		
		List<RepairRequest> requests = OfyService.ofy().load().type(RepairRequest.class).list();
		for (RepairRequest r : requests ) {
			if(req.getParameter(r.getRequestId().toString())!=null)
				ofy().delete().entity(r).now(); 
			
		}
		
		List<Resident> residents = OfyService.ofy().load().type(Resident.class).list();
		for (Resident rr : residents ) {
			if(req.getParameter(rr.getId().toString())!=null)
				ofy().delete().entity(rr).now(); 
		}
		resp.sendRedirect("/index.html");
	}
}