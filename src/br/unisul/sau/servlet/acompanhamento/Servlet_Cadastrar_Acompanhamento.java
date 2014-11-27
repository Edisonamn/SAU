package br.unisul.sau.servlet.acompanhamento;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Cadastrar_Acompanhamento
 */
@WebServlet("/Servlet_Cadastrar_Acompanhamento")
public class Servlet_Cadastrar_Acompanhamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		int status_ant = Integer.parseInt(request.getParameter("status_ant"));
		int status_new =  Integer.parseInt(request.getParameter("status_new"));
		long id_chamado = Long.parseLong(request.getParameter("id_chamado"));
		
		if  (status_ant != status_new) {
			new FactoryDAOImpl().getChamadoDAOImpl().update(status_new, id_chamado);
		}
		
		String acompanhamento_problema = request.getParameter("acompanhamento_problema");

		Acompanhamento acompanhamento = new Acompanhamento();
		acompanhamento.setDescricao(acompanhamento_problema);
		long seq_id_acompanhamento = new FactoryDAOImpl().getAcompanhamentoDAOImpl().add(acompanhamento);
		
		ChamadoAcompanhamento chamadoAcompanhamento = new ChamadoAcompanhamento();
		chamadoAcompanhamento.setSeq_id_chamado(id_chamado);
		chamadoAcompanhamento.setSeq_id_acompanhamento(seq_id_acompanhamento);
		
		boolean add = new FactoryDAOImpl().getChamadoAcompanhamentoDAOImpl().add(chamadoAcompanhamento);
		
		if (add) {
			System.out.println("Inserido");
		} else {
			System.out.println("Não Inserido");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/Servlet_Listar_Chamados_Em_Aberto");
		rd.include(request, response);
	}

}
