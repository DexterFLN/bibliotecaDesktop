package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtSessao;
	private JTextField textAutor;
	private JTextField textEditora;

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(new MigLayout("", "[159.00px][18px,grow][218px,grow][37px,grow][144px,grow]", "[32.00px][35.00px][27.00][34.00px][27.00px][19.00px][30.00px][][30.00px][47.00px]"));
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 1,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		add(txtTitulo, "cell 1 2 3 1,grow");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 3,alignx left,aligny center");
		
		textAutor = new JTextField();
		add(textAutor, "cell 1 4 2 1,grow");
		textAutor.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 5,alignx left,aligny top");
		
		textEditora = new JTextField();
		add(textEditora, "cell 1 6 2 1,grow");
		textEditora.setColumns(10);
		
		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 7,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 3,alignx left,aligny center");
		
		JComboBox cbAno = new JComboBox();
		add(cbAno, "cell 3 4,grow");
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "cell 0 0 3 1,alignx left,growy");
		
		JMenu mnAcervo = new JMenu("Acervo");
		menuBar.add(mnAcervo);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenu mnConsultar = new JMenu("Consultar ");
		menuBar.add(mnConsultar);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		txtSessao = new JTextField();
		add(txtSessao, "cell 1 8 3 1,grow");
		txtSessao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCadastrar, "cell 2 9,alignx right,growy");

	}
}
