<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Attack</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<jsp:include page="../CommonHeader.jsp"></jsp:include>

<form:form class="form-horizontal" action="admin_validate_add_category" method="post">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_id">Category ID</label>  
  <div class="col-md-4">
  <form:input id="id" name="id" path="id" placeholder="Category ID" value="${category.id }" class="form-control input-md" required="" type="text" aria-describedby="idHelpInline"/>
  <small id="idHelpInline" class="text-muted">
	<p>${ID }</p>
	</small>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name">Category NAME</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="Category NAME" value="${category.name }" class="form-control input-md" required="" type="text" aria-describedby="nameHelpInline"/>
   <small id="nameHelpInline" class="text-muted">
	<p>${Name }</p>
	</small>  
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
    <textarea class="form-control" id="description" name="description" rows="5" path="description" placeholder="Category Description" aria-describedby="descriptionHelpInline">${category.description }</textarea>
    <small id="descritionHelpInline" class="text-muted">
	<p>${Description }</p>
	</small>
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Add Category</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>