package model.vo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private int id;
	private String nome;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Sessao> sessoes;

	public Biblioteca(int id,String nome, ArrayList<Usuario> usuarios, ArrayList<Sessao> sessoes) {
		super();
		this.id = id;
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

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	
	
	

	
}