<br>
<nav class="navbar navbar-default navbar-fixed-top bg-info">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="home.jsp">BIBLIOTECA</a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="AuthServlet?type=lista">LIBRERIA</a></li>
        <li><a href="AutorServlet?type=lista">AUTOR</a></li>
        <li><a href="PaisServlet?type=lista">Pais</a></li>
        <li><a href="FormatoServlet?type=lista">Formato</a></li>
        <li><a href="ClienteServlet?type=lista">Cliente</a></li>
        <li><a href="EstudiosServlet?type=lista">Estudios</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Pefil</a></li>
        <li><a href="AuthServlet?type=logout">Cerrar Sesión</a></li>
      </ul>
    </div>
  </div>
</nav>
