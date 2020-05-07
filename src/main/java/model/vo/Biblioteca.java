package model.vo;

public class Biblioteca {
	private String nome;

	public Biblioteca(String nome) {
		super();
		this.nome = nome;
	}
	
	public Biblioteca() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}