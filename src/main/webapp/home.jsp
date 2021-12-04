<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<%@ include file="snippet/Header.jsp" %>

</head>
<body>

<div class="container-fluid">

	<%@ include file="snippet/Nav_main.jsp" %>
	
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-top: 3%;">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="img/banner/1.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/2.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/3.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/4.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/5.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/6.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/banner/4.jpg" alt="...">
	      <div class="carousel-caption">
	        ...
	      </div>
	    </div>
	    ...
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	<br>
	<div class="col-lg-12 jumbotron text-center bg-warning">
		<h2>LIBROS M�S VENDIDOS</h2>
	</div>

	<div class="col-lg-12 text-center">
		<div class="row">
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/sapien.jpg" data-holder-rendered="true" style="height: 300px; width: 300%; display: block;">
		      <div class="caption">
		        <h3>Sapiens</h3>
		        <p> Una breve historia de la humanidad es un libro escrito por Yuval Noah Harari, historiador y escritor israel�</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/mario.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Medio ciclo con Borges</h3>
		        <p>Uno de los escritores m�s extraordinarios del siglo XX, Jorge Luis Borges, a trav�s de la mirada del Premio Nobel.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/organiza.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Organ�zate con eficacia</h3>
		        <p>Getting Things Done es un m�todo de gesti�n de las actividades y el t�tulo de un libro de David Allen.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/familia.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Familias peruanas</h3>
		        <p>El autor nos menciona a trav�z de sus investigaciones, como en el Per� existen muchos tipos de familias.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		</div>			
	</div>
	
	
	<br>
	<div class="col-lg-12 jumbotron text-center">
		<h2>LIBROS RECOMENDADOS!</h2>
	</div>
	
	<div class="col-lg-12 text-center">
		<div class="row">
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/alicia.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Alicia</h3>
		        <p>Edici�n aniversario de la novela cl�sica infantil, en 1865 se public� por primera vez la obra de Lewis Carroll Alicia en el Pa�s de las Maravillas.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/george.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		           <div class="caption">
		        <h3>1984</h3>
		        <p>En el a�o 1984 Londres es una ciudad l�gubre en la que la Polic�a del Pensamiento controla de forma asfixiante la vida de los ciudadanos.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/estacion.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Estaci�n final</h3>
		        <p>Estaci�n Final es un libro de no ficci�n que esclarece un cap�tulo hasta ahora desconocido en la historia de Per�.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-3">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x300" alt="100%x300" src="img/libro/homo.jpg" data-holder-rendered="true" style="height: 300px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Homo Deus</h3>
		        <p>Tras el �xito de Sapiens. De animales a dioses, Yuval Noah Harari vuelve su mirada al futuro para ver hacia d�nde nos dirigimos.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Comprar</a></p>
		      </div>
		    </div>
		  </div>
		</div>			
	</div>
	
	<br>
	<div class="col-lg-12 jumbotron text-center">
		<h2>EVENTOS!</h2>
	</div>
	
	<div class="col-lg-12 text-center">
		<div class="row">
		  <div class="col-sm-4 col-md-4">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x200" alt="100%x200" src="img/libro/eve1.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Descrifrando misterios</h3>
		        <p>Descifra los misterios de los libros seleccionados y gana increibles premios</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Unirme</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-4">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x200" alt="100%x200" src="img/libro/eve2.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		      <div class="caption">
		        <h3>Convenci�n libros</h3>
		        <p>Inscr�bite a la convenci�n en donde grandes autores conversaran sobre literatura</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Unirme</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-4 col-md-4">
		    <div class="thumbnail">
		      <img data-src="holder.js/100%x200" alt="100%x200" src="img/libro/eve3.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		        <div class="caption">
		        <h3>Club de lectura</h3>
		        <p>�nete al club de lectura de verano en donde nos centramos en libros de ciencia ficci�n.</p>
		        <p><a href="#" class="btn btn-primary" role="button">Ver m�s</a> <a href="#" class="btn btn-default" role="button">Unirme</a></p>
		      </div>
		    </div>
		  </div>
		</div>			
	</div>
	
	
</div>

</body>

<%@ include file="snippet/Footer.jsp" %>


</html>