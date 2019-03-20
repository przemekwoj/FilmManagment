<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>
#left {
    float:left;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
zmowieniaPage
<c:url var="backToHomePage" value="${pageContext.request.contextPath}/backToHomePage">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
</c:url>

<br>
<div id="left">
<c:forEach var="tempFilm" items="${films}">
	
					 
					<c:set var="count" value="${count + 1}" scope="page"/>
					
					<tr>
							<br>
							<td> ${count}</td>
							<td> ${tempFilm.tytul} </td>
						
					</tr>
</c:forEach>
</div>
<div id="left">
<c:forEach var="tempUser" items="${users}">					
					<tr>
							<br>
							<td> ${tempUser.email} </td>
						
					</tr>
</c:forEach>
</div>
<div>
<c:forEach var="tempFilm" items="${films}">

					<c:url var="accept" value="accept">
						<c:param name="filmId" value="${tempFilm.id}" />
					</c:url>
					<c:url var="reject" value="reject">
						<c:param name="filmId" value="${tempFilm.id}" />
					</c:url>
					<tr>
							<br>
							<td> |   <a href="${accept}">accept</a> | <a href="${reject}">reject</a> </td>						
					</tr>
</c:forEach>
</div>
<br>
<a href="${backToHomePage}">Back</a>
</body>
</html>