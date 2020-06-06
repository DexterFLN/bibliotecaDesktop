package model.seletor;

public class PesquisaGeralSeletor {
	
	private String termoPesquisa;
	private String buscarPor;
	private String ano;
	
	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;
		
		temFiltroPreenchido = !termoPesquisa.trim().isEmpty() 
				|| !buscarPor.trim().isEmpty()
				|| !ano.trim().isEmpty();
		
		return temFiltroPreenchido;
	}
	
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	public String getBuscarPor() {
		return buscarPor;
	}
	public void setBuscarPor(String buscarPor) {
		this.buscarPor = buscarPor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	

}
