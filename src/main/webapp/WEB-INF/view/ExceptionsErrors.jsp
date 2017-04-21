<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Attack</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<jsp:include page="CommonHeader.jsp"></jsp:include>
<center><h1>>>>&nbsp;&nbsp;<button onclick="goBack()" class="btn btn-success btn-lg">CLICK HERE</button>&nbsp;&nbsp;To Go Back&nbsp;&nbsp;<<<</h1></center>
<center><h3>${errorMessage }</h3></center>
<jsp:include page="CommonFooter.jsp"></jsp:include>
</body>
</html>