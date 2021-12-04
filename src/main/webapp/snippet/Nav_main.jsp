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
      	<li class="dropdown">
	       <a class="dropdown-toggle" data-toggle="dropdown" href="#">BIBLIOTECA
	       <span class="caret"></span></a>
	       <ul class="dropdown-menu">
	         <li><a href="LibroServlet?type=lista">LIBRO</a></li>
	         <li><a href="IdiomaServlet?type=lista">IDIOMA</a></li>
	         <li><a href="FormatoServlet?type=lista">FORMATO</a></li>
	         <li><a href="AutorServlet?type=lista">AUTOR</a></li>
	         <li><a href="TematicaServlet?type=lista">TEMATICA</a></li>
	         <li><a href="EditorialServlet?type=lista">EDITORIAL</a></li>
	       </ul>
	    </li>
	    <li class="dropdown">
	       <a class="dropdown-toggle" data-toggle="dropdown" href="#">LUGARES
	       <span class="caret"></span></a>
	       <ul class="dropdown-menu">
	         <li><a href="PaisServlet?type=lista">PAIS</a></li>
	       </ul>
	    </li>
        <li><a href="ClienteServlet?type=lista">Cliente</a></li>
        <li><a href="EstudiosServlet?type=lista">Estudios</a></li>
        <li><a href="EmpleadoServlet?type=lista">Empleados</a></li>
        <li><a href="PersonaServlet?type=lista">Persona</a></li>
        <li><a href="PrestamoServlet?type=lista">Prestamo</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <% String name = (String) session.getAttribute("name"); %>
        <li><a href="#">Usuario : <%=name %></a></li>
        <li><a href="AuthServlet?type=logout">Cerrar Sesión</a></li>
     </ul>
      
     <% } %> 
    </div>
  </div>
</nav>
