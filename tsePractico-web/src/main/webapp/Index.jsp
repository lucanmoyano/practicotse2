<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.ionicframework.com/1.0.0/css/ionic.css" />
	<script src="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="./Style.css">

<title>Practico Taller Sistemas Empresariales</title>
</head>
<body>
	
<%
	//List<tse.negocio.TipoRecurso> recursos = (List<tse.negocio.TipoRecurso>) request.getAttribute("Recursos");
	System.out.println("hola");
		System.out.println(request.getAttribute("hola"));
%>

<!-- 
	<button id="button-1" onclick="location.href='ListarRecurso'" class="button button-block">Listar recursos</button>
	<button id="button-1" onclick="location.href='ListarTiposRecursos'" class="button button-block">Listar tipos de recurso</button>
	<button id="button-1" onclick="location.href='ListarRecursosTipoRecurso'" class="button button-block">Listar recursos de tipo de recursos</button>
	
	-->
	
	<div class="container" style="margin-top: 50px">
	<h3 style="text-align:center">Menú</h3>
	 <div class="row" style="margin-top: 20px">
    <div class="col-6" style="margin:auto" >
	<button type="button" onclick="location.href='CrearRecurso'" class="btn btn-warning btn-lg btn-block">Crear recurso</button>
	<button type="button" onclick="location.href='ListarRecurso'" class="btn btn-primary btn-lg btn-block">Listar recursos</button>
	<button type="button" onclick="location.href='ListarTiposRecursos'" class="btn btn-primary btn-lg btn-block">Listar tipos de recurso</button>
	<!--  <button type="button" onclick="location.href='ListarTiposRecursos'" class="btn btn-primary btn-lg btn-block">Listar Recursos de tipos de recurso</button> -->
	
	
	
	</div>
	
	  </div>
	</div>
	
	<footer>
  <p>Taller Sistemas Empresariales 2020</p>
   <p>Lucas Moyano ~ 5.129.435-9</p>
     <p>Tecnólogo en Informática</p>
	</footer>
	
</body>
</html>