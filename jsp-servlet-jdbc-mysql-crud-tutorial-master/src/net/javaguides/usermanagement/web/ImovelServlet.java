package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.ImovelDAO;
import net.javaguides.usermanagement.model.Imovel;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class ImovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImovelDAO imovelDAO;
	
	public void init() {
		imovelDAO = new ImovelDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertImovel(request, response);
				break;
			case "/delete":
				deleteImovel(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateImovel(request, response);
				break;
			default:
				listImovel(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
// Listar imoveis
	private void listImovel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Imovel> listImovel = imovelDAO.selectAllImoveis();
		request.setAttribute("listImovel", listImovel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("imovel-list.jsp");
		dispatcher.forward(request, response);
	}
// Mostrar formulario
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("imovel-form.jsp");
		dispatcher.forward(request, response);
	}
// Mostrar formulario para edicao
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Imovel existingImovel = imovelDAO.selectImovel(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("imovel-form.jsp");
		request.setAttribute("imovel", existingImovel);
		dispatcher.forward(request, response);

	}
// Insersao de Imovel
	private void insertImovel(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Boolean disponivel = Boolean.parseBoolean(request.getParameter("disponivel"));
		Boolean alugado = Boolean.parseBoolean(request.getParameter("alugado"));
		Boolean vendido = Boolean.parseBoolean(request.getParameter("vendido"));
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		Imovel newImovel = new Imovel(disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep);
		imovelDAO.insertImovel(newImovel);
		response.sendRedirect("list");
	}
// Atualizacao de Imovel
	private void updateImovel(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean disponivel = Boolean.parseBoolean(request.getParameter("disponivel"));
		Boolean alugado = Boolean.parseBoolean(request.getParameter("alugado"));
		Boolean vendido = Boolean.parseBoolean(request.getParameter("vendido"));
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		Imovel book = new Imovel(id, disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep);
		imovelDAO.updateImovel(book);
		response.sendRedirect("list");
	}
// Eliminar Imovel
	private void deleteImovel(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		imovelDAO.deleteImovel(id);
		response.sendRedirect("list");

	}

}
