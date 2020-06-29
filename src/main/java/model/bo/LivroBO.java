package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ExemplarDAO;
import model.dao.LivroDAO;
import model.seletor.LivroSeletor;
import model.vo.Livro;

public class LivroBO {
	
	LivroDAO livroDAO = new LivroDAO();

	public void salvar(Livro livro) {
		livroDAO.salvar(livro);
	}

	public ArrayList<Livro> consultarLivrosPorSeletor(LivroSeletor seletor) {
		return livroDAO.consultarLivrosPorSeletor(seletor) ;
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
}
