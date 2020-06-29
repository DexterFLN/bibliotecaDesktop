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

public class PainelUsuarioAlterar extends JPanel {
	private JLabel lblSobrenome;
	private JLabel lblNome;
	private JLabel lblIdUsuario;
	private JLabel lblTelefone;
	private JLabel lblBiblioteca;
	private JLabel lblEndereo;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblUf;
	private JTextField txtIdUsuario;
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
	private JComboBox cbBiblioteca;
	private ArrayList<Biblioteca> bibliotecas;
	private JComboBox cbUf;
	private JButton btnSalvarEndereco;
	private JButton btnExcluirUsuario;
	private Usuario usuarioAlterado = new Usuario();
	private JButton btnSalvarUsurio;
	private JButton btnLimparAlteracoes;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public PainelUsuarioAlterar(Usuario usuario) {
		setLayout(new MigLayout("", "[102.00px][184.00,grow][160.00,grow][32.00][162.00,grow][176.00,grow][102.00]",
				"[22px,grow][29][29][29][29][29][29][][][53.00][][][][][29][][][][][29][][][][][grow]"));

		cbBiblioteca = new JComboBox();
		add(cbBiblioteca, "cell 5 4,grow");

		lblIdUsuario = new JLabel("Id Usuario");
		add(lblIdUsuario, "cell 5 1,alignx leading");

		lblBiblioteca = new JLabel("Biblioteca");
		add(lblBiblioteca, "cell 5 3");

		txtIdUsuario = new JTextField();
		txtIdUsuario.setEditable(false);
		txtIdUsuario.setColumns(10);
		add(txtIdUsuario, "cell 5 2,grow");

		lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 1,alignx left");

		txtNome = new JTextField();
		add(txtNome, "cell 1 2 2 1,grow");
		txtNome.setColumns(10);

		lblSobrenome = new JLabel("Sobrenome");
		add(lblSobrenome, "cell 1 3,alignx left");

		lblTelefone = new JLabel("Telefone");
		add(lblTelefone, "cell 4 3,alignx left");

		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 4 2 1,grow");
		txtSobrenome.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("########");
			txtTelefone = new JFormattedTextField(maskFormatter);
			add(txtTelefone, "cell 4 4,grow");
			txtTelefone.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Telefone no painel de cadastro de usuario.");
			e.printStackTrace();
		}

		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		add(lblDataNascimento, "cell 4 5,alignx left");

		JLabel lblDdd = new JLabel("DDD");
		add(lblDdd, "cell 4 1,alignx left");

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");

			btnSalvarUsurio = new JButton("Salvar Usuario");
			add(btnSalvarUsurio, "cell 2 8,grow");

			lblCep = new JLabel("CEP");
			add(lblCep, "cell 1 10");

