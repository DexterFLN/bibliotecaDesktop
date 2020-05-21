package model.vo;

import java.util.Date;

public class Aluguel {
	private Date dataLocacao;
	private Date devovlucaoPrevista;
	private Date devolucaoEfetiva;
	private Usuario usuario;
	private Exemplar exemplar;
	

	public Aluguel(Date dataLocacao, Date devovlucaoPrevista, Date devolucaoEfetiva, Usuario usuario,
			Exemplar exemplar) {
		super();
		this.dataLocacao = dataLocacao;
		this.devovlucaoPrevista = devovlucaoPrevista;
		this.devolucaoEfetiva = devolucaoEfetiva;
		this.usuario = usuario;
		this.exemplar = exemplar;
	}

	public Aluguel() {
		super();
	}


	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDevovlucaoPrevista() {
		return devovlucaoPrevista;
	}

	public void setDevovlucaoPrevista(Date devovlucaoPrevista) {
		this.devovlucaoPrevista = devovlucaoPrevista;
	}

	public Date getDevolucaoEfetiva() {
		return devolucaoEfetiva;
	}

	public void setDevolucaoEfetiva(Date devolucaoEfetiva) {
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
