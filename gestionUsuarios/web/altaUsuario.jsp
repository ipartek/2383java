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
	<script type="text/javascript">
		$(function(){
			var $email = $("#email");
			$email.popover({
				title: 'Alerta',
				content: 'El usuario ya existe',
				placement: 'top',
				trigger: 'manual'
			});
			
			$email.blur(function(){
				$.ajax({
					url: "comprobarEmail",
					data: {"email":$(this).val()},
					dataType: "text"
				}).done(function(existe){
					console.log(existe);
					if(existe=="true"){
						$('#email').popover('show');
					}else{
						$('#email').popover('hide');
					}
				});
			});
			
			
		});

		
	</script>
</body>
</html>
</div>