			lblCidade = new JLabel("Cidade");
			add(lblCidade, "cell 4 10,alignx left");
			txtDataNascimento = new JFormattedTextField(maskFormatter);
			add(txtDataNascimento, "cell 4 6,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao de data no painel alterar usuario.");
			e1.printStackTrace();
		}

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##");
			txtDdd = new JFormattedTextField(maskFormatter);
			add(txtDdd, "cell 4 2,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao do DDD no painel alterar usuario.");
			e1.printStackTrace();
		}

		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 5,alignx left");

		txtEmail = new JTextField();
		add(txtEmail, "cell 1 6 2 1,grow");
		txtEmail.setColumns(10);

		lblUf = new JLabel("UF");
		add(lblUf, "cell 5 10,alignx left");

		txtCEP = new JTextField();
		add(txtCEP, "cell 1 11 2 1,grow");
		txtCEP.setColumns(10);

		txtCidade = new JTextField();
		add(txtCidade, "cell 4 11,grow");
		txtCidade.setColumns(10);

		cbUf = new JComboBox();
		add(cbUf, "cell 5 11,grow");

		lblEndereo = new JLabel("Rua");
		add(lblEndereo, "cell 1 12,alignx left");

		lblNumero = new JLabel("Numero");
		add(lblNumero, "cell 4 12,alignx left");

		lblBairro = new JLabel("Bairro");
		add(lblBairro, "cell 5 12");

		txtRua = new JTextField();
		add(txtRua, "cell 1 13 2 1,grow");
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		add(txtNumero, "cell 4 13,grow");
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		add(txtBairro, "cell 5 13,grow");
		txtBairro.setColumns(10);

		btnExcluirUsuario = new JButton("Excluir Usuario");
		add(btnExcluirUsuario, "cell 4 8,grow");

		btnSalvarEndereco = new JButton("Salvar Endereco");
		add(btnSalvarEndereco, "cell 2 15,grow");

		btnLimparAlteracoes = new JButton("Limpar Alteracoes");
		add(btnLimparAlteracoes, "cell 4 15,grow");

		this.preencherDadosDaTela(usuario);
		this.addListeners();

	}

	private void addListeners() {

		btnSalvarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = new Endereco();
				endereco.setId(usuarioAlterado.getEndereco().getId());
				endereco.setRua(txtRua.getText());
				endereco.setNumeroRua(txtNumero.getText());
				endereco.setBairro(txtBairro.getText());
				endereco.setUf(cbUf.getSelectedItem().toString());
				endereco.setCidade(txtCidade.getText());
				endereco.setCep(txtCEP.getText());

				EnderecoController enderecoController = new EnderecoController();
				String message = enderecoController.alterarEndereco(endereco);
				JOptionPane.showMessageDialog(null, message, "Alterar Endereco", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] options = { "Confirmar", "Cancelar" };

				int resposta = JOptionPane.showOptionDialog(null, "Deseja excluir o usuário?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				String message = "";
				if (resposta == 0) {
					UsuarioController usuarioController = new UsuarioController();

					if (usuarioController.excluirUsuario(usuarioAlterado)) {
						message += "Usuário excluido com Sucesso!";
					} else {
						message += "Usuário não foi excluído.";
					}
				}
				JOptionPane.showMessageDialog(null, message, "Alterar Usuario", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnSalvarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuarioAlterado.setId(Integer.parseInt(txtIdUsuario.getText()));
				usuarioAlterado.setNome(txtNome.getText());
				usuarioAlterado.setSobrenome(txtSobrenome.getText());
				usuarioAlterado.setEmail(txtEmail.getText());
				usuarioAlterado.setDataNascimento(ConversorData.converterTextoEmData(txtDataNascimento.getText()));
				usuarioAlterado.setDdd(txtDdd.getText());
				usuarioAlterado.setFone(txtTelefone.getText());
				System.out.println(cbBiblioteca.getSelectedItem().toString() + cbBiblioteca.getSelectedIndex());
				usuarioAlterado.setBiblioteca(bibliotecas.get(cbBiblioteca.getSelectedIndex()));

				UsuarioController usuarioController = new UsuarioController();
				String message = usuarioController.alterarUsuario(usuarioAlterado);

				JOptionPane.showMessageDialog(null, message, "Alterar Usuario", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnLimparAlteracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherDadosDaTela(usuarioAlterado);
			}
		});

	}

	private void preencherDadosDaTela(Usuario usuario) {

		if (usuario != null) {
			usuarioAlterado = usuario;
			txtIdUsuario.setText(Integer.toString(usuario.getId()));
			txtNome.setText(usuario.getNome());
			txtSobrenome.setText(usuario.getSobrenome());
			txtEmail.setText(usuario.getEmail());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			txtDdd.setText(usuario.getDdd());
			txtDataNascimento.setText(usuario.getDataNascimento().format(formatter));
			txtTelefone.setText(usuario.getFone());

			txtRua.setText(usuario.getEndereco().getRua());
			txtNumero.setText(String.valueOf(usuario.getEndereco().getNumeroRua()));
			txtBairro.setText(usuario.getEndereco().getBairro());
			txtCidade.setText(usuario.getEndereco().getCidade());
			txtCEP.setText(usuario.getEndereco().getCep());

			this.preencherComboUf();
			cbUf.setSelectedItem(usuario.getEndereco().getUf());

			this.preencherComboboxBiblioteca();
			cbBiblioteca.setSelectedItem(usuario.getBiblioteca().getNome());
			System.out.println(usuario.getDataNascimento().toString());

		}

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
