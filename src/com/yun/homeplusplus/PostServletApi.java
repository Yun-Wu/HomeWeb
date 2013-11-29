package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class PostServletApi extends HttpServlet {

	private static final Logger log = Logger.getLogger(PostServletApi.class
			.getName());

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		log.warning("starting doPost");

		String type = req.getParameter("type");

		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		// JSONObject jObj = new JSONObject(sb.toString());
		String tstJson = sb.toString();
		Gson gson = new Gson();

		if (type.equals("carpool")) {
			Carpool carpool = gson.fromJson(tstJson, Carpool.class);
			ofy().save().entity(carpool).now();
			log.warning("done saving");
		} else if(type.equals("party")){
			Party party = gson.fromJson(tstJson, Party.class);
			ofy().save().entity(party).now();
			log.warning("done saving");
		} else if(type.equals("sport")){
			Sports sport = gson.fromJson(tstJson, Sports.class);
			ofy().save().entity(sport).now();
			log.warning("done saving");
		} else if(type.equals("sale")){
			Sale sale = gson.fromJson(tstJson, Sale.class);
			ofy().save().entity(sale).now();
			log.warning("done saving");
		}

	}
}
