package model.vo;

import java.util.Date;

public class Livro {
	private String nome;
	private String autor;
	private String editora;
	private int edicao;
	private int ano;
	private boolean alugado;
	private Sessao sessao;
	
	
	public Livro(String nome, String autor, String editora, int edicao, int ano, boolean alugado, Sessao sessao) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.alugado = alugado;
		this.sessao = sessao;
		
	}
	

	public Livro() {
		super();
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

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	
	
}
