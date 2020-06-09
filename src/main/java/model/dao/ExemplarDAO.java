package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarDAO {
	
	public Exemplar construirExemplarDoResultSet(ResultSet resultSet) {
		Exemplar exemplar = new Exemplar();

		try {
			exemplar.setId(resultSet.getInt("id"));

			LivroDAO livroDAO = new LivroDAO();
			Livro livro = livroDAO.consultarLivroPorId(resultSet.getInt("idLivro"));
			exemplar.setLivro(livro);
		} catch (SQLException ex) {
			System.out.println("Erro ao construir exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} 

		return exemplar;
	}
	
	public Exemplar construirExemplaresDeLivroDoResultSet(ResultSet resultSet) {
		Exemplar exemplar = new Exemplar();

		try {
			exemplar.setId(resultSet.getInt("id"));

			LivroDAO livroDAO = new LivroDAO();
			Livro livro = livroDAO.consultarLivroPorId(resultSet.getInt("idLivro"));
			exemplar.setLivro(livro);
		} catch (SQLException ex) {
			System.out.println("Erro ao construir exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} 

		return exemplar;
	}
	
	public Exemplar consultarExemplarLivro(int idLivro) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLAR WHERE idLivro=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		Exemplar exemplar = null;

		try {
			preparedStatement.setInt(1, idLivro);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				exemplar = construirExemplarDoResultSet(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar exemplar.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return exemplar;
	}
	
  
	public Exemplar consultarExemplar(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLAR WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Exemplar exemplar = new Exemplar();

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet != null && resultSet.next()) {
				exemplar.setId(resultSet.getInt("id"));

				LivroDAO livroDAO = new LivroDAO();
				Livro livro = livroDAO.consultarLivroPorIdParaExemplares(resultSet.getInt("idLivro"));
				exemplar.setLivro(livro);
			}
			
		} catch (SQLException ex) {
			System.out.println("Erro ao construir exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} 

		return exemplar;
	}


	public ArrayList<Exemplar> construirExemplaresDoLivro(int idLivro) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLAR WHERE idLivro=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
		
		try {
			preparedStatement.setInt(1, idLivro);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Exemplar exemplar = construirExemplaresDeLivroDoResultSet(resultSet);
				exemplares.add(exemplar);
			}
		} catch (SQLException ex) {
			System.out.println("Erro construir exemplares do livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return exemplares;
	}

}