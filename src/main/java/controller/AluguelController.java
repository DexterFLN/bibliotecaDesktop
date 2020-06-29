package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bo.AluguelBO;
import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;
import util.ConversorData;

public class AluguelController {

	public Aluguel salvarAluguel(Aluguel aluguel) {
		AluguelBO bo = new AluguelBO();
		bo.salvar(aluguel);
		return aluguel;
	}

	public ArrayList<Aluguel> consultarAluguelSeletor(AluguelSeletor aluguelSeletor) {
		AluguelBO aluguelBO = new AluguelBO();
		return aluguelBO.consultarAluguelSeletor(aluguelSeletor);
	}

	public Aluguel renovarAluguel(Aluguel aluguel) {
		AluguelBO bo = new AluguelBO();
		bo.renovar(aluguel);
		return aluguel;

	}

	public Aluguel devolverAluguel(Aluguel aluguel) {
		AluguelBO bo = new AluguelBO();
		bo.devolver(aluguel);
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

		if (txtCodLivro.isEmpty()) {
			mensagem = "O(s) campo(s): CODIGO DO LIVRO";
		}

		if (txtCodUser.isEmpty()) {
			if (mensagem == "") {
				mensagem = "O(s) campo(s): CODIGO DO USUARIO ";

			} else {
				mensagem += ", CODIGO DO USUARIO";
			}
		}

		if (mensagem != "") {
			mensagem += " nÃ£o pode(m) ficar vazio(s).";
			mensagem += conversor.conferirDataVazia(txfDataDevolucao);
		} else {
			mensagem = conversor.conferirDataVazia(txfDataDevolucao);
		}

		if (mensagem == "") {
			return mensagem;
		} else {
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}

	}

	public String validarCamposRenovarDevolver(String txtCodLivro, String txfDataDevolucao) {
		ConversorData conversor = new ConversorData();
		String mensagem = "";

		if (txtCodLivro.isEmpty()) {
			mensagem = "O campo CODIGO DO EXEMPLAR nao pode ficar vazio.";
		}

		if (mensagem != "") {
			mensagem += conversor.conferirDataVazia(txfDataDevolucao);
		} else {
			mensagem = conversor.conferirDataVazia(txfDataDevolucao);
		}

		if (mensagem == "") {
			return mensagem;
		} else {
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
	}

	public static String consultarStatus(Exemplar exemplar) {
		ExemplarController controller = new ExemplarController();
		String mensagem = "";
		if (controller.consultarStatus(exemplar) == true) {
			mensagem += "Este livro ja foi alugado.";
		}
		return mensagem;
	}

	public static boolean existeAluguelAtrasado(Usuario usuario) {
		boolean existe = AluguelBO.existeAluguelAtrasado(usuario);
		return existe;
	}

}
