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

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.Empresa;
import br.unisul.sau.bean.tenum.TipoProblema;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

/**
 * Servlet implementation class Servlet_Listar_Chamados_Concluidos
 */
@WebServlet("/Servlet_Listar_Chamados_Concluidos")
public class Servlet_Listar_Chamados_Concluidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_Listar_Chamados_Concluidos() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tipo_problema = request.getParameter("tipo_problema");
		
		TipoProblema tipo = TipoProblema.findByValue(Integer.parseInt(tipo_problema));
		
		List<Chamado> allConcluido = new FactoryDAOImpl().getChamadoDAOImpl().getAllConcluido(tipo);
		
		List<Empresa> allEmpresa = new ArrayList<Empresa>();
		for (Chamado chamado : allConcluido) {
			allEmpresa.add(new FactoryDAOImpl().getEmpresaDAOImpl().get(chamado.getSeq_id_empresa()));
		}

		request.setAttribute("lista_chamados_concluidos_por_tipo", allConcluido);
		request.setAttribute("lista_empresas", allEmpresa);
		RequestDispatcher rd = request.getRequestDispatcher("/relatorio_chamados_concluidos.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
