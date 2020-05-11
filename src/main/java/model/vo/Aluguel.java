package model.vo;

import java.util.Date;

public class Aluguel {
	private Date dataLocacao;
	private Date devovlucaoPrevista;
	private Date devolucaoEfetiva;
	private Usuario usuario;
	private Livro[] livros;
	
	
	


	public Aluguel(Date dataLocacao, Date devovlucaoPrevista, Date devolucaoEfetiva, Usuario usuario, Livro[] livros) {
		super();
		this.dataLocacao = dataLocacao;
		this.devovlucaoPrevista = devovlucaoPrevista;
		this.devolucaoEfetiva = devolucaoEfetiva;
		this.usuario = usuario;
		this.livros = livros;
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


	public Livro[] getLivros() {
		return livros;
	}


	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}


	
}
