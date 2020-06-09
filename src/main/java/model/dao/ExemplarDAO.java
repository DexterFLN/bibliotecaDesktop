package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarDAO {
	
	//TODO criar construção de resultSet para ALUGUEL
	//TODO criar construção de resultSet para LIVRO
	//TODO criar construção de resultSet para EXEMPLAR
	
	//TODO criar mais métodos de consulta de EXEMPLAR (consulta vinda de um aluguel, e vinda de um livro)
	// CONSULTA DE ALUGUEL "SELECT * FROM EXEMPLAR INNER JOIN ALUGUEL ON EXEMPLAR.id = ALUGUEL.idExemplar WHERE idLivro=1;"
	
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
			Livro livro = livroDAO.consultarLivroPorIdParaExemplares(resultSet.getInt("idLivro"));
			exemplar.setLivro(livro);
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