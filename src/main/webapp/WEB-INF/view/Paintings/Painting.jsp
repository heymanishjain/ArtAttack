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
                    <h1 class="panel-title" style="font-size:30px"><b>Paintings</b></h1>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <a href="admin_manage_add_paintings" class="btn btn-success">Add Painting</a>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">ID</th>
                        <th style="text-align:center">Painting Image</th>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Quantity</th>
                        <th style="text-align:center">Price</th>
                        <th style="text-align:center">Description</th>
                        <th style="text-align:center"><em class="fa fa-cog"></em></th>
                    </tr> 
                  </thead>
                  <tbody>
                  	<c:forEach var="paintings" items="${displayPaintings }">
                          <tr>
                            <td>${paintings.id }</td>
                            <td><img src = "images/${paintings.id }.jpg" height="50"></td>
                            <td>${paintings.name }</td>
                            <td>${paintings.quantity }</td>
                            <td>${paintings.price }</td>
                            <td>${paintings.description }</td>
                            <td align="center">
                              <a href="admin_manage_edit_paintings?id=${paintings.id }" class="btn btn-default"><em class="fa fa-pencil"></em></a>
                              <a href="admin_manage_delete_paintings?id=${paintings.id }" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                          </tr>
                	</c:forEach>
                 </tbody>
        </table>
     </div>
  </div>
</div>
<br>
<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>