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
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">AGREGAR</button>
			
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Modal Header</h4>
			      </div>			     
			      <div class="modal-body">		      
			      
			      <form action="EstudiosServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Estudio</label>
							<input class="form-control" type="text" name="txtNombre">
						</div>
						
						<div class="form-group">
							<label>Nombre de Carrera</label>
							<input class="form-control" type="text" name="txtCarrera">
						</div>
						
						<div class="form-group">
							<label>Telefono</label>
							<input class="form-control" type="text" name="txtTelefono">
						</div>
						
						<div class="form-group">
							<label>Celular</label>
							<input class="form-control" type="text" name="txtCelular">
						</div>
						
						<div class="form-group">
							<label>Direccion</label>
							<input class="form-control" type="text" name="txtDireccion">
						</div>
						
						<div class="form-group">
							<label>Codigo Pais</label>
							<input class="form-control" type="text" name="txtCodPais">
						</div>
						
						<input type="submit" class="btn btn-primary" value="Enviar Datos">
						
					</form>
			      		      
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			</div>		
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
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#<%=item.getCodEstudiante() %>" onclick="miFunc()">MODIFICAR</button>
						
						<div id="<%=item.getCodEstudiante()%>" class="modal fade" role="dialog">
						  <div class="modal-dialog">
						
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">Modificar Autor</h4>
						      </div>
						      <div class="modal-body">
								   
								   
						        <form action="EstudiosServlet" method="post">
					
									<input type="hidden" name="type" value="edit">
									
									<div class="form-group">
										<label>Codido de Estudiante</label>
										<input class="form-control" type="text" name="txtCodEsA" value="<%=item.getCodEstudiante() %>" readonly>
									</div>
												
									<div class="form-group">
										<label>Nombre de Estudio</label>
										<input class="form-control" type="text" name="txtNombreA" value="<%=item.getNomEstudio()%>">
									</div>
									
									<div class="form-group">
										<label>Nombre de Carrera</label>
										<input class="form-control" type="text" name="txtCarreraA" value="<%=item.getCarrera()%>">
									</div>
									
									<div class="form-group">
										<label>Telefono</label>
										<input class="form-control" type="text" name="txtTelefonoA" value="<%=item.getTelefono()%>">
									</div>
									
									<div class="form-group">
										<label>Celular</label>
										<input class="form-control" type="text" name="txtCelularA" value="<%=item.getCelular()%>">
									</div>
									
									<div class="form-group">
										<label>Direccion</label>
										<input class="form-control" type="text" name="txtDireccionA" value="<%=item.getDireccion()%>">
									</div>
									
									<div class="form-group">
										<label>CodPais</label>
										<input class="form-control" type="text" name="txtCodPaisA" value="<%=item.getCodPais()%>">
									</div>
									
									<input type="submit" class="btn btn-primary" value="Enviar Datos">
									
								</form>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						      </div>
						    </div>
							<!--Fin del Modal-->
						  </div>
						</div>

					</td>
					<td>
						<a href="EstudiosServlet?type=delete&id=<%=item.getCodEstudiante()%>" class="btn btn-danger">ELIMINAR</a>
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
