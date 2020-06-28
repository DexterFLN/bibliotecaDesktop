package controller;

import java.util.ArrayList;

import model.bo.ExemplarBO;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarController {
	
	private Exemplar exemplar;
	private ExemplarBO exemplarBO = new ExemplarBO();

	public void salvarExemplar(Livro livro, String quantidade, boolean status) {

		exemplarBO.salvar(livro, quantidade, status);
    
    }
	
	public ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		return exemplarBO.consultarExemplarLivroSeletor(livroSeletor);
		//TODO retornar todos os livros selecionando apenas o ano
		
	}
	
	public Exemplar consultarExemplar(int id) {
		return exemplarBO.consultarExemplar(id);
    }

	public boolean consultarStatus(Exemplar exemplarAConsultar) {
		ExemplarBO bo = new ExemplarBO();
		boolean status = bo.consultarStatus(exemplarAConsultar);
		return status;
	}
	
	public static boolean exemplarAlugado(Exemplar exemplar) {
		ExemplarBO exemplarBO = new ExemplarBO();
		return exemplarBO.exemplarAlugado(exemplar);
	}
	
}
