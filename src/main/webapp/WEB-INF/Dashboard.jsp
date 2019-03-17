<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/project.css">
<style>
body{
		background-image: url("image/snowflake.png ");
		  
	}
	.no-background-image {
		background-image: url("images/blank.jpg");
		background-size: 200px;
		background-repeat: repeat;
	}
	.tableone {
		background-color: white;
		margin-top:200px;
	}

</style>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
        <h4>Welcome, <c:out value="${name}"/></h4>
        <a class='editall' href="/logout">logout</a>
        <a class='newjob btn btn-dark' href="/newCreate">Add a show!</a>
    </nav>
    <div class="container">
    <form class='one'>
        <div class="form-group">
            <h1>Shows created:</h1>
            <table class="tableone" class="table table-sm">
                <thead>
                    <tr>
                        <th>Show</th>
                        <th>Network</th>
                      <!--   <th>Rating</th> -->
                    </tr>
                    
                </thead>
                <tbody>
                    <c:forEach items="${shows}" var="show">
                    <tr>
                       
                        <td><a href="/ShowShow/${show.id}"><c:out value="${show.title }"/></a></td>
                        <td><c:out value="${show.network }"/></td>
                       
                    </tr>
                    </c:forEach>
                    
                    
                    <%-- <c:forEach items="${shows}" var="show">
                    <tr>
                       
                        <td><a href="/ShowIdea/${show.id}"><c:out value="${idea.name}"/></a></td>
                        <td><c:out value="${show.title}"/></td>
                        <td><c:out value="${show.network}"/></td>
                    </tr>
                    </c:forEach> --%>
   
                </tbody>
            </table>
        </div>
    </form>
    </div>
</body>
</html>