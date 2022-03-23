<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<h1>LISTA DE LOS CLIENTES</h1>

<table>
	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>DNI</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
	
	<c:forEach var="clienteTemp" items="${clientes }">
	
	<!-- LINK ACTUALIZAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkActualizar" value="/clientes/muestraFormularioActualizarCliente">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="clienteId" value="${clienteTemp.id }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<!-- LINK ELIMINAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkEliminar" value="/clientes/eliminarCliente">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="clienteId" value="${clienteTemp.id }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<tr>
		<td>${clienteTemp.nombre }</td>
		<td>${clienteTemp.apellido }</td>
		<td>${clienteTemp.dni }</td>
		<td><a href="${linkActualizar }"><input type="button" value="Modificar"/></a></td> <!-- Lo traemos a cada registro de la BBDD por ID -->
		<td><a href="${linkEliminar }"><input type="button" value="Eliminar" onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false"/></a></td>
	
	</tr>
	
	</c:forEach>

</table>

<br/>

<input type="button" value="Agregar Cliente" onclick="window.location.href='formularioAgregarCliente'; return false;">


</body>
</html>