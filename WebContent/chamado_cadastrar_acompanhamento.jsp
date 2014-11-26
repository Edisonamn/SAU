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
		Chamado chamado = (Chamado) request.getAttribute("Chamado");
		
			//Acompanhamento acompanhamento = (Acompanhamento) request.getAttribute("Acompanhamento");
	%>

	<form class="form-horizontal" action="Servlet_Acompanhar_Chamados"
		method="post">
		<fieldset>

			<legend>Conteúdo do Chamado</legend>

			<div class="form-group">
				<label class="col-md-4 control-label" for="id_chamado">Id do
					Chamado</label>
				<div class="col-md-4">
					<input id="id_chamado" value="<%=chamado.getSeq_id_chamado()%>"
						name="id_chamado" type="text" placeholder=""
						class="form-control input-md" readonly="true">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="status">Status do
					Chamado</label>
				<div class="col-md-4">
					<select id="status" name="status" class="form-control"
						disabled="true">
						<option value="<%=chamado.getStatus().getKey()%>">
							<%=
								chamado.getStatus().getLabel()
							%>
						</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome_cliente">Nome
					Cliente</label>
				<div class="col-md-4">
					<input id="nome_cliente" name="nome_cliente"
						value="<%=chamado.getNome_cliente()%>" type="text" placeholder=""
						class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="software">Software</label>
				<div class="col-md-4">
					<input id="software" name="software"
						value="<%=chamado.getSoftware()%>" type="text" placeholder=""
						class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="versao_software">Versão
					do Software</label>
				<div class="col-md-4">
					<input id="versao_software" name="versao_software"
						value="<%=chamado.getVersao_software()%>" type="text"
						placeholder="" class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="data">Data</label>
				<div class="col-md-4">
					<input id="data" name="data" value="<%=chamado.getData()%> type="
						text"
						placeholder="__/__/____"
						class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="duracao">Duração</label>
				<div class="col-md-4">
					<input id="duracao" name="duracao"
						value="<%=chamado.getDuracao()%>" type="text" placeholder=""
						class="form-control input-md" readonly="true">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="problema">Problema</label>
				<div class="col-md-4">
					<select id="problema" name="problema" class="form-control"
						disabled="true">
						<option value="<%=chamado.getProblema().getKey()%>">
							<%=
								chamado.getProblema().getLabel()
							%>
						</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="tipo_problema">Tipo
					do problema</label>
				<div class="col-md-4">
					<select id="tipo_problema" name="tipo_problema"
						class="form-control" disabled="true">
						<option value="<%=chamado.getTipo_problema().getKey()%>">
							<%=
								chamado.getTipo_problema().getLabel()
							%>
						</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="descricao_problema">Descrição
					do problema</label>
				<div class="col-md-4">
					<textarea id="descricao_problema" name="descricao_problema"
						class="form-control" rows="5" cols="10" readonly="true">
						<%=
							chamado.getInfo_problema()
						%> </textarea>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="acompanhamento_problema">Acompanhamento
					do problema</label>
				<div class="col-md-4">
					<textarea id="acompanhamento_problema" name="acompanhamento_problema" class="form-control"
						rows="" cols=""></textarea>
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