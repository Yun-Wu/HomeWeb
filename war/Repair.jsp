<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.yun.homeplusplus.RepairRequest" %>
<%@ page import="com.yun.homeplusplus.Manager" %>
<%@ page import="com.yun.homeplusplus.OfyService" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.text.*" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<HTML lang="en">
<HEAD>
    <meta charset="utf-8">
	<TITLE>Home++ - Repair Request</TITLE>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
  
<BODY>

	<form name="requests" action="delReq" method="get">  
        <table>
        <tr><td>Apartment Number</td><td>Title</td><td>Content</td><td>Priority</td><<td>Delete</td>/tr>
<%
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		List<RepairRequest> th = OfyService.ofy().load().type(RepairRequest.class).list();
		Collections.sort(th);
        
		for (RepairRequest r : th ) {
		  // APT: calls to System.out.println go to the console, calls to out.println go to the html returned to browser
		  // the line below is useful when debugging (jsp or servlet)
		  // ERROR: java.lang.NullPointerException
		  //System.out.println("s = " + s);
		  if (r.getAptId().equals(aptId)){
		  %>
		  <tr><td><%= r.getRoomNumber()%></td> 
		  <td><%=r.getTitle()%></td>
		  <td><%=r.getContent() %></td>
		  <td><%=r.getPriority()%></td><tr>
		  <td><label class="checkbox"><input type="checkbox" name="<%= r.getRequestId() %>"></label></td><tr>

<% }} %>
		
	  </table>
	  <input type="hidden" name="AptId" value="<%=aptId %>">
	  <input type="submit" class="btn" value="Delete Checked">
	</form>
</BODY>
</HTML>