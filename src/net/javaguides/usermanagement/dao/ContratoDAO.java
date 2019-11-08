package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Contrato;
import net.javaguides.usermanagement.model.User;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table Contratos in the database.
 *
 */
public class ContratoDAO {
	private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g4?useSSL=false";
	//private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "t1g4";
	private String jdbcPassword = "#Fhgkt!";

	private static final String INSERT_CONTRACTS_SQL = "INSERT INTO contratos" + "  (idImovel, idCliente, valor, dataInicio, dataFim, multa) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_CONTRACT_BY_ID = "select * from contratos where id =?";
	private static final String SELECT_ALL_CONTRACTS = "select * from contratos";
	private static final String DELETE_CONTRACTS_SQL = "delete from contratos where id = ?;";
	private static final String UPDATE_CONTRACTS_SQL = "update contratos set idImovel = ?, idCliente = ?, valor =?, dataInicio =?, dataFim =?, multa =? where id = ?;";

	public ContratoDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertContrato(Contrato contrato) throws SQLException {
		System.out.println(INSERT_CONTRACTS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACTS_SQL)) {
			preparedStatement.setInt(1, contrato.getIdImovel());
			preparedStatement.setString(2, contrato.getIdCliente());
			preparedStatement.setInt(3, contrato.getValor());
			preparedStatement.setLong(4, contrato.getDataInicio());
			preparedStatement.setLong(5, contrato.getDataFim());
			preparedStatement.setInt(6, contrato.getMulta());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Contrato selectContrato(int id) {
		Contrato contrato = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String idCliente = rs.getString("idCliente");
				int idImovel = rs.getInt("idImovel");
				int valor = rs.getInt("valor");
				long dataInicio = rs.getLong("dataInicio");
				long dataFim = rs.getLong("dataFim");
				int multa = rs.getInt("multa");

				contrato = new Contrato(id, idImovel, idCliente, valor, dataInicio, dataFim, multa);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return contrato;
	}

	public List<Contrato> selectAllContratos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Contrato> contratos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println (rs.getMetaData());

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String idCliente = rs.getString("idCliente");
				int idImovel = rs.getInt("idImovel");
				int valor = rs.getInt("valor");
				long dataInicio = rs.getLong("dataInicio");
				long dataFim = rs.getLong("dataFim");
				int multa = rs.getInt("multa");
				
				contratos.add(new Contrato(id, idImovel, idCliente, valor, dataInicio, dataFim, multa));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return contratos;
	}

	public boolean deleteContrato(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateContrato(Contrato contrato) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACTS_SQL);) {
			
			preparedStatement.setInt(1, contrato.getIdImovel());
			preparedStatement.setString(2, contrato.getIdCliente());
			preparedStatement.setInt(3, contrato.getValor());
			preparedStatement.setLong(4, contrato.getDataInicio());
			preparedStatement.setLong(5, contrato.getDataFim());
			preparedStatement.setInt(6, contrato.getMulta());
			System.out.println(preparedStatement);
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
