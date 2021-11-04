<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ include file="snippet/Header.jsp" %>

<style type="text/css">

.contenido{
	justify-content: center;
	display: flex;
	padding-top: 5%;
}

.formulario{
	width: 50%;
}

</style>

</head>
<body class="text-center">

	<h2>Iniciar sesión</h2>
	
	<div class="container bg-faded">
	
		<div class="row col-xs-offset-4">
		
			<div class="col-xs-6">
			
				<form action="AuthServlet" method="post" id="id_form">
			
						<input type="hidden" name="type" value="login" class="">
			
						<div class="form-group">
							<label>Correo</label>
			      			<input class="form-control" type="text" name="txtCorreo" >
							
						</div>
						
						<div class="form-group">
							<label>Contraseña</label>
							<input class="form-control" type="password" name="txtPass">
						</div>
					
						<input type="submit" class="btn btn-primary" name="validateBtn" value="Enviar Datos">
					
					</form>
					
					<h5>¿Olvidaste el correo electrónico?</h5>
					
					<div>
						<a href="">Crear Cuentra</a>
					</div>
					
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
		
	</div>


</body>

<%@ include file="snippet/Footer.jsp" %>

</html>