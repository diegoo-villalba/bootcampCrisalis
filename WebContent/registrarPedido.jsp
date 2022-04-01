<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedido</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

<div class="d-flex">
	<div class="col-sm-5">
		<div class="card">
			<form action="Controlador" method="POST">
			<div class="card-body">
				<div class="form-group">
					<label>Datos del Cliente</label>
				</div>
				
				<div class="form-group d-flex">
					<div class="col-sm-6 d-flex">
						<input type="text" class="form-control" name="codigocliente" placeholder="Codigo">
						<input type="submit" class="btn btn-outline-info" name="action" value="Buscar">
					</div>
					
					<div class="col-sm-6">
						<input type="text" class="form-control col-sm-6" name="nombrescliente" value="Datos cliente">
					</div>
					
				</div>


				<div class="form-group">
					<label>Datos del Producto</label>
				</div>
				<div class="form-group d-flex">
					<div class="col-sm-6 d-flex">
						<input type="text" class="form-control" name="codigoproducto" placeholder="Codigo">
						<input type="submit" class="btn btn-outline-info" name="accion" value="Buscar">
					</div>
					
					<div class="col-sm-6">
						<input type="text" class="form-control col-sm-6" name="nombrescliente" value="Datos producto">
					</div>
				</div>
				
				<div class="form-group d-flex">
					<div class="col-sm-6 d-flex">
						<input type="text" class="form-control" name="precio" placeholder="S/.0.00">
					</div>
					
					<div class="col-sm-3">
						<input type="number" class="form-control" name="cantidad" placeholder="">
					</div>
					
					<div class="col-sm-3">
						<input type="text" class="form-control" name="stock" placeholder="Stock">
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-outline-info" name="accion" value="Agregar">
				</div>
				
			</div>
			</form>
		</div>
	</div>
</div>






<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>