<%@page import="com.ipartek.gestionUsuarios.domain.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../includes/css.jsp" %>
<title>Listado de usuarios</title>
</head>
<body>
	<%@include file="../includes/cabecera.jsp" %>
	<div class="container">
		<div class="row">
			<div class="jumbotron">
				<h1>Usuarios</h1>
				<p>Listado de todos los usuarios</p>
			</div>
		</div>
		
		<div class="row">
			<div class="pull-right">
				<button class="btn btn-success" data-toggle="modal" data-target="#modalUsuario"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Crear Usuario</button>
			</div>
		</div>
		<div>&nbsp;</div>
		<div class="row">
			<table class="table table-bordered table-hover table-striped" id="tblUsuario">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					if(usuarios!=null){
						for(Usuario u : usuarios){ %>
							<tr>
								<td><%=u.getNombre() %></td>
								<td><%=u.getApellidos() %></td>
								<td><%=u.getEmail() %></td>
								<td class="text-center col-sm-1"><span class="glyphicon glyphicon-search"></span> <span class="glyphicon glyphicon-pencil col-sm-offset-1"></span> <span class="glyphicon glyphicon-remove col-sm-offset-1"></span></td>
							</tr>
						<%}
					}%>
				</tbody>
		
			</table>
		</div>
	</div>
	<%@include file="../includes/js.jsp" %>
	<!-- Modal -->
	<div class="modal fade" id="modalUsuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Alta de Usuario</h4>
	      </div>
	      <div class="modal-body">
			<form action="altaUsuario" method="post">
				<div class="form-group">
					<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="apellidos" id="apellidos" placeholder="Apellidos"> 
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="email" id="email" placeholder="Email">
				</div>
				<div class="form-group"> 
					<input type="password" class="form-control" name="pass" id="pass" placeholder="Password">
				</div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-success" id="guardarUsuario">Guardar</button>
	      </div>
	    </div>
	  </div>
	</div>
	<%@ include file="../includes/js.jsp" %>
</body>

				
</html>