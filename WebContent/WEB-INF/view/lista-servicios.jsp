<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servicios</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<h1>LISTA DE LOS SERVICIOS</h1>

<table>
	<tr>
		<th>Nombre</th>
		<th>Costo Mensual</th>
		<th>Fecha</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
	
	<c:forEach var="servicioTemp" items="${servicio }">
	
	<!-- LINK ACTUALIZAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkActualizar" value="/servicio/muestraFormularioActualizarServicio">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="servicioId" value="${servicioTemp.idServicio }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<!-- LINK ELIMINAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkEliminar" value="/servicio/eliminarServicio">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="servicioId" value="${servicioTemp.idServicio }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<tr>
		<td>${servicioTemp.nombre }</td>
		<td>${servicioTemp.costoMensual }</td>
		<td>${servicioTemp.fechaFinalizacion }</td>
		<td><a href="${linkActualizar }"><input type="button" value="Modificar"/></a></td> <!-- Lo traemos a cada registro de la BBDD por ID -->
		<td><a href="${linkEliminar }"><input type="button" value="Eliminar" onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false"/></a></td>
	
	</tr>
	
	</c:forEach>

</table>

<br/>

<input type="button" value="Agregar Servicio" onclick="window.location.href='formularioAgregarServicio'; return false;">


</body>
</html>