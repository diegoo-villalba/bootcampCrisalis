<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Alta Producto</title>
<!-- <link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

<div class="d-flex">
		<div class="card col-sm-6"> 
			<div class="card-body">
				<form:form action="insertarProducto" modelAttribute = "producto" method="POST">
				<!-- Campo oculto ID para actualizar los registros -->
					<form:hidden path="idProducto"/>
						<div class="form-group">
							<label>Nombre:</label>
						<form:input path="nombre" class="form-control"/> 
						</div>
						<div class="form-group">
							<label>Costo:</label>
							<form:input path="costoBase" class="form-control"/>
						</div>
						<div class="form-group">
							<input type="submit" value="Insertar" class="btn-info">
						</div>
				</form:form>	
		
			</div>
		
		</div>
		
	</div>

<!--  
<form:form action="insertarProducto" modelAttribute = "producto" method="POST">

<table> 
	
	<!-- Campo oculto ID para actualizar los registros -->
<!-- 	<form:hidden path="idProducto"/>
	
	<tr>
		<td>Nombre: </td>
		<td><form:input path="nombre"/></td>
	</tr>
	
	<tr>
		<td>Costo: </td>
		<td><form:input path="costoBase"/></td>
	</tr>

	
	<tr>
	<td colspan="2"> <input type="submit" value="Insertar"></td>
	</tr>


</table>

</form:form>
-->
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>



</body>
</html>