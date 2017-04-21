<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Art Attack</title>
</head>
<body>
<jsp:include page="../CommonHeader.jsp"></jsp:include>

<form:form class="form-horizontal" action="validate_user_checkout" method="post">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="Name" class="form-control input-md" required="" type="text" aria-describedby="nameHelpInline"/>
   <small id="nameHelpInline" class="text-muted">
	<p>${Name }</p>
	</small> 
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="shipping_address">Shipping Address </label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="address" name="address" rows="5" path="address" placeholder="Enter Shipping Address" aria-describedby="addressHelpInline"></textarea>
  	<small id="descritionHelpInline" class="text-muted">
	<p>${Description }</p>
	</small>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="contact">Contact</label>  
  <div class="col-md-4">
  <form:input id="contact" name="contact" path="contact" placeholder="Contact" class="form-control input-md" required="" type="text" aria-describedby="contactHelpInline"/>
  <small id="contactHelpInline" class="text-muted">
	<p>${Contact }</p>
	</small>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="city">City</label>  
  <div class="col-md-4">
  <form:input id="city" name="city" path="city" placeholder="CITY" class="form-control input-md" required="" type="text" aria-describedby="cityHelpInline"/>
   	<small id="cityHelpInline" class="text-muted">
	<p>${City }</p>
	</small> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="state">State</label>  
  <div class="col-md-4">
  <form:input id="state" name="state" path="state" placeholder="State" class="form-control input-md" required="" type="text" aria-describedby="stateHelpInline"/>
  <small id="stateHelpInline" class="text-muted">
	<p>${State }</p>
	</small>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="pin_code">Pin Code</label>  
  <div class="col-md-4">
  <form:input id="pincode" name="pincode" path="pincode" placeholder="Pin Code" class="form-control input-md" required="" type="text" aria-describedby="pcHelpInline"/>
   <small id="pcHelpInline" class="text-muted">
	<p>${PC }</p>
	</small> 
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Proceed To Generate Bill</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>