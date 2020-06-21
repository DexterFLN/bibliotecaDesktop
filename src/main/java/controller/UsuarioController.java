package controller;

import java.util.ArrayList;

import model.bo.UsuarioBO;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;

public class UsuarioController {
	
	private UsuarioBO usuarioBO = new UsuarioBO();

	public ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		return usuarioBO.consultarUsuarioPorFiltro(usuarioSeletor);
	}
	

}
