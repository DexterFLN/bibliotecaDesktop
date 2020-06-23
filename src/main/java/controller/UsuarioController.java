package controller;

import java.util.ArrayList;

import model.bo.UsuarioBO;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;
import util.Utils;

public class UsuarioController {
	
	private UsuarioBO usuarioBO = new UsuarioBO();

	public ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		return usuarioBO.consultarUsuarioPorFiltro(usuarioSeletor);
	}

	public String alterarUsuario(Usuario usuarioAlterado) {
		String message = "";

		if (usuarioAlterado.getNome() == null || usuarioAlterado.getNome().trim().isEmpty()) {
			message += "Nome inválido ";
		} else if (usuarioAlterado == null || usuarioAlterado.getDdd().trim().length() != 2) {
			message += "DDD inválido, o DDD deve ter 2 dígitos";
		} else if (usuarioAlterado.getSobrenome() == null || usuarioAlterado.getSobrenome().trim().isEmpty()) {
			message += "Sobrenome inválido ";
		}else if(!Utils.emailValido(usuarioAlterado.getEmail())) {
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
	

}
