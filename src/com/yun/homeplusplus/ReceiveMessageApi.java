package com.yun.homeplusplus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ReceiveMessageApi extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		List<Message> messages = OfyService.ofy().load().type(Message.class)
				.list();
		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString.trim());	

		List<Message> result = new ArrayList<Message>();

		for (Message m : messages) {
			if (m.getReceiverId().equals(id)) {
				result.add(m);
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(result);
		resp.setContentType("application/json");
		resp.getWriter().print(json);

	}
}
