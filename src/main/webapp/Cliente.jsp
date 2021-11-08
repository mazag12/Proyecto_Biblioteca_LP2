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
			<a href="" class="btn btn-success">
				AGREGAR
			</a>		
	</div>
	
	<div class="col">
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código de Cliente</th>
					<th>Código de Familia</th>
					<th>Número</th>
					<th>Código de trabajo</th>
					<th>Código de estudiante</th>
					<th>Código de personal</th>
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