package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ExemplarDAO;
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

	public static boolean excluir(Livro livro) {
		boolean excluiu = ExemplarDAO.excluir(livro);
		return excluiu;
	}


}
