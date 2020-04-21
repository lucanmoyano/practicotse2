<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Practico 1</title>
</head>
<body>
<%
	List<negocio.Recurso> recursos = (List<negocio.Recurso>) request.getAttribute("Recursos");
		//System.out.println(request.getAttribute("Recursos"));
	int cont = 1;
%>

<ul class="nav nav-pills" style="justify-content: center;  margin-top:1%">
  <li class="nav-item">
    <a onclick="location.href='Index.jsp'" class="nav-link " href="#">Home</a>
  </li>
  <li class="nav-item">
    <a onclick="location.href='CrearRecurso'" class="nav-link " href="#">Crear recurso</a>
  </li>
  <li class="nav-item">
    <a onclick="location.href='ListarRecurso'" class="nav-link active" href="#">Listar recursos</a>
  </li>
    <li class="nav-item">
    <a onclick="location.href='ListarTiposRecursos'" class="nav-link" href="#">Listar tipos recursos</a>
  </li>
</ul>


<div class="container" style="margin-top: 50px">
<h3 style="text-align:center">Recursos</h3>




<form action="ListarRecurso" name="form1" method="get" class="input-group mb-3">
  	<input autocomplete="off" type="text" name="nombretiporecurso" class="form-control" placeholder="Buscar recursos por tipo de recurso" aria-label="Recipient's username" aria-describedby="button-addon2">
  	<div class="input-group-append">
	    <button class="btn btn-outline-secondary" type="submit"  id="button-addon2">Buscar</button>
	  </div>
	  </form>
	 
	<% if (recursos.size() > 0 ){ %> 
  <div class="row" style="margin-top: 20px">
    <div class="col-12">
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Codigo</th>
      <th scope="col">Precio unitario</th>
      <th scope="col">Cantidad</th>
        <th scope="col">Tipo recurso</th>
    </tr>
  </thead>
  <tbody>
		<% 
		for( negocio.Recurso i: recursos ) {%>
		    <tr>
      <th scope="row"><%= cont%></th>
      <td><%= i.getCodigo()%></td>
      <td><%= i.getPrecioUnitario()%></td>
      <td><%= i.getCantidad()%></td>
      <td><%= i.getTipoRecurso().getNombre()%></td>
    </tr>
		<% cont++; } 
		}
		else { %> 
		 <div class="alert alert-danger" role="alert">
		  No hay recursos creados.
		  </div>
		<% } %>
  </tbody>
</table>
</div>
  </div>
</div>

<% String nombretiporecurso =request.getParameter("nombretiporecurso");%>

</body>
</html>