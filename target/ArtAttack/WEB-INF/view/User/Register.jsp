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

<div class="container" >
    	<div class="row">
			<div class="col-md-12">
				<div class="panel panel-login">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							<h1>Register Here</h1>
							<hr>
								<form:form id="REGISTER-form" action="validate_register" method="post" role="form" style="display: block;">
									<div class="form-row">
										<div class='col-xs-6 form-group'>
											<form:input type="text" path="firstname" name="firstname" value="${FNAME }" id="firstname" class="form-control" placeholder="First Name" aria-describedby="fnameHelpInline"/>
											<small id="fnameHelpInline" class="text-muted">
												<p>${RFNAME }</p>
											</small>
										</div>
										<div class='col-xs-6 form-group'>
											<form:input type="text" path="lastname" name="lastname" value="${LNAME }" id="lastname"  class="form-control" placeholder="Last Name" aria-describedby="lnameHelpInline"/>
											<small id="lnamdeHelpInline" class="text-muted">
										    	<p>${RLNAME }</p>
										    </small>
										</div>
									</div>
									<div class="form-row">
										<div class='col-xs-6 form-group'>
											<form:input type="text" path="id" name="id" id="id"  class="form-control" value="${user.id }" placeholder="User ID" aria-describedby="userHelpInline"/>
											<small id="userHelpInline" class="text-muted">
												<p>${compareUF }</p>
												<p>${RUID }</p>
										    </small>
										</div>
										<div class='col-xs-6 form-group'>
											<form:input type="email" path="email" name="email" id="email"  class="form-control" value="${user.email }" placeholder="Email Address" aria-describedby="emailHelpInline"/>
											<small id="emailHelpInline" class="text-muted">
										    	<p>${compareE }</p>
												<p>${RMAIL }</p>
											</small>
										</div>
									</div>
									<div class="form-row">
										<div class='col-xs-6 form-group'>
											<form:input type="password" path="password" name="password" id="password"  class="form-control" placeholder="Password" aria-describedby="passHelpInline"/>
											<small id="passHelpInline" class="text-muted">
												<p>${RPSW }</p>
												<p>${comparePSW }</p>												
										    </small>
										</div>
										<div class='col-xs-6 form-group'>
											<form:input type="password" path="confirmpassword" name="confirmpassword" id="confirmpassword"  class="form-control" placeholder="Confirm Password" aria-describedby="cpassHelpInline"/>
											<small id="cpassHelpInline" class="text-muted">
										    	<p>${RCPSW }</p>
										    </small>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-success" value="Register Now"/>
											</div>
										</div>
									</div>
							 </form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="../CommonFooter.jsp"></jsp:include>
</body>
</html>