package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Imovel;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 *
 */

public class ImovelDAO {
	private String jdbcURL = "jdbc:mariadb://db-labsoft.ml:3306/t1g4";
//	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "t1g4";
	private String jdbcPassword = "#Fhgkt!";

	private static final String INSERT_IMOVEIS_SQL = "INSERT INTO imoveis" 
			+ "  (disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_IMOVEL_BY_ID = "select * from imoveis where id =?";
	private static final String SELECT_ALL_IMOVEIS = "select * from imoveis";
	private static final String DELETE_IMOVEIS_SQL = "delete from imoveis where id = ?;";
	private static final String UPDATE_IMOVEIS_SQL = "update imoveis set disponivel=?, alugado=?, vendido=?, estado=?, cidade=?, bairro=?, rua=?, numero=?, complemento=?, cep=? where id = ?;";

	public ImovelDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
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

	public void insertImovel(Imovel imovel) throws SQLException {
		System.out.println(INSERT_IMOVEIS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMOVEIS_SQL)) {
			preparedStatement.setBoolean(1, imovel.getDisponivel());
			preparedStatement.setBoolean(2, imovel.isAlugado());
			preparedStatement.setBoolean(3, imovel.isVendido());
			preparedStatement.setString(4, imovel.getEstado());
			preparedStatement.setString(5, imovel.getCidade());
			preparedStatement.setString(6, imovel.getBairro());
			preparedStatement.setString(7, imovel.getRua());
			preparedStatement.setString(8, imovel.getNumero());
			preparedStatement.setString(9, imovel.getComplemento());
			preparedStatement.setString(10, imovel.getCep());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Imovel selectImovel(int id) {
		Imovel imovel = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMOVEL_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Boolean disponivel = rs.getBoolean("disponivel");
				Boolean alugado = rs.getBoolean("alugado");
				Boolean vendido = rs.getBoolean("vendido");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String cep = rs.getString("cep");
				imovel = new Imovel(id, disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return imovel;
	}

	public List<Imovel> selectAllImoveis() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Imovel> imoveis = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMOVEIS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				Boolean disponivel = rs.getBoolean("disponivel");
				Boolean alugado = rs.getBoolean("alugado");
				Boolean vendido = rs.getBoolean("vendido");
				String estado = rs.getString("estado");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String cep = rs.getString("cep");
				imoveis.add(new Imovel(id, disponivel, alugado, vendido, estado, cidade, bairro, rua, numero, complemento, cep));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return imoveis;
	}

	public boolean deleteImovel(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_IMOVEIS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateImovel(Imovel imovel) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_IMOVEIS_SQL);) {
			statement.setBoolean(1, imovel.getDisponivel());
			statement.setBoolean(2, imovel.isAlugado());
			statement.setBoolean(3, imovel.isVendido());
			statement.setString(4, imovel.getEstado());
			statement.setString(5, imovel.getCidade());
			statement.setString(6, imovel.getBairro());
			statement.setString(7, imovel.getRua());
			statement.setString(8, imovel.getNumero());
			statement.setString(9, imovel.getComplemento());
			statement.setString(10, imovel.getCep());
			statement.setInt(11, imovel.getId());
			rowUpdated = statement.executeUpdate() > 0;
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
