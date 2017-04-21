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
<jsp:include page="CommonHeader.jsp"></jsp:include>

<div class="row">
 <c:forEach var="paintings" items="${displayPaintings }">
    <div class="col-xs-6 col-md-3">
      <div class="thumbnail">
        <img src="images/${paintings.id}.jpg" height="75"/>
          <div class="caption">
          <center>${paintings.name}
          <p>Cost: ${paintings.price}</p>
          <a href="validate_add_cart?pid=${paintings.id}" class="btn btn-default"><em class="fa fa-shopping-cart fa-fw"></em>Add To Cart</a>
          </center>
          </div>
          </div>
    </div>
    </c:forEach>
    </div>


<br>
<jsp:include page="CommonFooter.jsp"></jsp:include>
</body>
</html>