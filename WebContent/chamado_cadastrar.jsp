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


	<form class="form-horizontal" action="Servlet_Cadastrar_Chamado"
		method="post">
		<fieldset>

			<legend>Lista de Chamados</legend>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_cliente">Nome
					Cliente</label>
				<div class="col-md-4">
					<input id="nome_cliente" name="nome_cliente" type="text"
						placeholder="" class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="software">Software</label>
				<div class="col-md-4">
					<input id="software" name="software" type="text"
						placeholder="" class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="versao_software">Versão do Software</label>
				<div class="col-md-4">
					<input id="versao_software" name="versao_software" type="text"
						placeholder="" class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="data">Data</label>
				<div class="col-md-4">
					<input id="data" name="data" type="text"
						placeholder="__/__/____" class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="duracao">Duração</label>
				<div class="col-md-4">
					<input id="duracao" name="duracao" type="text"
						placeholder="" class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="problema">Problema</label>
				<div class="col-md-4">
					<select id="problema" name="problema"
						class="form-control">
						<option value="comunicacao de rede">Comunicação de Rede</option>
						<option value="banco dados">Banco de Dados</option>
						<option value="">Desempenho</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="tipo_problema">Tipo
					do problema</label>
				<div class="col-md-4">
					<select id="tipo_problema" name="tipo_problema"
						class="form-control">
						<option value="adsl">Adsl</option>
						<option value="radio">Radio</option>
						<option value="cable model">Cable modem</option>
						<option value="mysql">Mysql</option>
						<option value="oracle">Oracle</option>
						<option value="sqlserver">SqlServer</option>
						<option value="outro">Outro</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="descricao_problema">Descrição
					do problema</label>
				<div class="col-md-4">
					<textarea id="descricao_problema" name="descricao_problema"
						class="form-control" rows="" cols=""></textarea>
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