<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Art Attack</title>
</head>
<body>
<jsp:include page="../CommonHeader.jsp"></jsp:include>

<form:form class="form-horizontal" action="admin_validate_edit_category" method="post">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_id">Category ID</label>  
  <div class="col-md-4">
  <form:input id="id" name="id" path="id" placeholder="Category ID" class="form-control input-md" value="${id }" required="" type="text"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name">Category NAME</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="Category NAME" class="form-control input-md" value="${name }" required="" type="text"/>
    
  </div>
</div>

<!-- Select Basic 
<div class="form-group">
  <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
  <div class="col-md-4">
    <select id="product_categorie" name="product_categorie" class="form-control">
    </select>
  </div>
</div>-->

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_description">Category DESCRIPTION </label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description" rows="5" path="description" placeholder="Category Description">${desc }</textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Update Category</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>