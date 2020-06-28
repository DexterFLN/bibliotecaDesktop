package model.bo;

import java.util.ArrayList;

import model.dao.SessaoDAO;
import model.vo.Sessao;

public class SessaoBO {

	public static boolean salvarSessao(Sessao sessao) {
		return SessaoDAO.consultarSessao(sessao).getId() > 0;
	}
	
	public static boolean excluirSessao(Sessao sessao) {
		return SessaoDAO.excluir(sessao);
	}
	
	public static boolean alterarSessao(Sessao sessao) {
		return SessaoDAO.alterar(sessao);
	}
	
	public static Sessao consultarSessao(int id) {		
		return SessaoDAO.consultarSessaoPorId(id);
	}
	
	public static ArrayList<Sessao> consultarSessoes(int limit) {
		return SessaoDAO.consultarTodasSessoes(limit);
	}

}
