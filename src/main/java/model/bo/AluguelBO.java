package model.bo;

import model.dao.AluguelDAO;
import model.vo.Aluguel;

public class AluguelBO {

	
	
	public void salvar(Aluguel aluguel) {
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.salvar(aluguel);
		
	}

	public void renovar(Aluguel aluguel) {
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.renovar(aluguel);
		
	}

	public void devolver(Aluguel aluguel) {
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.devolver(aluguel);
		
	}
	
	public Aluguel consultarAluguelAtual(int idExemplar) {
		Aluguel aluguel = new Aluguel();
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguel = aluguelDAO.consultarAluguelAtual(idExemplar);
		return aluguel;
	}

	

}
