$(function() {
	var $email = $("#email");
	$email.popover({
		title : 'Alerta',
		content : 'El usuario ya existe',
		placement : 'top',
		trigger : 'manual'
	});

	$email.blur(function() {
		$.ajax({
			url : "comprobarEmail",
			data : {
				"email" : $(this).val()
			},
			dataType : "text"
		}).done(function(existe) {
			console.log(existe);
			if (existe == "true") {
				$('#email').popover('show');
			} else {
				$('#email').popover('hide');
			}
		});
	});
	
	$("#guardarUsuario").click(function(){
		$.ajax({
			url: "altaUsuario",
			data: {
				"nombre": $("#nombre").val(),
				"apellidos": $("#apellidos").val(),
				"email": $("#email").val(),
				"pass": $("#pass").val(),
				"ajax": true
			},
			dataType: "json",
			type: "post"
		}).done(function(usuario){
			if(usuario!="altaKO" && usuario!=null){
				var $tBody = $("#tblUsuario tbody");
				var $celdaNombre = $("<td/>", {
					text : usuario.nombre
				});
				var $celdaApellidos = $("<td/>", {
					text : usuario.apellidos
				});
				var $celdaEmail = $("<td/>", {
					text : usuario.email
				});
				
				var $fila = $("<tr/>");
				
				$fila
					.append($celdaNombre)
					.append($celdaApellidos)
					.append($celdaEmail)
					.appendTo($tBody);
				
				$("#modalUsuario").modal("hide");
			}else{
				
			}
		});
	});

});