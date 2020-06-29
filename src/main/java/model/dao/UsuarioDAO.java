package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.seletor.LivroSeletor;
import model.seletor.UsuarioSeletor;
import model.vo.Biblioteca;
import model.vo.Endereco;
import model.vo.Usuario;

public class UsuarioDAO {

	public static Usuario salvar(Usuario usuario) {

		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO USUARIO (idBiblioteca, idEndereco, nome, sobrenome, tipo, dataNascimento, email,"
				+ " ddd, fone, cpf) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, usuario.getBiblioteca().getId());
			preparedStatement.setInt(2, usuario.getEndereco().getId());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getSobrenome());
			preparedStatement.setInt(5, usuario.getTipo());
			preparedStatement.setDate(6, java.sql.Date.valueOf(usuario.getDataNascimento()));
			preparedStatement.setString(7, usuario.getEmail());

			if (usuario.getDdd() != null && !usuario.getDdd().isEmpty()) {
				preparedStatement.setString(8, usuario.getDdd());
			} else {
				preparedStatement.setString(8, null);
			}
			if (usuario.getFone() != null && !usuario.getFone().isEmpty()) {
				preparedStatement.setString(9, usuario.getFone());
			} else {
				preparedStatement.setString(9, null);
			}
			if (usuario.getCpf() != null && !usuario.getCpf().isEmpty()) {
				preparedStatement.setString(10, usuario.getCpf());
			} else {
				preparedStatement.setString(10, null);
			}

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				usuario.setId(idGerado);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao cadastrar usu�rio.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return usuario;
	}

	public static boolean excluir(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM USUARIO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		AluguelDAO.excluirAluguelPorUsuario(usuario.getId());
		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, usuario.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir usuario.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;
		return excluiu;
	}

	public static boolean alterar(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE USUARIO SET idBiblioteca=?, idEndereco=?, nome=?, sobrenome=?, tipo=?, dataNascimento=?, email=?,"
				+ " ddd=?, fone=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		System.out.println(sql);
		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, usuario.getBiblioteca().getId());
			preparedStatement.setInt(2, usuario.getEndereco().getId());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getSobrenome());
			preparedStatement.setInt(5, usuario.getTipo());
			preparedStatement.setDate(6, java.sql.Date.valueOf(usuario.getDataNascimento()));
			preparedStatement.setString(7, usuario.getEmail());

			if (usuario.getDdd() != null && !usuario.getDdd().isEmpty()) {
				preparedStatement.setString(8, usuario.getDdd());
			} else {
				preparedStatement.setString(8, null);
			}
			if (usuario.getFone() != null && !usuario.getFone().isEmpty()) {
				preparedStatement.setString(9, usuario.getFone());
			} else {
				preparedStatement.setString(9, null);
			}
			preparedStatement.setInt(10, usuario.getId());

			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Erro ao alterar usuario.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public static Usuario construirUsuarioDoResultSet(ResultSet resultSet) {
		Usuario usuario;
		usuario = new Usuario();

		try {
			usuario.setId(resultSet.getInt("id"));

			BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
			Biblioteca biblioteca = bibliotecaDAO.consultarBibliotecaPorId(resultSet.getInt("idBiblioteca"));
			usuario.setBiblioteca(biblioteca);
			usuario.setNome(resultSet.getString("nome"));
			usuario.setSobrenome(resultSet.getString("sobrenome"));
			usuario.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
			usuario.setEmail(resultSet.getString("email"));
			usuario.setTipo(resultSet.getInt("tipo"));
			usuario.setDdd(resultSet.getString("ddd"));
			usuario.setFone(resultSet.getString("fone"));
			usuario.setCpf(resultSet.getString("cpf"));

		} catch (SQLException ex) {
			System.out.println("Erro ao construir Biblioteca do ResultSet");
		}

		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco endereco = enderecoDAO.consultarEnderecoPorId(resultSet.getInt("idEndereco"));
			usuario.setEndereco(endereco);
		} catch (SQLException ex) {
			System.out.println("Erro ao construir Endereco do ResultSet");
		}

		return usuario;
	}

	public static Usuario consultarUsuario(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM USUARIO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, usuario.getId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null && resultSet.next()) {
				usuario = construirUsuarioDoResultSet(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar usu�rio.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return usuario;
	}

	public static ArrayList<Usuario> consultarTodosUsuarios(int limit) {
		String sql = "SELECT * FROM USUARIO LIMIT ?";

		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			preparedStatement.setInt(1, limit);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = construirUsuarioDoResultSet(resultSet);
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			System.out.println("Erro consultar todos os usuários.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return usuarios;
	}

	private static String criarFiltros(String sql, UsuarioSeletor seletor) {

		if (seletor.getTermoPesquisa() != null && !seletor.getTermoPesquisa().trim().isEmpty()) {
			System.out.println(" - Seletor Termo Pesquisa Validado");
			sql += " WHERE ";

			if (seletor.getBuscarPor() != null && !seletor.getBuscarPor().trim().isEmpty()) {
				if (seletor.getBuscarPor() == "Código") {
					System.out.println("  - Seletor Código");
					sql += " id = " + seletor.getTermoPesquisa().toString();
				} else {
					System.out.println(" - Seletor nome");
					sql += " nome LIKE " + "'%" + seletor.getTermoPesquisa() + "%'";
				}

			}

		}

		System.out.println(" SQL FILTROS: " + sql);
		return sql;
	}

	public static ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		String sql = "SELECT * FROM USUARIO";
		Connection connection = Banco.getConnection();

		usuarioSeletor = usuarioSeletor.validarFitros(usuarioSeletor);
		if (usuarioSeletor.temFiltro()) {
			sql = criarFiltros(sql, usuarioSeletor);
		}
		System.out.println("Consultar Usuario Filtro - " + sql);
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = construirUsuarioDoResultSet(resultSet);
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			System.out.println("Erro consultar todos os usuários.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return usuarios;

	}

	public static boolean existeUsuarioPorCpf(String cpf) {
		String sql = "SELECT * FROM USUARIO WHERE cpf = ?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			preparedStatement.setString(1, cpf);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = construirUsuarioDoResultSet(resultSet);
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			System.out.println("Erro consultar todos os usuários.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return !usuarios.isEmpty();

	}

}
