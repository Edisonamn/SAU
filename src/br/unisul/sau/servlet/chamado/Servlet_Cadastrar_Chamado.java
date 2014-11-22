package br.unisul.sau.servlet.chamado;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JLabel;

/**
 * Servlet implementation class Servlet_Cadastrar_Chamado
 */
@WebServlet("/Servlet_Cadastrar_Chamado")
public class Servlet_Cadastrar_Chamado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Cadastrar_Chamado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Usuario usuario = new Usuario();
		// usuario = (Usuario) session.getAttribute("usuario_logado");
		
		//Setar o status do chamado quando é iniciado <<<
		String nome_cliente = request.getParameter("nome_cliente");
		String software = request.getParameter("software");
		String versao_software = request.getParameter("versao_software");
		String data = request.getParameter("data");
		String duracao = request.getParameter("duracao");
		
		String problema = request.getParameter("problema");
		String tipo_problema = request.getParameter("tipo_problema");
		String descricao_problema = request.getParameter("descricao_problema");

//		Calendar c = Calendar.getInstance();
//		Date d = c.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		sdf.format(d);
//		System.out.println("\nData: " + d); 

		try {
			// chamadoDAO.inserir(chamado);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/TesteBootstrap/Servlet_Cadastrar_Chamado");
	}
}//