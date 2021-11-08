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

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	
	<%
	
	Autor autorForm = (Autor) request.getAttribute("autortData");
	
	%>
	<div class="text-center">
			<h3>AUTORES</h3>
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
			
			List<Autor> listAutor = (List<Autor>) request.getAttribute("data");
			if (listAutor != null) {
				
				for(Autor item : listAutor) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodautor() %></td>
					<td><%=item.getNomautor() %></td>
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