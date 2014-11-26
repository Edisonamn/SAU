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
		List<Chamado> lista_chamados_abertos = (List<Chamado>) request
				.getAttribute("lista_chamados_abertos");
	%>

	<legend>Lista das Turmas Cadastradas</legend>

	<form class="form-horizontal" action="Servlet_Mostrar_Chamado" method="get">

		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Acompanha Chamado</th>
					<th>ID Chamado</th>
					<th>Status Chamado</th>
					<th>Cliente</th>
					<th>Software</th>
					<th>Problema</th>
					<th>Tipo do problema</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Chamado c : lista_chamados_abertos) {
				%>
				<tr>
					<td><input type="radio" name="radio_consulta_chamado"
						value="<%=c.getSeq_id_chamado()%>"></td>

					<td><%=c.getSeq_id_chamado()%></td>
					<td><%=c.getStatus().getLabel()%></td>
					<td><%=c.getNome_cliente()%></td>
					<td><%=c.getSoftware() %></td>
					<td><%=c.getProblema().getLabel() %></td>
					<td><%=c.getTipo_problema().getLabel() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<div class="form-group">
			<div class="col-md-8">
				<button id="visualizar" name="visualizar" class="btn btn-primary">Visualizar
					Chamado</button>
			</div>
		</div>

	</form>

	<%@include file="template/rodape.jsp"%>
</body>
</html>