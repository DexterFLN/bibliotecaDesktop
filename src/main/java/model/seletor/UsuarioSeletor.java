package model.seletor;

import util.Constants;

public class UsuarioSeletor {
	
	private String buscarPor;
	private String termoPesquisa;
	
	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;
		//TODO melhorar essas verificacoes
		temFiltroPreenchido = (termoPesquisa != null && !termoPesquisa.isBlank())
				|| !buscarPor.isBlank();		
		return temFiltroPreenchido;
	}
	
	public UsuarioSeletor validarFitros(UsuarioSeletor seletor){
		//TODO melhorar essas verificacoes
		seletor.setTermoPesquisa(
				termoPesquisa = seletor.getTermoPesquisa().equals(Constants.PLACECHOLDEDRPESQUISA) ? "" : seletor.getTermoPesquisa());
				
		return seletor;
	}	
	
	
	public String getBuscarPor() {
		return buscarPor;
	}
	public void setBuscarPor(String buscarPor) {
		this.buscarPor = buscarPor;
	}
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	
}
