<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- Compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> -->
<!-- Compiled and minified JavaScript -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="./Style.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%
	List<negocio.TipoRecurso> tRecursos = (List<negocio.TipoRecurso>) request.getAttribute("TRecursos");
		//System.out.println(request.getAttribute("Recursos"));
	Boolean msj = (Boolean) request.getAttribute("msj");
	System.out.println(msj);
%>

<ul class="nav nav-pills" style="justify-content: center;  margin-top:1%">
  <li class="nav-item">
    <a onclick="location.href='Index.jsp'" class="nav-link " href="#">Home</a>
  </li>
  <li class="nav-item">
    <a onclick="location.href='CrearRecurso'" class="nav-link active" href="#">Crear recurso</a>
  </li>
  <li class="nav-item">
    <a onclick="location.href='ListarRecurso'" class="nav-link" href="#">Listar recursos</a>
  </li>
    <li class="nav-item">
    <a onclick="location.href='ListarTiposRecursos'" class="nav-link" href="#">Listar tipos recursos</a>
  </li>
</ul>

	
	<div class="container" style="margin-top: 50px">
	<h3 style="text-align:center">Crear recurso</h3>
	 <div class="row" style="margin-top: 20px">
    <div class="col-6" style="margin:auto" >
	<form action="CrearRecurso" name="form1" method="post" >
  <div class="form-group">
    <label   for="exampleInputEmail1">Codigo: </label>
    <input  autocomplete="off" name="codigo" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
    <small id="emailHelp" class="form-text text-muted">El código puede estar conformado por letras y numeros.</small>
  </div>
  <div class="form-group">
    <label autocomplete="off" for="exampleInputEmail1">Precio unitario: </label>
    <input name="precio" type="number" class="form-control" id="precio" aria-describedby="emailHelp" required>
  </div>
  <div class="form-group">
    <label autocomplete="off" for="exampleInputEmail1">Cantidad: </label>
    <input name="cantidad" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Tipo recurso: </label>
    <select name="tipoRecurso" class="form-control">
    <% for( negocio.TipoRecurso i: tRecursos ) {%>
  	<option><%=i.getNombre() %></option>
  	<%} %>
	</select>
  </div>
  <button  type="submit" name="confirmar" class="btn btn-primary btn-lg btn-block">Enviar</button>
</form>
	
	</div>
	  </div>
	</div>
 
 <% if ( msj!=null ) {%>
	<% if ( msj ) {%>
	<div id="snackbar" style="background-color: #46A049">Recurso creado con éxito</div>
	<%} else {%>
	<div id="snackbar">El precio no puede superar un 10% al precio del tipo de recurso</div>
<%} }%>
	

	
	<%
		String codigo=request.getParameter("codigo");
		String precio=request.getParameter("precio");
		String cantidad=request.getParameter("cantidad");
		String tipoRecurso=request.getParameter("tipoRecurso");
	%>
	
</body>

<script>

function snack() {
	  // Get the snackbar DIV
	  var x = document.getElementById("snackbar");
	  // Add the "show" class to DIV
	  x.className = "show";
	  // After 3 seconds, remove the show class from DIV
	  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 4000);
	}
	
	snack();
</script>

</html>