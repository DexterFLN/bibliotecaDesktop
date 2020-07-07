package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ExemplarController;
import model.dao.AluguelDAO;
import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;
import util.Utils;

public class AluguelBO {

	public void salvar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == false) {
			if (aluguel.getDevolucaoPrevista().isAfter(Utils.consultarData())) {
				AluguelDAO.salvar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao REGISTRAR o aluguel! \nA data informada deve ser superior � data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao registrar o ALUGUEL. O exemplar informado ja se encontra alugado!");
		}

	}

	public void renovar(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if (aluguel.getDevolucaoPrevista().isAfter(Utils.consultarData())) {
				AluguelDAO.renovar(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao RENOVAR o aluguel! \nA data informada deve ser superior � data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao RENOVAR o aluguel. O exemplar informado n�o se encontra alugado!");
		}
	}

	public void devolver(Aluguel aluguel) {
		if (consultarStatus(aluguel.getExemplar()) == true) {
			if (aluguel.getDevolucaoEfetiva().equals(Utils.consultarData())) {
				AluguelDAO.devolver(aluguel);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao DEVOLVER o aluguel! \nA data informada deve ser IGUAL � data atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"ERRO ao DEVOLVER o ALUGUEL. O exemplar informado n�o se encontra alugado!");
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
			JOptionPane.showMessageDialog(null, "N�o � poss�vel alugar o exemplar ao usu�rio! "
					+ "\nO usuario informado possui outro(s) exemplar(es) alugados que n�o foram devolvidos dentro da Data Prevista! "
					+ "\nO usuario deve regularizar sua situacao antes de efetuar novo aluguel.");
		}
		return existe;
	}

}
