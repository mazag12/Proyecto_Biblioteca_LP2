<%@page import="beans.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Persona</title>

<%@ include file="snippet/Header.jsp" %>
</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	<br>

<div class="text-center">
			<h3>PERSONA</h3>
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
			      
			      <form action="PersonaServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre </label>
							<input class="form-control" type="text" name="txtNombre">
						</div>
						
						<div class="form-group">
							<label>Ape. Paterno</label>
							<input class="form-control" type="text" name="txtPaterno">
						</div>
						
						<div class="form-group">
							<label>Ape. Materno</label>
							<input class="form-control" type="text" name="txtMaterno">
						</div>
						
						<div class="form-group">
							<label>Tipo Documento</label>
							<input class="form-control" type="text" name="txtTipo">
						</div>
						
						<div class="form-group">
							<label>N° Documento</label>
							<input class="form-control" type="text" name="txtNum">
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
							<label>Correo</label>
							<input class="form-control" type="text" name="txtCorreo">
						</div>
						<div class="form-group">
							<label>Direccion</label>
							<input class="form-control" type="text" name="txtDireccion">
						</div>
						<div class="form-group">
							<label>Sexo</label>
							<input class="form-control" type="text" name="txtSexo">
						</div>
						<div class="form-group">
							<label>Nacionalidad</label>
							<input class="form-control" type="text" name="txtNacionalidad">
						</div>
						<div class="form-group">
							<label>Estado Civil</label>
							<input class="form-control" type="text" name="txtEstado">
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
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Ape. Paterno</th>
					<th>Ape. Materno</th>
					<th>Tipo Doc.</th>
					<th>N° Doc.</th>
					<th>Telefono</th>
					<th>Celular</th>
					<th>Correo</th>
					<th>Direccion</th>
					<th>Sexo</th>
					<th>Nacionalidad</th>
					<th>Estado Civil</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<%
			
			List<Persona> listPersona = (List<Persona>) request.getAttribute("data");
			if (listPersona != null) {
				
				for(Persona item : listPersona) {
					
			%>
				<tr class="grilla_campo">
					<td><%= item.getCodPersona() %></td>
					<td><%= item.getNombre() %></td>
					<td><%= item.getApePaterno()%></td>
					<td><%= item.getApeMaterno() %></td>
					<td><%= item.getTipoDoc() %></td>
					<td><%= item.getNumDoc() %></td>
					<td><%= item.getTelefono()%></td>
					<td><%= item.getCelular()%></td>
					<td><%= item.getCorreo()%></td>
					<td><%= item.getDireccion()%></td>
					<td><%= item.getSexo()%></td>
					<td><%= item.getNacionalidad()%></td>
					<td><%= item.getEstadoCivil()%></td>
					
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#<%=item.getCodPersona() %>" onclick="miFunc()">MODIFICAR</button>
						
						<div id="<%=item.getCodPersona()%>" class="modal fade" role="dialog">
						  <div class="modal-dialog">
						
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">Modificar Persona</h4>
						      </div>
						      <div class="modal-body">
								   
								   
						        <form action="PersonaServlet" method="post">
					
									<input type="hidden" name="type" value="edit">
									
									<div class="form-group">
										<label>Codido</label>
										<input class="form-control" type="text" name="txtCodA" value="<%=item.getCodPersona() %>" readonly>
									</div>
												
									<div class="form-group">
										<label>Nombre</label>
										<input class="form-control" type="text" name="txtNombreA" value="<%=item.getNombre()%>">
									</div>
									
									<div class="form-group">
										<label>Apellido Paterno</label>
										<input class="form-control" type="text" name="txtPaternoA" value="<%=item.getApePaterno()%>">
									</div>
									
									<div class="form-group">
										<label>Apellido Materno</label>
										<input class="form-control" type="text" name="txtMaternoA" value="<%=item.getApeMaterno()%>">
									</div>
									
									<div class="form-group">
										<label>Tipo de Documento</label>
										<input class="form-control" type="text" name="txtTipoA" value="<%=item.getTipoDoc()%>">
									</div>
									
									<div class="form-group">
										<label>N° Documento</label>
										<input class="form-control" type="text" name="txtNumA" value="<%=item.getNumDoc()%>">
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
										<label>Correo</label>
										<input class="form-control" type="text" name="txtCorreoA" value="<%=item.getCorreo()%>">
									</div>
									<div class="form-group">
										<label>Direccion</label>
										<input class="form-control" type="text" name="txtDireccionA" value="<%=item.getDireccion()%>">
									</div>
									<div class="form-group">
										<label>Sexo</label>
										<input class="form-control" type="text" name="txtSexoA" value="<%=item.getSexo()%>">
									</div>
									<div class="form-group">
										<label>Nacionalidad</label>
										<input class="form-control" type="text" name="txtNacionalidadA" value="<%=item.getNacionalidad()%>">
									</div>
									<div class="form-group">
										<label>Estado Civil</label>
										<input class="form-control" type="text" name="txtEstadoA" value="<%=item.getEstadoCivil()%>">
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
						<a href="PersonaServlet?type=delete&id=<%=item.getCodPersona()%>" class="btn btn-danger">ELIMINAR</a>
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
