<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Attack</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<jsp:include page="../CommonHeader.jsp"></jsp:include>


<div class="col-md-12">
            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title" style="font-size:30px"><b>Shipping Address</b></h1>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <a href="manage_cart_add_checkout" class="btn btn-success">Add Another Address</a>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">User ID</th>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Address</th>
                        <th style="text-align:center">Contact</th>
                        <th style="text-align:center">City</th>
                        <th style="text-align:center">State</th>
                        <th style="text-align:center">Pin Code</th>
                        <th style="text-align:center"><em class="fa fa-cog"></em></th>
                    </tr> 
                  </thead>
                  <tbody>
                  	<c:forEach var="checkout" items="${displayCheckout }">
                          <tr>
                            <td>${checkout.user_id }</td>
                            <td>${checkout.name }</td>
                            <td>${checkout.address }</td>
                            <td>${checkout.contact }</td>
                            <td>${checkout.city }</td>
                            <td>${checkout.state }</td>
                            <td>${checkout.pincode }</td>
                            <td align="center">
                            	<a href="manage_cart_checkout_edit?id=${checkout.id }" class="btn btn-success"><em class="fa fa-pencil"></em></a>
                            </td>
                          </tr>
                	</c:forEach>
                 </tbody>
        </table>
     </div>
  </div>
</div>


<div class="col-md-12">
            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title" style="font-size:30px"><b>My Cart</b></h1>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">ID</th>
                        <th style="text-align:center">Painting Image</th>
                        <th style="text-align:center">Painting Name</th>
                        <th style="text-align:center">Quantity</th>
                        <th style="text-align:center">Status</th>
                        <th style="text-align:center">Price</th>
                        <th style="text-align:center">Date Added</th>
                        <th style="text-align:center"><em class="fa fa-cog"></em></th>
                    </tr> 
                  </thead>
                  <tbody>
                  	<c:forEach var="mycart" items="${displayMyCart }">
                          <tr>
                            <td>${mycart.id }</td>
                            <td><img src="images/${mycart.painting_id }.jpg" height="50"></td>
                            <td>${mycart.paintingname }</td>
                            <td>
                            <a href="manage_cart_edit_cart_add_quantity?id=${mycart.id }" class="btn btn-default"><em class="fa fa-plus"></em></a>
                            ${mycart.quantity }
                            <a href="manage_cart_edit_cart_less_quantity?id=${mycart.id }" class="btn btn-default"><em class="fa fa-minus"></em></a></td>
                            <td>${mycart.status }</td>
                            <td>${mycart.sum }</td>
                            <td>${mycart.dateadded }</td>
                            <td align="center">
                              <a href="manage_cart_delete_cart?id=${mycart.id }" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                          </tr>
                	</c:forEach>
                	<tr>
                		<td colspan="6">Total</td>
                     	<td colspan="3">${total }</td>
                   	</tr>
                 </tbody>
        </table>
     </div>
  </div>
</div>
<a style="float:right" href="manage_cart_generate_bill" class="btn btn-success btn-lg"><em class="fa fa-credit-card"></em>&nbsp;Generate Bill</a>
<div class="col-sm-12">
<jsp:include page="../CommonFooter.jsp"></jsp:include>
</div>

</body>
</html>