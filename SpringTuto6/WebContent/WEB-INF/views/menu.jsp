<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Menu</title>
		
	</head>
	<body>
	
	<h1>Menu</h1>
	
	<sec:authorize access="!isAuthenticated()">Haga usted el favor de inicar sesion</sec:authorize>
	<sec:authorize access="isAuthenticated()">Ainiciado sesion como: 
		<!-- "principal" es una interfaz de spring que almacena los datos del usuario que inicio la sesion" -->
		<sec:authentication property="principal" var="principal"/>
		<c:set var="nombre" value="${principal.username}"/> <!-- Accede a la variable principal.username y lo mete en "nombre" -->
		<c:out value="${nombre}"></c:out>
		<br>
		<a href="<c:url value='/logout'/>">Chapa la sesion</a>
	</sec:authorize>

</body>

</html>