<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E Commerce page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/project.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
 
<style>
body{
		background-image: url("image/images.jpeg");		  
	}
	.card-body {
  border: 10px solid black;
  border-color: black;
}
	.card-img-top{
	border-style: solid;
  	border-color: black;
}
</style>
</head>
<body>

<div class = "container">
<div class="row" >
	<div class="col">
		<div class="card align-bottom"  > 
  			<img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4Cj2UVKWg6ONTzBkGmeS0VCgaxWM44c91qZey0VJAdaOayKwR" alt="Card image cap">
  			<div class="card-body" style="background-color:gold">
    			<h5 class="card-title">Gold Package</h5>
    			<p class="card-text"> You are ready to meet the Directors and Producers.
    			Ava Duvernay & Steven Spielberg here you come! </p>
    			<a href="#" class="btn btn-primary">Buy</a>
    			<!-- iframe in a button -->
          <input type="button" id="buy_gold" class="button large" value="Buy Gold" />
                <!-- iframe end  -->
  			</div>
		</div>
	</div>
	
	<div class="col">
		<div class="card " >
  			<img class="card-img-top " src="https://i.etsystatic.com/11366822/r/il/35b41a/1649492429/il_fullxfull.1649492429_prot.jpg" alt="Card image cap">
  			<div class="card-body" style="background-color:silver">
    			<h5 class="card-title">Silver Package</h5>
    			<p class="card-text">Your movie idea is fantastic. 
    			JK Rowlings & Issa Rae would be proud of you!
    			 Let's introduce you
    			to the writers of the industry.</p>
    			<a href="#" class="btn btn-primary">Buy</a>
  			</div>
		</div>
	</div>
	
	<div class="col">
		<div class="card align-bottom" >
  			<img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTSOPad6anpFmQ90e2YhkI5LIJO_oSPJTVuv9wZX3NzqyjFLsaAg" alt="Card image cap">
  			<div class="card-body"style="background-color:yellow">
    			<h5 class="card-title">Bronze Package</h5>
    			<p class="card-text">We love your idea. Ben Afflick, Matt Damon & Flavor Flav,
    			think you are following in their footsteps. 
    			Let us teach you how to build your movie idea
    			as a product and be ready to shop it to writers.</p>
    			<a href="#" class="btn btn-primary">Buy</a>
  			</div>
		</div>
	</div>
	
	
</div>
</div>






</body>
</html>