<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<h1>LLEGAMOS A LA LISTA DE LOS PRODUCTOS</h1>

<table>
	<tr>
		<th>Nombre</th>
		<th>Costo</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
	
	<c:forEach var="productoTemp" items="${producto }">
	
	<!-- LINK ACTUALIZAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkActualizar" value="/producto/muestraFormularioActualizarProducto">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="productoId" value="${productoTemp.idProducto }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<!-- LINK ELIMINAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkEliminar" value="/producto/eliminarProducto">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="productoId" value="${productoTemp.idProducto }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<tr>
		<td>${productoTemp.nombre }</td>
		<td>${productoTemp.costoBase }</td>
		<td><a href="${linkActualizar }"><input type="button" value="Modificar"/></a></td> <!-- Lo traemos a cada registro de la BBDD por ID -->
		<td><a href="${linkEliminar }"><input type="button" value="Eliminar" onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false"/></a></td>
	
	</tr>
	
	</c:forEach>

</table>

<br/>

<input type="button" value="Agregar Producto" onclick="window.location.href='formularioAgregarProducto'; return false;">


</body>
</html>