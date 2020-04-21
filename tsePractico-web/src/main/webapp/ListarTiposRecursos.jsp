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
	List<negocio.TipoRecurso> tRecursos = (List<negocio.TipoRecurso>) request.getAttribute("TRecursos");
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
    <a onclick="location.href='ListarRecurso'" class="nav-link " href="#">Listar recursos</a>
  </li>
    <li class="nav-item">
    <a onclick="location.href='ListarTiposRecursos'" class="nav-link active" href="#">Listar tipos recursos</a>
  </li>
</ul>


<div class="container" style="margin-top: 50px">
<h3 style="text-align:center">Tipos de recursos</h3>
  <div class="row" style="margin-top: 20px">
    <div class="col-12">
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Descripción</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
  <tbody>
		<% for( negocio.TipoRecurso i: tRecursos ) {%>
		    <tr>
      <th scope="row"><%= cont%></th>
      <td><%= i.getNombre()%></td>
      <td><%= i.getDescripcion()%></td>
      <td><%= i.getPrecioReferencia()%></td>
    </tr>
		<% cont++; }  %>
  </tbody>
</table>
</div>
  </div>
</div>

</body>
</html>