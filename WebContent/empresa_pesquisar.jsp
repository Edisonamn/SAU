<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="template/cabecalho.jsp"%>

	<form class="form-horizontal" action="" method="post">
		<fieldset>

			<legend>Pesquisar Empresa</legend>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_empresa">Nome
					da Empresa</label>
				<div class="col-md-4">
					<input id="nome_empresa" name="nome_empresa" type="text"
						placeholder="" class="form-control input-md">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="numero_contrato">Nº do contrato</label>
				<div class="col-md-4">
					<input id="numero_contrato" name="numero_contrato" type="text"
						placeholder="" class="form-control input-md">
				</div>
			</div>

			<br> <br />

			<div class="form-group">
				<label class="col-md-4 control-label" for="salvar"></label>
				<div class="col-md-8">
					<button id="salvar" name="salvar" class="btn btn-primary">Pesquisar</button>
					<button id="cancelar" name="cancelar" class="btn btn-default">Cancelar</button>
				</div>
			</div>

		</fieldset>
	</form>

	<%@include file="template/rodape.jsp"%>

</body>
</html>