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
	<div class="col-lg-6">
		<h2>Cliente</h2>
		
	</div>
	
	<div class="col-lg-8">
		<h3>Lista de Clientes</h3>
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Código de Cliente</th>
					<th>Código de Familia</th>
					<th>Número</th>
					<th>Código de trabajo</th>
					<th>Código de estudiante</th>
					<th>Código de personal</th>
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