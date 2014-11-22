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


/**
 * Servlet implementation class Servlet_Listar_Chamados
 */
@WebServlet("/Servlet_Listar_Chamados")
public class Servlet_Listar_Chamados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Listar_Chamados() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Usuario usuario = new Usuario();
//		usuario = (Usuario) session.getAttribute("usuario_logado");

//		List<Chamado> lista_chamados = ;
		
		
//		request.setAttribute("lista_chamados_usuario_logado", lista_chamados);
		RequestDispatcher rd = request
				.getRequestDispatcher("/chamados_listar_todos.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub
	}

}//