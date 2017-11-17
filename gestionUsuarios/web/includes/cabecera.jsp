<%@page import="com.ipartek.gestionUsuarios.domain.Usuario"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img height="20" width="20" alt="Ipartek" src="img/ipartek.jpg">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          		<%
				if(request.getSession().getAttribute("usuario")!=null){
					Usuario u = (Usuario) request.getSession().getAttribute("usuario");
				%>
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					<%=u.getNombre() %> <%=u.getApellidos() %>
				<%
				}%>
          	<span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">Editar</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Cerrar Sesión</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>