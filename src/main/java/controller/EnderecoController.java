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
		
		mensagem = validarEndereco(endereco);
		
		if(mensagem.trim().isEmpty()) {
			boolean alterou = EnderecoBO.alterarEndereco(endereco);
			if (!alterou) {
				mensagem += "Não foi possível alterar este endereço.";
			} else {
				mensagem += "Endereço alterado com sucesso!";
			}
		}
		return mensagem;
	}

	public static String validarEndereco(Endereco endereco) {
		String message = "";

		if (endereco.getCep().trim().replaceAll("[^0-9]", "").length() != 8) {
			message += "\nCEP Inválido ";
		} 
		if (endereco.getBairro().trim().isEmpty()) {
			message += "\nBairro Inválido ";
		} 
		if (endereco.getCidade().trim().isEmpty()) {
			message += "\nCidade Inválida ";
		} 
		if (endereco.getRua().trim().isEmpty()) {
			message += "\nRua Inválida";
		} 
		if (endereco.getUf().trim().isEmpty()) {
			message += "\nUF Inválido";
		}
		if(endereco.getNumeroRua().trim().isEmpty()){
			message += "\nNumero Rua Inválido";
		}
		return message;

	}

}
