package br.unisul.sau.servlet.chamado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.sau.bean.Acompanhamento;
import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.ChamadoAcompanhamento;
import br.unisul.sau.bean.Empresa;
import br.unisul.sau.dao.impl.AcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoAcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;
import br.unisul.sau.dao.impl.EmpresaDAOImpl;

/**
 * Servlet implementation class Servlet_Mostrar_Chamado_Concluido_Por_Tipo
 */
@WebServlet("/Servlet_Mostrar_Chamado_Concluido_Por_Tipo")
public class Servlet_Mostrar_Chamado_Concluido_Por_Tipo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();
	EmpresaDAOImpl empresaDAOImp = new EmpresaDAOImpl();

	AcompanhamentoDAOImpl acompanhamentoDAOImpl = new AcompanhamentoDAOImpl();

	ChamadoAcompanhamentoDAOImpl chamadoAcompanhamentoDAOImpl = new ChamadoAcompanhamentoDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Mostrar_Chamado_Concluido_Por_Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long radio_consulta_chamado = Long.parseLong(request
				.getParameter("radio_consulta_chamado"));

		Chamado chamado = new Chamado();
		Empresa empresa = new Empresa();

		List<ChamadoAcompanhamento> lista_chamadoAcompanhamento = new ArrayList<ChamadoAcompanhamento>();

		try {
			chamado = chamadoDAOImp.get(radio_consulta_chamado);
			empresa = empresaDAOImp.get(chamado.getSeq_id_empresa());

			// COMO PEGA OS ACOMPANHAMENTOS EDISON!!1!!1! 
			lista_chamadoAcompanhamento = chamadoAcompanhamentoDAOImpl
					.getAll(radio_consulta_chamado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// COMO PEGA ESSA PORRA !!1!!1! X_X
//		Acompanhamento acompanhamento = new Acompanhamento();
//		acompanhamento = acompanhamentoDAOImpl.get(id);

		request.setAttribute("chamado", chamado);
		request.setAttribute("empresa", empresa);
		request.setAttribute("lista_chamadoAcompanhamento",
				lista_chamadoAcompanhamento);
		// request.setAttribute("acompanhamento", acompanhamento);
		RequestDispatcher rd = request
				.getRequestDispatcher("/relatorio_chamado_concluido_selecionado.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
