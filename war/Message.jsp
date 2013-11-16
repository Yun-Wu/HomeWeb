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
	<TITLE>Home++ - Message</TITLE>
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
		
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		
		%>
	<!-- Justified navbar -->
	<div class="masthead">
    	<h3 class="text-muted">Home ++</h3>
        <ul class="nav nav-justified">
        	<li><a href="Manage.jsp<%=parameters %>">Manage</a></li>
            <li><a href="Repair.jsp<%=parameters %>">Repair Request</a></li>
            <li class="active"><a href="Message.jsp<%=parameters %>">Message</a></li>
            <li><a href="Search.jsp<%=parameters %>">Search</a></li>
        </ul>
    </div>
	
	<br>
	<label>From: </label>
	<input type="email" value="<%=m.getEmail() %>"><br>
	<label>To: </label>
	<input type="text" name="receiver" multiple><br>
	<label>Subject: </label>
	<input type="text" name="subject" autofocus><br>
	<input type="text" name="content" maxlength="100" size="100"><br>
</div>
</BODY>
</HTML>