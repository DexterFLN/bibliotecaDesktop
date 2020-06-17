package model.bo;

import model.dao.AluguelDAO;
import model.vo.Aluguel;

public class AluguelBO {

	AluguelDAO aluguelDAO = new AluguelDAO();
	
	public void salvar(Aluguel aluguel) {
		aluguelDAO.salvar(aluguel);
		
	}

	public void renovar(Aluguel aluguel) {
		aluguelDAO.renovar(aluguel);
		
	}

	public Aluguel consultarAluguelAtual(int idExemplar) {
		Aluguel aluguel = new Aluguel();
		aluguel = aluguelDAO.consultarAluguelAtual(idExemplar);
		return aluguel;
	}

}
