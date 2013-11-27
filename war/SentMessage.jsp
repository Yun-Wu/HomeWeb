<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="com.yun.homeplusplus.Resident"%>
<%@ page import="com.yun.homeplusplus.Manager"%>
<%@ page import="com.yun.homeplusplus.Message"%>
<%@ page import="com.yun.homeplusplus.OfyService"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.text.*"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<HTML lang="en">
<HEAD>
<meta charset="utf-8">
<TITLE>Home++ - Message</TITLE>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/justified-nav.css" rel="stylesheet">

<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet">

<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js"></script>

</head>

<BODY>
	<div class="container">
		<%
			String aptName = request.getParameter("AptName");
				String aptIdString = request.getParameter("AptId");
				Long aptId = Long.parseLong(aptIdString);

				
				String receiver = request.getParameter("Receiver");
				
				Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
				
				aptName = m.getAptName();
				
				String parameters = "?AptName=" + aptName + "&AptId=" + aptId;
				
				List<Resident> residents = OfyService.ofy().load().type(Resident.class).list();
				
				List<Message> messages = OfyService.ofy().load().type(Message.class).list();
				
				Collections.sort(messages);
		%>
		<!-- Justified navbar -->
		<div class="masthead">
			<h3 class="text-muted">Home ++</h3>
			<ul class="nav nav-justified">
				<li><a href="Manage.jsp<%=parameters%>">Manage</a></li>
				<li><a href="Repair.jsp<%=parameters%>">Repair Request</a></li>
				<li class="active"><a href="Message.jsp<%=parameters%>&Receiver=">Message</a></li>
				<li><a href="Search.jsp<%=parameters%>">Search</a></li>
			</ul>
		</div>

		<br>
		<form name="sentMsg" action="delMsg" method="get">
			<table class="table table-hover">
        <tr><td>Receiver</td><td>Title</td><td>Content</td><td>Delete</td></tr>

<%		
		for (Message msg : messages ) {
		  // APT: calls to System.out.println go to the console, calls to out.println go to the html returned to browser
		  // the line below is useful when debugging (jsp or servlet)
		  // ERROR: java.lang.NullPointerException
		  //System.out.println("s = " + s);
		  if (msg.getSenderId().equals(aptId)){
				Resident r = OfyService.ofy().load().type(Resident.class).id(msg.getReceiverId()).get();
		  %>
		  <tr><td><%= r.getName()%></td> 
		  <td><%=msg.getTitle()%></td>
		  <td><%=msg.getContent() %></td>
		  <td><label class="checkbox"><input type="checkbox" name="<%= msg.getId() %>"></label></td><tr>

<% }} %>
		
	    </table>
	<input type="hidden" name="AptId" value="<%=aptId %>">	
	<input type="submit" class="btn btn-primary" value="Delete Checked">
		</form>
	
	</div>
	<!-- close container -->

	<script>

	 $(function() {
var availableNames = new Array();
var availableRooms = new Array();
var j=0;
<%for (Resident r : residents ) {%>
	availableNames[j] = "<%=r.getName()%>";
	availableRooms[j] = "<%=r.getRoomNumber().toString()%>";
			j++;
	<%}%>
		if (document.getElementById("opt1").checked===true) {
				$("#to").autocomplete({
					source : availableNames
				});
			} else {
				if (document.getElementById("opt2").checked===true) {
					$("#to").autocomplete({
						source : availableRooms
					});
				}
			}

		});
	</script>
</BODY>
</HTML>