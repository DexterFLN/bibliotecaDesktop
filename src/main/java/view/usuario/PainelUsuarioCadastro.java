package view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.BibliotecaController;
import controller.EnderecoController;
import controller.UsuarioController;
import model.vo.Biblioteca;
import model.vo.Endereco;
import model.vo.Usuario;
import net.miginfocom.swing.MigLayout;
import util.ConversorData;
import util.Utils;
import java.awt.Label;

public class PainelUsuarioCadastro extends JPanel {
	private JLabel lblSobrenome;
	private JLabel lblNome;
	private JLabel lblIdUsuario;
	private JLabel lblTelefone;
	private JLabel lblEndereo;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblUf;
	private JLabel lblCpf;
	private Label lblBiblioteca;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCEP;
	private JTextField txtTelefone;
	private JFormattedTextField txtDataNascimento;
	private JFormattedTextField txtDdd;
	private JTextField txtCpf;
	private JComboBox cbUf;
	private JComboBox cbBiblioteca;
	private JButton btnSalvarUsurio;
	private JButton btnLimpar;
	private Usuario usuarioCadastrado = new Usuario();
	private ArrayList<Biblioteca> bibliotecas;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public PainelUsuarioCadastro() {
		setLayout(new MigLayout("", "[102.00px,grow][184.00px,grow][160.00px,grow][32.00px,grow][162.00px,grow][176.00px,grow][102.00px,grow]", "[22px,grow][29px][29px][29px][29px][29px][29px][][][53.00px][29px][29px][][][][][grow]"));

		lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 1,alignx left,growy");

		lblBiblioteca = new Label("Biblioteca");
		add(lblBiblioteca, "cell 5 1,alignx left,aligny center");

		txtNome = new JTextField();
		add(txtNome, "cell 1 2 2 1,grow");
		txtNome.setColumns(10);

		cbBiblioteca = new JComboBox();
		add(cbBiblioteca, "cell 5 2,grow");

		lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 1 3,alignx left,growy");

		lblTelefone = new JLabel("Telefone");
		add(lblTelefone, "cell 4 3,alignx left,growy");
		
		lblCpf = new JLabel("CPF");
		add(lblCpf, "cell 5 3,alignx left,growy");

		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 4 2 1,grow");
		txtSobrenome.setColumns(10);

		
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("########");
			txtTelefone = new JFormattedTextField(maskFormatter);
			add(txtTelefone, "cell 4 4,grow");
			txtTelefone.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na máscara de formatação de Telefon no painel de cadastro de usuário.");
			e.printStackTrace();
		}
		
	
		try {
			MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskFormatter);
			add(txtCpf, "cell 5 4,grow");
			txtCpf.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na máscara de formatação de CPf no painel de cadastro de usuário.");
			e.printStackTrace();
		}

		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		add(lblDataNascimento, "cell 4 5,alignx left,growy");

		JLabel lblDdd = new JLabel("DDD");
		add(lblDdd, "cell 4 1,alignx left,growy");
		

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");

			btnSalvarUsurio = new JButton("Salvar Usuário");
			add(btnSalvarUsurio, "cell 2 15,grow");

			lblCep = new JLabel("CEP");
			add(lblCep, "cell 1 10,alignx left,growy");

			lblUf = new JLabel("UF");
			add(lblUf, "cell 5 10,alignx left,growy");
			txtDataNascimento = new JFormattedTextField(maskFormatter);
			add(txtDataNascimento, "cell 4 6,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação de data no painel de cadastro de usuário.");
			e1.printStackTrace();
		}

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
			txtDdd = new JFormattedTextField(maskFormatter);
			add(txtDdd, "cell 4 2,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na máscara de formatação ddo DDD no painel de alteração de usuário.");
			e1.printStackTrace();
		}

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 5,alignx left,growy");

		txtEmail = new JTextField();
		add(txtEmail, "cell 1 6 2 1,grow");
		txtEmail.setColumns(10);
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("########");
			txtCEP = new JFormattedTextField(maskFormatter);
			add(txtCEP, "cell 1 11 2 1,grow");
			txtCEP.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na máscara de formatação de Telefon no painel de cadastro de usuário.");
			e.printStackTrace();
		}

		cbUf = new JComboBox();
		add(cbUf, "cell 5 11,grow");

		lblEndereo = new JLabel("Rua");
		add(lblEndereo, "cell 1 12,alignx left,growy");

		lblNumero = new JLabel("Numero");
		add(lblNumero, "cell 4 12,alignx left,growy");

		lblBairro = new JLabel("Bairro");
		add(lblBairro, "cell 5 12,alignx left,growy");

		lblCidade = new JLabel("Cidade");
		add(lblCidade, "cell 4 10,alignx left,growy");

		txtRua = new JTextField();
		add(txtRua, "cell 1 13 2 1,grow");
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		add(txtNumero, "cell 4 13,grow");
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		add(txtBairro, "cell 5 13,grow");
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		add(txtCidade, "cell 4 11,grow");
		txtCidade.setColumns(10);

		btnLimpar = new JButton("Limpar");
		add(btnLimpar, "cell 4 15,grow");

		this.preencherComboboxBiblioteca();
		this.preencherComboUf();
		this.addListeners();

	}

	private void addListeners() {

		btnSalvarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioController usuarioController = new UsuarioController();
				String message = usuarioController.cadastrarUsuario(txtNome.getText(), txtSobrenome.getText(), txtEmail.getText(),
						txtDdd.getText(), txtTelefone.getText(), txtDataNascimento.getText(), txtCpf.getText(),
						bibliotecas.get(cbBiblioteca.getSelectedIndex()), txtRua.getText(), txtNumero.getText(), txtBairro.getText(), cbUf, txtCidade.getText(), txtCEP.getText());
				JOptionPane.showMessageDialog(null, message, "Cadastrar Usuario", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtEmail.setText("");
				txtRua.setText("");
				txtNumero.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtCEP.setText("");
				txtTelefone.setText("");
				txtDataNascimento.setText("");
				txtDdd.setText("");
				txtCpf.setText("");
				cbUf.setSelectedIndex(0);
				cbBiblioteca.setSelectedIndex(0);;
			}
		});
	}

	private void preencherComboUf() {
		List<String> ufs = Utils.ufsBrasil();
		for (String uf : ufs) {
			cbUf.addItem(uf);
		}
	}

	private void preencherComboboxBiblioteca() {
		BibliotecaController bibliotecaController = new BibliotecaController();
		bibliotecas = bibliotecaController.consultarTodas();

		for (Biblioteca biblioteca : bibliotecas) {
			cbBiblioteca.addItem(biblioteca.getNome());
		}
	}

}
