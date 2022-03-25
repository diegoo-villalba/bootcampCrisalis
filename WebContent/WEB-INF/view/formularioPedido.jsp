<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Alta Pedido</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>
<body>

	<form:form action="insertarPedido" modelAttribute="pedido"
		method="POST">
		<!-- Campo oculto ID para actualizar los registros -->
		<form:hidden path="idPedido" />
		<div>
			<table>

				<form:form action="insertarCliente" modelAttribute="cliente"
					method="POST">
					<form:hidden path="id" />

					<tr>
						<td>Nombre:</td>
						<td><form:input path="nombre" /></td>
					</tr>

					<tr>
						<td>Costo mensual:</td>
						<td><form:input path="costoTotal" /></td>
					</tr>

					<tr>
						<td>Fecha:</td>
						<td><form:input path="fechaFinalizacion" /></td>
					</tr>
				</form:form>


			</table>
		</div>

		<tr>
			<td colspan="2"><input type="submit" value="Insertar"></td>
		</tr>
	</form:form>

</body>
</html>