package view.endereco;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.EnderecoController;
import model.vo.Endereco;
import net.miginfocom.swing.MigLayout;

public class PainelEnderecoAlterar extends JPanel {
	private JTextField txtRua;
	private JTextField txtNumRua;
	private JTextField txtBairro;
	private Label lblCidade;
	private JTextField txtCidade;
	private Label lblUf;
	private Label lblCep;
	private JTextField txtCep;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private Label lblIdEndereco;
	private JTextField txtIdEndereco;
	private JButton btnPesquisar;
	private JComboBox cbUf;

	/**
	 * Create the panel.
	 */
	public PainelEnderecoAlterar() {
		setLayout(new MigLayout("", "[][][104.00,grow][107.00][]", "[][][][][][][][][][]"));

		lblIdEndereco = new Label("Digite o id do endere\u00E7o");
		add(lblIdEndereco, "cell 1 1");

		txtIdEndereco = new JTextField();
		add(txtIdEndereco, "cell 2 1,growx");
		txtIdEndereco.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnPesquisar, "cell 3 1");

		JLabel lblRua = new JLabel("Rua");
		add(lblRua, "cell 1 2");

		lblCidade = new Label("Cidade");
		add(lblCidade, "cell 3 2");

		txtRua = new JTextField();
		add(txtRua, "cell 1 3 2 1,growx");
		txtRua.setColumns(10);

		txtCidade = new JTextField();
		add(txtCidade, "cell 3 3,growx");
		txtCidade.setColumns(10);

		JLabel lblNumeroRua = new JLabel("Numero da Rua");
		add(lblNumeroRua, "cell 1 4");

		lblUf = new Label("UF");
		add(lblUf, "cell 3 4");

		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(330, 40, 110, 28);
			txtCep.setText("");
			add(txtCep, "cell 3 7,growx");

		} catch (ParseException e) {
			System.out.println("Erro na m�scara de formata��o de cep no painel de cadastro de Endere�o.");
			e.printStackTrace();
		}

		txtNumRua = new JTextField();
		add(txtNumRua, "cell 1 5 2 1,growx");
		txtNumRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		add(lblBairro, "cell 1 6");

		lblCep = new Label("CEP");
		add(lblCep, "cell 3 6");

		txtBairro = new JTextField();
		add(txtBairro, "cell 1 7 2 1,growx");
		txtBairro.setColumns(10);

		cbUf = new JComboBox();
		cbUf.addItem("BA");
		cbUf.addItem("CE");
		cbUf.addItem("DF");
		cbUf.addItem("AC");
		cbUf.addItem("GO");
		cbUf.addItem("PR");
		cbUf.addItem("SC");
		cbUf.addItem("RS");

		add(cbUf, "cell 3 5,growx");

		btnSalvar = new JButton("Salvar Alteracoes");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnSalvar, "cell 1 9");

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				Endereco endereco = new Endereco();
				endereco.setId(Integer.parseInt(txtIdEndereco.getText()));
				mensagem = EnderecoController.excluirEndereco(endereco);
				if (mensagem.isEmpty()) {
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "Endereco excluido com sucesso!");
				} else {
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, mensagem);
				}
			}
		});
		add(btnExcluir, "cell 3 9");
	}

}
