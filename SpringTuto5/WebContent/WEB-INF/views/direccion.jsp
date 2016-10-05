<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Direccion</title>
		<!-- Scripts -->
		
	</head>
	<body>
		<p>direccion.jsp</p>
		
		<!-- sf:form es un formulario mejorado de spring todos los campos que el usuario rellene
		los va a colocar en el objeto 'admin' haciendo uso de los metodos setters-->
		<!-- ${pageContext.request.contextPath} -> Rellena la URL de forma dinamica: http://localhost... -->
		<sf:form action="${pageContext.request.contextPath}/direccion/save" method="post" commandName="direccion">
			<table>
				<!-- 
				Spring bug
				Peta si la vista intenta acceder a campos nulos. Solo muesto los cambios si idAd es DIFERENTE a 0 
				-->
<%-- 				<c:if test="${admin.idAd ne 0}"> --%>
<%-- 					<sf:input path="idAd" type="hidden"/> --%>
<%-- 					<sf:input path="fechaCreacion" type="hidden"/> --%>
<%-- 				</c:if> --%>
				
				<tr>
					<td>Calle</td>
					<td><sf:input path="calle" type="text"/></td>
				</tr>
				<tr>
					<td>C.P.</td>
					<td><sf:input path="cp" type="text"/></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="Guardar cambios"/></td>
				</tr>
			</table>
		</sf:form>
		<br>
		<c:out value="${result}"></c:out><br><br>
		
		<c:forEach items="${direcciones}" var="direccion">
			<c:out value="${direccion}"/>
			<br/>
		</c:forEach>
		
		<br><a href='<c:url value="/about"/>'>About</a>
	</body>
</html>