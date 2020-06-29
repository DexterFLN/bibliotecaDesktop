package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import model.bo.SessaoBO;
import model.dao.SessaoDAO;
import model.vo.Sessao;

public class SessaoController {

	public static String salvarSessao(Sessao sessao) {
		String mensagem = "";
		if(!SessaoBO.salvarSessao(sessao)) {
			mensagem += "Nao foi possivel salvar sessao.";
		}
		
		return mensagem;
	}
	
	public static String excluirSessao(Sessao sessao) {
		String mensagem = "";
		if(!SessaoBO.excluirSessao(sessao)) {
			mensagem += "Nao foi possivel excluir sessao.";
		}
		
		return mensagem;
	}
	
	public static String alterarSessao(Sessao sessao, String nomeAntigo) {
		String mensagem = "";
		if(!SessaoBO.alterarSessao(sessao, nomeAntigo)) {
			mensagem += "Nao foi possivel alterar sessao.";
		}
		
		return mensagem;
	}
	
	public static Sessao consultarSessao(int id) {
		return SessaoBO.consultarSessao(id);
	}
	
	public static ArrayList<Sessao> consultarSessoes(int limit) {
		return SessaoBO.consultarSessoes(limit);
	}
	
	public static void preencherComboBox(JComboBox cbSessao) {
		ArrayList<Sessao> sessoes = SessaoController.consultarSessoes(6);
		for (Sessao sessao : sessoes) {
			cbSessao.addItem(sessao);
		}
	}

	public static Sessao consultarSessaoPorNome(String nome) {
		return SessaoBO.consultarSessaoPorNome(nome);
	}
	
}
