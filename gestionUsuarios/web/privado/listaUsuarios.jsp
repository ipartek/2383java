<%@page import="com.ipartek.gestionUsuarios.domain.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de usuarios</title>
</head>
<body>
	<%@include file="../includes/cabecera.jsp" %>
	<button>Crear Usuario</button>
	<h1>Los usuarios son:</h1>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Email</th>
		</tr>
		
		<%
		if(usuarios!=null){
			for(Usuario u : usuarios){ %>
				<tr>
					<td><%=u.getNombre() %></td>
					<td><%=u.getApellidos() %></td>
					<td><%=u.getEmail() %></td>
				</tr>
			<%}
		}%>
	</table>
</body>
</html>