package model.vo;

import java.util.Date;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String sobrenome;
	private int tipo;
	private Date dataNascimento;
	private String rua;
	private int numeroRua;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String email;
	private String dddFixo;
	private String dddMovel;
	private String foneMovel;
	private List<Livro> livros;
	private List<Aluguel> alugueis;
	
	
	
	
	
	
	public Usuario(String nome, String sobrenome, int tipo, Date dataNascimento, String rua, int numeroRua,
			String bairro, String cidade, String uf, String cep, String email, String dddFixo, String dddMovel,
			String foneMovel, List<Livro> livros, List<Aluguel> alugueis) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.numeroRua = numeroRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.email = email;
		this.dddFixo = dddFixo;
		this.dddMovel = dddMovel;
		this.foneMovel = foneMovel;
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
	
	
	public int getTipo() {
		return tipo;
	}
	
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public String getRua() {
		return rua;
	}
	
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	public int getNumeroRua() {
		return numeroRua;
	}
	
	
	public void setNumeroRua(int numeroRua) {
		this.numeroRua = numeroRua;
	}
	
	
	public String getBairro() {
		return bairro;
	}
	
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	public String getCidade() {
		return cidade;
	}
	
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getUf() {
		return uf;
	}
	
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	public String getCep() {
		return cep;
	}
	
	
	public void setCep(String cep) {
		this.cep = cep;
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
	
	

	
	
	
}
