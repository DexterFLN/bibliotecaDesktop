package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ExemplarController;
import controller.LivroController;
import model.dao.ExemplarDAO;
import model.dao.LivroDAO;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarBO {
    
	public void salvar(Livro livro, String quantidade, boolean status) {
		ExemplarDAO.salvar(livro, quantidade, status);
		
	}

	public ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		return ExemplarDAO.consultarExemplarLivroSeletor(livroSeletor) ;
	}

	public Exemplar consultarExemplar(int id) {
		return ExemplarDAO.consultarExemplar(id);
	}

	public boolean consultarStatus(Exemplar exemplarAConsultar) {
		return ExemplarDAO.consultarStatus(exemplarAConsultar);
	}

	public static boolean alteracaoValida(int quantidade, int idLivro) {
		return quantidade >= ExemplarDAO.pesquisarQuantidade(idLivro);
	}

	public static ArrayList<Exemplar> consultarQuantidade(int idLivro) {
		return ExemplarDAO.construirExemplaresDoLivro(idLivro);
	}

	public static void excluir(Livro livro) {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o livro " + livro.getNome() 
		+ " e seu(s) " + ExemplarController.consultarQuantidade(livro.getId()).size() + " exemplar(es)?", "Excluir livro", JOptionPane.YES_NO_OPTION); 
	
	if (resposta == JOptionPane.YES_OPTION) {
		int alugado = 0;
		
		ArrayList<Exemplar> exemplares = ExemplarController.consultarQuantidade(livro.getId());
		for (Exemplar exemplar : exemplares) {
			if (ExemplarController.consultarStatus(exemplar) == true) {
				alugado += 1;
			}
		}
		
		if (alugado > 0) {
			JOptionPane.showMessageDialog(null, "Impossivel excluir livro enquanto houver exemplares alugados!");
		} else {
			if (ExemplarDAO.excluir(livro) == true) {
				if (LivroController.excluir(livro) == true) {
					JOptionPane.showMessageDialog(null, "Livro e exemplares excluidos com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir o livro!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao excluir os exemplares!");
			}
		}
	}
	}

	public static boolean existeIdDeExemplar(Exemplar exemplar) {
		boolean existe = ExemplarDAO.existeIdDeExemplar(exemplar);
		return existe;
	}


}
