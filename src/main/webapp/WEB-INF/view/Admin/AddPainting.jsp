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

<form:form class="form-horizontal" action="admin_validate_add_paintings" method="post" enctype="multipart/form-data">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_id">Painting ID</label>  
  <div class="col-md-4">
  <form:input id="id" name="id" path="id" placeholder="Painting ID" class="form-control input-md" required="" value="${painting.id }" type="text" aria-describedby="idHelpInline"/>
   <small id="idHelpInline" class="text-muted">
	<p>${ID }</p>
	</small> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_name">Painting NAME</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="PRODUCT NAME" class="form-control input-md" required="" value="${painting.name }" type="text" aria-describedby="nameHelpInline"/>
  <small id="nameHelpInline" class="text-muted">
	<p>${Name }</p>
	</small>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">AVAILABLE QUANTITY</label>  
  <div class="col-md-4">
  <form:input id="quantity" name="quantity" path="quantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md" value="${painting.quantity }" required="" type="text" aria-describedby="quantityHelpInline"/>
   	<small id="quantityHelpInline" class="text-muted">
	<p>${Quantity }</p>
	</small> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_cost">Painting Cost</label>  
  <div class="col-md-4">
  <form:input id="price" name="price" path="price" placeholder="Painting Price" class="form-control input-md" required="" type="text" value="${painting.price }" aria-describedby="costHelpInline"/>
  <small id="priceHelpInline" class="text-muted">
	<p>${Price }</p>
	</small>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_description">Painting DESCRIPTION </label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description" rows="5" path="description" placeholder="Painting Description" aria-describedby="descriptionHelpInline">${painting.description }</textarea>
  	<small id="descritionHelpInline" class="text-muted">
	<p>${Description }</p>
	</small>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_category_id">PAINTING's CATEGORY</label>
  <div class="col-md-4">
    <form:select id="category_id" name="category_id" path="category_id" class="form-control">
    	<c:forEach var="category" items="${categoryList }">
    	<option value="${category.name }">${category.name }</option>
    	</c:forEach>
    </form:select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_artist_id">PAINTING's ARTIST</label>
  <div class="col-md-4">
    <form:select id="artist_id" name="artist_id" path="artist_id" class="form-control">
    	<c:forEach var="artist" items="${artistList }">
    	<option value="${artist.name }">${artist.name }</option>
    	</c:forEach>
    </form:select>
  </div>
</div>


<!-- Image input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="image_upload">Upload Image</label>  
  <div class="col-md-4">
  <form:input path="paintingimage" placeholder="Uplaod Image" class="form-control input-md" type="file" aria-describedby="imageHelpInline"/>
  <small id="imageHelpInline" class="text-muted">
	<p>${Image }</p>
	</small>
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Add Painting</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>