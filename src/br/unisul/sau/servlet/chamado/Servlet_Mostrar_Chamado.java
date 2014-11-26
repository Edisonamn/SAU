package br.unisul.sau.servlet.chamado;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.apt.model.Factory;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Mostrar_Chamado
 */
@WebServlet("/Servlet_Mostrar_Chamado")
public class Servlet_Mostrar_Chamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Mostrar_Chamado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long radio_consulta_chamado = Long.parseLong(request.getParameter("radio_consulta_chamado"));

		Chamado chamado = new FactoryDAOImpl().getChamadoDAOImpl().get(radio_consulta_chamado);

		request.setAttribute("chamado", chamado);
		RequestDispatcher rd = request
				.getRequestDispatcher("/chamado_mostrar.jsp");
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
