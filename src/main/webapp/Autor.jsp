<%@page import="entities.Autor"%>
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

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	<div class="col-lg-6 jumbotron">
		<h2>AUTOR!</h2>
		
	</div>
	
	<div class="col-lg-8">
		<h3>Lista Autores</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
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