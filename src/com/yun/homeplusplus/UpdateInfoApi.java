package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class UpdateInfoApi  extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(UploadRequestApi.class.getName());
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		log.warning("starting doPost");
		
		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString.trim());	
		
		Resident r = OfyService.ofy().load().type(Resident.class).id(id).get();;
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		// JSONObject jObj = new JSONObject(sb.toString());
		String tstJson = sb.toString();
		Gson gson = new Gson();
		r = gson.fromJson(tstJson, Resident.class);
		
		ofy().save().entity(r).now();
		log.warning("done saving");

	}
}