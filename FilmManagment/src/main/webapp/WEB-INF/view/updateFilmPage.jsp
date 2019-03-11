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
	<form:form action="${pageContext.request.contextPath}/FilmManagment/updateFilm"  modelAttribute="film" method="POST">
		<p>
			tytul <form:input path="tytul"/>
		</p>
		<p>
			iloscc wypozyczen <form:input path="iloscwyp"/>
		</p>
		<p>
			dostepnosc  <form:hidden path="id" value="${param.filmId}"/>
		</p>
		<input type="submit" value="update"/>
	</form:form>
</body>
</html>