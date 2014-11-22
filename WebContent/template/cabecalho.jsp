
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/carousel.css" rel="stylesheet">

<title>Eng Soft III</title>
</head>
<!-- MENU -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<div class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Menu</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand">Engenharia de Software III</a>
					</div>

					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.jsp">Início</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Terminal Técnico <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li role="navigation" class="dropdown-header">Chamados</li>
									<li><a href="Servlet_Listar_Chamados">Listar ou Repassar Chamados Abertos</a></li>
								</ul></li>
								
								<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Terminal Cliente <b class="caret"></b></a>
								<ul class="dropdown-menu">
								<li role="navigation" class="dropdown-header">Chamados</li>
									<li><a href="Servlet_Cadastrar_Chamado">Cadastrar Chamado</a></li>
									<li><a href="TERMINAR AQUI- Servlet_Listar_Chamados">Listar ou Cancelar Chamados Abertos</a></li>
								</ul></li>
								
								<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">(Testes) Cadastra Usuario ou Sistema<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="usuario_cadastrar.jsp">Cadastrar Usuarios</a></li>
									<li><a href="sistema_cadastrar.jsp">Cadastrar Sistemas</a></li>
								</ul></li>
								
							<li><a href="Servlet_Login">Sair</a></li>

							<ul class="navbar-text navbar-right">
								<li>Usuário autenticado: <%=session.getAttribute("usuario_logado")%></li>
							</ul>

						</ul>

					</div>
				</div>
			</div>