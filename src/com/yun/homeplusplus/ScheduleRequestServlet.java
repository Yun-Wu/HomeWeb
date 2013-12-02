package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ScheduleRequestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Long requestId = new Long(req.getParameter("RequestId"));
		RepairRequest r = OfyService.ofy().load().type(RepairRequest.class).id(requestId).get();
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		
		r.setScheduledDate(date);
		r.setScheduledTime(time);
		ofy().save().entity(r).now();
		
		String aptIdString = req.getParameter("AptId");
		resp.sendRedirect("ShowRequest.jsp?requestId=" + requestId + "&aptId=" + aptIdString);
	}
}
