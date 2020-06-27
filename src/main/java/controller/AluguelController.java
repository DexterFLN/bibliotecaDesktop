package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.JOptionPane;

import model.bo.AluguelBO;
import model.vo.Aluguel;
import model.vo.Exemplar;
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

	public Aluguel devolverAluguel(Aluguel aluguel) {
		String dataFormulario = aluguel.getDevolucaoEfetiva()
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		String dataHoje = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));

		if (aluguel.getDevolucaoEfetiva().equals(LocalDate.now())) {
			AluguelBO bo = new AluguelBO();
			bo.devolver(aluguel);
		} else {
			JOptionPane.showMessageDialog(null,
					"Para efetuar a devolução, a data informada deve ser igual a data de hoje!");
		}
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
			mensagem = "O(s) campo(s): CÓDIGO DO LIVRO";
		}

		if (txtCodUser.isEmpty()) {
			if (mensagem == "") {
				mensagem = "O(s) campo(s): CÓDIGO DO USUÁRIO ";

			} else {
				mensagem += ", CÓDIGO DO USUÁRIO";
			}
		}

		if (mensagem != "") {
			mensagem += " não pode(m) ficar vazio(s).";
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
			mensagem = "O campo CÓDIGO DO EXEMPLAR não pode ficar vazio.";
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

	public static String exemplarAlugado(Exemplar exemplar) {
		String mensagem = "";
		ExemplarController exemplarController = new ExemplarController();
		if (exemplarController.exemplarAlugado(exemplar)) {
			mensagem += "Este livro já foi alugado.";
		}
		return mensagem;
	}
	
}
