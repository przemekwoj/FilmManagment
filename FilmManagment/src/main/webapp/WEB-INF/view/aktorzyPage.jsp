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
<style>
#left {
    float:left;
}
</style>
</head>
<body>
<c:url var="changeActor" value="http://localhost:8080/FilmManagment/changeActor">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
</c:url>
<c:url var="addActorPage" value="http://localhost:8080/FilmManagment/addActorPage">
</c:url>
<c:url var="backToPage" value="${pageContext.request.contextPath}/viewParticularFilm">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
</c:url>

aktorzyPage
<br>

<div id="left">
<form:form action="${changeActor}" method="POST"  modelAttribute="actorWrapper" >
   			Imie i Nazwisko
   			<br>
        <c:forEach items="${actorWrapper.actors}" varStatus="vs">
        	
            <form:input path="actors[${vs.index}].first_name"/>
            <form:input path="actors[${vs.index}].last_name"/>
		<br>
   		</c:forEach>         
 <c:if test="${ role == 'Admin'}">           
        <input type="submit" value="update" />
 </c:if>
</form:form>
<c:if test="${ role == 'Admin'}">
	<form action="${addActorPage}" method="get">
		<input type='hidden' name='filmId' id='filmId' value="${param.filmId}" />
		<input type='hidden' name='userId' id='userId' value="${param.userId}" />
		<input type="submit" value="add">
	</form>
</c:if>
<a href="${backToPage}">Back</a>
</div>
<div>
	<br>
     <c:forEach var="tempAktor" items="${listaAktorow}">
	     <c:url var="deleteActorFromFilm" value="http://localhost:8080/FilmManagment/deleteActorFromFilm">
		        	<c:param name="filmId" value="${param.filmId}" />
					<c:param name="userId" value="${param.userId}" />
					<c:param name="aktorId" value="${tempAktor.aktorzy_id}" />
		</c:url> 
		<c:if test="${ role == 'Admin'}">
		<a href="${deleteActorFromFilm}"
					onclick="if (!(confirm('Are you sure you want to delete this Film?'))) return false">Delete</a>
		<br>
		</c:if>
    </c:forEach>                                  
</div>


</body>
</html>