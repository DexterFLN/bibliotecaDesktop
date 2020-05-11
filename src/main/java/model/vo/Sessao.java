package model.vo;

public class Sessao {
	private String nome;
	private Livro[] livros;
	
	
	


	public Sessao(String nome, Livro[] livros) {
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


	public Livro[] getLivros() {
		return livros;
	}


	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}





	


	
	
	
	
}
