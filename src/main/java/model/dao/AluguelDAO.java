package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;

public class AluguelDAO {

	public Aluguel salvar(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista, devolucaoEfetiva) values (?,?,?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, aluguel.getExemplar().getId());
			preparedStatement.setInt(2, aluguel.getUsuario().getId());
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevolucaoPrevista()));

			if (aluguel.getDevolucaoEfetiva() != null) {
				preparedStatement.setDate(5, java.sql.Date.valueOf(aluguel.getDevolucaoEfetiva()));
			} else {
				preparedStatement.setDate(5, null);
			}

			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				aluguel.setId(idGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo aluguel.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return aluguel;
	}

	public boolean excluir(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM ALUGUEL WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, aluguel.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir aluguel.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;

		return excluiu;
	}

	public boolean alterar(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE ALUGUEL SET idUsuario=?, idExemplar=?, dataLocacao=?, devolucaoPrevista=?, devolucaoEfetiva=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int registrosAlterados = 0;
		try {
			preparedStatement.setInt(1, aluguel.getUsuario().getId());
			preparedStatement.setInt(2, aluguel.getExemplar().getId());
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevolucaoPrevista()));
			
			if(aluguel.getDevolucaoEfetiva() == null) {
				preparedStatement.setDate(5, null);
			} else {
				preparedStatement.setDate(5, java.sql.Date.valueOf(aluguel.getDevolucaoEfetiva()));
			}
			
			preparedStatement.setInt(6, aluguel.getId());
			registrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar aluguel.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return registrosAlterados > 0;
	}

	public Aluguel construirAluguelDoResultSet(ResultSet resultSet) {
		
		Aluguel aluguel;
		aluguel = new Aluguel();

		try {

			aluguel.setId(resultSet.getInt("id"));

			Exemplar exemplar = new Exemplar();
			exemplar.setId(resultSet.getInt("idExemplar"));
			ExemplarDAO exemplarDAO = new ExemplarDAO();
			exemplar = exemplarDAO.consultarExemplar(exemplar.getId());

			aluguel.setExemplar(exemplar);

			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getInt("idUsuario"));
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuario = usuarioDAO.consultarUsuario(usuario);

			aluguel.setUsuario(usuario);

			if (resultSet.getDate("dataLocacao").toLocalDate() != null) {
				aluguel.setDataLocacao(resultSet.getDate("dataLocacao").toLocalDate());
			}
			if (resultSet.getDate("devolucaoPrevista").toLocalDate() != null) {
				aluguel.setDevolucaoPrevista(resultSet.getDate("devolucaoPrevista").toLocalDate());
			}
			if (resultSet.next()) {
				if (resultSet.getDate("devolucaoEfetiva") != null) {
					aluguel.setDevolucaoEfetiva(resultSet.getDate("devolucaoEfetiva").toLocalDate());
				}
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao construir aluguel do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		}

		return aluguel;
	}

	public Aluguel consultarAluguelPorId(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Aluguel aluguel = null;

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				aluguel = construirAluguelDoResultSet(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar aluguel por id.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return aluguel;
	}

	public Aluguel consultarAluguel(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, aluguel.getId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				aluguel = construirAluguelDoResultSet(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar aluguel.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return aluguel;
	}

	// TODO arrumar, a consulta só mostra 1 aluguel.
	public ArrayList<Aluguel> consultarTodos(int limit) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL LIMIT ?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

		try {

			preparedStatement.setInt(1, limit);
			resultSet = preparedStatement.executeQuery();

			while (resultSet != null && resultSet.next()) {
				Aluguel aluguel = construirAluguelDoResultSet(resultSet);
				alugueis.add(aluguel);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao consultar todos os alugueis.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return alugueis;
	}

}
