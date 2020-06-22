package view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.UsuarioController;
import model.vo.Usuario;
import net.miginfocom.swing.MigLayout;
import util.ConversorData;

public class PainelUsuarioAlterar extends JPanel {
	private JTextField txtIdUsuario;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JLabel lblSobrenome;
	private JLabel lblNome;
	private JLabel lblIdUsuario;
	private JFormattedTextField txtDataNascimento;
	private JFormattedTextField txtDdd;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public PainelUsuarioAlterar(Usuario usuario) {
		setLayout(new MigLayout("", "[71px][213.00][107.00,grow][99.00,grow][63.00,grow]", "[22px,grow][29][29][29][29][29][29][29][29][71.00][][grow]"));

		lblIdUsuario = new JLabel("Id Usuario");
		add(lblIdUsuario, "cell 3 5,alignx left");

		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setColumns(10);
		add(txtIdUsuario, "cell 3 6,growx");

		lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 1");

		txtNome = new JTextField();
		add(txtNome, "cell 1 2 2 1,growx");
		txtNome.setColumns(10);

		lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 1 3");
		
		lblTelefone = new JLabel("Telefone");
		add(lblTelefone, "cell 3 3");

		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 4 2 1,growx");
		txtSobrenome.setColumns(10);
		
		txtTelefone = new JTextField();
		add(txtTelefone, "cell 3 4,growx");
		txtTelefone.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		add(lblDataNascimento, "cell 1 5");

		JLabel lblDdd = new JLabel("DDD");
		add(lblDdd, "cell 3 1");

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			txtDataNascimento = new JFormattedTextField(maskFormatter);
			add(txtDataNascimento, "cell 1 6,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação de data no painel de alteração de usuário.");
			e1.printStackTrace();
		}

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
			txtDdd = new JFormattedTextField(maskFormatter);
			add(txtDdd, "cell 3 2,growx");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação ddo DDD no painel de alteração de usuário.");
			e1.printStackTrace();
		}

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 2 5");

		txtEmail = new JTextField();
		add(txtEmail, "cell 2 6,growx");
		txtEmail.setColumns(10);

		btnSalvar = new JButton("Salvar Alteracoes");
		add(btnSalvar, "cell 2 8,alignx center");

		btnExcluir = new JButton("Excluir");
		add(btnExcluir, "cell 3 8,alignx center");

		this.preencherDadosDaTela(usuario);
		this.addListeners();

	}

	private void addListeners() {

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarioAlterado = new Usuario();
				usuarioAlterado.setId(Integer.parseInt(txtIdUsuario.getText()));
				usuarioAlterado.setNome(txtNome.getText());
				usuarioAlterado.setSobrenome(txtSobrenome.getText());
				usuarioAlterado.setEmail(txtEmail.getText());
				usuarioAlterado.setDataNascimento(ConversorData.converterTextoEmData(txtDataNascimento.getText()));
				usuarioAlterado.setDdd(txtDdd.getText());
				usuarioAlterado.setFone(txtTelefone.getText());
				
				UsuarioController usuarioController = new UsuarioController();
				String message = usuarioController.alterarUsuario(usuarioAlterado);
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

	private void preencherDadosDaTela(Usuario usuario) {
		if(usuario!= null) {
			txtIdUsuario.setText(Integer.toString(usuario.getId()));
			txtNome.setText(usuario.getNome());
			txtSobrenome.setText(usuario.getSobrenome());
			txtEmail.setText(usuario.getEmail());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			txtDdd.setText(usuario.getDdd());
			txtDataNascimento.setText(usuario.getDataNascimento().format(formatter));
			txtTelefone.setText(usuario.getFone());
			System.out.println(usuario.getDataNascimento().toString());
		}
		
	}

}
