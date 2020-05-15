package model.vo;

import java.util.List;

public class Biblioteca {
	private String nome;
	private List<Usuario> usuarios;
	private List<Sessao> sessoes;
	
	
	

	public Biblioteca(String nome, List<Usuario> usuarios, List<Sessao> sessoes) {
		super();
		this.nome = nome;
		this.usuarios = usuarios;
		this.sessoes = sessoes;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	
	
	

	
}