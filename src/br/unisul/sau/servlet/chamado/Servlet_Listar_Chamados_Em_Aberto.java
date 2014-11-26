package br.unisul.sau.servlet.chamado;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Listar_Chamados
 */
@WebServlet("/Servlet_Listar_Chamados_Em_Aberto")
public class Servlet_Listar_Chamados_Em_Aberto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_Listar_Chamados_Em_Aberto() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Chamado> lista_chamados_abertos = new FactoryDAOImpl().getChamadoDAOImpl().getAllAberto();

		request.setAttribute("lista_chamados_abertos", lista_chamados_abertos);
		RequestDispatcher rd = request.getRequestDispatcher("/chamados_listar_todos_em_aberto.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}