package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;

public class AluguelDAO {

	public static Aluguel salvar(Aluguel aluguel) {

		ExemplarDAO exemplarDAO = new ExemplarDAO();
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO ALUGUEL (idExemplar, idUsuario, dataLocacao, devolucaoPrevista) values (?,?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, aluguel.getExemplar().getId());
			preparedStatement.setInt(2, aluguel.getUsuario().getId());
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevolucaoPrevista()));
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				aluguel.setId(idGerado);
			}
			exemplarDAO.statusAlugado(aluguel.getExemplar());
			JOptionPane.showMessageDialog(null, "Aluguel registrado com sucesso!");
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

	public static boolean excluirAluguelPorUsuario(int id) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM ALUGUEL WHERE idUsuario=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, id);
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir aluguel por usuario.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;

		return excluiu;
	}

	public static boolean excluir(Aluguel aluguel) {
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

	public static boolean alterar(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE ALUGUEL SET idUsuario=?, idExemplar=?, dataLocacao=?, devolucaoPrevista=?, devolucaoEfetiva=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int registrosAlterados = 0;
		try {
			preparedStatement.setInt(1, aluguel.getUsuario().getId());
			preparedStatement.setInt(2, aluguel.getExemplar().getId());
			preparedStatement.setDate(3, java.sql.Date.valueOf(aluguel.getDataLocacao()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(aluguel.getDevolucaoPrevista()));

			if (aluguel.getDevolucaoEfetiva() == null) {
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

	public static Aluguel renovar(Aluguel aluguel) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE ALUGUEL SET devolucaoPrevista=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		try {
			preparedStatement.setDate(1, java.sql.Date.valueOf(aluguel.getDevolucaoPrevista()));
			preparedStatement.setInt(2, aluguel.getId());
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aluguel renovado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao renovar o aluguel.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return aluguel;
	}

	public static Aluguel devolver(Aluguel aluguel) {
		ExemplarDAO exemplarDAO = new ExemplarDAO();
		Connection connection = Banco.getConnection();
		String sql = "UPDATE ALUGUEL SET devolucaoEfetiva=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		try {
			preparedStatement.setDate(1, java.sql.Date.valueOf(aluguel.getDevolucaoEfetiva()));
			preparedStatement.setInt(2, aluguel.getId());
			preparedStatement.executeUpdate();
			exemplarDAO.statusDevolvido(aluguel.getExemplar());
			JOptionPane.showMessageDialog(null, "Aluguel devolvido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao encerrar o aluguel.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return aluguel;
	}

	public static Aluguel construirAluguelDoResultSet(ResultSet resultSet) {

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

			Date datatLocacao = resultSet.getDate("dataLocacao");
			Date dataDevolucaoPrevista = resultSet.getDate("devolucaoPrevista");
			Date dataDevolucaoEfetiva = resultSet.getDate("devolucaoEfetiva");

			if (datatLocacao != null) {
				aluguel.setDataLocacao(datatLocacao.toLocalDate());
			}
			if (dataDevolucaoPrevista != null) {
				aluguel.setDevolucaoPrevista(dataDevolucaoPrevista.toLocalDate());
			}
			if (dataDevolucaoEfetiva != null) {
				aluguel.setDevolucaoEfetiva(dataDevolucaoEfetiva.toLocalDate());
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao construir aluguel do resultSet.");
			System.out.println("Erro: " + ex.getMessage());
		}

		return aluguel;
	}

	public static Aluguel consultarAluguelPorId(int id) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Aluguel aluguel = null;

		try {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
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

	public static Aluguel consultarAluguel(Aluguel aluguel) {
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

	public static Aluguel consultarAluguelAtual(int idExemplar) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL WHERE idExemplar=? ORDER BY id DESC LIMIT 1";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		Aluguel aluguel = new Aluguel();

		try {
			preparedStatement.setInt(1, idExemplar);
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

	public static ArrayList<Aluguel> consultarTodos(int limit) {
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

	public static ArrayList<Aluguel> consultarAluguelSeletor(AluguelSeletor seletor) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM ALUGUEL";
		ResultSet resultSet = null;
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

		seletor = seletor.validarFitros(seletor);

		if (seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}

		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Aluguel aluguel = construirAluguelDoResultSet(resultSet);
				alugueis.add(aluguel);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar aluguel.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return alugueis;
	}

	private static String criarFiltros(String sql, AluguelSeletor seletor) {
		boolean primeiro = true;
		if (seletor.getTermoPesquisa() != null && !seletor.getTermoPesquisa().isEmpty()) {
			sql += " WHERE ";
			primeiro = false;
			System.out.println("AluguelDAO.java - Seletor Termo Pesquisa Validado");
			if (seletor.getBuscarPor() != null && !seletor.getBuscarPor().isEmpty()) {

				if (seletor.getBuscarPor() == "Codigo Usuario") {
					System.out.println("AluguelDAO.java - Seletor Codigo Usuario");
					sql += " idUsuario = " + seletor.getTermoPesquisa();
				} else if (seletor.getBuscarPor() == "Codigo Exemplar") {
					System.out.println("AluguelDAO.java - Seletor Codigo Exemplar");

					sql += " idExemplar = " + seletor.getTermoPesquisa();
				}

			}

		}

		if (seletor.getTermoPesquisa() != null && seletor.getBuscarPor() == "Atrasados") {
			if (primeiro) {
				sql += " WHERE ";
			}
			System.out.println("AluguelDAO.java - Seletor Termo Pesquisa Validado");
			System.out.println("AluguelDAO.java - Seletor Atrasados");
			sql += " devolucaoPrevista < '" + LocalDate.now() + "' AND devolucaoEfetiva IS NULL";
		}

		System.out.println(" SQL FILTROS: " + sql);

		return sql;
	}

	public static boolean existeAluguelAtrasado(Usuario usuario) {
		String sql = "SELECT * FROM ALUGUEL WHERE devolucaoPrevista < ? AND devolucaoEfetiva IS NULL and idUsuario = ?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

		try {
			preparedStatement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			preparedStatement.setInt(2, usuario.getId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Aluguel aluguelSelecionado = construirAluguelDoResultSet(resultSet);
				alugueis.add(aluguelSelecionado);
			}

		} catch (SQLException ex) {
			System.out.println("Erro consultar todos os alugueis.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return !alugueis.isEmpty();
	}
}
