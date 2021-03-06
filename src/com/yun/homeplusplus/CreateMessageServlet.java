package com.yun.homeplusplus;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String receiver = req.getParameter("to");
		String title = req.getParameter("subject");
		String content = req.getParameter("content");
		String receiverOpt = req.getParameter("receiverOpt");

		String aptIdString = req.getParameter("AptId");
		String aptName = req.getParameter("AptName");
		
		if (receiverOpt.equals("all")){
			receiver = "all";
		}

		if (receiver.isEmpty() || title.isEmpty() || content.isEmpty() || receiverOpt.isEmpty()) {
			System.out.println("please fill in the form completely");
			resp.sendRedirect("/Message.jsp?AptName=" + aptName + "&AptId="
					+ aptIdString);
			return;
		}
		
		Long aptId = Long.parseLong(aptIdString);
		List<Resident> residents = OfyService.ofy().load().type(Resident.class)
				.list();
		
		System.out.println(receiverOpt);

		if (receiverOpt.equals("individual")) {
			for (Resident r : residents) {
				if (r.getName().equals(receiver)) {
					Message m = new Message(aptName, aptId, r.getName(), r.getId(), title, content);
					ofy().save().entity(m).now();
					System.out.println("create message " + m.getTitle());
					System.out.println(r.getId());
					break;
				}
			}
		} else if (receiverOpt.equals("room")) {
			for (Resident r : residents) {
				if (r.getRoomNumber() == Integer.parseInt(receiver.trim())) {
					Message m = new Message(aptName, aptId,r.getName(), r.getId(), title, content);
					ofy().save().entity(m).now();
				}
			}
		} else if (receiverOpt.equals("all")) {
			for (Resident r : residents) {
				Message m = new Message(aptName, aptId, r.getName(),r.getId(), title, content);
				ofy().save().entity(m).now();
			}
		}
		resp.sendRedirect("/SentMessage.jsp?AptName=" + aptName + "&AptId="
				+ aptIdString);
	}
}
