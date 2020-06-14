package view.usuario;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class PainelUsuarioCadastro extends JPanel {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtDtNascimento;
	private JTextField txtEmail;
	private JTextField txtDdd;
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
		
		JLabel lblTelefone = new JLabel("Telefone");
		add(lblTelefone, "cell 4 3");
		
		txtSobrenome = new JTextField();
		add(txtSobrenome, "cell 1 4 3 1,growx");
		txtSobrenome.setColumns(10);
		
		JRadioButton rdbtnFixo = new JRadioButton("Fixo");
		buttonGroup.add(rdbtnFixo);
		rdbtnFixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(rdbtnFixo, "flowx,cell 4 4");
		
		JLabel lblDtNascimento = new JLabel("Data de Nascimento");
		add(lblDtNascimento, "cell 1 5");
		
		JLabel lblDdd = new JLabel("DDD");
		add(lblDdd, "cell 4 5");
		
		txtDtNascimento = new JTextField();
		add(txtDtNascimento, "cell 1 6 3 1,growx");
		txtDtNascimento.setColumns(10);
		
		txtDdd = new JTextField();
		add(txtDdd, "cell 4 6,growx");
		txtDdd.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 1 7");
		
		txtEmail = new JTextField();
		add(txtEmail, "cell 1 8 3 1,growx");
		txtEmail.setColumns(10);
		
		JRadioButton rdbtnMovel = new JRadioButton("Movel");
		buttonGroup.add(rdbtnMovel);
		rdbtnMovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(rdbtnMovel, "cell 4 4");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCadastrar, "cell 2 10");

	}

}
