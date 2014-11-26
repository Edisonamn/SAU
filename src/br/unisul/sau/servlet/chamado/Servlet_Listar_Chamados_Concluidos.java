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

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.Empresa;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;
import br.unisul.sau.dao.impl.EmpresaDAOImpl;

/**
 * Servlet implementation class Servlet_Listar_Chamados_Concluidos
 */
@WebServlet("/Servlet_Listar_Chamados_Concluidos")
public class Servlet_Listar_Chamados_Concluidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();
	EmpresaDAOImpl empresaDAOImp = new EmpresaDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Listar_Chamados_Concluidos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tipo_problema = request.getParameter("tipo_problema");

		List<Chamado> lista_chamados_concluidos = new ArrayList<Chamado>();
		List<Chamado> lista_chamados_concluidos_por_tipo = new ArrayList<Chamado>();

		List<Empresa> lista_empresas = new ArrayList<Empresa>();

		try {
			// pega todos chamados concluidos
			lista_chamados_concluidos = chamadoDAOImp.getAllConcluido();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// pega todos chamados do tipo escolhido e add na outra lista
		for (Chamado c : lista_chamados_concluidos) {
			if (c.getTipo_problema().getLabel().equals(tipo_problema)) {
				lista_chamados_concluidos_por_tipo.add(c);
			}
		}

		// add na lista a empresa de cada chamado
		for (Chamado c : lista_chamados_concluidos_por_tipo) {
			lista_empresas.add(empresaDAOImp.get(c.getSeq_id_empresa()));
		}

		request.setAttribute("lista_chamados_concluidos_por_tipo",
				lista_chamados_concluidos_por_tipo);
		request.setAttribute("lista_empresas", lista_empresas);
		RequestDispatcher rd = request
				.getRequestDispatcher("/relatorio_chamados_concluidos.jsp");
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
