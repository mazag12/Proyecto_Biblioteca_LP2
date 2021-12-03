<%@page import="java.util.List"%>
<%@page import="beans.Carnet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carnet</title>

<%@ include file="snippet/Header.jsp" %>

</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	
	<%
	
	Carnet autorForm = (Carnet) request.getAttribute("autortData");
	
	%>
	<div class="text-center">
			<h3>Carnet</h3>
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
			        <p>Some text in the modal.</p>
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
					<th>Número</th>
					<th>Fecha de emisión</th>
					<th>Fecha de cadudidad</th>
					<th>Estado</th>
					<th>Codigo Categoria</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Carnet> listCarnet = (List<Carnet>) request.getAttribute("data");
			if (listCarnet != null) {
				
				for(Carnet item : listCarnet) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getNumero() %></td>
					<td><%=item.getFecha_emision() %></td>
					<td><%=item.getFecha_caducidad() %></td>
					<td><%=item.getEstado() %></td>
					<td><%=item.getCodcategoria() %></td>
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