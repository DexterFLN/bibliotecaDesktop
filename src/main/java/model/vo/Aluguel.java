package model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {

	private int id;
	private LocalDate dataLocacao;
	private LocalDate devovlucaoPrevista;
	private LocalDate devolucaoEfetiva;
	private Usuario usuario;
	private ArrayList<Livro> livros;

	public Aluguel(LocalDate dataLocacao, LocalDate devolucaoPrevista, LocalDate devolucaoEfetiva,
			Usuario usuario, ArrayList<Livro> livros) {
		super();
		this.dataLocacao = dataLocacao;
		this.devovlucaoPrevista = devolucaoPrevista;
		this.devolucaoEfetiva = devolucaoEfetiva;
		this.usuario = usuario;
		this.livros = livros;
	}

	public Aluguel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDate getDevovlucaoPrevista() {
		return devovlucaoPrevista;
	}

	public void setDevovlucaoPrevista(LocalDate devovlucaoPrevista) {
		this.devovlucaoPrevista = devovlucaoPrevista;
	}

	public LocalDate getDevolucaoEfetiva() {
		return devolucaoEfetiva;
	}

	public void setDevolucaoEfetiva(LocalDate devolucaoEfetiva) {
		this.devolucaoEfetiva = devolucaoEfetiva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

}
