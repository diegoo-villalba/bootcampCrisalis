<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>
<body>


	<h1>LISTA DE PEDIDOS</h1>

	<table>
		<tr>
			<th>Nombre</th>
			<th>Costo</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>

		<c:forEach var="pedidoTemp" items="${pedido }">

			<!-- LINK ACTUALIZAR REGISTRO -->
			<!-- var tiene que coincidir con href de <a> -->
			<c:url var="linkActualizar"
				value="/pedido/muestraFormularioActualizarPedido">

				<!-- Para pasarle a "value" el ID del registro a modificar -->
				<c:param name="idPedido" value="${pedidoTemp.idPedido }" />

			</c:url>
			<!-- ---------------------- -->

			<!-- LINK ELIMINAR REGISTRO -->
			<!-- var tiene que coincidir con href de <a> -->
			<c:url var="linkEliminar" value="/pedido/eliminarPedido">

				<!-- Para pasarle a "value" el ID del registro a modificar -->
				<c:param name="idPedido" value="${pedidoTemp.idPedido }" />

			</c:url>
			<!-- ---------------------- -->

			<tr>
				<td>${pedidoTemp.fechaPedido }</td>
				<td>${pedidoTemp.montoPedido }</td>
				<td><a href="${linkActualizar }"><input type="button"
						value="Modificar" /></a></td>
				<!-- Lo traemos a cada registro de la BBDD por ID -->
				<td><a href="${linkEliminar }"><input type="button"
						value="Eliminar"
						onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false" /></a></td>

			</tr>

		</c:forEach>

	</table>

	<br />

	<input type="button" value="Agregar Pedido"
		onclick="window.location.href='formularioNuevoPedido'; return false;">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


</body>
</html>