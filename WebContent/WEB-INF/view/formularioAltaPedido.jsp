<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Alta Pedido</title>
</head>
<body>

	<div class="d-flex">

		<div class="col-sm-4">

			<div class="card">
				<div class="card-body">
					<div class = "form-group">
						<label>DATOS DEL CLIENTE</label>
					</div>
					<div class = "form-group">
						<input tpye="text" name="codigoCliente" class="form-control" placheholder = "Codigo">
						<input tpye="submit" name="accion" valeu = "Buscar" class="btn btn-outline-light">
					</div>
					<div class = "form-group"></div>
					<div class = "form-group"></div>
					<div class = "form-group"></div>
					<div class = "form-group"></div>
				</div>
			</div>

		</div>

		<div class="col-sm-8"></div>

	</div>

</body>
</html>