package com.yun.homeplusplus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class GetServletApi  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String idString = req.getParameter("aptid");
		Long id = Long.parseLong(idString.trim());	
		String type = req.getParameter("type");
		
		Gson gson = new Gson();
		
		if (type.equals("carpool")) {
			List<Carpool> messages = OfyService.ofy().load().type(Carpool.class)
					.list();
			
			List<Carpool> result = new ArrayList<Carpool>();

			for (Carpool m : messages) {
				if (m.getApartmentId().equals(id)) {
					result.add(m);
				}
			}
			
			String json = gson.toJson(result);
			resp.setContentType("application/json");
			resp.getWriter().print(json);
			
		} else if(type.equals("party")){
			List<Party> messages = OfyService.ofy().load().type(Party.class)
					.list();
			
			List<Party> result = new ArrayList<Party>();

			for (Party m : messages) {
				if (m.getApartmentId().equals(id)) {
					result.add(m);
				}
			}
			
			String json = gson.toJson(result);
			resp.setContentType("application/json");
			resp.getWriter().print(json);
			
		} else if(type.equals("sport")){
			List<Sports> messages = OfyService.ofy().load().type(Sports.class)
					.list();
			
			List<Sports> result = new ArrayList<Sports>();

			for (Sports m : messages) {
				if (m.getApartmentId().equals(id)) {
					result.add(m);
				}
			}
			
			String json = gson.toJson(result);
			resp.setContentType("application/json");
			resp.getWriter().print(json);
			
		} else if(type.equals("sale")){
			List<Sale> messages = OfyService.ofy().load().type(Sale.class)
					.list();
			
			List<Sale> result = new ArrayList<Sale>();

			for (Sale m : messages) {
				if (m.getApartmentId().equals(id)) {
					result.add(m);
				}
			}
			
			String json = gson.toJson(result);
			resp.setContentType("application/json");
			resp.getWriter().print(json);
		}
		
	}
}
