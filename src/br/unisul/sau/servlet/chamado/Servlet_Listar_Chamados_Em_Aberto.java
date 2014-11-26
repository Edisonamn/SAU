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
import javax.servlet.http.HttpSession;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;

/**
 * Servlet implementation class Servlet_Listar_Chamados
 */
@WebServlet("/Servlet_Listar_Chamados")
public class Servlet_Listar_Chamados_Em_Aberto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Listar_Chamados_Em_Aberto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Chamado> lista_chamados_abertos = new ArrayList<Chamado>();

		try {
			lista_chamados_abertos = chamadoDAOImp.getAllAberto();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("lista_chamados_abertos", lista_chamados_abertos);
		RequestDispatcher rd = request
				.getRequestDispatcher("/chamados_listar_todos_em_aberto.jsp");
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

}//