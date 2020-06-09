package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Exemplar;
import model.vo.Livro;
import model.vo.Sessao;

public class LivroDAO {


	public Livro salvar(Livro livro) { 		//MÉTODO SALVAR ESTÁ FUNCIONANDO
    
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO LIVRO (nome, autor, editora, edicao, ano, idSessao) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setString(1, livro.getNome());
			preparedStatement.setString(2, livro.getAutor());
			preparedStatement.setString(3, livro.getEditora());
			preparedStatement.setInt(4, livro.getEdicao());
			preparedStatement.setInt(5, livro.getAno());
			preparedStatement.setInt(6, livro.getSessao().getId());
			
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				livro.setId(idGerado);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao cadastrar livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return livro;
	}


	public boolean alterar(Livro livro) { 		//MÉTODO ALTERAR ESTÁ EM CONSTRUÇÃO

		int registrosAlterados = 0;
		String sql = "UPDATE LIVRO SET nome=?, autor=?, editora=?, edicao=?, ano=?, idSessao=? WHERE id=?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		try {
			preparedStatement.setString(1, livro.getNome());
			preparedStatement.setString(2, livro.getAutor());
			preparedStatement.setString(3, livro.getEditora());
			preparedStatement.setInt(4, livro.getEdicao());
			preparedStatement.setInt(5, livro.getAno());
			preparedStatement.setInt(6, livro.getSessao().getId());
			preparedStatement.setInt(7, livro.getId());
			registrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException ex) {

			System.out.println(" Erro ao alterar endereço. Causa: " + ex.getMessage());

		}

		return registrosAlterados > 0;
	}
	

	public boolean excluir(Livro livro) {		// MÉTODO EXCLUIR ESTÁ FUNCIONANDO

		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM LIVRO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, livro.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;
		return excluiu;
	}

	// TODO inserir exemplares na construÃ§Ã£o do objeto livro
	private Livro construirLivroDoResultSet(ResultSet resultSet) {
		Livro livro = new Livro();
		
		try {
			livro.setId(resultSet.getInt("id"));

			SessaoDAO sessaoDAO = new SessaoDAO();
			Sessao sessao = sessaoDAO.consultarSessaoPorId(resultSet.getInt(2));

			livro.setSessao(sessao);
			livro.setNome(resultSet.getString(3));
			livro.setAutor(resultSet.getString(4));
			livro.setEditora(resultSet.getString(5));
			livro.setEdicao(resultSet.getInt(6));
			livro.setAno(resultSet.getInt(7));

			/*ExemplarDAO exemplarDAO = new ExemplarDAO();
			ArrayList<Exemplar> exemplares = exemplarDAO.construirExemplaresDoLivro(livro.getId());
			livro.setExemplares(exemplares);*/

		} catch (SQLException ex) {
			System.out.println("Erro ao construir livro do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} 

		return livro;
	}

	private Livro construirLivroParaExemplares(ResultSet resultSet) {
		Livro livro = new Livro();
		
		try {
			livro.setId(resultSet.getInt("id"));

			SessaoDAO sessaoDAO = new SessaoDAO();
			Sessao sessao = sessaoDAO.consultarSessaoPorId(resultSet.getInt(2));

			livro.setSessao(sessao);
			livro.setNome(resultSet.getString(3));
			livro.setAutor(resultSet.getString(4));
			livro.setEditora(resultSet.getString(5));
			livro.setEdicao(resultSet.getInt(6));
			livro.setAno(resultSet.getInt(7));
			
		} catch (SQLException ex) {
			System.out.println("Erro ao construir livro do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} 

		return livro;
	}
	
	public Livro consultarLivroPorId(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM LIVRO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		Livro livro = null;

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				livro = construirLivroDoResultSet(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return livro;
	}


	public Livro consultarLivroPorIdParaExemplares(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM LIVRO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		Livro livro = null;

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				livro = construirLivroParaExemplares(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return livro;
	}
}