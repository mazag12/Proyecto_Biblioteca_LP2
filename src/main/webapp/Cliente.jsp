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

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	<div class="text-center">
			<h3>CLIENTE</h3>
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
					<th>C�digo de Cliente</th>
					<th>C�digo de Familia</th>
					<th>N�mero</th>
					<th>C�digo de trabajo</th>
					<th>C�digo de estudiante</th>
					<th>C�digo de personal</th>
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