package model.bo;

import java.util.ArrayList;

import model.dao.BibliotecaDAO;
import model.vo.Biblioteca;

public class BibliotecaBO {
	
	private BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
	
	public ArrayList<Biblioteca> consultarTodas() {
		return bibliotecaDAO.consultarTodas(100);
	}

}
