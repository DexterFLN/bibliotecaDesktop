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

public class PainelUsuarioAlterar extends JPanel {
	private JTextField txtIdUsuario;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtDDDFixo;
	private JTextField txtFoneFixo;
	private JTextField txtDDDMovel;
	private JTextField txtFoneMovel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtUsuario;

	/**
	 * Create the panel.
	 */
	public PainelUsuarioAlterar() {
setLayout(new MigLayout("", "[64.00px][135.00][grow][99.00,grow][63.00,grow]", "[22px][][][][][][][][][][][][]"));
		
		JLabel lblIdUsuario = new JLabel("Digite o id do usu\u00E1rio");
		add(lblIdUsuario, "cell 1 1,alignx left");
		
		txtUsuario = new JTextField();
		add(txtUsuario, "cell 2 1,growx");
		txtUsuario.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnPesquisar, "cell 3 1,growx");
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 2");
		
		JLabel lblDDDFixo = new JLabel("DDD Fixo:");
		add(lblDDDFixo, "cell 3 2");
		
		JLabel lblFoneFixo = new JLabel("Telefone Fixo:");
		add(lblFoneFixo, "cell 4 2");
		
		txtNome = new JTextField();
		add(txtNome, "cell 1 3 2 1,growx");
		txtNome.setColumns(10);
		
		txtDDDFixo = new JTextField();
		add(txtDDDFixo, "cell 3 3,growx,aligny top");
		txtDDDFixo.setColumns(10);
		
		txtFoneFixo = new JTextField();
		add(txtFoneFixo, "cell 4 3,growx");
		txtFoneFixo.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 1 4");
		
		JLabel lblDDDMovel = new JLabel("DDD M\u00F3vel:");
		add(lblDDDMovel, "cell 3 4");
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			JFormattedTextField txtDataNascimento = new JFormattedTextField(maskFormatter);
			txtDataNascimento.setText("");
			add(txtDataNascimento, "cell 1 7 2 1,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação de data no painel de cadastro de usuário.");
			e1.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação ddo DDD no painel de alteração de usuário.");
			e1.printStackTrace();
		}
		
		JLabel lblFoneMovel = new JLabel("Telefone M\u00F3vel:");
		add(lblFoneMovel, "cell 4 4");
		
		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 5 2 1,growx");
		txtSobrenome.setColumns(10);
		
		txtDDDMovel = new JTextField();
		add(txtDDDMovel, "cell 3 5,growx");
		txtDDDMovel.setColumns(10);
		
		txtFoneMovel = new JTextField();
		add(txtFoneMovel, "cell 4 5,growx");
		txtFoneMovel.setColumns(10);
		
		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		add(lblDtNascimento, "cell 1 6");
		
		JButton btnSalvar = new JButton("Salvar Alteracoes");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		JButton btnEndereco = new JButton("Endere\u00E7o");
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnEndereco, "cell 3 7 2 1,growx");
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 8");
		
		txtEmail = new JTextField();
		add(txtEmail, "cell 1 9 3 1,growx");
		txtEmail.setColumns(10);
		add(btnSalvar, "cell 1 12");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnExcluir, "cell 2 12,alignx center");

	}

}
