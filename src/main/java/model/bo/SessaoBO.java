package model.bo;

import java.util.ArrayList;

import model.dao.SessaoDAO;
import model.vo.Sessao;

public class SessaoBO {

	public static boolean salvarSessao(Sessao sessao) {
		return SessaoDAO.salvar(sessao).getId() > 0;
	}

	public static boolean excluirSessao(Sessao sessao) {
		return SessaoDAO.excluir(sessao);
	}

	public static boolean alterarSessao(Sessao sessao, String nomeAntigo) {
		return SessaoDAO.alterar(sessao, nomeAntigo);
	}

	public static Sessao consultarSessao(int id) {
		return SessaoDAO.consultarSessaoPorId(id);
	}

	public static ArrayList<Sessao> consultarSessoes(int limit) {
		return SessaoDAO.consultarTodasSessoes(limit);
	}

	public static Sessao consultarSessaoPorNome(String nome) {
		return SessaoDAO.consultarSessaoPorNome(nome);
	}

}
