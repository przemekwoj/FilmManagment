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
	Film
	<c:url var="zamowFilm" value="${pageContext.request.contextPath}/orderFilm">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
	</c:url>	
					
	<c:url var="updateFilm" value="${pageContext.request.contextPath}/updateFilmPage">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
	</c:url>				

	<c:url var="deleteFilm" value="${pageContext.request.contextPath}/deleteFilm">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
	</c:url>
	
	<c:url var="backToHomePage" value="${pageContext.request.contextPath}/backToHomePage">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
	</c:url>
	
	<c:set var="count" value="${count + 1}" scope="page"/>
	${role} 
	<table>
		<tr>
			<th>lp</th>
			<th>tytul</th>
			<th>ilosc wypozyczen</th>
			<th>data wyp.</th>
			<th>data zwrt.</th>
		</tr>
		<tr>
			<td>${count}</td>
			<td>${film.tytul} </td>
			<td>${film.iloscwyp}</td>
			<td>${film.datawyp}</td>
			<td>${film.datazwot}</td>
			<td>
				<c:choose>
   					<c:when test="${film.dostepnosc}">
   					<c:if test="${ role == 'NormalUser'}">
   						<a href="${zamowFilm}"
   						onclick="if (!(confirm('Are you sure you want to order this Film?'))) return false">Zamow</a>
   					</c:if>
   					</c:when>
  			 		<c:otherwise>Niedostepna Aktualnie</c:otherwise>  
					</c:choose>
				<c:if test="${ role == 'Admin'}">
				<a href="${updateFilm}">Update</a>
				|
				<a href="${deleteFilm}"
				onclick="if (!(confirm('Are you sure you want to delete this Film?'))) return false">Delete</a>
				</c:if>
			</td>
		</tr>
	</table>
	<br>
		
	<c:url var="aktorzyPage" value="http://localhost:8080/FilmManagment/aktorzy">
	</c:url>
	<form action="${aktorzyPage}" method="GET">
		<input type='hidden' name='filmId' id='filmId' value="${param.filmId}" />
		<input type='hidden' name='userId' id='userId' value="${param.userId}" />
		<input type="submit" value="akotrzy"/>
	</form>
	<br>
	<a href="${backToHomePage}">Back</a>
</body>
</html>