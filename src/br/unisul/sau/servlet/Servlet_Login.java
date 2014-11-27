package br.unisul.sau.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; //quem sabe utilizar o import no cabe�alho para nao retornar null no nome do usu�rio logado

import br.unisul.sau.bean.Tecnico;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;

		response.sendRedirect("/SAU/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Tecnico user = new FactoryDAOImpl().getTecnicoDAOImpl().getUser(login);
		
		if (senha.equals(user.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario_logado", true);
			session.setAttribute("usuario_nome", user.getNome());
			session.setAttribute("usuario_user", user);
			response.sendRedirect("/SAU/index.jsp");
		} else {
			response.sendRedirect("/SAU/login.jsp");
		}

	}

}//