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
import br.unisul.sau.dao.impl.FactoryDAOImpl;

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
		long radio_consulta_chamado = -1;
		
		try {
			radio_consulta_chamado = Long.parseLong(request.getParameter("radio_consulta_chamado"));
		} catch(Exception e) {
		}
		
		Chamado chamado = new Chamado();
		Empresa empresa = new Empresa();
		List<ChamadoAcompanhamento> all = new ArrayList<ChamadoAcompanhamento>();
		List<Acompanhamento> listAcompanhamento = new ArrayList<Acompanhamento>();
		if (radio_consulta_chamado != -1) {
			chamado = new FactoryDAOImpl().getChamadoDAOImpl().get(radio_consulta_chamado);
			empresa = new FactoryDAOImpl().getEmpresaDAOImpl().get(chamado.getSeq_id_empresa());
			all = new FactoryDAOImpl().getChamadoAcompanhamentoDAOImpl().getAll(radio_consulta_chamado);
			if (all != null) {
				for (ChamadoAcompanhamento id : all) {
					listAcompanhamento.add(new FactoryDAOImpl().getAcompanhamentoDAOImpl().get(id.getSeq_id_acompanhamento()));
				}
			}
			request.setAttribute("chamado", chamado);
			request.setAttribute("empresa", empresa);
			request.setAttribute("lista_chamadoAcompanhamento", listAcompanhamento);
			// request.setAttribute("acompanhamento", acompanhamento);
			RequestDispatcher rd = request
					.getRequestDispatcher("/relatorio_chamado_concluido_selecionado.jsp");
			rd.include(request, response);
		} else {
			response.sendRedirect("/SAU/index.jsp");
		}

		// Acompanhamento acompanhamento = new Acompanhamento();
		// acompanhamento = acompanhamentoDAOImpl.get(id);

		
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
