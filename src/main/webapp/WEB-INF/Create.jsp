<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new show</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/project.css">
<style>
form{
	width: 300px;
}
body{
	text-align:center;
	padding-top: 100px;
}
</style>
</head>
<body>
<div class="container">
<h1 class="h3 mb-3 font-weight-normal">Create a new show</h1>
				<form:form class="one" action="/processCreate" method="POST" modelAttribute="show">
      
                    	<label>Title:</label>
                    	<form:errors class="errors" path="title"></form:errors>
                		<form:input path="title" placeholder="title"></form:input>
                    <div class="form-group">
                        <label>Network:</label>
                    	<form:errors class="errors" path="network"></form:errors>
                		<form:input path="network" placeholder="network"></form:input>
                        
                    </div>
                        <button type="submit" class="btn btn-primary btn-sm">Create</button>
                </form:form>
   	</div>

</body>
</html>