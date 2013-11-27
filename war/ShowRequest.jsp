<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.yun.homeplusplus.RepairRequest" %>
<%@ page import="com.yun.homeplusplus.Manager" %>
<%@ page import="com.yun.homeplusplus.Image" %>
<%@ page import="com.yun.homeplusplus.OfyService" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.text.*" %>

<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<HTML lang="en">
<HEAD>
    <meta charset="utf-8">
	<TITLE>Home++ - Repair Request</TITLE>
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
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
		aptName = m.getAptName();
		String parameters = "?AptName=" + aptName + "&AptId=" + aptId;
		%>
		
		<!-- Justified navbar -->
	<div class="masthead">
    	<h3 class="text-muted">Home ++</h3>
        <ul class="nav nav-justified">
        	<li><a href="Manage.jsp<%=parameters %>">Manage</a></li>
            <li class="active"><a href="Repair.jsp<%=parameters %>">Repair Request</a></li>
            <li><a href="Message.jsp<%=parameters %>&Receiver=">Message</a></li>
            <li><a href="Search.jsp<%=parameters %>">Search</a></li>
        </ul>
    </div>
    <br>

<%
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		Long requestId = new Long(request.getParameter("requestId"));
		RepairRequest r = OfyService.ofy().load().type(RepairRequest.class).id(requestId).get();
%>
		<div class="jumbotron">
        <h2><%=r.getTitle()%></h2>
        <br>
        <p><%=r.getContent() %></p>
		<div class="row-fluid">
		<ul class="thumbnails">
<%

		r.setRead(true);
		OfyService.ofy().save().entity(r).now();
		List<String> imageUrls = r.getImageList();

		for ( String url : imageUrls ) {
     		  //out.println("<img src=\"" + img.bkUrl + "\">"); // better to not use println for html output, use templating instead
     		%>
     		<li class="span3">
   			<div class="thumbnail">
     		<img src="<%= url %>" alt="">
     		</div>
    		</li>
     		<%
     	 }
%>
		    </ul>
		    </div>
          </div>
          </div>		
</BODY>
</HTML>