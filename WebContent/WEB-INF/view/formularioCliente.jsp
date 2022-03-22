<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Alta Cliente</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<form:form action="insertarCliente" modelAttribute = "cliente" method="POST">

<table>
	
	<!-- Campo oculto ID para actualizar los registros -->
	<form:hidden path="id"/>
	
	<tr>
		<td>Nombre: </td>
		<td><form:input path="nombre"/></td>
	</tr>
	
	<tr>
		<td>Apellido: </td>
		<td><form:input path="apellido"/></td>
	</tr>
	
	<tr>
		<td>DNI: </td>
		<td><form:input path="dni"/></td>
	</tr>
	
	<tr>
	<td colspan="2"> <input type="submit" value="Insertar"></td>
	</tr>


</table>

</form:form>

</body>
</html>