package br.unisul.sau.servlet.chamado;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.Tecnico;
import br.unisul.sau.bean.tenum.Problema;
import br.unisul.sau.bean.tenum.Status;
import br.unisul.sau.bean.tenum.TipoProblema;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Cadastrar_Chamado
 */
@WebServlet("/Servlet_Cadastrar_Chamado")
public class Servlet_Cadastrar_Chamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

	public Servlet_Cadastrar_Chamado() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 Tecnico tecnico = (Tecnico) session.getAttribute("usuario_user");
		 
		 if (tecnico == null) {
			 response.sendRedirect("/SAU/login.jsp");
		 } else {

			String id = request.getParameter("seq_id");
			String nome_empresa = request.getParameter("nome_empresa");
			String nome_cliente = request.getParameter("nome_cliente");
			String software = request.getParameter("software");
			String versao_software = request.getParameter("versao_software");
			String data = request.getParameter("data");
			String duracao = request.getParameter("duracao");

			String problema = request.getParameter("problema");
			String tipo_problema = request.getParameter("tipo_problema");
			String descricao_problema = request
					.getParameter("descricao_problema");

			Chamado chamado = new Chamado();
			chamado.setStatus(Status.INICIADO);
			chamado.setNome_cliente(nome_cliente);
			chamado.setSoftware(versao_software);
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			data = data.replaceAll("\\D", "");
			try {
				chamado.setData(new java.sql.Date(sdf.parse(data).getTime()));
			} catch (ParseException e) {
				chamado.setData(new java.sql.Date(1L));
			}

			if (duracao.isEmpty()) {
				chamado.setDuracao(0D);
			} else {
				duracao = duracao.replaceAll(",", ".");
				chamado.setDuracao(Double.parseDouble(duracao));
			}

			try {
				chamado.setProblema(Problema.findByValue(Integer
						.parseInt(problema)));
			} catch (Exception e) {
				chamado.setProblema(Problema.NAO_INFORMADO);
			}

			try {
				chamado.setTipo_problema(TipoProblema.findByValue(Integer
						.parseInt(tipo_problema)));
			} catch (Exception e) {
				chamado.setTipo_problema(TipoProblema.NAO_INFORMADO);
			}

			chamado.setInfo_problema(descricao_problema);

			// vinculando a empresa ao chamado
			chamado.setSeq_id_empresa(Long.parseLong(id));
			chamado.setSeq_id_tecnico(tecnico.getSeq_id_tecnico());

			long add = new FactoryDAOImpl().getChamadoDAOImpl().add(chamado);

			if (add > 0) {
				System.out.println("Inserido");
			} else {
				System.out.println("Não Inserido");
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/empresa_pesquisar.jsp");
			rd.include(request, response);
		 }
	}
}//