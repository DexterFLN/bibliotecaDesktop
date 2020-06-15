package model.bo;

import model.dao.LivroDAO;
import model.vo.Livro;

public class LivroBO {

	public void salvar(Livro livro) {
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.salvar(livro);
		
	}

}
