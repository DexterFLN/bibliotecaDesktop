package model.bo;

import java.util.ArrayList;

import model.dao.EnderecoDAO;
import model.vo.Endereco;

public class EnderecoBO {

	public static boolean salvarEndereco(Endereco endereco) {
		return EnderecoDAO.salvar(endereco).getId() > 0;
	}

	public static boolean excluirEndereco(Endereco endereco) {
		return EnderecoDAO.excluir(endereco);
	}

	public static Endereco consultarEndereco(int id) {
		return EnderecoDAO.consultarEnderecoPorId(id);
	}

	public static ArrayList<Endereco> consultarEnderecos(int limit) {
		return EnderecoDAO.consultarTodos(limit);
	}

	public static boolean alterarEndereco(Endereco endereco) {
		return EnderecoDAO.alterar(endereco);
	}

}
