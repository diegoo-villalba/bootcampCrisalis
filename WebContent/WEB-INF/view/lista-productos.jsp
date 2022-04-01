<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<!--  <link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/> -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

<h1>LISTA DE LOS PRODUCTOS</h1>

<div class="d-flex">
<div class="col-sm-12">
<table class="table table-hover">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Costo</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>
	</thead>
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
	<tbody>
		<tr>
			<td>${productoTemp.nombre }</td>
			<td>${productoTemp.costoBase }</td>
			<td><a href="${linkActualizar }"><input type="button" value="Modificar"/></a></td> <!-- Lo traemos a cada registro de la BBDD por ID -->
			<td><a href="${linkEliminar }"><input type="button" value="Eliminar" onclick="if(!(confirm('¡¡Atención!! Estas por eliminar un registro ¿Estas seguro?'))) return false"/></a></td>
	
		</tr>
	</tbody>
	
	</c:forEach>

</table>
</div>
<br/>


</div>

<div class="col-sm-2">

<input type="button" class="btn btn-primary btn-sm" value="Agregar Producto" onclick="window.location.href='formularioAgregarProducto'; return false;">

</div >


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


</body>
</html>