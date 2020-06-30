package model.seletor;

import util.Constants;

public class UsuarioSeletor {

	private String buscarPor;
	private String termoPesquisa;

	public boolean temFiltro() {
		boolean temFiltroPreenchido = false;

		temFiltroPreenchido = (termoPesquisa != null && !termoPesquisa.trim().isEmpty()) || !buscarPor.trim().isEmpty();
		return temFiltroPreenchido;
	}

	public UsuarioSeletor validarFitros(UsuarioSeletor seletor) {

		seletor.setTermoPesquisa(termoPesquisa = seletor.getTermoPesquisa().equals(Constants.PLACECHOLDEDRPESQUISA) ? ""
				: seletor.getTermoPesquisa());

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
