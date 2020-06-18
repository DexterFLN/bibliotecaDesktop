package view.endereco;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Choice;

public class PainelEnderecoCadastro extends JPanel {
	private JTextField txtRua;
	private JTextField txtNumRua;
	private JTextField txtBairro;
	private Label lblCidade;
	private JTextField txtCidade;
	private Label lblUf;
	private Label lblCep;
	private JTextField txtCep;
	private JButton btnCadastrar;
	private JComboBox cbUf;

	/**
	 * Create the panel.
	 */
	public PainelEnderecoCadastro() {
		setLayout(new MigLayout("", "[][][195.00][76.00,grow][26.00]", "[][][][][][][][grow][]"));
		
		JLabel lblRua = new JLabel("Rua");
		add(lblRua, "cell 1 1");
		
		lblCidade = new Label("Cidade");
		add(lblCidade, "cell 3 1");
		
		txtRua = new JTextField();
		add(txtRua, "cell 1 2 2 1,growx");
		txtRua.setColumns(10);
		
		txtCidade = new JTextField();
		add(txtCidade, "cell 3 2,growx");
		txtCidade.setColumns(10);
		
		JLabel lblNumeroRua = new JLabel("Numero da Rua");
		add(lblNumeroRua, "cell 1 3");
		
		lblUf = new Label("UF");
		add(lblUf, "cell 3 3");
		
		txtNumRua = new JTextField();
		add(txtNumRua, "cell 1 4 2 1,growx");
		txtNumRua.setColumns(10);
		
		
		
		JLabel lblBairro = new JLabel("Bairro");
		add(lblBairro, "cell 1 5");
		
		lblCep = new Label("CEP");
		add(lblCep, "cell 3 5");
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");

			txtCep = new JFormattedTextField(mascaraCep);
			txtCep.setBounds(330, 40, 110, 28);
			txtCep.setText("");
			add(txtCep, "cell 3 6,growx");

		} catch (ParseException e) {
			System.out.println("Erro na máscara de formatação de cep no painel de cadastro de Endereço.");
			e.printStackTrace();
		}
		
		
		txtBairro = new JTextField();
		add(txtBairro, "cell 1 6 2 1,growx");
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
		
		add(cbUf, "flowx,cell 3 4,growx");
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCadastrar, "cell 2 8");
		
		

	}

}
