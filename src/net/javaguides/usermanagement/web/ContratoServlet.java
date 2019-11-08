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

import net.javaguides.usermanagement.dao.ContratoDAO;
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.Contrato;
import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class ContratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContratoDAO contratoDAO;
	
	public void init() {
		contratoDAO = new ContratoDAO();
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
				insertContrato(request, response);
				break;
			case "/delete":
				deleteContrato(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateContrato(request, response);
				break;
			default:
				listContratos(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
// Listar usuarios
	private void listContratos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Contrato> listContratos = contratoDAO.selectAllContratos();
		request.setAttribute("listUser", listContratos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contrato-lista.jsp");
		dispatcher.forward(request, response);
	}
// Mostrar formulario
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("contrato.jsp");
		dispatcher.forward(request, response);
	}
// Mostrar forumulario para edição
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Contrato existingContrato = contratoDAO.selectContrato(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contrato.jsp");
		request.setAttribute("contrato", existingContrato);
		dispatcher.forward(request, response);

	}
// Inserção de Usuario
	private void insertContrato(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int idImovel = Integer.parseInt(request.getParameter("idImovel"));
		String idCliente = request.getParameter("idCliente");
		int valor = Integer.parseInt(request.getParameter("valor"));
		long dataInicio = Long.parseLong(request.getParameter("dataInicio"));
		long dataFim = Long.parseLong(request.getParameter("dataFim"));
		int multa = Integer.parseInt(request.getParameter("multa"));
		
		Contrato newContrato = new Contrato(idImovel, idCliente, valor, dataInicio, dataFim, multa);
		contratoDAO.insertContrato(newContrato);
		response.sendRedirect("list");
	}
// Atualização de Usuario
	private void updateContrato(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idImovel = Integer.parseInt(request.getParameter("idImovel"));
		String idCliente = request.getParameter("idCliente");
		int valor = Integer.parseInt(request.getParameter("valor"));
		long dataInicio = Long.parseLong(request.getParameter("dataInicio"));
		long dataFim = Long.parseLong(request.getParameter("dataFim"));
		int multa = Integer.parseInt(request.getParameter("multa"));

		Contrato contrato = new Contrato(id, idImovel, idCliente, valor, dataInicio, dataFim, multa);
		contratoDAO.updateContrato(contrato);
		response.sendRedirect("list");
	}
// Eliminar Usuario
	private void deleteContrato(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		contratoDAO.deleteContrato(id);
		response.sendRedirect("list");

	}

}
