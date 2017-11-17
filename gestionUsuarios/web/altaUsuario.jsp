<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="includes/css.jsp" %>
<title>Alta Usuario</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-success">
				<div class="panel-heading">Alta de Usuario</div>
				<form action="altaUsuario" method="post">
		  			<div class="panel-body">
						<div class="form-group">
							<input type="text" class="form-control" name="nombre" placeholder="Nombre">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="apellidos" placeholder="Apellidos"> 
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="email" id="email" placeholder="Email">
						</div>
						<div class="form-group"> 
							<input type="password" class="form-control" name="pass" placeholder="Password">
						</div>
						<div class="form-group">
							<button class="btn btn-default col-sm-12" type="submit">Enviar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="includes/js.jsp" %>
</body>
</html>
</div>