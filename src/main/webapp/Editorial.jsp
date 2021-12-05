<%@page import="beans.Editorial"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editorial</title>
<%@ include file="snippet/Header.jsp" %>
</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	<div class="text-center">
			<h3>EDITORIAL</h3>
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
			        <h4 class="modal-title">Registrar Editorial</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="EditorialServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Editorial</label>
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
		
		<br>
		<br>
		<table id=tabledatos class="table table-striped table-bordered" style="width:100%">
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
			
			List<Editorial> listEditorial = (List<Editorial>) request.getAttribute("data");
			if (listEditorial != null) {
				
				for(Editorial item : listEditorial) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodEditorial() %></td>
					<td><%=item.getNomEditorial() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar" onclick="miFunc('<%=item.getCodEditorial() %>','<%=item.getNomEditorial() %>');">MODIFICAR</button>
					</td>
					<td>
						<a href="EditorialServlet?type=delete&id=<%=item.getCodEditorial()%>" class="btn btn-danger">ELIMINAR</a>
					</td>
				</tr>
			<%
					
				}
				
			}
			
			%>
			
			</tbody>
			<tfoot>
	            <tr>
	                <th>Código</th>
					<th>Nombre</th>
					<th></th>
					<th></th>
	            </tr>
        	</tfoot>
		</table>
		
		<!--Formulario para editar-->
		
		<div id="ModalModificar" class="modal fade" role="dialog">
			<div class="modal-dialog">
						
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						    <h4 class="modal-title">Modificar Editorial</h4>
					</div>
					<div class="modal-body">
 
						<form action="EditorialServlet" method="post">
							<input type="hidden" name="type" value="edit">
								<div class="form-group">
									<label>Codido de Editorial</label>
									<input class="form-control" type="text" name="txtcodigo" id="CodigoEditorial" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Editorial</label>
									<input class="form-control" type="text" name="txtName" id="NombreEditorial">
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
		document.getElementById("CodigoEditorial").value = codigo;
		document.getElementById("NombreEditorial").value = nombre;
		
  	}
	
</script>

</html>