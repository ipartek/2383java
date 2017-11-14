<%@page import="com.ipartek.gestionUsuarios.domain.Usuario"%>
<div>
	<h1>ESTO ES UNA CABECERA</h1>
</div>

<div style="float: right;">
	<%
	if(request.getSession().getAttribute("usuario")!=null){
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
	%>
		<%=u.getNombre() %> <%=u.getApellidos() %>
	<%
	}%>
</div>