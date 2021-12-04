<%@page import="interfaces.DepartamentoInterface"%>
<%@page import="beans.Pais"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="misLibrerias" prefix="etiquetas"%>
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
	
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myagregar">AGREGAR PAIS</button>
		
			<!--Formulario para registrar-->
			<div id="myagregar" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Registrar Pais</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>Nombre de Pais</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						
						<input type="submit" class="btn btn-primary" value="Registrar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para registrar-->
			
			<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myactualizar">ACTUALIZAR PAIS</button>
		
			<!--Formulario para actualizar-->
			<div id="myactualizar" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Actualizar Pais</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						
						<div class="form-group">
							<label>Selecciona el Pais</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>				
						<div class="form-group">
							<label>Nuevo Nombre del Pais</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						
						<input type="submit" class="btn btn-primary" value="Registrar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para registrar-->
			
			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myEliminar">ELIMINAR PAIS</button>
		
			<!--Formulario para eliminar-->
			<div id="myEliminar" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Eliminar Pais</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						
						<div class="form-group">
							<label>Selecciona el Pais</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>				

						<input type="submit" class="btn btn-primary" value="Eliminar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para eliminar-->
			
	</div>
	
	<div class="col-lg-3">
		<br>
			<br>
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#agregarDepartamento">AGREGAR DEPARTAMENTO</button>
		
			<!--Formulario para agregar departamento-->
			<div id="agregarDepartamento" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Agregar Departamento</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						
						<div class="form-group">
							<label>Selecciona el Pais</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>				
						<div class="form-group">
							<label>Nombre del Departamento</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						<input type="submit" class="btn btn-primary" value="Agregar">
							
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para agregar departamento-->
			<br>
			<br>
			
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#agregarProvincia">AGREGAR PROVINCIA</button>
		
			<!--Formulario para agregar Provincia-->
			<div id="agregarProvincia" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Agregar Provincia</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						
						<div class="form-group">
							<label>Selecciona el Pais</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>
						<div class="form-group">
							<label>Selecciona el Departamento</label>
						</div>				
						<div class="form-group">
							<label>Nombre del Provincia</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						<input type="submit" class="btn btn-primary" value="Agregar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para agregar Provincia-->
			<br>
			<br>
			
			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#agregarDistrito">AGREGAR DISTRITO</button>
		
			<!--Formulario para agregar Distrito-->
			<div id="agregarDistrito" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Agregar Distrito</h4>
			      </div>
			      <div class="modal-body">
					   
			        <form action="PaisServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						
						<div class="form-group">
							<label>Selecciona el Pais</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>
						<div class="form-group">
							<label>Selecciona el Departamento</label>
						</div>				
						<div class="form-group">
							<label>Nombre del Provincia</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						<input type="submit" class="btn btn-primary" value="Agregar">
			
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!--Fin del Formulario para agregar Distrito-->
			
	</div>
	
	<div class="col-lg-9">
		<h3 class="text-center">Lista Pais </h3>
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Departamento</th>
					<th>Provincia</th>
					<th>Distrito</th>
					<th></th>
					<th></th>
					<th></th>
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
					<td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificarDepartamento" onclick="departamento('<%=item.getCoddepartamento() %>','<%=item.getNomdepartamento() %>');">MODIFICAR DEPARTAMENTO</button>
					<a href="PaisServlet?type=deletedepartamento&id=<%=item.getCoddepartamento()%>" class="btn btn-danger">ELIMINAR DEPARTAMENTO</a>
					</td>
					<td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificarProvincia" onclick="provincia'<%=item.getCodprovincia() %>','<%=item.getNomprovincia() %>');">MODIFICAR PROVINCIA</button>
					<a href="PaisServlet?type=deleteprovincia&id=<%=item.getCodprovincia()%>" class="btn btn-danger">ELIMINAR PROVINCIA</a>
					</td>
					<td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificarDistrito" onclick="distrito'<%=item.getCoddistrito() %>','<%=item.getNomdistrito() %>');">MODIFICAR DISTRITO</button>
					<a href="PaisServlet?type=deletedistrito&id=<%=item.getCoddistrito()%>" class="btn btn-danger">ELIMINAR DISTRITO</a>
					</td>
				</tr>
			<%
					
				}
				
			}
			
			%>
			
			</tbody>
		</table>
		
		<!--Formulario para editar-->
		
		<div id="ModalModificarDepartamento" class="modal fade" role="dialog">
			<div class="modal-dialog">
						
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						    <h4 class="modal-title">Modificar Departamento</h4>
					</div>
					<div class="modal-body">
 
						<form action="AutorServlet" method="post">
							<input type="hidden" name="type" value="editdepartamento">
								<div class="form-group">
									<label>Codido de Departamento</label>
									<input class="form-control" type="text" name="txtcodigodepartamento" id="Codigodepartamento" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Departamento</label>
									<input class="form-control" type="text" name="txtNamedepartamento" id="Nombredepartamento">
								</div>

							<input type="submit" class="btn btn-primary" value="Modificar">
									
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				<!--Fin del Modal-->
			</div>
		</div>
		<!--Fin del Formulario para editar-->
		
		
		<!--Formulario para editar-->
		
		<div id="ModalModificarProvincia" class="modal fade" role="dialog">
			<div class="modal-dialog">
						
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						    <h4 class="modal-title">Modificar Provincia</h4>
					</div>
					<div class="modal-body">
 
						<form action="PaisrServlet" method="post">
							<input type="hidden" name="type" value="editprovincia">
								<div class="form-group">
									<label>Codido de Provincia</label>
									<input class="form-control" type="text" name="txtcodigo" id="Codigoprovincia" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Provincia</label>
									<input class="form-control" type="text" name="txtName" id="Nombreprovincia">
								</div>

							<input type="submit" class="btn btn-primary" value="Modificar">
									
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				<!--Fin del Modal-->
			</div>
		</div>
		<!--Fin del Formulario para editar-->
		
		
		<!--Formulario para editar-->
		
		<div id="ModalModificarDistrito" class="modal fade" role="dialog">
			<div class="modal-dialog">
						
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal">&times;</button>
						    <h4 class="modal-title">Modificar Departamento</h4>
					</div>
					<div class="modal-body">
 
						<form action="AutorServlet" method="post">
							<input type="hidden" name="type" value="editdistrito">
								<div class="form-group">
									<label>Codido de Departamento</label>
									<input class="form-control" type="text" name="txtcodigo" id="Codigodistrito" readonly>
								</div>
												
								<div class="form-group">
									<label>Nombre de Departamento</label>
									<input class="form-control" type="text" name="txtName" id="Nombredistrito">
								</div>

							<input type="submit" class="btn btn-primary" value="Modificar">
									
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
				<!--Fin del Modal-->
			</div>
		</div>
		<!--Fin del Formulario para editar-->
		
	</div>

</div>


</body>
<%@ include file="snippet/Footer.jsp" %>

<script type="text/javascript">
	
	function departamento(codigo,nombre) {
		document.getElementById("Codigodepartamento").value = codigo;
		document.getElementById("Nombredepartamento").value = nombre;
		
  	}
	
	function provincia(codigo,nombre) {
		document.getElementById("Codigoprovincia").value = codigo;
		document.getElementById("Nombreprovincia").value = nombre;
		
  	}
	
	function distrito(codigo,nombre) {
		document.getElementById("Codigodistrito").value = codigo;
		document.getElementById("Nombredistrito").value = nombre;
		
  	}
	
</script>


</html>