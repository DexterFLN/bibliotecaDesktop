package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ExemplarController;
import model.dao.LivroDAO;
import model.seletor.LivroSeletor;
import model.vo.Livro;

public class LivroBO {

	LivroDAO livroDAO = new LivroDAO();

	public void salvar(Livro livro) {
		livroDAO.salvar(livro);
	}

	public ArrayList<Livro> consultarLivrosPorSeletor(LivroSeletor seletor) {
		return livroDAO.consultarLivrosPorSeletor(seletor);
	}

	public Livro consultarLivroPorId(int id) {
		return livroDAO.consultarLivroPorId(id);
	}

	public Livro consultarLivroPorIdParaExemplares(int id) {
		return livroDAO.consultarLivroPorIdParaExemplares(id);
	}

	public static boolean excluir(Livro livro) {
		boolean excluiu = LivroDAO.excluir(livro);
		return excluiu;
	}

	public static boolean alterar(Livro livro, Livro dadosNovos) {
		boolean alterou = false;
		int resposta = JOptionPane.showConfirmDialog(null,
				"Deseja mesmo alterar o livro " + livro.getNome() + " e seu(s) "
						+ ExemplarController.consultarQuantidade(livro.getId()).size() + " exemplar(es)?",
				"Alterar livro", JOptionPane.YES_NO_OPTION);

		if (resposta == JOptionPane.YES_OPTION) {
			if (LivroDAO.alterar(livro, dadosNovos) == true) {
				JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
				alterou = true;
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao alterar o livro!");
			}
		}
		return alterou;
	}

	public static ArrayList<Integer> consultarAnos() {
		return LivroDAO.consultarAnosExistentes();
	}
}
