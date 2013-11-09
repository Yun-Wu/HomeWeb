<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.yun.homeplusplus.Resident" %>
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
</head>
  
<BODY>

       <form name="deletestreaminput" action="deleteStreamServlet" method="get">  
        <table class="table table-hover">
        <tr><td>Name</td><td>Last Update</td><td>Number of Pictures</td><td>Delete</td></tr>
<%
		String aptName = request.getParameter("AptName");
		List<Resident> residents = OfyService.ofy().load().type(Resident.class).list();
		//Collections.sort(residents);
        
		for (Resident r : residents ) {
		  // APT: calls to System.out.println go to the console, calls to out.println go to the html returned to browser
		  // the line below is useful when debugging (jsp or servlet)
		  // ERROR: java.lang.NullPointerException
		  //System.out.println("s = " + s);
		  if (r.getAptName().equals(aptName)){
		  %>
		  <tr><td><a href="index.html"> <%= r.getName() %></a></td> 
		  <td><%=r.getAge()%></td>
		  <td><%=s.pictures %></td>
		  <td><label class="checkbox"><input type="checkbox" name="<%= s.name %>"></label></td><tr>

<% }} %>
		
	  </table>
	<input type="submit" class="btn" value="Delete Checked">
	</form>


</BODY>
</HTML>