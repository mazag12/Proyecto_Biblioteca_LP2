<%@page import="beans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIBRO</title>

<%@ include file="snippet/Header.jsp" %>

</head>
<body>

<div class="container">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<br>
	
	<%
	
	Libro autorForm = (Libro) request.getAttribute("autortData");
	
	%>
	<div class="text-center">
			<h3>LIBRO</h3>
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
					<th>Código</th>
					<th>Titulo</th>
					<th>Año</th>
					<th>Idioma</th>
					<th>Matematica</th>
					<th>Restrincion</th>
					<th>Cantidad</th>
					<th>Fragmento</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
			<%
			
			List<Libro> listLibro = (List<Libro>) request.getAttribute("data");
			if (listLibro != null) {
				
				for(Libro item : listLibro) {
					
			%>
				<tr class="grilla_campo">
					<td><%=item.getCodlibro() %></td>
					<td><%=item.getTitulo() %></td>
					<td><%=item.getAno() %></td>
					<td><%=item.getCodidioma() %></td>
					<td><%=item.getCodtematica() %></td>
					<td><%=item.getRestrincion() %></td>
					<td><%=item.getCantidad() %></td>
					<td><%=item.getFragmento() %></td>
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