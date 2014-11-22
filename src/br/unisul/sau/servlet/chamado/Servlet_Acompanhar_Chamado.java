package br.unisul.sau.servlet.chamado;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Acompanhar_Chamado
 */
@WebServlet("/Servlet_Acompanhar_Chamado")
public class Servlet_Acompanhar_Chamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Acompanhar_Chamado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int radio_consulta_chamado = Integer.parseInt(request
				.getParameter("radio_consulta_chamado"));
		
		//traz o chamado pelo id
		Chamado chamado = chamadoDAO.consultarPorId(radio_consulta_chamado);

		request.setAttribute("chamado", chamado);
		RequestDispatcher rd = request.getRequestDispatcher("/chamado_listar.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acompanhamento_problema = request.getParameter("acompanhamento_problema");
		
		Chamado chamado = new Chamado();
		chamado.setAcompanhamento_problema(acompanhamento_problema);
		
		//caso seja necessário setar um ID para o método alterarAcompanhamento() da classe chamadoDAO
//		List<Chamado> lista_chamados = chamadoDAO.listar();
//		for (Chamado c : lista_chamados) {
//			if(c.getId_chamado()==chamado.getId_chamado()){
//				chamado.setId_chamado(ALGUMID);
//			}
//		}
		
		try {
			chamadoDAO.alterarAcompanhamento(chamado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/TesteBootstrap/Servlet_Listar_Chamados");
	}

}//