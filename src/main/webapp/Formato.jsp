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
			<a href="" class="btn btn-success">
				AGREGAR
			</a>		
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