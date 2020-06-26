package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;
import util.GeradorPlanilha;

public class UsuarioBO {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	public ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		return usuarioDAO.consultarUsuarioPorFiltro(usuarioSeletor);
	}
	public void gerarRelatorio(ArrayList<Usuario> usuarios, String caminhoEscolhido) {
		 GeradorPlanilha.gerarPlanilhaUsuarios(usuarios, caminhoEscolhido);
	}

}
