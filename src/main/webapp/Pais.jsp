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
	
	<div class="text-center">
			<h3>PAIS</h3>
	</div>
	
	<div class="col">
	
		<form action="AutorServlet" method="post" class="form-inline">
		<input type="hidden" name="type" value="register">
		<input type="hidden" name="idSubject">
		  <div class="form-group mb-2">
		    <label for="staticEmail2" class="sr-only">PAIS: </label>
		    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="PAIS: ">
		  </div>
		  <div class="form-group mx-sm-3 mb-2">
		    <label for="inputPassword2" class="sr-only">Password</label>
		    <input type="text" class="form-control" id="inputPassword2" placeholder="Nombre del Pais">
		  </div>
		  <button type="submit" class="btn btn-primary mb-2">Enviar Datos</button>
	</div>
	
	<div class="col-lg-4">
		<h3>Registrar </h3>
		<br>
		<a href="" class="btn btn-success">
				DEPARTAMENTO AGREGAR
		</a>	
		<br>
			<br>
		<a href="" class="btn btn-success">
				PROVINCIA AGREGAR
		</a>
		<br>
		<br>
		<a href="" class="btn btn-success">
				DISTRITO AGREGAR
		</a>
	</div>
	
	<div class="col-lg-8">
		<h3>Lista Pais </h3>
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Departamento</th>
					<th>Provincia</th>
					<th>Distrito</th>
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
					<td><%=item.getNomdepartamento() %></td>
					<td><%=item.getNomprovincia() %></td>
					<td><%=item.getNomdistrito() %></td>
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