<%@page import="br.unisul.sau.bean.Empresa"%>
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
	
	
	<%
		Empresa empresa = (Empresa) request.getAttribute("empresa");
	%>


	<form class="form-horizontal" action="Servlet_Cadastrar_Chamado"
		method="post">
		<fieldset>
			<input type="hidden" value="<%= empresa.getSeq_id_empresa() %>" name="seq_id">
			<legend>Cadastrar Chamado</legend>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_empresa">Nome
					da Empresa</label>
				<div class="col-md-4">
					<input id="nome_empresa" value="<%=empresa.getNome() %>" name="nome_empresa" type="text"
						placeholder="" class="form-control input-md">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="numero_contrato">N� do contrato</label>
				<div class="col-md-4">
					<input id="numero_contrato" value="<%=empresa.getContrato() %>" name="numero_contrato" type="text"
						placeholder="" class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_cliente">Nome
					Cliente</label>
				<div class="col-md-4">
					<input id="nome_cliente" name="nome_cliente" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="software">Software</label>
				<div class="col-md-4">
					<input id="software" name="software" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="versao_software">Vers�o do Software</label>
				<div class="col-md-4">
					<input id="versao_software" name="versao_software" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="data">Data</label>
				<div class="col-md-4">
					<input id="data" name="data" type="text"
						placeholder="__/__/____" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="duracao">Dura��o</label>
				<div class="col-md-4">
					<input id="duracao" name="duracao" type="text"
						placeholder="" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="problema">Problema</label>
				<div class="col-md-4">
					<select id="problema" name="problema"
						class="form-control">
						<option selected="selected" value="4">Selecione...</option>
						<option value="1">Comunica��o de Rede</option>
						<option value="2">Banco de Dados</option>
						<option value="3">Desempenho</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="tipo_problema">Tipo
					do problema</label>
				<div class="col-md-4">
					<select id="tipo_problema" name="tipo_problema"
						class="form-control">
						<option selected="selected" value="8">Selecione...</option>
						<option value="1">Adsl</option>
						<option value="2">Radio</option>
						<option value="3">Cable modem</option>
						<option value="5">Mysql</option>
						<option value="6">Oracle</option>
						<option value="7">SqlServer</option>
						<option value="4">Outro</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="descricao_problema">Descri��o
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