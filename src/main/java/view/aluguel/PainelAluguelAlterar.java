package view.aluguel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import controller.AluguelController;
import controller.ExemplarController;
import model.dao.AluguelDAO;
import model.dao.ExemplarDAO;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;
import net.miginfocom.swing.MigLayout;
import util.ConversorData;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PainelAluguelAlterar extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtCodigoExemplar;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JFormattedTextField txfDataDevolucao;
	private JFormattedTextField txfDataNascimento;

	/**
	 * Create the panel.
	 */
	public PainelAluguelAlterar() {
		setLayout(new MigLayout("",
				"[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]",
				"[45.00px][29.00][35.00px][27.00][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));

		JLabel lblExcluir = new JLabel("Digite o Codigo do Exemplar");
		add(lblExcluir, "cell 1 1,alignx center,aligny center");

		txtCodigoExemplar = new JTextField();
		add(txtCodigoExemplar, "cell 2 1,grow");
		txtCodigoExemplar.setColumns(10);

		JButton btnPesquisarAluguel = new JButton("Pesquisar");
		btnPesquisarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemplarController exemplarController = new ExemplarController();
				Exemplar exemplar = new Exemplar();
				int idExemplar = Integer.valueOf(txtCodigoExemplar.getText());
				exemplar = exemplarController.consultarExemplar(idExemplar);

				if (exemplar.isStatus() == true) {
					AluguelController aluguelController = new AluguelController();
					Aluguel aluguel = new Aluguel();
					aluguel = aluguelController.consultarAluguelAtual(idExemplar);
					txtTitulo.setText(aluguel.getExemplar().getLivro().getNome().toUpperCase());
					LocalDate dataOriginal = aluguel.getDevolucaoPrevista();
					String dataFormatada = dataOriginal.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
					txfDataDevolucao.setText(dataFormatada);
					dataOriginal = aluguel.getUsuario().getDataNascimento();
					dataFormatada = dataOriginal.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
					txfDataNascimento.setText(dataFormatada);
					txtNome.setText(aluguel.getUsuario().getNome().toUpperCase());
					txtSobrenome.setText(aluguel.getUsuario().getSobrenome().toUpperCase());
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao renovar/devolver! O exemplar informado nao se encontra alugado!");
				}
			}
		});
		add(btnPesquisarAluguel, "cell 3 1,grow");

		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 2,alignx left,aligny center");

		txtTitulo = new JTextField();
		add(txtTitulo, "cell 1 3 2 1,grow");
		txtTitulo.setEditable(false);
		txtTitulo.setEnabled(true);
		txtTitulo.setColumns(10);

		JLabel lblAutor = new JLabel("Data Devolucao");
		add(lblAutor, "cell 3 2,alignx left,aligny center");

		try {

			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			txfDataDevolucao = new JFormattedTextField(maskFormatter);
			add(txfDataDevolucao, "cell 3 3,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao de data no painel de cadastro de usuario.");
			e1.printStackTrace();
		}

		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 5");

		JLabel lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 2 5,alignx left");

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		add(lblDataDeNascimento, "cell 3 5");

		txtNome = new JTextField();
		add(txtNome, "cell 1 6,grow");
		txtNome.setEditable(false);
		txtNome.setEnabled(true);
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 2 6,grow");
		txtSobrenome.setEditable(false);
		txtSobrenome.setEnabled(true);
		txtSobrenome.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			txfDataNascimento = new JFormattedTextField(maskFormatter);
			txfDataNascimento.setEditable(false);
			txfDataNascimento.setEnabled(true);
			add(txfDataNascimento, "cell 3 6,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao de data no painel de cadastro de usuario.");
			e1.printStackTrace();
		}

		JButton btnRenovar = new JButton("Renovar");
		btnRenovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelController controller = new AluguelController();
				Aluguel aluguel = new Aluguel();

				String mensagem = "";
				mensagem += controller.validarCamposRenovarDevolver(txtCodigoExemplar.getText(),
						txfDataDevolucao.getText());
				if (mensagem.isEmpty()) {
					int idExemplar = Integer.valueOf(txtCodigoExemplar.getText());
					aluguel = controller.consultarAluguelAtual(idExemplar);
					aluguel.setDevolucaoPrevista(ConversorData.converterTextoEmData(txfDataDevolucao.getText()));

					try {
						controller.renovarAluguel(aluguel);
					} catch (Exception ex) {
						System.out.println("Erro ao renovar o aluguel: " + ex.getMessage());
					}
				}
			}
		});
		btnRenovar.setBackground(new Color(173, 255, 47));
		add(btnRenovar, "cell 1 10,grow");

		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelController controller = new AluguelController();
				Aluguel aluguel = new Aluguel();

				String mensagem = "";
				mensagem += controller.validarCamposRenovarDevolver(txtCodigoExemplar.getText(),
						txfDataDevolucao.getText());
				if (mensagem.isEmpty()) {
					int idExemplar = Integer.valueOf(txtCodigoExemplar.getText());
					aluguel = controller.consultarAluguelAtual(idExemplar);
					aluguel.setDevolucaoEfetiva(ConversorData.converterTextoEmData(txfDataDevolucao.getText()));

					try {
						controller.devolverAluguel(aluguel);
					} catch (Exception ex) {
						System.out.println("Erro ao renovar o aluguel: " + ex.getMessage());
					}
				}
			}
		});
		btnDevolver.setBackground(new Color(229, 13, 13, 90));
		add(btnDevolver, "cell 3 10,grow");

		this.addListeners();

	}

	private void addListeners() {

	}
}
