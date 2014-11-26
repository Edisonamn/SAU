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

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.ChamadoAcompanhamento;
import br.unisul.sau.bean.Empresa;
import br.unisul.sau.bean.Tecnico;
import br.unisul.sau.bean.tenum.Status;
import br.unisul.sau.dao.impl.ChamadoAcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;
import br.unisul.sau.dao.impl.EmpresaDAOImpl;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Cadastrar_Chamado
 */
@WebServlet("/Servlet_Cadastrar_Chamado")
public class Servlet_Cadastrar_Chamado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ChamadoDAOImpl chamadoDAOImp = new ChamadoDAOImpl();
	EmpresaDAOImpl empresaDAOImp = new EmpresaDAOImpl();
	ChamadoAcompanhamentoDAOImpl chamadoAcompanhamentoDAOImp = new ChamadoAcompanhamentoDAOImpl();

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
		 Tecnico tecnico = (Tecnico) session.getAttribute("usuario_user");

		String id = request.getParameter("seq_id");
		String nome_empresa = request.getParameter("nome_empresa");
		String nome_cliente = request.getParameter("nome_cliente");
		String software = request.getParameter("software");
		String versao_software = request.getParameter("versao_software");
		String data = request.getParameter("data");
		String duracao = request.getParameter("duracao");

		String problema = request.getParameter("problema");
		String tipo_problema = request.getParameter("tipo_problema");
		String descricao_problema = request.getParameter("descricao_problema");

		Chamado chamado = new Chamado();
		chamado.setStatus(Status.INICIADO);
		chamado.setNome_cliente(nome_cliente);
		chamado.setSoftware(versao_software);
		// chamado.setData(data);
		// chamado.setDuracao(duracao);
		// chamado.setProblema(problema);
		// chamado.setTipo_problema(tipo_problema);
		chamado.setInfo_problema(descricao_problema);

		// vinculando a empresa ao chamado
		chamado.setSeq_id_empresa(Long.parseLong(id));
		chamado.setSeq_id_tecnico(tecnico.getSeq_id_tecnico());

		long add = new FactoryDAOImpl().getChamadoDAOImpl().add(chamado);

		response.sendRedirect("/SAU/empresa_pesquisar.jsp");
	}
}//