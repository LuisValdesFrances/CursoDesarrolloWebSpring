<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<p>index.jsp</p>
		
		
		<c:out value="${adminForm}"/><br>
		<!--
		Atributos con ambito de vista: <c:out value="${message}"/><br>
		Atributos con ambito de sesion: <c:out value="${sessionScope.result}"/>
		-->
		<br><a href='<c:url value="/about"/>'>About</a>
		<br><a href='<c:url value="/admin"/>'>Gestionar administradores</a>
	</body>
</html>