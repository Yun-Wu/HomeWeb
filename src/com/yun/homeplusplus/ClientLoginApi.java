package com.yun.homeplusplus;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ClientLoginApi extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		List<Resident> residents = OfyService.ofy().load().type(Resident.class)
				.list();
		String email = req.getParameter("email");

		Resident result = null;

		for (Resident r : residents) {
			if (r.getEmail().equals(email.trim())) {
				Gson gson = new Gson();
				String json = gson.toJson(r);
				resp.setContentType("application/json");
				System.out.println(r.getName());
				resp.getWriter().print(json);
				break;
			}
		}

	}
}
