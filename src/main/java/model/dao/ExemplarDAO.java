package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import model.seletor.ExemplarSeletor;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarDAO {

	public static Exemplar construirExemplarDoResultSet(ResultSet resultSet) {
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

	public static Exemplar construirExemplaresDeLivroDoResultSet(ResultSet resultSet) {
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

	public static Exemplar consultarExemplarLivro(int idLivro) {
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

	public static Exemplar consultarExemplar(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLAR WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Exemplar exemplar = new Exemplar();

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				exemplar.setId(resultSet.getInt("id"));

				LivroDAO livroDAO = new LivroDAO();
				Livro livro = livroDAO.consultarLivroPorIdParaExemplares(resultSet.getInt("idLivro"));
				exemplar.setLivro(livro);
				int status = resultSet.getInt("status");
				if (status == 1) {
					exemplar.setStatus(true);
				} else {
					exemplar.setStatus(false);
				}
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao construir exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return exemplar;
	}

	public static ArrayList<Exemplar> construirExemplaresDoLivro(int idLivro) {
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

	public static void salvar(Livro livro, String quantidade, boolean status) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO EXEMPLAR (idLivro, status) VALUES (?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		Exemplar exemplar = new Exemplar();
		int qtde = Integer.parseInt(quantidade);
		int alugado = (status) ? 1 : 0;
		alugado = 0;

		try {

			for (int i = 0; i < qtde; i++) {
				preparedStatement.setInt(1, livro.getId());
				preparedStatement.setInt(2, alugado);
				preparedStatement.executeUpdate();
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					int idGerado = resultSet.getInt(1);
					exemplar.setId(idGerado);
				}
			}
			JOptionPane.showMessageDialog(null, "Livro e exemplar(es) cadastrados com sucesso!");

		} catch (SQLException ex) {
			System.out.println("Erro ao cadastrar exemplar.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

	}

	public static ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		LivroDAO livroDAO = new LivroDAO();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		livros = livroDAO.consultarLivrosPorSeletor(livroSeletor);
		int[] idsLivros = new int[livros.size()];
		for (int i = 0; i < idsLivros.length; i++) {
			idsLivros[i] = livros.get(i).getId();
		}

		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM EXEMPLAR WHERE idLivro IN (" + Arrays.toString(idsLivros) + ");";
		sql = sql.replaceAll("\\[|\\]", "");
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
		try {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Exemplar exemplar = construirExemplarDoResultSet(resultSet);
				exemplares.add(exemplar);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar exemplar.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		System.out.println(" Consulta Exemplar " + sql);
		return exemplares;
	}

	public static boolean statusAlugado(Exemplar exemplar) { // METODO CONCLUIDO

		int registrosAlterados = 0;
		String sql = "UPDATE EXEMPLAR SET status=? WHERE id=?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		exemplar.setStatus(true);

		try {
			preparedStatement.setBoolean(1, exemplar.isStatus());
			preparedStatement.setInt(2, exemplar.getId());
			registrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(" Erro ao alterar status. Causa: " + ex.getMessage());

		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return registrosAlterados > 0;
	}

	public static boolean statusDevolvido(Exemplar exemplar) { // METODO CONCLUIDO
		int registrosAlterados = 0;
		String sql = "UPDATE EXEMPLAR SET status=? WHERE id=?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		exemplar.setStatus(false);

		try {
			preparedStatement.setBoolean(1, exemplar.isStatus());
			preparedStatement.setInt(2, exemplar.getId());
			registrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(" Erro ao alterar status. Causa: " + ex.getMessage());

		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return registrosAlterados > 0;
	}

	public static boolean consultarStatus(Exemplar exemplar) { // METODO CONCLUIDO
		Connection connection = Banco.getConnection();
		String sql = "SELECT status FROM EXEMPLAR WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Exemplar statusExemplar = new Exemplar();
		int valor;
		boolean status;
		try {
			preparedStatement.setInt(1, exemplar.getId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				statusExemplar.setStatus(resultSet.getBoolean("status"));
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao consultar status do exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		status = statusExemplar.isStatus();

		return status;
	}

	public static int pesquisarQuantidade(int idLivro) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT COUNT(LIVRO.id) FROM LIVRO INNER JOIN EXEMPLAR ON LIVRO.id = EXEMPLAR.idLivro WHERE LIVRO.id = ?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		int quantidade = 0;

		try {
			preparedStatement.setInt(1, idLivro);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				quantidade = resultSet.getInt(1);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao consultar status do exemplar do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return quantidade;
	}
}