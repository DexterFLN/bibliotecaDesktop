package model.bo;

import java.util.ArrayList;

import model.dao.ExemplarDAO;
import model.seletor.ExemplarSeletor;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarBO {
    private ExemplarDAO exemplarDAO = new ExemplarDAO();
    
	public void salvar(Livro livro, String quantidade, boolean status) {
		ExemplarDAO exemplarDAO = new ExemplarDAO();
		exemplarDAO.salvar(livro, quantidade, status);
		
	}

	public ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		return exemplarDAO.consultarExemplarLivroSeletor(livroSeletor) ;
	}

	public Exemplar consultarExemplar(int id) {
		ExemplarDAO exemplarDAO = new ExemplarDAO();
		return exemplarDAO.consultarExemplar(id);
	}

	public boolean consultarStatus(Exemplar exemplarAConsultar) {
		ExemplarDAO dao = new ExemplarDAO();
		return dao.consultarStatus(exemplarAConsultar);
	}


}
