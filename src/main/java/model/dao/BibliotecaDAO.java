package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Biblioteca;

public class BibliotecaDAO {

	public static Biblioteca salvar(Biblioteca biblioteca) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO BIBLIOTECA (nome) VALUES (?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		try {
			preparedStatement.setString(1, biblioteca.getNome());
			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			int idGerado = 0;

			if (resultSet.next()) {
				biblioteca.setId(idGerado);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao cadastrar biblioteca.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return biblioteca;
	}

	public static boolean excluir(Biblioteca biblioteca) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM BIBLIOTECA WHERE id= ?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;

		try {
			preparedStatement.setInt(1, biblioteca.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir biblioteca.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		boolean excluiu = quantidadeLinhasAfetadas > 0;

		return excluiu;
	}

	public static boolean alterar(Biblioteca biblioteca) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE BIBLIOTECA SET nome=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		int quantidadeRegistrosAlterados = 0;

		try {
			preparedStatement.setString(1, biblioteca.getNome());
			quantidadeRegistrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir biblioteca.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		boolean alterou = quantidadeRegistrosAlterados > 0;
		return alterou;
	}

	private static Biblioteca construirBibliotecaDoResultSet(ResultSet resultSet) {
		Biblioteca biblioteca = new Biblioteca();
		try {
			biblioteca.setId(resultSet.getInt("id"));
			biblioteca.setNome(resultSet.getString("nome"));
		} catch (SQLException e) {
			System.out.println("Erro ao construir biblioteca a partir do ResultSet. Causa: " + e.getMessage());
		}

		return biblioteca;
	}

	public static ArrayList<Biblioteca> consultarTodas(int limit) {
		Connection connection = Banco.getConnection();
		String sql = " SELECT * FROM BIBLIOTECA LIMIT ?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;

		ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
		try {
			preparedStatement.setInt(1, limit);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Biblioteca biblioteca = construirBibliotecaDoResultSet(resultSet);
				bibliotecas.add(biblioteca);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return bibliotecas;
	}

	public static Biblioteca consultarBiblioteca(Biblioteca biblioteca) {
		Connection connection = Banco.getConnection();
		String sql = " SELECT * FROM BIBLIOTECA WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, biblioteca.getId());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				biblioteca.setId(resultSet.getInt(1));
				biblioteca.setNome(resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return biblioteca;
	}
	
	public static Biblioteca consultarBibliotecaPorId(int id) {
		Connection connection = Banco.getConnection();
		String sql = " SELECT * FROM BIBLIOTECA WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Biblioteca biblioteca = null;

		try {
			biblioteca = new Biblioteca();
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				biblioteca.setId(resultSet.getInt(1));
				biblioteca.setNome(resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return biblioteca;
	}

}
