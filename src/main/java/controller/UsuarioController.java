package controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.bo.UsuarioBO;
import model.seletor.UsuarioSeletor;
import model.vo.Biblioteca;
import model.vo.Endereco;
import model.vo.Livro;
import model.vo.Sessao;
import model.vo.Usuario;
import util.ConversorData;
import util.Utils;

public class UsuarioController {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private UsuarioBO usuarioBO = new UsuarioBO();

	public ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		return usuarioBO.consultarUsuarioPorFiltro(usuarioSeletor);
	}

	public String cadastrarUsuario(String txtNome, String txtSobrenome, String txtEmail, String txtDdd,
			String txtTelefone, String txtDataNascimento, String cpf, Biblioteca biblioteca, String txtRua,
			String txtNumero, String txtBairro, JComboBox cbUf, String txtCidade, String txtCEP) {
		String message = "";

		Endereco endereco = new Endereco();
		endereco.setRua(txtRua);
		endereco.setNumeroRua(txtNumero);
		endereco.setBairro(txtBairro);
		endereco.setUf(cbUf.getSelectedItem().toString());
		endereco.setCidade(txtCidade);
		endereco.setCep(txtCEP);

		message += EnderecoController.validarEndereco(endereco);

		Usuario usuario = new Usuario();
		usuario.setNome(txtNome.trim());
		usuario.setSobrenome(txtSobrenome.trim());
		usuario.setEmail(txtEmail.trim());
		usuario.setDdd(txtDdd);
		usuario.setFone(txtTelefone);
		usuario.setDataNascimento(ConversorData.converterTextoEmData(txtDataNascimento));
		usuario.setBiblioteca(biblioteca);
		usuario.setEndereco(endereco);
		usuario.setCpf(cpf.trim().replaceAll("[^0-9]", ""));

		message += validarUsuario(usuario);

		if (UsuarioBO.existeUsuarioPorCpf(usuario)) {
			message += "\n CPF já utilizado! ";
		}

		if (message.trim().isEmpty()) {
			message += EnderecoController.salvarEndereco(endereco);
			if (message.trim().isEmpty()) {
				usuario = usuarioBO.cadastrarUsuario(usuario);
			}
		}

		if (message.trim().isEmpty()) {
			message += "Usuário cadastrado com sucesso!";
		}

		return message;
	}

	public String alterarUsuario(Usuario usuarioAlterado) {
		String message = "";

		if (usuarioAlterado.getNome() == null || usuarioAlterado.getNome().trim().isEmpty()) {
			message += "Nome inválido ";
		} else if (usuarioAlterado == null || usuarioAlterado.getDdd().trim().length() != 2) {
			message += "DDD inválido, o DDD deve ter 2 dígitos";
		} else if (usuarioAlterado.getSobrenome() == null || usuarioAlterado.getSobrenome().trim().isEmpty()) {
			message += "Sobrenome inválido ";
		} else if (!Utils.emailValido(usuarioAlterado.getEmail())) {
			message += "Email inválido ";
		}

		if (message.isEmpty()) {
			if (usuarioBO.alterarUsuario(usuarioAlterado)) {
				message += "Usuário alterado com sucesso!";
			} else {
				message += "Usuário não foi alterado.";
			}
		}

		return message;
	}

	public void gerarRelatorio(ArrayList<Usuario> usuarios, String caminhoEscolhido) {
		usuarioBO.gerarRelatorio(usuarios, caminhoEscolhido);
	}

	private String validarUsuario(Usuario usuario) {
		String message = "";
		if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			message += "Nome inválido ";
		} else if (usuario == null || usuario.getDdd().trim().length() != 2) {
			message += "DDD inválido, o DDD deve ter 2 dígitos";
		} else if (usuario.getSobrenome() == null || usuario.getSobrenome().trim().isEmpty()) {
			message += "Sobrenome inválido ";
		} else if (!Utils.emailValido(usuario.getEmail())) {
			message += "Email inválido ";
		} else if (usuario.getFone().length() > 8) {
			message += "Telefone inválido ";
		} else if (usuario.getCpf().trim().length() != 11) {
			message += "CPF inválido";
		}
		return message;

	}

	public boolean excluirUsuario(Usuario usuario) {
		return usuarioBO.excluirUsuario(usuario);

	}

}
