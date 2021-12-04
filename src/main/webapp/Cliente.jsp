<%@page import="beans.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>

<%@ include file="snippet/Header.jsp" %>

</head>
<body>

<% 
	String msj  = (String) request.getAttribute("message");
	if (msj != null){

%>
	<h2><%=msj %></h2>
<%
					
	}
					
%>
<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	
	
	<div class="text-center">
			<h3>Clientes</h3>
	</div>
	
	<%
	
		Cliente autorForm = (Cliente) request.getAttribute("autortData");
					
	%> 
	
	<div class="col-1">
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">AGREGAR</button>
			<!--Formulario para registrar-->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Registrar Cliente</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="ClienteServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Codigo Familia</label>
							<input class="form-control" type="text" name="txtName">
							<label>Numero</label>
							<input class="form-control" type="text" name="txtNumero">
							<label>Codigo Trabajo</label>
							<input class="form-control" type="text" name="txtName">
							<label>Codigo Estudio</label>
							<input class="form-control" type="text" name="txtName">
							<label>Codigo persona</label>
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
					<th>Código Cliente</th>
					<th>Codigo Familia</th>
					<th>Número</th>
					<th>Codigo Trabajo</th>
					<th>Código Estudio</th>
					<th>Código Persona</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Cliente> listCliente = (List<Cliente>) request.getAttribute("data");
			if (listCliente != null) {
				
				for(Cliente item : listCliente) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodcliente() %></td>
					<td><%=item.getCodfamilia() %></td>
					<td><%=item.getNumero() %></td>
					<td><%=item.getCodtrabajo() %></td>
					<td><%=item.getCodestudio() %></td>
					<td><%=item.getCodperson() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodcliente() %>','<%=item.getNumero() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="ClienteServlet?type=delete&id=<%=item.getCodcliente()%>" class="btn btn-danger">ELIMINAR</a>
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
						    <h4 class="modal-title">Modificar Cliente</h4>
					</div>
					<div class="modal-body">
 
						<form action="ClienteServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codido de Cliente</label>
									<input class="form-control" type="text" name="txtcodigo" id="CodigoCliente" readonly>
								</div>
												
								<div class="form-group">
									<label>Codigo Familia</label>
									<input class="form-control" type="text" name="txtcodF" id="CodFam">
								</div>
								
								<div class="form-group">
									<label>Numero</label>
									<input class="form-control" type="text" name="txtNumero" id="Numero">
								</div>
								
								<div class="form-group">
									<label>Codido Trabajo</label>
									<input class="form-control" type="text" name="txtcodt" id="CodigoTrab">
								</div>
												
								<div class="form-group">
									<label>Codigo Estudio</label>
									<input class="form-control" type="text" name="txtcode" id="CodigoEst">
								</div>
								
								<div class="form-group">
									<label>Codigo Persona</label>
									<input class="form-control" type="text" name="txtcodp" id="Codigop">
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
		document.getElementById("CodigoAutor").value = codigo;
		document.getElementById("NombreAutor").value = nombre;
		
  	}
	
</script>

</html>