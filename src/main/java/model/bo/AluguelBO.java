package model.bo;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ExemplarController;
import model.dao.AluguelDAO;
import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Exemplar;

public class AluguelBO {
	
	public void salvar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == false) {
			if(aluguel.getDevolucaoPrevista().isAfter(LocalDate.now())) {
				AluguelDAO aluguelDAO = new AluguelDAO();
				aluguelDAO.salvar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null, 
						"Erro ao REGISTRAR o aluguel! \nA data informada deve ser superior ‡ data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao registrar o ALUGUEL. O exemplar informado j√° se encontra alugado!");
		}
		
		
		
	}

	public void renovar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if(aluguel.getDevolucaoPrevista().isAfter(LocalDate.now())) {
				AluguelDAO aluguelDAO = new AluguelDAO();
				aluguelDAO.renovar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null, 
						"Erro ao RENOVAR o aluguel! \nA data informada deve ser superior ‡ data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao RENOVAR o aluguel. O exemplar informado n„o se encontra alugado!");
		}
	}


	public void devolver(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if(aluguel.getDevolucaoPrevista().equals(LocalDate.now())) {
				AluguelDAO aluguelDAO = new AluguelDAO();
				aluguelDAO.devolver(aluguel);
			} else {
				JOptionPane.showMessageDialog(null, 
						"Erro ao DEVOLVER o aluguel! \nA data informada deve ser IGUAL ‡ data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao DEVOLVER o ALUGUEL. O exemplar informado n„o se encontra alugado!");
		}
	}
	
	public Aluguel consultarAluguelAtual(int idExemplar) {
		Aluguel aluguel = new Aluguel();
		AluguelDAO aluguelDAO = new AluguelDAO();
		aluguel = aluguelDAO.consultarAluguelAtual(idExemplar);
		return aluguel;
	}
	
	public boolean consultarStatus(Exemplar exemplar) {
		ExemplarController exemplarController = new ExemplarController();
		boolean status = exemplarController.consultarStatus(exemplar);
		return status;
	}

	public ArrayList<Aluguel> consultarAluguelSeletor(AluguelSeletor aluguelSeletor) {
		AluguelDAO aluguelDAO = new AluguelDAO();
		return aluguelDAO.consultarAluguelSeletor(aluguelSeletor) ;
	}

}
