package model.vo;


import java.util.ArrayList;


public class Exemplar {

	private int id;
	private Livro livro;
	private boolean status;
	private ArrayList<Aluguel> alugueis;

	public Exemplar(Livro livro, ArrayList<Aluguel> alugueis) {
		super();
		this.livro = livro;
		this.alugueis = alugueis;

	}

	public Exemplar() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	@Override
	public String toString() {
		
		return "\nId do Exemplar: " + this.getId() + "\nId do Livro: " + this.getLivro().getId() 
				+ "\nId da Sessão: " + this.getLivro().getSessao().getId() 
				+ "\nNome do Livro: " + this.getLivro().getNome() 
				+ "\nAutor: " + this.getLivro().getAutor()
				+ "\nEditora: " + this.getLivro().getEditora()
				+ "\nEdição: " + this.getLivro().getEdicao()
				+ "\nAno: " + this.getLivro().getAno()
				+ "\nStatus: " + ((this.isStatus() == true) ? "Alugado" : "Disponível")
				+ "\n";
		
	}
}

