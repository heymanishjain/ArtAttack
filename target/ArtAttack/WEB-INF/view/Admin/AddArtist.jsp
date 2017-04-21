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

<form:form class="form-horizontal" action="admin_validate_add_artist" method="post">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="artist_id">Artist ID</label>  
  <div class="col-md-4">
  <form:input id="id" name="id" path="id" placeholder="Artist ID" class="form-control input-md" value="${artist.id }" required="" type="text" aria-describedby="idHelpInline"/>
   <small id="idHelpInline" class="text-muted">
	<p>${ID }</p>
	</small>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="artist_name">Artist NAME</label>  
  <div class="col-md-4">
  <form:input id="name" name="name" path="name" placeholder="Artist NAME" value="${artist.name }" class="form-control input-md" required="" type="text" aria-describedby="nameHelpInline"/>
  <small id="nameHelpInline" class="text-muted">
	<p>${Name }</p>
	</small> 
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="artist_description">Artist DESCRIPTION </label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description" rows="5" path="description" placeholder="Artist Description" aria-describedby="descriptionHelpInline">${artist.description }</textarea>
    <small id="descritionHelpInline" class="text-muted">
	<p>${Description }</p>
	</small>
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-6 control-label" for="submit_button"></label>
  <div class="col-md-6">
    <button id="submit_button" name="submit_button" type="submit" class="btn btn-success">Add Artist</button>
  </div>
  </div>

</form:form>

<jsp:include page="../CommonFooter.jsp"></jsp:include>

</body>
</html>