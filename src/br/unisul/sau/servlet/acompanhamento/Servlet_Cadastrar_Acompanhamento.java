package br.unisul.sau.servlet.acompanhamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.sau.bean.Acompanhamento;
import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.ChamadoAcompanhamento;
import br.unisul.sau.dao.impl.AcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoAcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;

/**
 * Servlet implementation class Servlet_Cadastrar_Acompanhamento
 */
@WebServlet("/Servlet_Cadastrar_Acompanhamento")
public class Servlet_Cadastrar_Acompanhamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();
	AcompanhamentoDAOImpl acompanhamentoDAOImp = new AcompanhamentoDAOImpl();

	ChamadoAcompanhamentoDAOImpl chamadoAcompanhamentoDAOImp = new ChamadoAcompanhamentoDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Cadastrar_Acompanhamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long id_chamado = Long.parseLong(request.getParameter("id_chamado"));
		String acompanhamento_problema = request
				.getParameter("acompanhamento_problema");

		ChamadoAcompanhamento chamadoAcompanhamento = new ChamadoAcompanhamento();
		chamadoAcompanhamento.setSeq_id_chamado(id_chamado);

		Acompanhamento acompanhamento = new Acompanhamento();
		acompanhamento.setDescricao(acompanhamento_problema);
		chamadoAcompanhamento.setSeq_id_acompanhamento(acompanhamento
				.getSeq_id_acompanhamento());// Assim o correto de implementar?
		
		try {
			acompanhamentoDAOImp.add(acompanhamento);
			chamadoAcompanhamentoDAOImp.add(chamadoAcompanhamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/SAU/Servlet_Listar_Chamados_Em_Aberto");
	}

}
