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
	<TITLE>Home++ - Search</TITLE>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
  
<BODY>


 	<form class="form-search-by-room-number">
 		<p>Search by room number:</p>
  	    <input type="text" id="room-number" name="room-number">
  	    <input type="submit" class="btn" value="Search">
    </form>
    
    <form class="form-search-by-user">
 		<p>Search by residents' name:</p>
  	    <input type="text" id="user-name" name="user-name">
  	    <input type="submit" class="btn" value="Search">
    </form>
    
    <form name="residents" action="delete" method="get">  
        <table>
        <tr><td>Name</td><td>Age</td><td>Apartment Number</td><td>Delete</td></tr>
<%
		String aptName = request.getParameter("AptName");
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		
		String roomNumString = request.getParameter("room-number");
		String userName = request.getParameter("user-name");
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		List<Resident> residents = OfyService.ofy().load().type(Resident.class).list();
		//Collections.sort(residents);
        
		for (Resident r : residents ) {
		  // APT: calls to System.out.println go to the console, calls to out.println go to the html returned to browser
		  // the line below is useful when debugging (jsp or servlet)
		  // ERROR: java.lang.NullPointerException
		  //System.out.println("s = " + s);
		  if (r.getAptId().equals(aptId)){
			  if(roomNumString!=null && !roomNumString.isEmpty()){
				  Integer roomNum = Integer.parseInt(roomNumString);
				  if(roomNum.equals( r.getRoomNumber())){
		  %>
		  <tr><td><%= r.getName()%></td> 
		  <td><%=r.getAge()%></td>
		  <td><%=r.getRoomNumber() %></td>
		  <td><label class="checkbox"><input type="checkbox" name="<%= r.getId() %>"></label></td><tr>

<% 				}
			}else if(userName!=null && !userName.isEmpty()){
				if(userName.equals(r.getName())){
					  %>
					  <tr><td><%= r.getName()%></td> 
					  <td><%=r.getAge()%></td>
					  <td><%=r.getRoomNumber() %></td>
					  <td><label class="checkbox"><input type="checkbox" name="<%= r.getId() %>"></label></td><tr>

			<% 
				}
			}
		  }
		}
		%>
		
	  </table>
	<input type="hidden" name="AptId" value="<%=aptId %>">
	<input type="submit" class="btn" value="Delete Checked">
	</form>

  </body>
</html>