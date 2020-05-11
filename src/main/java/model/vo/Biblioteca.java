package model.vo;

public class Biblioteca {
	private String nome;
	private Usuario[] usuarios;
	private Sessao[] sessoes;
	
	
	public Biblioteca(String nome, Usuario[] usuarios, Sessao[] sessoes) {
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

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public Sessao[] getSessoes() {
		return sessoes;
	}

	public void setSessoes(Sessao[] sessoes) {
		this.sessoes = sessoes;
	}
	
	

	
}