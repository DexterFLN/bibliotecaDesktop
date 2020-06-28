package controller;

import java.util.ArrayList;

import javax.swing.JFormattedTextField;

import model.bo.ExemplarBO;
import model.dao.SessaoDAO;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;
import model.vo.Sessao;

public class ExemplarController {

	private Exemplar exemplar;
	private ExemplarBO exemplarBO = new ExemplarBO();

	public void salvarExemplar(Livro livro, String quantidade, boolean status) {

		exemplarBO.salvar(livro, quantidade, status);

	}

	public ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		return exemplarBO.consultarExemplarLivroSeletor(livroSeletor);
		// TODO retornar todos os livros selecionando apenas o ano

	}

	public Exemplar consultarExemplar(int id) {
		return exemplarBO.consultarExemplar(id);
	}

	public boolean consultarStatus(Exemplar exemplarAConsultar) {
		ExemplarBO bo = new ExemplarBO();
		boolean status = bo.consultarStatus(exemplarAConsultar);
		return status;
	}

	public static String validarQuantidade(JFormattedTextField quantidadeExemplares, int idLivro) {
		String mensagem = "";
		int quantidade = Integer.parseInt(quantidadeExemplares.getText());
		boolean maiorQueQuantidade = ExemplarBO.alteracaoValida(quantidade, idLivro);

		if (maiorQueQuantidade == false) {
			mensagem += "A quantidade informada tem que ser igual ou maior do que a quantidade atual.";
		}

		return mensagem;
	}

	public static ArrayList<Exemplar> consultarQuantidade(int idLivro) {
		return ExemplarBO.consultarQuantidade(idLivro);
	}

	/*
	 * public static boolean exemplarAlugado(Exemplar exemplar) { ExemplarBO
	 * exemplarBO = new ExemplarBO(); return exemplarBO.exemplarAlugado(exemplar); }
	 */

}
