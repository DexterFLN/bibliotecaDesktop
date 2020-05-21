package model.vo;

public class Exemplar {

	private Livro livro;

	
	public Exemplar(Livro livro) {
		super();
		this.livro = livro;
	}

	public Exemplar() {
		super();
	}

	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
		
	
	
}
