package model.vo;

import java.util.ArrayList;

public class Sessao {

	private int id;
	private String nome;
	private Biblioteca biblioteca;
	private ArrayList<Livro> livros;

	public Sessao(String nome, Biblioteca biblioteca, ArrayList<Livro> livros) {
		super();
		this.nome = nome;
		this.biblioteca = biblioteca;
		this.livros = livros;
	}

	public Sessao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
}
