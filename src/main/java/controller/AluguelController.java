package controller;

import javax.swing.JOptionPane;
import model.bo.AluguelBO;
import model.vo.Aluguel;
import util.ConversorData;


public class AluguelController {
	
	public Aluguel salvarAluguel(Aluguel aluguel) {
		AluguelBO bo = new AluguelBO();
        bo.salvar(aluguel);
        return aluguel;
    }
	
	public Aluguel renovarAluguel(Aluguel aluguel) {
		AluguelBO bo = new AluguelBO();
        bo.renovar(aluguel);
        return aluguel;
		
	}
	
	public Aluguel consultarAluguelAtual(int idExemplar) {
		AluguelBO bo = new AluguelBO();
		Aluguel aluguel = new Aluguel();
		aluguel = bo.consultarAluguelAtual(idExemplar);
		return aluguel;
	}
	
	public String validarCamposAlugar(String txtCodLivro, String txtCodUser, String txfDataDevolucao) {
		ConversorData conversor = new ConversorData();
		String mensagem = "";
		
		if(txtCodLivro.isEmpty()) {
			mensagem = "O(s) campo(s): CÓDIGO DO LIVRO";
		}
		
		if(txtCodUser.isEmpty()) {
			if(mensagem == "") {
				mensagem = "O(s) campo(s): CÓDIGO DO USUÁRIO ";
				
			} else {
				mensagem += ", CÓDIGO DO USUÁRIO";
			}
		}
		
		if(mensagem != "") {
			mensagem += " não pode(m) ficar vazio(s).";
			mensagem += conversor.conferirDataVazia(txfDataDevolucao);
		} else {
			mensagem = conversor.conferirDataVazia(txfDataDevolucao);
		}
		
		if(mensagem == "") {
			return mensagem;
		} else {
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
		
	}

	public String validarCamposRenovarDevolver(String txtCodLivro, String txfDataDevolucao) {
		ConversorData conversor = new ConversorData();
		String mensagem = "";
		
		if(txtCodLivro.isEmpty()) {
			mensagem = "O campo CÓDIGO DO EXEMPLAR não pode ficar vazio.";
		}
		
		if(mensagem != "") {
			mensagem += conversor.conferirDataVazia(txfDataDevolucao);
		} else {
			mensagem = conversor.conferirDataVazia(txfDataDevolucao);
		}
		
		if(mensagem == "") {
			return mensagem;
		} else {
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
		
	}

	

	
	
}
