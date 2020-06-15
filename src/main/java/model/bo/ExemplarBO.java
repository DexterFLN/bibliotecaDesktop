package model.bo;

import model.dao.ExemplarDAO;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarBO {

	public void salvar(Livro livro, String quantidade, boolean status) {
		ExemplarDAO exemplarDAO = new ExemplarDAO();
		exemplarDAO.salvar(livro, quantidade, status);
		
	}

}
