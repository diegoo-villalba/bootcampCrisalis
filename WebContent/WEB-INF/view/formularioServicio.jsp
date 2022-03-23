<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Alta Servicio</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<form:form action="insertarServicio" modelAttribute = "servicio" method="POST">

<table>
	
	<!-- Campo oculto ID para actualizar los registros -->
	<form:hidden path="idServicio"/>
	
	<tr>
		<td>Nombre: </td>
		<td><form:input path="nombre"/></td>
	</tr>
	
	<tr>
		<td>Costo mensual: </td>
		<td><form:input path="costoMensual"/></td>
	</tr>
	
	<tr>
		<td>Fecha: </td>
		<td><form:input path="fechaFinalizacion"/></td>
	</tr>

	
	<tr>
	<td colspan="2"> <input type="submit" value="Insertar"></td>
	</tr>


</table>

</form:form>

</body>
</html>