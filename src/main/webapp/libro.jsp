<%@page import="beans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="misLibrerias" prefix="etiquetas"%>
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
			        <h4 class="modal-title">Registrar Libro</h4>
			      </div>
			      <div class="modal-body">
			        <form action="FormatoServlet" method="post">
		
						<input type="hidden" name="type" value="register">
										
						<div class="form-group">
							<label>TITULO</label>
							<input class="form-control" type="text" name="txtName">
						</div>
						<div class="form-group">
							<label>AUTOR</label>
							<etiquetas:tagAutorCombobox></etiquetas:tagAutorCombobox>
						</div>
						<div class="form-group">
							<label>AÑO</label>
							<input class="form-control" type="text" name="txtAno">
						</div>
						
						<div class="form-group">
							<label>IDIOMA</label>
							<etiquetas:tagIdiomaCombobox></etiquetas:tagIdiomaCombobox>
						</div>
						<div class="form-group">
							<label>TEMATICA</label>
							<etiquetas:tagTematicaCombobox></etiquetas:tagTematicaCombobox>
						</div>
						<div class="form-group">
							<label>EDITORAIL</label>
							<etiquetas:tagEditorialCombobox></etiquetas:tagEditorialCombobox>
						</div>
						<div class="form-group">
							<label>RESTRINCIÓN</label>
							<select class='form-control' name='txtrestrincion'>
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>PAGINAS</label>
							<input class="form-control" type="text" name="txtpagina">
						</div>
						<div class="form-group">
							<label>CANTIDAD</label>
							<input class="form-control" type="text" name="txtpagina">
						</div>
						<div class="form-group">
							<label>FRAGMENTO</label>
							<select class='form-control' name='txtfragmento'>
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>RECOMENDADOS</label>
							<select class='form-control' name='txtrecomendado'>
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>FORMATO</label>
							<etiquetas:tagFormatoCombobox></etiquetas:tagFormatoCombobox>
						</div>
						<div class="form-group">
							<label>PAIS</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>
						<div class="form-group">
							<label>ESTADO</label>
							<select class='form-control' name='txtestado'>
								<option value="D">USADO</option>
								<option value="N">NUEVO</option>
							</select>
						</div>
						<div class="form-group">
							<label>ISBN</label>
							<input class="form-control" type="text" name="txtisbn">
						</div>
						<input type="submit" class="btn btn-primary" value="Registrar">
					</form>
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
					<th>AUTOR</th>
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
					<td><%=item.getNomautor() %></td>
					<td>
						<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModalModificar"
						 onclick="miFunc('<%=item.getCodlibro() %>','<%=item.getTitulo() %>','<%=item.getAno() %>','<%=item.getCodidioma() %>','<%=item.getCodtematica() %>',
						 '<%=item.getRestrincion() %>','<%=item.getCantidad() %>','<%=item.getFragmento() %>','<%=item.getCodautor()%>';">
						MODIFICAR
						</button>
					</td>
					<td>
						<a href="LibroServlet?type=delete&id=<%=item.getCodlibro()%>" class="btn btn-danger">ELIMINAR</a>
					</td>
				</tr>
			<%
					
				}
				
			}
			
			%>
			
			</tbody>
		</table>
		<!--Formulario para editar-->
		<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Registrar Libro</h4>
			      </div>
			      <div class="modal-body">
			        <form action="FormatoServlet" method="post">
		
						<input type="hidden" name="type" value="register">
						<div class="form-group">
							<label>CODIGO</label>
							<input class="form-control" type="text" name="txtCodigo" id="codigo">
						</div>				
						<div class="form-group">
							<label>TITULO</label>
							<input class="form-control" type="text" name="txtName" id="name">
						</div>
						<div class="form-group">
							<label>AUTOR</label>
							<etiquetas:tagAutorCombobox></etiquetas:tagAutorCombobox>
						</div>
						<div class="form-group">
							<label>AÑO</label>
							<input class="form-control" type="text" name="txtAno" id="ano">
						</div>
						
						<div class="form-group">
							<label>IDIOMA</label>
							<etiquetas:tagIdiomaCombobox></etiquetas:tagIdiomaCombobox>
						</div>
						<div class="form-group">
							<label>TEMATICA</label>
							<etiquetas:tagTematicaCombobox></etiquetas:tagTematicaCombobox>
						</div>
						<div class="form-group">
							<label>EDITORAIL</label>
							<etiquetas:tagEditorialCombobox></etiquetas:tagEditorialCombobox>
						</div>
						<div class="form-group">
							<label>RESTRINCIÓN</label>
							<select class='form-control' name='txtrestrincion' id="restrincion">
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>PAGINAS</label>
							<input class="form-control" type="text" name="txtpagina" id="pagina">
						</div>
						<div class="form-group">
							<label>CANTIDAD</label>
							<input class="form-control" type="text" name="txtpagina" id="cantidad">
						</div>
						<div class="form-group">
							<label>FRAGMENTO</label>
							<select class='form-control' name='txtfragmento' id="fragmento">
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>RECOMENDADOS</label>
							<select class='form-control' name='txtrecomendado' id="recomendados">
								<option value="NO">NO</option>
								<option value="SI">SI</option>
							</select>
						</div>
						<div class="form-group">
							<label>FORMATO</label>
							<etiquetas:tagFormatoCombobox></etiquetas:tagFormatoCombobox>
						</div>
						<div class="form-group">
							<label>PAIS</label>
							<etiquetas:tagPaisCombobox></etiquetas:tagPaisCombobox>
						</div>
						<div class="form-group">
							<label>ESTADO</label>
							<select class='form-control' name='txtestado' id="estado">
								<option value="D">USADO</option>
								<option value="N">NUEVO</option>
							</select>
						</div>
						<div class="form-group">
							<label>ISBN</label>
							<input class="form-control" type="text" name="txtisbn" id="isbn">
						</div>
						<input type="submit" class="btn btn-primary" value="Registrar">
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			</div>
		<!--Fin del Formulario para editar-->
	</div>

</div>

</body>

<%@ include file="snippet/Footer.jsp" %>

<script type="text/javascript">
	
	function miFunc(codigo,nombre,autor,ano,idioma,tematica,editorial,restrincion,formato,pais,isbn,autor) {
		document.getElementById("codigo").value = codigo;
		document.getElementById("name").value = nombre;
		document.getElementById("autor").value = autor;
		document.getElementById("ano").value = ano;
		document.getElementById("idioma").value = idioma;
		document.getElementById("tematica").value = tematica;
		document.getElementById("editorial").value = editorial;
		document.getElementById("restrincion").value = restrincion;
		document.getElementById("formato").value = formato;
		document.getElementById("pais").value = pais;
		document.getElementById("isbn").value = isbn;
		document.getElementById("autor").value = autor;
  	}
	
</script>

</html>