package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;
import model.vo.Sessao;

public class LivroDAO {

	public Livro salvar(Livro livro) { // METODO SALVAR ESTA FUNCIONANDO

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
			// JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
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

	public boolean alterar(Livro livro) { // METODO ALTERAR EM CONSTRUCAO

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
			System.out.println(" Erro ao alterar endereÃ§o. Causa: " + ex.getMessage());

		}

		return registrosAlterados > 0;
	}

	public boolean excluir(Livro livro) { // MÃ‰TODO EXCLUIR ESTÃ� FUNCIONANDO

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

	// TODO inserir exemplares na construÃƒÂ§ÃƒÂ£o do objeto livro
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

			/*
			  ExemplarDAO exemplarDAO = new ExemplarDAO(); 
			  ArrayList<Exemplar> exemplares = exemplarDAO.construirExemplaresDoLivro(livro.getId());
			  livro.setExemplares(exemplares);
			 */

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
	
	public ArrayList<Livro> consultarLivrosPorSeletor(LivroSeletor seletor) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM LIVRO";
		ResultSet resultSet = null;
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		seletor = seletor.validarFitros(seletor);
		
		if(seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}
		
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Livro livro = construirLivroDoResultSet(resultSet);
				livros.add(livro);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar livro.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		
		return livros;
	}

	private String criarFiltros(String sql, LivroSeletor seletor) {
		boolean primeiro = true;
		

		if (seletor.getTermoPesquisa() != null && !seletor.getTermoPesquisa().isBlank()) {
			sql += " WHERE ";
			System.out.println("LivroDAO.java - Seletor Termo Pesquisa Validado");
			if (seletor.getBuscarPor() != null && !seletor.getBuscarPor().isBlank()) {

				if (seletor.getBuscarPor() == "Autor") {
					System.out.println("LivroDAO.java - Seletor Autor");
					sql += " autor LIKE " + "'%"  + seletor.getTermoPesquisa() + "%'";
				}  else if (seletor.getBuscarPor() == "Editora") {
					System.out.println("LivroDAO.java - Seletor Editora");
					sql += " editora LIKE " + "'%"  + seletor.getTermoPesquisa().toString() + "%'";
				} else if(seletor.getBuscarPor() == "Sessão") {
					System.out.println("LivroDAO.java - Seletor Sessão");
					sql += " idSessao IN (SELECT ID FROM SESSAO WHERE NOME LIKE " + "'%"  + seletor.getTermoPesquisa().toString() + "%')";
				} else {
					System.out.println("LivroDAO.java - Seletor nome");
					sql += " nome LIKE " + "'%"  + seletor.getTermoPesquisa() + "%'";
				}
				
				primeiro = false;
			}
			
			if (seletor.getAno() != null && !seletor.getAno().isBlank()) {
				if (!primeiro) {
					sql += " AND ";
				}
				sql += " ano = " + seletor.getAno().toString();
			}

		}
	
		System.out.println(	getClass().toString() + " SQL FILTROS: " + sql);
		return sql;
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