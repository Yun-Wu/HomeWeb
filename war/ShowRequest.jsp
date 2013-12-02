<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.yun.homeplusplus.RepairRequest" %>
<%@ page import="com.yun.homeplusplus.Manager" %>
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
    <link href="css/datepicker.css" rel="stylesheet">
    
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/jquery-ui-1.10.3.custom.js"></script>
</head>
  
<BODY>
  <div class="container">
<%
		String aptName = request.getParameter("AptName");
		String aptIdString = request.getParameter("aptId");
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
	
	<h3><%=r.getTitle()%></h3>
    <p><%=r.getContent() %></p>
    <p>&nbsp;</p>
    
    <div class="container-fluid">
		<div class="row-fluid">
			<div class="col-lg-4">
<%
		List<String> imageUrls = r.getImageList();

		for ( String url : imageUrls ) {
     		  //out.println("<img src=\"" + img.bkUrl + "\">"); // better to not use println for html output, use templating instead
     		%>
     		<img src="<%= url %>" alt="" class="img-thumbnail">
     		<%
     	 }
%>
		    </div>
			<div class="col-lg-4">
		    
			<h4>Schedule</h4>
	    		<form id="Schedule" class="form-horizontal" action="scheduleReq" method="get">
	    		Date: <input type="text" class="span2" value="<%=r.getScheduledDate()%>" title="format: dd/mm/yyyy" name="date" id="dp1" >
    			<br>
    			Time: <input type="text" class="span2" value="<%=r.getScheduledTime() %>" title="format: hh:mm" name="time">
    			<br>
    			<input type="hidden" name="RequestId" value="<%=requestId %>">
    			<input type="hidden" name="AptId" value="<%=aptId %>">
    			<br>
    			<input type="submit" class="btn btn-primary" value="Submit">
    			</form>
    		</div>
    	</div>
    </div>
  </div>
	 <script>
	 $(function() {
	 	//$('#dp1').datepicker();
	 	//$( document ).tooltip();
	 });
</script>	
</BODY>
</HTML>