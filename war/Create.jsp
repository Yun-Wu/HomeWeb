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
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/jumbotron.css" rel="stylesheet">
</head>
  
<BODY>
  <div class="container">
  <div class="jumbotron">
    <h2>Create a new resident</h2>
    <br>
<%
		String aptIdString = request.getParameter("AptId");
		Long aptId = Long.parseLong(aptIdString);
		
		Manager m = OfyService.ofy().load().type(Manager.class).id(aptId).get();
 %>
		
   <form role="form" class="form-horizontal" name="CreateResident" action="/create" method="get">
	  <div class="form-group">
		<label class="col-sm-4 control-label" for="name" >Name: </label>
		<div class="col-sm-7">
		  <input type="text" class="form-control" name="name" id="name">
	    </div>
	  </div>
	  <div class="form-group">
		<label class="col-sm-4 control-label" for="room" >Room Number: </label>
		<div class="col-sm-7">
		  <input type="text" class="form-control" name="room" id="room">
	    </div>
	  </div>
	  <div class="form-group">
		<label class="col-sm-4 control-label" for="age" >Age: </label>
		<div class="col-sm-7">
		  <input type="text" class="form-control" name="age" id="age">
	    </div>
	  </div>
	  <div class="form-group">
		<label class="col-sm-4 control-label" for="gender" >Gender: </label>
		<div class="col-sm-7">
		  <input type="text" class="form-control" name="gender" id="gender">
	    </div>
	  </div>
	  <div class="form-group">
		<label class="col-sm-4 control-label" for="email" >Email: </label>
		<div class="col-sm-7">
		  <input type="email" class="form-control" name="email" id="email">
	    </div>
	  </div>
		
		<input type="hidden" name="AptId" value="<%=aptId %>">
		<input type="submit" class="btn btn-primary" value="Create">
  	</form>
  
  </div><!-- close jumbotron -->
  </div><!-- close container -->

</BODY>
</HTML>