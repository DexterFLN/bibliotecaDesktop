package model.vo;

import java.time.LocalDate;

public class Aluguel {

	private int id;
	private Exemplar exemplar;
	private LocalDate dataLocacao;
	private LocalDate devovlucaoPrevista;
	private LocalDate devolucaoEfetiva;
	private Usuario usuario;

	public Aluguel(Exemplar idExemplar, LocalDate dataLocacao, LocalDate devolucaoPrevista, LocalDate devolucaoEfetiva,
			Usuario usuario) {
		super();
		this.exemplar = idExemplar;
		this.dataLocacao = dataLocacao;
		this.devovlucaoPrevista = devolucaoPrevista;
		this.devolucaoEfetiva = devolucaoEfetiva;
		this.usuario = usuario;
	}

	public Aluguel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setExemplar(Exemplar idExemplar) {
		this.exemplar = idExemplar;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setId(int id) {
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

}
