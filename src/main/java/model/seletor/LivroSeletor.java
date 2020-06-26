package model.seletor;
import util.Constants;

public class LivroSeletor {
	
	private String termoPesquisa;
	private String buscarPor;
	private String ano;
	
	
	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;
		//TODO melhorar essas verificacoes
		temFiltroPreenchido = (termoPesquisa != null && !termoPesquisa.trim().isEmpty())
				|| !buscarPor.trim().isEmpty()
				|| !ano.trim().isEmpty();
		
		return temFiltroPreenchido;
	}
	
	public LivroSeletor validarFitros(LivroSeletor seletor){
		//TODO melhorar essas verificacoes
		seletor.setAno(
				ano = seletor.getAno().equals(Constants.CMBANO) ? "" : seletor.getAno());
		seletor.setTermoPesquisa(
				termoPesquisa = seletor.getTermoPesquisa().equals(Constants.PLACECHOLDEDRPESQUISA) ? "" : seletor.getTermoPesquisa());
				
		return seletor;
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
