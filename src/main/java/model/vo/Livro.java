package model.vo;

import java.util.ArrayList;

public class Livro {

	private int id;
	private String nome;
	private String autor;
	private String editora;
	private int edicao;
	private int ano;
	private Sessao sessao;


	public Livro(String nome, String autor, String editora, int edicao, int ano, boolean alugado,
			Sessao sessao) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.sessao = sessao;
	}

	public Livro() {
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(ArrayList<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
}
