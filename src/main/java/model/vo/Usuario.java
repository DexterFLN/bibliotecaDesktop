package model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String email;
	private String dddFixo;
	private String dddMovel;
	private String foneMovel;
	private String foneFixo;
	private ArrayList<Livro> livros;
	private ArrayList<Aluguel> alugueis;
	private Endereco endereco;

	public Usuario(String nome, String sobrenome, LocalDate dataNascimento, String email, String dddFixo,
			String dddMovel, String foneMovel, String foneFixo, ArrayList<Livro> livros, ArrayList<Aluguel> alugueis,
			Endereco endereco) {
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
		this.endereco = endereco;
	}

	public Usuario() {
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public String getFoneFixo() {
		return foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
