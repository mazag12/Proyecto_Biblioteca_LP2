<%@page import="beans.Tematica"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tematica</title>
<%@ include file="snippet/Header.jsp" %>
</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	<div class="text-center">
			<h3>TEMATICA</h3>
	</div>
	
	<div class="col-1">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">AGREGAR</button>
			
			<!--Formulario para registrar-->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Registrar Tematica</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="TematicaServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Tematica</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						
						<input type="submit" class="btn btn-primary" value="Registrar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para registrar-->	
	</div>
	
	<div class="col">
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Tematica> listTematica = (List<Tematica>) request.getAttribute("data");
			if (listTematica != null) {
				
				for(Tematica item : listTematica) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodTematica() %></td>
					<td><%=item.getNomTematica() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodTematica() %>','<%=item.getNomTematica() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="TematicaServlet?type=delete&id=<%=item.getCodTematica()%>" class="btn btn-danger">ELIMINAR</a>
					</td>
				</tr>
			<%
					
				}
				
			}
			
			%>
			
			</tbody>
		</table>
		
		<!--Formulario para editar-->
		
		<div id="ModalModificar" class="modal fade" role="dialog">
			<div class="modal-dialog">
						
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						    <h4 class="modal-title">Modificar Tematica</h4>
					</div>
					<div class="modal-body">
 
						<form action="TematicaServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codido de Tematica</label>
									<input class="form-control" type="text" name="txtcodigo" id="CodigoTematica" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Tematica</label>
									<input class="form-control" type="text" name="txtName" id="NombreTematica">
								</div>

							<input type="submit" class="btn btn-primary" value="Modificar">
									
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				<!--Fin del Modal-->
			</div>
		</div>
		<!--Fin del Formulario para editar-->
		
	</div>

</div>

</body>


<%@ include file="snippet/Footer.jsp" %>

<script type="text/javascript">
	
	function miFunc(codigo,nombre) {
		document.getElementById("CodigoTematica").value = codigo;
		document.getElementById("NombreTematica").value = nombre;
		
  	}
	
</script>

</html>