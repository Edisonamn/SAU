//package usuario;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/Servlet_Cadastrar_Usuario")
//public class Servlet_Cadastrar_Usuario extends HttpServlet{
//	private static final long serialVersionUID = 1L;
//	
//	UsuarioDAO usuarioDAO = new UsuarioDAO();
//
//	public Servlet_Cadastrar_Usuario() {
//		// TODO Auto-generated constructor stub
//	}
//
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String nome = request.getParameter("nome");
//		String login = request.getParameter("login");
//		String senha = request.getParameter("senha");
//		String tipo_usuario = request.getParameter("tipo_usuario");
//
//		Usuario usuario = new Usuario();
//		usuario.setNome(nome);
//		usuario.setLogin(login);
//		usuario.setSenha(senha);
//
//		if (tipo_usuario.equalsIgnoreCase(TipoUsuario.CLIENTE.getTipo())) {
//			usuario.setTipo_usuario(TipoUsuario.CLIENTE);
//		} else {
//			usuario.setTipo_usuario(TipoUsuario.TECNICO);
//		}
//
//		try {
//			usuarioDAO.inserir(usuario);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		response.sendRedirect("/TesteBootstrap/usuario_cadastrar.jsp");
//	}
//
//}//