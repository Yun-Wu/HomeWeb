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
</head>
  
<BODY>
<%
		String aptName = request.getParameter("AptName");
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		String parameters = "?AptName=" + aptName + "&AptId=" + aptId;
		%>
		
	<a href="Manage.jsp<%=parameters %>">Manage</a>
	<a href="Repair.jsp<%=parameters %>">Repair Request</a>
	<a href="Message.jsp<%=parameters %>">Message</a>
	<a href="Search.jsp<%=parameters %>">Search</a>
	

</BODY>
</HTML>