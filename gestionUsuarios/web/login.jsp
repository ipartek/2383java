<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="includes/css.jsp" %>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				if (request.getParameter("error") != null) {
			%>
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				Usuario o contraseña <strong>INCORRECTOS</strong>
			</div>
			<%
				}
			%>
			<%
				if (request.getParameter("usuarioOK") != null) {
			%>
			<div class="alert alert-success" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				Usuario creado correctamente
			</div>
			<%
				}
			%>


			<div class="panel panel-primary">

				<div class="panel-heading">
					<h3 class="panel-title">Inicio de Sesión</h3>
				</div>
				<form class="form-horizontal" action="login" method="post">
					<div class="panel-body">
						<div class="form-group">
							<label class="col-sm-1 control-label" for="email">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="email"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="pass">Contraseña</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="pass"
									id="pass" placeholder="Contraseña">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="recuerdame" id="recuerdame">Recuerdame
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-10">
								<button class="btn btn-default col-sm-12" type="submit">Enviar</button>
							</div>
						</div>
					</div>
				</form>

			</div>

			<div class="pull-right">
				Date de alta <a href="altaUsuario.jsp">AQUÍ!</a>
			</div>
		</div>
	</div>
	<%@include file="includes/js.jsp" %>

</body>
</html>