package model.bo;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ExemplarController;
import model.dao.AluguelDAO;
import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;

public class AluguelBO {

	public void salvar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == false) {
			if (aluguel.getDevolucaoPrevista().isAfter(LocalDate.now())) {
				AluguelDAO.salvar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao REGISTRAR o aluguel! \nA data informada deve ser superior à data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao registrar o ALUGUEL. O exemplar informado ja se encontra alugado!");
		}

	}

	public void renovar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if (aluguel.getDevolucaoPrevista().isAfter(LocalDate.now())) {
				AluguelDAO.renovar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao RENOVAR o aluguel! \nA data informada deve ser superior à data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao RENOVAR o aluguel. O exemplar informado não se encontra alugado!");
		}
	}

	public void devolver(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if (aluguel.getDevolucaoEfetiva().equals(LocalDate.now())) {
				AluguelDAO.devolver(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao DEVOLVER o aluguel! \nA data informada deve ser IGUAL à data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao DEVOLVER o ALUGUEL. O exemplar informado não se encontra alugado!");
		}
	}

	public Aluguel consultarAluguelAtual(int idExemplar) {
		Aluguel aluguel = new Aluguel();
		aluguel = AluguelDAO.consultarAluguelAtual(idExemplar);
		return aluguel;
	}

	public boolean consultarStatus(Exemplar exemplar) {
		ExemplarController exemplarController = new ExemplarController();
		boolean status = exemplarController.consultarStatus(exemplar);
		return status;
	}

	public ArrayList<Aluguel> consultarAluguelSeletor(AluguelSeletor aluguelSeletor) {
		return AluguelDAO.consultarAluguelSeletor(aluguelSeletor);
	}

	public static boolean existeAluguelAtrasado(Usuario usuario) {
		boolean existe = AluguelDAO.existeAluguelAtrasado(usuario);
		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Não é possível alugar o exemplar ao usuário! "
					+ "\nO usuario informado possui outro(s) exemplar(es) alugados que não foram devolvidos dentro da Data Prevista! "
					+ "\nO usuario deve regularizar sua situacao antes de efetuar novo aluguel.");
		}
		return existe;
	}

}
