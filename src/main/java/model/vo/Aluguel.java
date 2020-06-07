package model.vo;

import java.time.LocalDate;


public class Aluguel {

	private int id;
	private Exemplar exemplar;
	private LocalDate dataLocacao;
	private LocalDate devovlucaoPrevista;
	private LocalDate devolucaoEfetiva;
	private Usuario usuario;
	
	
	public Aluguel(LocalDate dataLocacao, LocalDate devovlucaoPrevista, LocalDate devolucaoEfetiva,
			Usuario usuario, Exemplar exemplar) {
		super();
		//this.exemplar = idExemplar;
		this.dataLocacao = dataLocacao;
		this.devovlucaoPrevista = devovlucaoPrevista;
		this.devolucaoEfetiva = devolucaoEfetiva;
		this.usuario = usuario;
		this.exemplar = exemplar;
	}

	public Aluguel() {
		super();
	}


	public int getId() {
		return id;
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


	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

}
