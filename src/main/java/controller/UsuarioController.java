package controller;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

		if (message.trim().isEmpty()) {
			usuario.setNome(txtNome.trim());
			usuario.setSobrenome(txtSobrenome.trim());
			usuario.setEmail(txtEmail.trim());
			usuario.setDdd(txtDdd);
			usuario.setFone(txtTelefone);

			try {
				usuario.setDataNascimento(ConversorData.converterTextoEmData(txtDataNascimento));
			} catch (Exception e) {
				usuario.setDataNascimento(null);
			}
			usuario.setBiblioteca(biblioteca);
			usuario.setEndereco(endereco);
			usuario.setCpf(cpf.trim().replaceAll("[^0-9]", ""));

			message += validarUsuario(usuario);
		}

		if (UsuarioBO.existeUsuarioPorCpf(usuario)) {
			message += "\nCPF ja utilizado! ";
		}

		if (message.trim().isEmpty()) {
			message += EnderecoController.salvarEndereco(endereco);
			if (message.trim().isEmpty()) {
				usuario = usuarioBO.cadastrarUsuario(usuario);
			}
		}

		if (message.trim().isEmpty()) {
			message += "Usuario cadastrado com sucesso!";
		}

		return message;
	}

	public String alterarUsuario(Usuario usuarioAlterado) {
		String message = "";

		message = validarUsuario(usuarioAlterado);

		if (message.trim().isEmpty()) {
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
			message += "\nNome inválido ";
		}
		if (usuario == null || usuario.getDdd().trim().length() != 2) {
			message += "\nDDD inválido, o DDD deve ter 2 dígitos";
		}
		if (usuario.getSobrenome() == null || usuario.getSobrenome().trim().isEmpty()) {
			message += "\nSobrenome inválido ";
		}
		if (!Utils.emailValido(usuario.getEmail())) {
			message += "\nEmail inválido ";
		}
		if (usuario.getFone().trim().length() > 8 || usuario.getFone().trim().length() < 8) {
			message += "\nTelefone inválido ";
		}
		if (usuario.getCpf().trim().length() != 11) {
			message += "\nCPF inválido";
		}
		if (usuario.getDataNascimento() == null) {
			message += "\nData de nascimento inválida";
		}
		return message;

	}

	public boolean excluirUsuario(Usuario usuario) {
		return usuarioBO.excluirUsuario(usuario);

	}

}
