package com.yun.homeplusplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetResidentsApi extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		// JSONObject jObj = new JSONObject(sb.toString());
		String tstJson = sb.toString();
		Gson gson = new Gson();
		
		Type listType = new TypeToken<List<Long>>() {}.getType();		 
		List<Long> ids = gson.fromJson(tstJson, listType);
		
		List<Resident> residents = OfyService.ofy().load().type(Resident.class)
				.list();
		List<Resident> results = new ArrayList<Resident>();
		
		for(Long id:ids){
			for(Resident r:residents){
				if(r.getId().equals(id)){
					results.add(r);
				}
			}
		}
		
		String json = gson.toJson(results);
		resp.setContentType("application/json");
		resp.getWriter().print(json);	
		
		
	}
}

