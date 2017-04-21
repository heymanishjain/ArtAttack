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

<div class="container">
  <form:form role="form" class="form-horizontal" action="validate_account_update" method="post">
  <div class="form-group">
      <label class="col-sm-12">User</label>
      <div class="col-sm-6"><form:input type="text" path="id" id="id" name="id" class="form-control" placeholder="ID" required="" readonly="true" value="${user.id }"/><div class="help">ID</div></div>
      <div class="col-sm-6"><form:input type="text" path="firstname" id="firstname" name="firstname" class="form-control" placeholder="First Name" required="" value="${user.firstname }"/><div class="help">First Name</div></div>
    </div>
     <div class="form-group">
     <label class="col-sm-12">User</label>
    	 <div class="col-sm-6"><form:input type="text" path="lastname" id="lastname" name="lastname" class="form-control" placeholder="Name" required="" value="${user.lastname }"/><div class="help">Last Name</div></div>
    	  <div class="col-sm-6"><form:input type="email" path="email" id="email" name="email" class="form-control" placeholder="Mail" value="${user.email }" required=""/><div class="help">Email</div></div>
   </div>
   <div class="form-group">
     <label class="col-sm-12">User</label>
    	 <div class="col-sm-6"><form:input type="password" path="password" id="password" name="password" class="form-control" placeholder="Password" value="${user.password }" required=""/><div class="help">Password</div></div>
    	  <div class="col-sm-6"><form:input type="password" path="confirmpassword" id="confirmpassword" name="confirmpassword" class="form-control" value="${user.confirmpassword }" placeholder="Confirm Password" required=""/><div class="help">Confirm Password</div></div>
   </div>
   <div class="form-group">
    	  <div class="col-sm-6" style="visibility:hidden"><form:input type="text" path="role" id="role" name="role" class="form-control" value="${user.role }" placeholder="Role" required=""/></div>
   </div>
    <div class="form-group">
      <div class="col-sm-6">
        <form:button type="submit" class="btn btn-info pull-right">Update Account Information</form:button>
      </div>
    </div>
  </form:form>
  <hr>
</div>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>