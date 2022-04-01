<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Insertar Pedido</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
</head>
<body>

	<form action="insertarPedido" method="POST">


		<spring:bind path="cliente.id">
			<input type="text">
			<br />
		</spring:bind>

		<spring:bind path="cliente.apellido">
			<input type="text">
			<br />
		</spring:bind>

		<spring:bind path="cliente.dni">
			<input type="text">
			<br />
		</spring:bind>

		<spring:bind path="pedido.fechaPedido">
			<input type="text">
			<br />
		</spring:bind>
		<br /> <input type="submit" value="Insertar" />
	</form>


	</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


</body>
</html>