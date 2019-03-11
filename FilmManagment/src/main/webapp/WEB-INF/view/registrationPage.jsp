<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>registration page :)</h3>
		<i>${param.error}</i>
	<form:form action="${pageContext.request.contextPath}/checkRegistration" method="POST">
		<p>
			User email <input type="email" name="email"/>
		</p>
		<p>
			User password <input type="password" name="password"/>
		</p>
		<input type="submit" value="action"/>
	</form:form>
</body>
</html>