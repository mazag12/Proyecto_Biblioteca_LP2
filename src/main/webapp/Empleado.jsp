<%@page import="beans.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


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
					<th>Código Empleado</th>
					<th>Código personal</th>
					<th>Código cargo</th>
				
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
					<td><%=item.getCodcargo() %></td>
					
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