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
addFilmRequestPage
<br>
<table>
				<tr>
					<th>lp</th>
					<th>name</th>
				</tr>
				<c:set var="count" value="0" scope="page" />
				
				<c:forEach var="tempFilm" items="${allRequestFilms}">
	
					<c:url var="addRequestedFilm" value="${pageContext.request.contextPath}/addRequestedFilm">
					<c:param name="filmId" value="${tempFilm.id}" />
					</c:url> 
					<c:url var="deleteRequestedFilm" value="${pageContext.request.contextPath}/deleteRequestedFilm">
					<c:param name="filmId" value="${tempFilm.id}" />
					</c:url> 
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<tr>
							<td> ${count}</td>
							<td> ${tempFilm.tytul} </td>
							<td>
							<!-- display the update link -->
							<a href="${addRequestedFilm}">Add</a>
|							</td>
<td>
							<!-- display the update link -->
							<a href="${deleteRequestedFilm}">Delete</a>
|							</td>
					</tr>
				</c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}//FilmManagment/backToHomePage">Back</a>
</body>
</html>