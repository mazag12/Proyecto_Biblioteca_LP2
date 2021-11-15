<br>
<nav class="navbar navbar-default navbar-fixed-top bg-info">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="home.jsp">BIBLIOTECA</a>
    </div>

    <div class="collapse navbar-collapse">
  	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("name") == null) {
	%>
	<ul class="nav navbar-nav navbar-right">
        <li><a href="login.jsp">Iniciar Sessión</a></li>
     </ul>
	
	<%
		}else{
	
	%>  
      <ul class="nav navbar-nav">
        <li><a href="LibroServlet?type=lista">LIBRO</a></li>
        <li><a href="AutorServlet?type=lista">AUTOR</a></li>
        <li><a href="PaisServlet?type=lista">Pais</a></li>
        <li><a href="FormatoServlet?type=lista">Formato</a></li>
        <li><a href="ClienteServlet?type=lista">Cliente</a></li>
        <li><a href="EstudiosServlet?type=lista">Estudios</a></li>
        <li><a href="EmpleadoServlet?type=lista">Empleados</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <% String name = (String) session.getAttribute("name"); %>
        <li><a href="#"><%=name %></a></li>
        <li><a href="AuthServlet?type=logout">Cerrar Sesión</a></li>
     </ul>
      
     <% } %> 
    </div>
  </div>
</nav>
