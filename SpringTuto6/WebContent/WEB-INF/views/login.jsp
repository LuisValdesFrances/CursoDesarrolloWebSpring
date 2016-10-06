<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin</title>
		<!-- Scripts -->
		
	</head>
	<body>
	
		<!-- Mete como fragmento una vista(Asi no repito codigo a lo mierder) -->
		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		<h1>Acceso a usuario</h1>
		
		<!-- Solo se llama si el parametro de error es diferente de NULL -->
		<c:if test="${param.error != null}">
			
			<spam style="color:red;">Error de identificacion</spam>
		
		</c:if>
		
		<form name='f' action="j_spring_security_check" method='POST'>
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type='text' name='usuario' value=''></td>
				</tr>
				<tr>
					<td>Contraseña:</td>
					<td><input type='password' name='clave' /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="Accesar" /></td>
				</tr>
			</table>
		</form>

</body>

</html>