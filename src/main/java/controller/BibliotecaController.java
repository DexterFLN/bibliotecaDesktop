package controller;

import java.util.ArrayList;

import model.bo.BibliotecaBO;
import model.vo.Biblioteca;

public class BibliotecaController {
	
	private BibliotecaBO bibliotecaBO = new BibliotecaBO();

	public ArrayList<Biblioteca> consultarTodas() {
		
		return bibliotecaBO.consultarTodas();
	}
	


}
