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
addActorPage
<c:url var="addActor" value="http://localhost:8080/FilmManagment/addActor">
	<c:param name="filmId" value="${param.filmId}" />
	<c:param name="userId" value="${param.userId}" />
</c:url>
<form:form action="${addActor}" method="POST"  modelAttribute="aktor">
   
  
          Imie  <form:input path="first_name"/>
          <br>
          Nazwisko<form:input path="last_name"/>
           
        <input type="submit" value="add" />
</form:form>
</body>
</html>