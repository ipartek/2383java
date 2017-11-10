<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
	<div><input type="email" name="email" placeholder="Email"></div>
	<div><input type="password" name="pass" placeholder="Contraseña"></div>
	<div><button type="submit">Enviar</button></div>
</form>
<%if(request.getParameter("error")!=null){ %>
	<div>Usuario o contraseña INCORRECTOS</div>
<%} %>
</body>
</html>