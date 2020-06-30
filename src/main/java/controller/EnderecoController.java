package controller;

import java.util.ArrayList;

import model.bo.EnderecoBO;
import model.vo.Endereco;

public class EnderecoController {

	public static String salvarEndereco(Endereco endereco) {
		String mensagem = "";
		boolean salvou = EnderecoBO.salvarEndereco(endereco);
		if (!salvou) {
			mensagem += "Não foi possível salvar o endereço.";
		}

		return mensagem;
	}

	public static String excluirEndereco(Endereco endereco) {
		String mensagem = "";
		boolean excluiu = EnderecoBO.excluirEndereco(endereco);
		if (!excluiu) {
			mensagem += "Não foi possível excluir este endereço.";
		}

		return mensagem;
	}

	public static Endereco consultarEndereco(int id) {
		Endereco endereco = EnderecoBO.consultarEndereco(id);
		return endereco;
	}

	public static ArrayList<Endereco> consultarEnderecos(int limit) {
		return EnderecoBO.consultarEnderecos(limit);
	}

	public static String alterarEndereco(Endereco endereco) {
		String mensagem = "";
		boolean alterou = EnderecoBO.alterarEndereco(endereco);
		if (!alterou) {
			mensagem += "Não foi possível alterar este endereço.";
		} else {
			mensagem += "Endereço alterado com sucesso!";
		}
		return mensagem;
	}

	public static String validarEndereco(Endereco endereco) {
		String message = "";

		if (endereco.getCep().trim().replaceAll("[^0-9]", "").length() != 8) {
			message += "\n CEP Inválido ";
		} else if (endereco.getBairro().trim().isEmpty()) {
			message += "\n Bairro Inválido ";
		} else if (endereco.getCidade().trim().isEmpty()) {
			message += "\n Cidade Inválida ";
		} else if (endereco.getRua().trim().isEmpty()) {
			message += "\n Rua Inválida";
		} else if (endereco.getUf().trim().isEmpty()) {
			message += "\n UF Inválido";
		}
		return message;

	}

}
