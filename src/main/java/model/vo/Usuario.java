package model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int id;
	private Biblioteca biblioteca;
	private String nome;
	private String sobrenome;
	private int tipo;
	private LocalDate dataNascimento;
	private String email;
	private String dddFixo;
	private String dddMovel;
	private String foneMovel;
	private String foneFixo;
	private ArrayList<Livro> livros;
	private ArrayList<Aluguel> alugueis;
	private Endereco endereco;

	public Usuario(Biblioteca biblioteca, String nome, String sobrenome, int tipo, LocalDate dataNascimento,
			String email, String dddFixo, String dddMovel, String foneMovel, String foneFixo, ArrayList<Livro> livros,
			ArrayList<Aluguel> alugueis, Endereco endereco) {
		super();
		this.biblioteca = biblioteca;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipo = tipo;
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

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	@Override
	public String toString() {
		
		return this.getNome() + " " + this.getSobrenome();
		
	}
}
