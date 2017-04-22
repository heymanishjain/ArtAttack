<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link href='//fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
<link rel="stylesheet" href="fonts/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<script src="js/bootstrap.min.js"></script>
<script src="js/header.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>ArtAttack</title>
</head>
<body>
<div id="navbar" class="navbar">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="color:red">ARTATTACK&nbsp;-&nbsp;<small style="color:blue">ART GALLERY</small></a>
    </div>
    <ul class="nav navbar-nav">
      <li id="effect"><a href="home"  style="color:red"><i class="fa fa-home fa-fw"></i>Home</a></li>
      	<li id="effect"><a href="about" style="color:blue"><i class="fa fa-info-circle fa-fw"></i>About</a></li>
  		<li id="effect"><a href="contact" style="color:red"><i class="fa fa-phone fa-fw"></i>Contact</a></li>
  		<c:if test="${ empty showAdmin}"><li id="effect"><a href="paintings" style="color:blue"><i class="fa fa-paint-brush fa-fw"></i>Art Gallery</a></li></c:if>
  		<!--Start Admin Dropdown Menu Contents -->
      <c:if test="${not empty showAdmin }">      
      <li id="effect" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:red">Admin
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          	<li id="effect"><a href="admin_manage_paintings">Paintings</a></li>
    		<li id="effect"><a href="admin_manage_categories">Categories</a></li>
    		<li id="effect"><a href="admin_manage_artist">Artist</a></li>
        </ul>
      </li>
      </c:if>
      <!--End Admin Dropdown Menu Contents -->
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
         <!--Start User Dropdown Menu Contents -->
      <li id="effect" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:red"><c:if test="${not empty userid }"><b>${userid }</b></c:if><i class="fa fa-user-circle-o fa-fw fa-lg"></i>
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          	<li id="effect"><c:if test="${empty userLogin }"><a href="manage_login" style="color:blue"><i class="fa fa-sign-in fa-fw"></i>Login</a></c:if></li>
  			<li id="effect"><c:if test="${empty userRegister }"><a href="manage_register" style="color:red"><i class="fa fa-registered fa-fw"></i>Register</a></c:if></li>
  			<li id="effect"><c:if test="${(not empty userLogin) and (not empty userRegister) }">
  			<c:if test="${empty showAdmin }"><a href="manage_cart" style="color:blue"><i class="fa fa-shopping-cart fa-fw"></i>My Cart</a></c:if>
  			<a href="manage_account_settings"><i class="fa fa-cog fa-fw" style="color:red"></i>My Account</a>
  			<a href="javascript:document.getElementById('logout').submit()"><i class="fa fa-sign-in fa-fw" style="color:blue"></i>Logout</a></c:if></li>
  			<c:url value="j_spring_security_logout" var="logoutUrl" />
			<form id="logout" action="${logoutUrl}" method="post" >
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
        </ul>
      </li>
      <!--End User Dropdown Menu Contents -->
      </ul>
  </div>
</nav>
</div>
</body>
</html>