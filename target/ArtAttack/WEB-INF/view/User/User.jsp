<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Art Attack</title>
</head>
<body>

<jsp:include page="../CommonHeader.jsp"></jsp:include>

<div class="col-md-12">
            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title" style="font-size:30px"><b>User Settings</b></h1>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list" style="text-align:center">
                  <thead>
                    <tr>
                        <th style="text-align:center">ID</th>
                        <th style="text-align:center">First Name</th>
                        <th style="text-align:center">Last Name</th>
                        <th style="text-align:center">Email</th>
                        <th style="text-align:center"><em class="fa fa-cog"></em></th>
                    </tr> 
                  </thead>
                  <tbody>
                          <tr>
                            <td>${displayUser.id }</td>
                            <td>${displayUser.firstname }</td>
                            <td>${displayUser.lastname }</td>
                            <td>${displayUser.email }</td>
                            <td align="center">
                              <a href="manage_account_update?id=${displayUser.id}" class="btn btn-default"><em class="fa fa-pencil"></em></a>
                              <a href="manage_account_delete?id=${displayUser.id }" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                          </tr>
                 </tbody>
        </table>
     </div>
  </div>
</div>
<br>

<jsp:include page="../CommonFooter.jsp"></jsp:include>

</body>
</html>