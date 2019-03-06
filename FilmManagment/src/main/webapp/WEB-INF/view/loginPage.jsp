<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Login Page</title>
	<spring:url value="/resources/style.css" var="styleCSS" />
	<link href="${styleCSS}" rel="stylesheet" />
	
</head>

<body>
"${styleCSS}" 
	<h3>Login Page</h3>
	<c:if test = "${param.error != null}">
		<i>Sorry , you entered wrong email or password</i>
	</c:if>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<p>
			User email <input type="email" name="email"/>
		</p>
		<p>
			User password <input type="password" name="password"/>
		</p>
		<input type="submit" value="login"/>
	</form:form>
</body>
</html>