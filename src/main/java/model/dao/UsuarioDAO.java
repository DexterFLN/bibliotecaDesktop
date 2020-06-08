package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Biblioteca;
import model.vo.Endereco;
import model.vo.Usuario;

public class UsuarioDAO {

	public Usuario salvar(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO USUARIO (idBiblioteca, idEndereco, nome, sobrenome, tipo, dataNascimento, email,"
				+ " dddFixo, foneFixo, dddMovel, foneMovel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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

			if (usuario.getDddFixo() != null && !usuario.getDddFixo().isEmpty()) {
				preparedStatement.setString(8, usuario.getDddFixo());
			} else {
				preparedStatement.setString(8, null);
			}
			if (usuario.getFoneFixo() != null && !usuario.getFoneFixo().isEmpty()) {
				preparedStatement.setString(9, usuario.getFoneFixo());
			} else {
				preparedStatement.setString(9, null);
			}
			if (usuario.getDddMovel() != null && !usuario.getDddMovel().isEmpty()) {
				preparedStatement.setString(10, usuario.getDddMovel());
			} else {
				preparedStatement.setString(10, null);
			}
			if (usuario.getFoneMovel() != null && !usuario.getFoneMovel().isEmpty()) {
				preparedStatement.setString(11, usuario.getFoneMovel());
			} else {
				preparedStatement.setString(11, null);
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

	public boolean excluir(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "DELETE FROM USUARIO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, usuario.getId());
			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir usu�rio.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		boolean excluiu = quantidadeLinhasAfetadas > 0;
		return excluiu;
	}

	// TODO pensar nas regras de neg�cio por tr�s do m�todo (verificar quais atributos podem ser nulos, e quais s�o obrigat�rios).
	public boolean alterar(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "UPDATE USUARIO SET idBiblioteca=?, idEndereco=?, nome=?, sobrenome=?, tipo=?, dataNascimento=?, email=?,"
				+ " dddFixo=?, foneFixo=?, dddMovel=?, foneMovel=? WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			preparedStatement.setInt(1, usuario.getBiblioteca().getId());
			preparedStatement.setInt(2, usuario.getEndereco().getId());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getSobrenome());
			preparedStatement.setInt(5, usuario.getTipo());
			preparedStatement.setDate(6, java.sql.Date.valueOf(usuario.getDataNascimento()));
			preparedStatement.setString(7, usuario.getEmail());

			if (usuario.getDddFixo() != null && !usuario.getDddFixo().isEmpty()) {
				preparedStatement.setString(8, usuario.getDddFixo());
			} else {
				preparedStatement.setString(8, null);
			}
			if (usuario.getFoneFixo() != null && !usuario.getFoneFixo().isEmpty()) {
				preparedStatement.setString(9, usuario.getFoneFixo());
			} else {
				preparedStatement.setString(9, null);
			}
			if (usuario.getDddMovel() != null && !usuario.getDddMovel().isEmpty()) {
				preparedStatement.setString(10, usuario.getDddMovel());
			} else {
				preparedStatement.setString(10, null);
			}
			if (usuario.getFoneMovel() != null && !usuario.getFoneMovel().isEmpty()) {
				preparedStatement.setString(11, usuario.getFoneMovel());
			} else {
				preparedStatement.setString(11, null);
			}
			preparedStatement.setInt(12, usuario.getId());

			quantidadeLinhasAfetadas = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Erro ao alterar usu�rio.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Usuario construirUsuarioDoResultSet(ResultSet resultSet) {
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
			usuario.setDddFixo(resultSet.getString("dddFixo"));
			usuario.setFoneFixo(resultSet.getString("foneFixo"));
			usuario.setDddMovel(resultSet.getString("dddMovel"));
			usuario.setFoneMovel(resultSet.getString("foneMovel"));
		} catch (SQLException ex) {
			System.out.println("Erro ao construir Biblioteca do ResultSet");
		}

		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco endereco = enderecoDAO.consultarEnderecoPorId(resultSet.getInt("idEndereco"));
			usuario.setEndereco(endereco);
		} catch (SQLException ex) {
			System.out.println("Erro ao construir Endere�o do ResultSet");
		}

		return usuario;
	}

	public Usuario consultarUsuario(Usuario usuario) {
		Connection connection = Banco.getConnection();
		String sql = "SELECT * FROM USUARIO WHERE id=?";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setInt(1, usuario.getId());
			resultSet = preparedStatement.executeQuery();

			if(resultSet != null && resultSet.next()) {
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
	
	public ArrayList<Usuario> consultarTodosUsuarios(int limit) {
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

}
