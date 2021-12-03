<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>

<%@ include file="snippet/Header.jsp" %>

</head>
<body>

<div class="container">

	<br>
	<br>
	<div class="col-lg-4">
		<form action="AuthServlet" method="post" id="id_form">

			<input type="hidden" name="type" value="login">

			<div class="form-group">
				<label>Correo</label>
				<input class="form-control" type="text" name="txtCorreo">
			</div>
			
			<div class="form-group">
				<label>Contraseña</label>
				<input class="form-control" type="password" name="txtPass">
			</div>
		
			<input type="submit" class="btn btn-primary" name="validateBtn" value="Enviar Datos">
		
		</form>
		
		<% 
		
		String message = (String) request.getAttribute("msj");
		
		if (message != null){
			
		%>
			<br>
			<div class="alert alert-danger">
				<strong>Error! </strong> <%=message %>
			</div>
			
		<%
		
		}
		
		%>
		
	</div>

</div>


</body>

<%@ include file="snippet/Footer.jsp" %>

<script type="text/javascript">

$(document).ready(function() {
	$('#id_form').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			txtCorreo: {
				validators: {
					notEmpty:{
						message: "El campo es obligatorio"
					},
					emailAddress: {
						message: "El formato de correo es incorrecto"
					}
				}
			},
			txtPass: {
				validators: {
					notEmpty:{
						message: "El campo es obligatorio"
					}
				}
			}
		}
	});
	
	$('#validateBtn').click(function() {
		$('#id_form').bootstrapValidator('validate');
	});
	
});

</script>


</html>