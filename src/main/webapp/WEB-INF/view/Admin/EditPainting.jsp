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

<form:form class="form-horizontal" action="admin_validate_edit_paintings" method="post" enctype="multipart/form-data">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_id">Painting ID</label>  
  <div class="col-md-4">
  <form:input id="id" name="id" path="id" placeholder="Painting ID" class="form-control input-md" value="${id }" required="" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_name">Painting NAME</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="PRODUCT NAME" class="form-control input-md" value="${name }" required="" type="text"/>
    
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

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">AVAILABLE QUANTITY</label>  
  <div class="col-md-4">
  <form:input id="quantity" name="quantity" path="quantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md" value="${qty }" required="" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_cost">Painting Cost</label>  
  <div class="col-md-4">
  <form:input id="price" name="price" path="price" placeholder="Painting Price" class="form-control input-md" value="${price }" required="" type="text"/>
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="painting_description">Painting DESCRIPTION </label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description" rows="5" path="description" placeholder="Painting Description">${desc }</textarea>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_category_id">PRODUCT CATEGORY</label>
  <div class="col-md-4">
    <form:select id="category_id" name="category_id" path="category_id" class="form-control">
    <option value="${categoryname }">${categoryname}</option>
    	<c:forEach var="category" items="${categoryList }">
    	<option value="${category.name }">${category.name}</option>
    	</c:forEach>
    </form:select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_artist_id">PRODUCT ARTIST</label>
  <div class="col-md-4">
    <form:select id="artist_id" name="artist_id" path="artist_id" class="form-control">
    	<option value="${artistname }">${artistname }</option>
    	<c:forEach var="artist" items="${artistList }">
    	<option value="${artist.name }">${artist.name }</option>
    	</c:forEach>
    </form:select>
  </div>
</div>

<!-- Image input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="existing_image">UUPLOADED IMAGE</label>  
  <div class="col-md-4">
  <img src="${image}${id}.jpg" height="50" width="50">
  </div>
</div>
 <div class="form-group">  
 <label class="col-md-2 control-label" for="image_upload"></label>
  <div class="col-md-6">
  <form:input path="paintingimage" placeholder="Uplaod New Image" class="form-control input-md" type="file"/>
  </div>
</div>
<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Edit Painting</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>