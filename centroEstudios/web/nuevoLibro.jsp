<%@page import="com.ipartek.centroEstudios.domain.Asignatura"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Asignatura> asignaturas = (ArrayList<Asignatura>) request.getAttribute("asignaturas"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aladir Libro</title>
</head>
<body>
<form action="nuevoLibro" method="post">
	<div><input type="text" name="isbn" placeholder="ISBN"></div>
	<div><input type="text" name="titulo" placeholder="Titulo"></div>
	<div><input type="text" name="autor" placeholder="Autor"></div>
	<div><input type="text" name="editorial" placeholder="editorial"></div>
	<div>
		<select name="asignatura">
			<option value="0">Selecciona una Asignatura</option>
			<%
				for(Asignatura a: asignaturas){
			%>
				<option value="<%= a.getId() %>"><%= a.getNombre() %></option>
			<%} %>
		</select>
	</div>
	<button type="submit">Enviar</button>
</form>
</body>
</html>