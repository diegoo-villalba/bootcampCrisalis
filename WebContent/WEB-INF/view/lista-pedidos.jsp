<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>

<h1>LISTA DE LOS PEDIDOS</h1>

<table>
	<tr>
		<th>Numero de Pedido</th>
		<th>Costo Total</th>
		<th>Fecha</th>
		<th>Producto</th>
		<th>Servicio</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
	
	<c:forEach var="pedidoTemp" items="${pedido }">
	
	<!-- LINK ACTUALIZAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkActualizar" value="/servicio/muestraFormularioActualizarPedido">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="idPedido" value="${pedidoTemp.idPedido }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<!-- LINK ELIMINAR REGISTRO -->
	<!-- var tiene que coincidir con href de <a> -->
	<c:url var="linkEliminar" value="/servicio/eliminarPedido">
	
		<!-- Para pasarle a "value" el ID del registro a modificar -->
		<c:param name="idPedido" value="${pedidoTemp.idPedido }"/>
	
	</c:url>
	<!-- ---------------------- -->
	
	<tr>
		<td>${pedidoTemp.costoTotal }</td>
		<td>${pedidoTemp.pedido }</td>
		<td>${pedidoTemp.cliente }</td>
		<td><a href="${linkActualizar }"><input type="button" value="Modificar"/></a></td> <!-- Lo traemos a cada registro de la BBDD por ID -->
		<td><a href="${linkEliminar }"><input type="button" value="Eliminar" onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false"/></a></td>
	
	</tr>
	
	</c:forEach>

</table>

<br/>

<input type="button" value="Agregar Pedido" onclick="window.location.href='formularioAgregarPedido'; return false;">


</body>
</html>