<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show TV shows</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<style>
body{
		background-image: url("image/crown.png");
		background-repeat:repeat;
		background-size: 30% 50%;
		background-position: center;
		  
	}


</style>
<body>
<div class="container">

<h2>${shows.name}</h2>
<form action="showShow/{id}" method="POST">

<div>
<h1><c:out value="${show.title}"/></h1>
<h1><c:out value="${show.network}"/></h1>
</div>

<div>
   <a href="/ShowShow/${show.id}/edit">Edit</a>
</div>
</form>
</div>
<!-- 888888888888888put the form:form in here8888888888888888888888888888888888 -->
<%-- <form:form action="/shows/${show.getId()}" method="post">
			<label for="text">Leave a Rating:</label>	
			
		<!-- 	<input type="text" name="text"/> -->
	<!-- ************************		try this******************************* -->
			<form:input type="number" name="rating"></form:input>
<!-- ***********************or try this****************************** -->
			<form:input path="rating" placeholder="rating"></form:input>
		
			<input type="submit" value="Post"/>
		</form:form> --%>
</body>
</html>