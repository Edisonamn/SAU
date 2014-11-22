package br.unisul.sau.servlet.empresa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.unisul.sau.bean.Empresa;

/**
 * Servlet implementation class Servlet_Pesquisar_Empresa
 */
@WebServlet("/Servlet_Pesquisar_Empresa")
public class Servlet_Pesquisar_Empresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		List<Empresa> lista_empresas = ArrayList<>();

		if (nome_empresa == null && numero_contrato == null) {
			response.sendRedirect("/SAU/empresa_pesquisar.jsp");

		} else if (nome_empresa == null && numero_contrato != null) {
			// pesquisaDAO pelo numero
		} else if (nome_empresa != null && numero_contrato == null) {
			// pesquisaDAO pelo nome da empresa
		}
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/chamado_cadastrar.jsp");
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
