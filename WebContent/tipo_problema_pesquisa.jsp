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


	<form class="form-horizontal" action="Servlet_Listar_Chamados_Concluidos"
		method="get">
		<fieldset>

			<legend>Tipo do problema</legend>


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