<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/project.css">
<style>
	body{
		background-image: url("image/luxury-jet-concierge.jpg");
		background-repeat: no-repeat;
		background-size:100% auto;
		width:100% !important;
		text-align: center;
		margin-top:300px;
		}
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h1>Register</h1>
            <form:form action="/processRegistration" method="POST" modelAttribute="user">
               
                <!-- name section -->
                <div class="form-group">
                <form:errors class="errors" path="name"></form:errors>
                <form:input path="name" placeholder="name"></form:input>
                </div>
                <!-- end of name -->
                    <!-- beginning of email -->
                <div class="form-group">
                  <form:errors class="errors" path="email"></form:errors>
                <form:input path="email" placeholder="email"></form:input>  
                </div>
                           <!-- end of email -->
                                  <!-- beginning of password -->
                <div class="form-group">
                   <form:errors class="errors" path="password"></form:errors>
                <form:input path="password" type="password" placeholder="password"></form:input>      
                </div>
                           <!-- end of password -->
                           <!-- beginning of password confirm -->
                           <div class="form-group">
                             <form:errors class="errors" path="confirmation"></form:errors>
                <form:input path="confirmation" type="password" placeholder="confirm password"></form:input>    
                        </div>
                                <!-- end of password confirm -->

                <button type="submit" class="btn btn-primary">Register</button>
            </form:form>
        </div>

<!-- ----------------------------Login---------------------------- -->
        <div class="col-md-6">
            <h1 class="sea text-white">Login </h1>
            <form:form action="/processLogin" method="POST" modelAttribute="user">
                <div class="form-group">
                    <form:errors class="errors" path="email"></form:errors>
                	<form:input path="email" placeholder="email"></form:input>
                </div>
                <div class="form-group">
                   <form:errors class="errors" path="password"></form:errors>
                <form:input path="password" type="password" placeholder="password"></form:input> 
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
</body>
</html>