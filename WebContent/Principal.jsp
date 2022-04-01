<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a class="nav-link active"
						aria-current="page" href="#">Home</a>
						</li>
					<li class="nav-item">
					<a stlye="margin-left:10px; border:none" class="nav-link btn-outline-light" href="producto/lista">Productos</a>
					</li>
					<li class="nav-item">
					<a stlye="margin-left:10px; border:none" class="nav-link btn-outline-light" href="servicio/lista">Servicios</a>
					</li>
					<li class="nav-item">
					<a stlye="margin-left:10px; border:none" class="nav-link btn-outline-light" href="clientes/lista">Clientes</a>
					</li>
					<li class="nav-item">
					<a stlye="margin-left:10px; border:none" class="nav-link btn-outline-light" href="pedido/lista">Pedidos</a>
					</li>
					
					<li class="nav-item">
					<a stlye="margin-left:10px; border:none" class="nav-link btn-outline-light" href="Controlador?menu=NuevoPedido">Nuevo Pedido</a>
					</li>
				</ul>
			</div>
	</nav> 

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>