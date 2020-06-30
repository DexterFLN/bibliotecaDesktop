package model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private int id;
	private Biblioteca biblioteca;
	private String nome;
	private String sobrenome;
	private int tipo;
	private LocalDate dataNascimento;
	private String email;
	private String ddd;
	private String fone;
	private String cpf;
	private ArrayList<Livro> livros;
	private ArrayList<Aluguel> alugueis;
	private Endereco endereco;

	public Usuario(int id, Biblioteca biblioteca, String nome, String sobrenome, int tipo, LocalDate dataNascimento,
			String email, String ddd, String fone, String cpf, ArrayList<Livro> livros, ArrayList<Aluguel> alugueis,
			Endereco endereco) {
		super();
		this.id = id;
		this.biblioteca = biblioteca;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.ddd = ddd;
		this.fone = fone;
		this.cpf = cpf;
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

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Livro> getLivros() {
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
