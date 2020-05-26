package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Aluguel;

public class AluguelDAO {

	public Aluguel salvar(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO ALUGUEL (dataLocacao, devolucaoPrevista, devolucaoEfetiva) values (?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setDate(2, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDevovlucaoPrevista()));
			if (aluguel.getDevolucaoEfetiva() != null) {
				preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevolucaoEfetiva()));
			} else {
				preparedStatement.setDate(4, null);
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
		String sql = "UPDATE ALUGUEL SET id=?, idUsuario=?, dataLocacao=?, devolucaoPrevista=?, devolucaoEfetiva=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int registrosAlterados = 0;
		try {
			preparedStatement.setInt(1, aluguel.getId());
			preparedStatement.setInt(2, aluguel.getUsuario().getId());
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevovlucaoPrevista()));
			preparedStatement.setDate(5, java.sql.Date.valueOf(aluguel.getDevolucaoEfetiva()));
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
	
	public Aluguel construirAluguelDoResultSet(ResultSet resultset) {
		Aluguel aluguel;
		aluguel = new Aluguel();
		
		try {
			
		} 
		
		return aluguel;
	}

	// TODO método de listagem de aluguel (consultarAluguel)
	// TODO método de listagem de alugeis (consultarTodos)

}
