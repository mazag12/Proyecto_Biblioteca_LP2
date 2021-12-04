<%@page import="beans.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado</title>

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
			<h3>Empleados</h3>
	</div>
	
	<%
	
		Empleado autorForm = (Empleado) request.getAttribute("autortData");
					
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
			        <h4 class="modal-title">Registrar Empleado</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="EmpleadoServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Codigo Persona</label>
							<input class="form-control" type="text" name="txtcodp">
						</div>
						
						<div class="form-group">
							<label>Codigo Cargo</label>
							<input class="form-control" type="text" name="txtcodc">
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
					<th>Código empleado</th>
					<th>Código persona</th>
					<th>Código Cargo</th>
					
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Empleado> listEmpleado = (List<Empleado>) request.getAttribute("data");
			if (listEmpleado != null) {
				
				for(Empleado item : listEmpleado) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodigoemple() %></td>
					<td><%=item.getCodperson() %></td>
					<td><%=item.getCodperson() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodigoemple() %>','<%=item.getCodperson() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="AutorServlet?type=delete&id=<%=item.getCodigoemple()%>" class="btn btn-danger">ELIMINAR</a>
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
						    <h4 class="modal-title">Modificar Empleado</h4>
					</div>
					<div class="modal-body">
 
						<form action="EmpleadoServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codigo de Empleado</label>
									<input class="form-control" type="text" name="txtcode" id="CodigoEmp" readonly>
								</div>
												
								<div class="form-group">
									<label>Codigo Persona</label>
									<input class="form-control" type="text" name="txtcodp" id="CodigoPer">
								</div>
								
									<div class="form-group">
									<label>Codigo Cargo</label>
									<input class="form-control" type="text" name="txtcodc" id="CodigoCar">
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