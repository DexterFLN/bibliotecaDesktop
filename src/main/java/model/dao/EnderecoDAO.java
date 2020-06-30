package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Endereco;

public class EnderecoDAO {

	public static Endereco salvar(Endereco endereco) {
		Connection connection = Banco.getConnection();
		String sql = "INSERT INTO ENDERECO (rua, numeroRua, bairro, cidade, uf, cep) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			preparedStatement.setString(1, endereco.getRua());
			preparedStatement.setString(2, endereco.getNumeroRua());
			preparedStatement.setString(3, endereco.getBairro());
			preparedStatement.setString(4, endereco.getCidade());
			preparedStatement.setString(5, endereco.getUf());
			preparedStatement.setString(6, endereco.getCep());

			preparedStatement.execute();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				int idGerado = resultSet.getInt(1);
				endereco.setId(idGerado);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao inserir novo endereco.");
			System.out.println("Erro: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return endereco;
	}

	public static boolean excluir(Endereco endereco) {
		String sql = " DELETE FROM ENDERECO WHERE id = ?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		boolean excluiu = false;
		try {
			preparedStatement.setInt(1, endereco.getId());
			int codigoRetornoUpdate = preparedStatement.executeUpdate();

			excluiu = (codigoRetornoUpdate == Banco.CODIGO_RETORNO_SUCESSO_EXCLUSAO);
		} catch (SQLException ex) {
			System.out.println(" Erro ao excluir endere�o. Id: " + endereco.getId() + " .Causa: " + ex.getMessage());
		} finally {
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return excluiu;
	}

	private static Endereco construirEnderecoDoResultSet(ResultSet resultSet) {
		Endereco endereco = new Endereco();
		try {
			endereco.setId(resultSet.getInt("id"));
			endereco.setRua(resultSet.getString("rua"));
			endereco.setNumeroRua(resultSet.getString("numeroRua"));
			endereco.setBairro(resultSet.getString("bairro"));
			endereco.setCidade(resultSet.getString("cidade"));
			endereco.setUf(resultSet.getString("uf"));
			endereco.setCep(resultSet.getString("cep"));
		} catch (SQLException ex) {
			System.out.println(" Erro ao construir endere�o a partir do ResultSet. Causa: " + ex.getMessage());
		}
		return endereco;
	}

	public static Endereco consultarEnderecoPorId(int id) {
		String sql = " SELECT * FROM ENDERECO WHERE id = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		Endereco enderecoConsultado = null;
		try {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				enderecoConsultado = construirEnderecoDoResultSet(rs);
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar endere�o. Id: " + id + " .Causa: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return enderecoConsultado;
	}

	public static ArrayList<Endereco> consultarTodos(int limit) {
		String sql = " SELECT * FROM ENDERECO LIMIT ?";

		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);
		ResultSet resultSet = null;
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			preparedStatement.setInt(1, limit);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Endereco enderecoConsultado = construirEnderecoDoResultSet(resultSet);
				enderecos.add(enderecoConsultado);
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar endere�os. Causa: " + ex.getMessage());
		} finally {
			Banco.closeResultSet(resultSet);
			Banco.closePreparedStatement(preparedStatement);
			Banco.closeConnection(connection);
		}
		return enderecos;
	}

	public static boolean alterar(Endereco endereco) {
		int registrosAlterados = 0;
		String sql = "UPDATE ENDERECO SET rua=?, numeroRua=?, bairro=?, cidade=?, uf=?, cep=? WHERE id=?";
		Connection connection = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(connection, sql);

		try {
			preparedStatement.setString(1, endereco.getRua());
			preparedStatement.setString(2, endereco.getNumeroRua());
			preparedStatement.setString(3, endereco.getBairro());
			preparedStatement.setString(4, endereco.getCidade());
			preparedStatement.setString(5, endereco.getUf());
			preparedStatement.setString(6, endereco.getCep());
			preparedStatement.setInt(7, endereco.getId());
			registrosAlterados = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(" Erro ao alterar endere�o. Causa: " + ex.getMessage());
		}

		return registrosAlterados > 0;
	}

}
