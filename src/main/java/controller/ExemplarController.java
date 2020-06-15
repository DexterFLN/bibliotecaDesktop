package controller;

import model.bo.ExemplarBO;
import model.vo.Exemplar;
import model.vo.Livro;

public class ExemplarController {
	
	private Exemplar exemplar;
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
        ExemplarBO bo = new ExemplarBO();
        bo.salvar(livro, quantidade, status);
    
    }
	
}
