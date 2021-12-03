<%@page import="beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autor</title>

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
			<h3>AUTORES</h3>
	</div>
	
	<%
	
		Autor autorForm = (Autor) request.getAttribute("autortData");
					
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
			        <h4 class="modal-title">Modal Header</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="AutorServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Autor</label>
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
			
			List<Autor> listAutor = (List<Autor>) request.getAttribute("data");
			if (listAutor != null) {
				
				for(Autor item : listAutor) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodautor() %></td>
					<td><%=item.getNomautor() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodautor() %>','<%=item.getNomautor() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="AutorServlet?type=delete&id=<%=item.getCodautor()%>" class="btn btn-danger">ELIMINAR</a>
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
						    <h4 class="modal-title">Modificar Autor</h4>
					</div>
					<div class="modal-body">
 
						<form action="AutorServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codido de Autor</label>
									<input class="form-control" type="text" name="txtcodigo" id="CodigoAutor" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Autor</label>
									<input class="form-control" type="text" name="txtName" id="NombreAutor">
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