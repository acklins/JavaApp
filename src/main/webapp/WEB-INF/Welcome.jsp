<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Concierge</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
	body{
		background-image: url("image/crown.png");
		background-repeat:repeat;
		background-size: 30% 50%;
		background-position: center;
		  
	}
	.no-background-image {
		background-image: url("images/blank.jpg");
	}
	.king{
		text-align: center;
		margin-top:300px;
		margin-left: 350px;
		padding-color:white;
		width: 50%;
   		
  	/* 	text-decoration-line: overline underline;
  		text-decoration-style:wavy; */
	}
	
</style>
</head>
<body>
<nav class="no-background-image navbar navbar-dark bg-primary">
                <h4>Hello Creative Artists!</h4>
                <h5>你好創意藝術家</h5>
                
                <a class='logout btn btn-dark' href="/login">註冊</a>
                <a class='logout btn btn-dark' href="/login">Register</a>
                <a class='logout btn btn-dark' href="/login">登錄</a>
                <a class='logout btn btn-dark' href="/login">Login</a>
            </nav>
            
            <div class ="king">
            <h1> Welcome to Concierge Services</h1>
            <h2><a href="/ecommerce">Start Building your Movie</a></h2>
            <h2><a href="/ecommerce">開始製作你的電影</a></h2>
            </div>
            
</body>
</html>