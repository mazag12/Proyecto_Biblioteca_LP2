<%@page import="beans.Formato"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formato</title>
<%@ include file="snippet/Header.jsp" %>
</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	<div class="text-center">
			<h3>FORMATO</h3>
	</div>
	
	<div class="col-1">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#ModalRegistrar">AGREGAR</button>
			
			<div id="ModalRegistrar" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Registrar Formato</h4>
			      </div>
			      <div class="modal-body">
			        <form action="FormatoServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Autor</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						
						<input type="submit" class="btn btn-primary" value="Registrar">
			
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
					<th>Código</th>
					<th>Nombre</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Formato> listFormato = (List<Formato>) request.getAttribute("data");
			if (listFormato != null) {
				
				for(Formato item : listFormato) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodformato() %></td>
					<td><%=item.getNomformato () %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodformato() %>','<%=item.getNomformato() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="FormatoServlet?type=delete&id=<%=item.getCodformato()%>" class="btn btn-danger">ELIMINAR</a>
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
						    <h4 class="modal-title">Modificar Formato</h4>
					</div>
					<div class="modal-body">
 
						<form action="FormatoServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codido de Formato</label>
									<input class="form-control" type="text" name="txtcodigo" id="CodigoFormato" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Formato</label>
									<input class="form-control" type="text" name="txtName" id="NombreFormato">
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
		document.getElementById("CodigoFormato").value = codigo;
		document.getElementById("NombreFormato").value = nombre;
		
  	}
	
</script>

</html>