package model.bo;

import java.util.ArrayList;
import model.dao.UsuarioDAO;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;
import util.GeradorPlanilha;

public class UsuarioBO {
	
	public ArrayList<Usuario> consultarUsuarioPorFiltro(UsuarioSeletor usuarioSeletor) {
		return UsuarioDAO.consultarUsuarioPorFiltro(usuarioSeletor);
	}
	public Boolean alterarUsuario(Usuario usuarioAlterado) {
		return UsuarioDAO.alterar(usuarioAlterado);
	}
	
	public void gerarRelatorio(ArrayList<Usuario> usuarios, String caminhoEscolhido) {
		 GeradorPlanilha.gerarPlanilhaUsuarios(usuarios, caminhoEscolhido);
	}
	public Usuario cadastrarUsuario(Usuario usuario) {
		return UsuarioDAO.salvar(usuario);
		 
	}
	public static boolean existeUsuarioPorCpf(Usuario usuario) {
		return UsuarioDAO.existeUsuarioPorCpf(usuario.getCpf());
	}
}
