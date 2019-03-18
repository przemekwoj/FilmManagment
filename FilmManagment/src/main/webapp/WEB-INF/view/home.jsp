<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	
	Welcome!
	
	${param.userId}
	<br>
	<table>
				<tr>
					<th>lp</th>
					<th>name</th>
				</tr>
				<c:set var="count" value="0" scope="page" />
				
				<c:forEach var="tempFilm" items="${allFilms}">
	
					<c:url var="viewParticularFilm" value="${pageContext.request.contextPath}/viewParticularFilm">
						<c:param name="filmId" value="${tempFilm.id}" />
						<c:param name="userId" value="${param.userId}" />
					</c:url> 
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<tr>
							<td> ${count}</td>
							<td> ${tempFilm.tytul} </td>
							<td>
							<!-- display the update link -->
							<a href="${viewParticularFilm}">View</a>
|							</td>
					</tr>
				</c:forEach>
</table>
	
	<br>
	<form action="${pageContext.request.contextPath}/FilmManagment/addFilmPage" method="GET">
		<input type="submit" value="add Film"/>
	</form>
	<c:if test="${ role == 'Admin'}">
	<form action="${pageContext.request.contextPath}/FilmManagment/addFilmRequestPage" method="GET">
		<input type="submit" value="add new film request"/>
	</form>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/test" method="GET">
		<input type="submit" value="test"/>
	</form>

</body>

</html>