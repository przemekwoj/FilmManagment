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
Prosba o Dodanie filmu
<form:form action="${pageContext.request.contextPath}/FilmManagment/addingFilm" method="POST">
<p>
Tytul :<input type="text" name="tytul"/>
</p>
<input type="submit" value="dodaj"/>
</form:form>

</body>
</html>