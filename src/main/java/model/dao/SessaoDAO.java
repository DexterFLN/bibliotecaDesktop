package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Biblioteca;
import model.vo.Sessao;

public class SessaoDAO {

	public Sessao salvar(Sessao sessao) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO SESSAO (nome, idBiblioteca) VALUES (?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setString(1, sessao.getNome());
			preparedStatement.setInt(2, sessao.getBiblioteca().getId());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				sessao.setId(idGerado);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao cadastrar sessão.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return sessao;
	}

	public boolean excluir(Sessao sessao) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM SESSAO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, sessao.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir sessão.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;
		return excluiu;
	}

	public boolean alterar(Sessao sessao) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE SESSAO SET nome=?, idBiblioteca=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setString(1, sessao.getNome());
			preparedStatement.setInt(2, sessao.getBiblioteca().getId());

			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao alterar sessão.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Sessao construirSessaoDoResultset(ResultSet resultSet) {
		Biblioteca biblioteca = new Biblioteca();
		Sessao sessao = new Sessao();
		sessao.setBiblioteca(biblioteca);
		try {
			if(resultSet != null && resultSet.next()) {
				sessao.setId(resultSet.getInt(1));
				sessao.setNome(resultSet.getString(2));
				sessao.getBiblioteca().setId(resultSet.getInt("idBiblioteca")); //3
				sessao.getBiblioteca().setNome(resultSet.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao construir sessao do resultSet.");
			System.out.println("Erro: " + e.getMessage());
		}

		return sessao;
	}

	public Sessao consultarSessao(Sessao sessao) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM SESSAO INNER JOIN BIBLIOTECA ON SESSAO.idBiblioteca = BIBLIOTECA.id WHERE SESSAO.id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, sessao.getId());
			resultSet = preparedStatement.executeQuery();

			sessao = construirSessaoDoResultset(resultSet);
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar sessão.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return sessao;
	}
	
	public Sessao consultarSessaoPorId(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM SESSAO INNER JOIN BIBLIOTECA ON SESSAO.idBiblioteca = BIBLIOTECA.id WHERE SESSAO.id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		Sessao sessao = null;

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			sessao = construirSessaoDoResultset(resultSet);
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar sessão.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return sessao;
	}

	public ArrayList<Sessao> consultarTodasSessoes(int limit) {
		String sql = "SELECT * FROM SESSAO INNER JOIN BIBLIOTECA ON SESSAO.idBiblioteca = BIBLIOTECA.id LIMIT ?";

		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();

		try {
			preparedStatement.setInt(1, limit);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Sessao sessao = construirSessaoDoResultset(resultSet);
				sessoes.add(sessao);
			}

		} catch (SQLException ex) {
			System.out.println("Erro consultar todas as sessões.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return sessoes;
	}

}
