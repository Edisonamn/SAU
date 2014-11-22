<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>(TESTE) Cadastro de Usuário</title>
</head>
<body>

	<%@include file="template/cabecalho.jsp"%>

	<form class="form-horizontal" action="Servlet_Cadastrar_Usuario"
		method="post">
		<fieldset>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome">Nome</label>
				<div class="col-md-4">
					<input id="nome" name="nome" type="text" placeholder=""
						class="form-control input-md" >
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="login">Login</label>
				<div class="col-md-4">
					<input id="login" name="login" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="senha">Senha</label>
				<div class="col-md-4">
					<input id="senha" name="senha" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="tipo_usuario">Tipo de
					Usuário</label>
				<div class="col-md-4">
					<select id="tipo_usuario" name="tipo_usuario" class="form-control">
						<option value="cliente">Cliente</option>
						<option value="tecnico">Técnico</option>
					</select>
				</div>
			</div>

			<br> <br />

			<div class="form-group">
				<label class="col-md-4 control-label" for="salvar"></label>
				<div class="col-md-8">
					<button id="salvar" name="salvar" class="btn btn-primary">Salvar</button>
					<button id="cancelar" name="cancelar" class="btn btn-default">Cancelar</button>
				</div>
			</div>

		</fieldset>
	</form>

	<%@include file="template/rodape.jsp"%>

</body>
</html>