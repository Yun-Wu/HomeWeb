<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.yun.homeplusplus.Resident" %>
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
	<TITLE>Home++ - Manage</TITLE>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">
</head>
  
<BODY>
  <div class="container">

<%
		String aptName = request.getParameter("AptName");
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		String parameters = "?AptName=" + aptName + "&AptId=" + aptId;
		%>
		
		<!-- Justified navbar -->
	<div class="masthead">
    	<h3 class="text-muted">Home ++</h3>
        <ul class="nav nav-justified">
        	<li class="active"><a href="Manage.jsp<%=parameters %>">Manage</a></li>
            <li><a href="Repair.jsp<%=parameters %>">Repair Request</a></li>
            <li><a href="Message.jsp<%=parameters %>">Message</a></li>
            <li><a href="Search.jsp<%=parameters %>">Search</a></li>
        </ul>
    </div>
    <br>

    <form name="residents" action="delRes" method="get">  
        <table class="table table-hover">
        <tr><td>Name</td><td>Age</td><td>Apartment Number</td><td>Delete</td></tr>

<%		
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		List<Resident> residents = OfyService.ofy().load().type(Resident.class).list();
		//Collections.sort(residents);
        
		for (Resident r : residents ) {
		  // APT: calls to System.out.println go to the console, calls to out.println go to the html returned to browser
		  // the line below is useful when debugging (jsp or servlet)
		  // ERROR: java.lang.NullPointerException
		  //System.out.println("s = " + s);
		  if (r.getAptId().equals(aptId)){
		  %>
		  <tr><td><%= r.getName()%></td> 
		  <td><%=r.getAge()%></td>
		  <td><%=r.getRoomNumber() %></td>
		  <td><label class="checkbox"><input type="checkbox" name="<%= r.getId() %>"></label></td><tr>

<% }} %>
		
	    </table>
	<input type="hidden" name="AptId" value="<%=aptId %>">

	
	<input type="submit" class="btn btn-primary" value="Delete Checked">
	</form>
	<button class="btn btn-primary"  onclick="location.href='/Create.jsp?AptId='+<%=aptId %>;">Create Residents</button>

  </div><!-- close container -->	

</BODY>
</HTML>