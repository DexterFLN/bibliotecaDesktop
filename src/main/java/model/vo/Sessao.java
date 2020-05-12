package model.vo;

import java.util.List;

public class Sessao {
	private String nome;
	private List<Livro> livros;
	
	
	


	
	


	public Sessao(String nome, List<Livro> livros) {
		super();
		this.nome = nome;
		this.livros = livros;
	}



	public Sessao() {
		super();
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<Livro> getLivros() {
		return livros;
	}



	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	





	


	
	
	
	
}
