package br.unisul.sau.servlet.empresa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.sau.bean.Empresa;
import br.unisul.sau.dao.impl.EmpresaDAOImpl;

/**
 * Servlet implementation class Servlet_Pesquisar_Empresa
 */
@WebServlet("/Servlet_Pesquisar_Empresa")
public class Servlet_Pesquisar_Empresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpresaDAOImpl empresaDAOImp = new EmpresaDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Pesquisar_Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome_empresa = request.getParameter("nome_empresa");
		String numero_contrato = request.getParameter("numero_contrato");

		Empresa empresa = new Empresa();

		if (nome_empresa == null && numero_contrato == null) {
			response.sendRedirect("/SAU/empresa_pesquisar.jsp");

		} else if (nome_empresa == null && numero_contrato != null) {
			try {
				empresa = empresaDAOImp.get(numero_contrato);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("empresa", empresa);
			RequestDispatcher rd = request
					.getRequestDispatcher("/chamado_cadastrar.jsp");
			rd.include(request, response);

		} else if (nome_empresa != null && numero_contrato == null) {
			try {
				empresa = empresaDAOImp.get(nome_empresa);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("empresa", empresa);
			RequestDispatcher rd = request
					.getRequestDispatcher("/chamado_cadastrar.jsp");
			rd.include(request, response);
		}
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
