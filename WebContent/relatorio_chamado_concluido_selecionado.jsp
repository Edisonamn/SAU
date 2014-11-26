<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, br.unisul.sau.bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="template/cabecalho.jsp"%>

	<%
		Chamado chamado = (Chamado) request.getAttribute("chamado");

		Empresa empresa = (Empresa) request.getAttribute("empresa");

		Acompanhamento acompanhamento = (Acompanhamento) request.getAttribute("Acompanhamento");
	%>

	<form class="form-horizontal" action="" method="">
		<fieldset>

			<legend>Conteúdo do Chamado</legend>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_empresa">Nome
					da Empresa</label>
				<div class="col-md-4">
					<input id="nome_empresa" name="nome_empresa" value="<%=empresa.getNome()%>"
						type="text" placeholder="" class="form-control input-md"
						readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_empresa">Nome
					do Tecnico</label>
				<div class="col-md-4">
					<input id="nome_empresa" name="nome_empresa" value="<%=chamado.getSeq_id_tecnico()%>"
						type="text" placeholder="" class="form-control input-md"
						readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="data">Data de
					Abertura</label>
				<div class="col-md-4">
					<input id="data" name="data" value="<%=chamado.getData()%> type="
						text"
						placeholder="__/__/____"
						class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="acompanhamento_problema">Log do Acompanhamento</label>
				<div class="col-md-4">
					<textarea id="acompanhamento_problema"
						name="acompanhamento_problema" class="form-control" rows=""
						cols=""><%=acompanhamento.getDescricao() %></textarea>
				</div>
			</div>

			<br> <br />

			<div class="form-group">
				<label class="col-md-4 control-label" for="salvar"></label>
				<div class="col-md-8">
					<button id="salvar" name="salvar" class="btn btn-primary">Voltar</button>
				</div>
			</div>

		</fieldset>
	</form>

	<%@include file="template/rodape.jsp"%>

</body>
</html>