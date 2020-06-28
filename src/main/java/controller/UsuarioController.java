package controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.UsuarioBO;
import model.seletor.UsuarioSeletor;
import model.vo.Biblioteca;
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

	public Usuario cadastrarUsuario(String txtNome, String txtSobrenome, String txtEmail, String txtDdd,
			String txtTelefone, String txtDataNascimento, Biblioteca cbBiblioteca) {
		Usuario usuario = new Usuario();
		usuario.setNome(txtNome);
		usuario.setSobrenome(txtSobrenome);
		usuario.setEmail(txtEmail);
		usuario.setDdd(txtDdd);
		usuario.setFone(txtTelefone);
		;
		usuario.setDataNascimento(ConversorData.converterTextoEmData(txtDataNascimento));
		usuario.setBiblioteca(cbBiblioteca);
		return usuarioBO.cadastrarUsuario(usuario);

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
}
