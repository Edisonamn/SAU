package util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; //quem sabe utilizar o import no cabeçalho para nao retornar null no nome do usuário logado

import usuario.Usuario;
import usuario.UsuarioDAO;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO usuarioDAO = new UsuarioDAO();

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

		System.out
				.println("-----------------------------------------------------------------"
						+ "\nSession Finalizada.");
		response.sendRedirect("/TesteBootstrap/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out
				.println("-----------------------------------------------------------------"
						+ "\nIniciando Session.");

		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		List<Usuario> lista_usuarios = usuarioDAO.listar();

		Usuario usuario_logado = new Usuario();

		boolean aux_login = false;

		for (Usuario user : lista_usuarios) {
			if (user.getLogin().equals(login)) {
				if (user.getSenha().equals(senha)) {
					usuario_logado = user;
					aux_login = true;
				}
			}
		}

		if (aux_login == true) {
			session.setAttribute("usuario_logado", usuario_logado);

			System.out
					.println("-----------------------------------------------------------------"
							+ "\nSession Iniciada.");
			response.sendRedirect("/TesteBootstrap/index.jsp");
			//Tentar mandar por dispatcher o usuario logado.

		} else {
			System.out
					.println("-----------------------------------------------------------------"
							+ "\nLogin ou Senha incorretos!");
			response.sendRedirect("/TesteBootstrap/login.jsp");
		}

	}

}//