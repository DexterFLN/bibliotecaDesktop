package model.vo;

public class Exemplar {

	private int id;
	private Livro livro;
	
	
	public Exemplar(Livro livro) {
		super();
		this.livro = livro;
	}

	public Exemplar() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
			
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}