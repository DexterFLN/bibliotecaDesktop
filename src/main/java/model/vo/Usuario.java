package model.vo;

import java.util.Date;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String email;
	private String dddFixo;
	private String dddMovel;
	private String foneMovel;
	private String foneFixo;
	private List<Livro> livros;
	private List<Aluguel> alugueis;
	

	public Usuario(String nome, String sobrenome, Date dataNascimento, String email, String dddFixo, String dddMovel,
			String foneMovel, String foneFixo, List<Livro> livros, List<Aluguel> alugueis) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.dddFixo = dddFixo;
		this.dddMovel = dddMovel;
		this.foneMovel = foneMovel;
		this.foneFixo = foneFixo;
		this.livros = livros;
		this.alugueis = alugueis;
	}



	public Usuario() {
		super();
	}



	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getDddFixo() {
		return dddFixo;
	}
	
	
	public void setDddFixo(String dddFixo) {
		this.dddFixo = dddFixo;
	}
	
	
	public String getDddMovel() {
		return dddMovel;
	}
	
	
	public void setDddMovel(String dddMovel) {
		this.dddMovel = dddMovel;
	}
	
	
	public String getFoneMovel() {
		return foneMovel;
	}
	
	
	public void setFoneMovel(String foneMovel) {
		this.foneMovel = foneMovel;
	}



	public List<Livro> getLivros() {
		return livros;
	}



	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}



	public List<Aluguel> getAlugueis() {
		return alugueis;
	}



	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}



	public String getFoneFixo() {
		return foneFixo;
	}



	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}
	
	

	
	
	
}
