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
	<div class="col-lg-6">
		<h2>FORMATO </h2>
		
	</div>
	
	<div class="col-lg-8">
		<h3>Lista Formato </h3>
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
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