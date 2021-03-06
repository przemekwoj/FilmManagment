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
	<link rel="stylesheet" type="text/css" href="/resources/style.css">
	
</head>

<body>
	<h3>Login Page</h3>
	<i>${param.error}</i>
	<form action="${pageContext.request.contextPath}/checkLoginUser" method="POST">
		<p>
			User email <input type="email" name="email"/>
		</p>
		<p>
			User password <input type="password" name="password"/>
		</p>
		<input type="submit" value="login"/>
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/registrationPage" method="GET">
		<input type="submit" value="registration"/>
	</form>
</body>
</html>