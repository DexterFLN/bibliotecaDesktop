package view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

public class PainelUsuarioCadastro extends JPanel {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PainelUsuarioCadastro() {
		setLayout(new MigLayout("", "[64.00px][135.00,grow][][99.00][63.00,grow]", "[22px][][][][][][][][][][]"));

		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 1");

		txtNome = new JTextField();
		add(txtNome, "cell 1 2 4 1,growx");
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 1 3");

		JLabel lblTelefone = new JLabel("Telefone Fixo");
		add(lblTelefone, "cell 4 3");

		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 4 3 1,growx");
		txtSobrenome.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("########");
			JFormattedTextField txtTelefoneFixo = new JFormattedTextField(maskFormatter);
			add(txtTelefoneFixo, "cell 4 4,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação do telefone fixo no painel de cadastro de usuário.");
			e1.printStackTrace();
		}

		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		add(lblDtNascimento, "cell 1 5");

		JLabel lblDdd = new JLabel("DDD Fixo");
		add(lblDdd, "cell 4 5");

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			JFormattedTextField txtDataNascimento = new JFormattedTextField(maskFormatter);
			add(txtDataNascimento, "cell 1 6,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação de data no painel de cadastro de usuário.");
			e1.printStackTrace();
		}

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
			JFormattedTextField txtDddFixo = new JFormattedTextField(maskFormatter);
			add(txtDddFixo, "cell 4 6,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação do DDD Fixo no painel de alteração de usuário.");
			e1.printStackTrace();
		}

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 7");

		JLabel lblTelefoneMovel = new JLabel("Telefone Móvel");
		add(lblTelefoneMovel, "cell 4 7");

		txtEmail = new JTextField();
		add(txtEmail, "cell 1 8 3 1,growx");
		txtEmail.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("#########");
			JFormattedTextField txtTelefoneMovel = new JFormattedTextField(maskFormatter);
			add(txtTelefoneMovel, "cell 4 8,growx");
		} catch (ParseException ex) {
			System.out.println("Erro na máscara de formatação do telefone móvel no painel de alteração de usuário.");
			ex.printStackTrace();
		}

		JLabel lblDddMovel = new JLabel("DDD Móvel");
		add(lblDddMovel, "cell 4 9");

		JButton btnEndereco = new JButton("Endereço");
		add(btnEndereco, "flowx,cell 1 10");

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
		JFormattedTextField txtDddMovel = new JFormattedTextField(maskFormatter);
		add(txtDddMovel, "cell 4 10,growx");
		} catch (ParseException ex) {
			System.out.println("Erro na máscara de formatação do DDD móvel no painel de alteração de usuário.");
			ex.printStackTrace();
		}

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCadastrar, "cell 1 10");

	}

}
