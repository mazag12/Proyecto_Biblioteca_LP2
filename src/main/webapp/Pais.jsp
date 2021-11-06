<%@page import="beans.Pais"%>
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
		<h2>PAIS </h2>
		
	</div>
	
	<div class="col-lg-8">
		<h3>Lista Pais </h3>
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Pais> listPais = (List<Pais>) request.getAttribute("data");
			if (listPais != null) {
				
				for(Pais item : listPais) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodpais() %></td>
					<td><%=item.getNompais () %></td>
					
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