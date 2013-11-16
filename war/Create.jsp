<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
	<TITLE>Home++ - Create Resident</TITLE>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
  
<BODY>

<%
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
 %>
		
   <form name="CreateResident" action="/create" method="get">
   		<label>Name: </label>
		<input type="text" name="name"><br>
		<label>Room Number: </label>
		<input type="text" name="room"><br>
		<label>Age: </label>
		<input type="text" name="age"><br>
		<label>Gender: </label>
		<input type="text" name="gender"><br>
		<label>Email: </label>
		<input type="email" name="email"><br>
		
		<input type="hidden" name="AptId" value="<%=aptId %>">
		<input type="submit" class="btn" value="Create">
  	</form>


</BODY>
</HTML>