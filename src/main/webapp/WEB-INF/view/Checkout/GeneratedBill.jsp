<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Art Attack</title>
</head>
<body>

<jsp:include page="../CommonHeader.jsp"></jsp:include>
<div class="col-md-12">
            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title" style="font-size:30px"><b>Address Details</b></h1>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">ID</th>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Address</th>
                        <th style="text-align:center">Contact</th>
                        <th style="text-align:center">City</th>
                        <th style="text-align:center">State</th>
                        <th style="text-align:center">Pin Code</th>
                    </tr> 
                  </thead>
                  <c:forEach var="checkout" items="${checkoutBill }">
                  <tbody>
                  	<tr>
                  	<td>${checkout.id }</td>
                  	<td>${checkout.name }</td>
                  	<td>${checkout.address }</td>
                  	<td>${checkout.contact }</td>
                  	<td>${checkout.city }</td>
                  	<td>${checkout.state }</td>
                  	<td>${checkout.pincode }</td>
                  	</tr>
                  	</tbody>
                  	</c:forEach>
        </table>
     </div>
  </div>
</div>

<div class="col-md-12">
            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title" style="font-size:30px"><b>Bill Details</b></h1>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">Painting Image</th>
                        <th style="text-align:center">Painting Name</th>
                        <th style="text-align:center">Quantity</th>
                    </tr> 
                  </thead>
                  <c:forEach var="cart" items="${cartDetails }">
                  <tbody>
                  	<tr>
                  		<td><img src="images/${cart.painting_id }.jpg"  width="200" height="100"></td>
                  		<td>${cart.paintingname }</td>
                  		<td>${cart.quantity }</td>
                  	</tr>
                  	</tbody>
                  	</c:forEach>
                  	<tr>
                  	<td colspan="2">Total</td>
                  	<td colspan="1">${total }</td>
                  	</tr>
        </table>
     </div>
  </div>
</div>

<center><a href = "home" class = "btn btn-success btn-lg">Continue Shopping</a></center>

 <div class="col-sm-12">
<jsp:include page="../CommonFooter.jsp"></jsp:include>
</div>

</body>
</html>