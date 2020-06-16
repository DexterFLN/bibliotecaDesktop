package controller;

import java.util.ArrayList;

import model.bo.ExemplarBO;
import model.bo.LivroBO;
import model.seletor.ExemplarSeletor;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarController {
	
	private Exemplar exemplar;
	private ExemplarBO exemplarBO = new ExemplarBO();
/*
	public Livro criarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String cbAno, int numSessao) {
		Livro livro = new Livro ();
		livro.setNome(txtTitulo);
		livro.setAutor(txtAutor);
		livro.setEditora(txtEditora);
		livro.setEdicao(Integer.parseInt(txtEdicao));
		livro.setAno(Integer.parseInt(cbAno));
		Sessao sessao = new Sessao();
		sessao.setId(numSessao);
		livro.setSessao(sessao);

        return livro;
    }
*/	
	public void salvarExemplar(Livro livro, String quantidade, boolean status) {
        
		exemplarBO.salvar(livro, quantidade, status);
    
    }
	public ArrayList<Exemplar> consultarExemplarLivroSeletor(LivroSeletor livroSeletor) {
		return exemplarBO.consultarExemplarLivroSeletor(livroSeletor);
		//TODO retornar todos os livros selecionando apenas o ano
		
	}
	
}
