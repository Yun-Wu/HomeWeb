package com.yun.homeplusplus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class SentRequestApi extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		List<RepairRequest> requests = OfyService.ofy().load().type(RepairRequest.class)
				.list();
		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString.trim());	

		List<RepairRequest> result = new ArrayList<RepairRequest>();

		for (RepairRequest r : requests) {
			if (r.getUserId().equals(id)) {
				result.add(r);
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(result);
		resp.setContentType("application/json");
		resp.getWriter().print(json);

	}
}
