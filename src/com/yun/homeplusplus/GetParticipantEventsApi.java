package com.yun.homeplusplus;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class GetParticipantEventsApi extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString.trim());

		Gson gson = new Gson();

		Event myEvents = new Event();

		List<Carpool> cc = OfyService.ofy().load().type(Carpool.class).list();
		for (Carpool c : cc) {
			if (c.getParticipantsList()==null || c.getParticipantsList().isEmpty())
				continue;
			if (c.getParticipantsList().contains(id)) {
				myEvents.capools.add(c);
			}
		}
		
		List<Party> pp = OfyService.ofy().load().type(Party.class).list();
		for (Party p : pp) {
			if (p.getParticipantsList()==null || p.getParticipantsList().isEmpty())
				continue;
			if (p.getParticipantsList().contains(id)) {
				myEvents.parties.add(p);
			}
		}
		
		List<Sports> sps = OfyService.ofy().load().type(Sports.class).list();
		for (Sports sp : sps) {
			if (sp.getParticipants()==null || sp.getParticipants().isEmpty())
				continue;
			if (sp.getParticipants().contains(id)) {
				myEvents.sports.add(sp);
			}
		}	
		
		String json = gson.toJson(myEvents);
		resp.setContentType("application/json");
		resp.getWriter().print(json);
	}
}

