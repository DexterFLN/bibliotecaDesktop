package controller;

import java.util.ArrayList;

import model.bo.SessaoBO;
import model.dao.SessaoDAO;
import model.vo.Sessao;

public class SessaoController {

	public static String salvarSessao(Sessao sessao) {
		String mensagem = "";
		if(!SessaoBO.salvarSessao(sessao)) {
			mensagem += "Não foi possível salvar sessão.";
		}
		
		return mensagem;
	}
	
	public static String excluirSessao(Sessao sessao) {
		String mensagem = "";
		if(!SessaoBO.excluirSessao(sessao)) {
			mensagem += "Não foi possível excluir sessão.";
		}
		
		return mensagem;
	}
	
	public static String alterarSessao(Sessao sessao) {
		String mensagem = "";
		if(!SessaoBO.alterarSessao(sessao)) {
			mensagem += "Não foi possível alterar sessão.";
		}
		
		return mensagem;
	}
	
	public static Sessao consultarSessao(int id) {
		return SessaoDAO.consultarSessaoPorId(id);
	}
	
	public static ArrayList<Sessao> consultarSessoes(int limit) {
		return SessaoDAO.consultarTodasSessoes(limit);
	}
	
}
