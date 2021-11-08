<%@page import="beans.Estudios"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudios</title>

<%@ include file="snippet/Header.jsp" %>
</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	<br>
	
	<div class="text-center">
			<h3>ESTUDIOS</h3>
	</div>
	
	<div class="col-1">
			<a href="" class="btn btn-success">
				AGREGAR
			</a>		
	</div>

	<div class="col">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Codigo Estudiante</th>
					<th>Universidad</th>
					<th>Carrera</th>
					<th>Telefono</th>
					<th>Celular</th>
					<th>Direccion</th>
					<th>CodPais</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<%
			
			List<Estudios> listEstudios = (List<Estudios>) request.getAttribute("data");
			if (listEstudios != null) {
				
				for(Estudios item : listEstudios) {
					
			%>
				<tr class="grilla_campo">
					<td><%= item.getCodEstudiante() %></td>
					<td><%= item.getNomEstudio() %></td>
					<td><%= item.getCarrera() %></td>
					<td><%= item.getTelefono() %></td>
					<td><%= item.getCelular() %></td>
					<td><%= item.getDireccion() %></td>
					<td><%= item.getCodPais() %></td>
					<td>
						<a href="" class="btn btn-warning">MODIFICAR</a>
					</td>
					<td>
						<a href="" class="btn btn-danger">ELIMINAR</a>
					</td>
				</tr>
			
			<%
					
				}
				
			}
			
			%>
			
			</tbody>
		</table>
		
	</div>

</div>

</body>
<%@ include file="snippet/Footer.jsp" %>

</html>
