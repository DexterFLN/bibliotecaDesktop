package view.acervo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtSessao;
	private JTextField textAutor;
	private JTextField textEditora;
	private JPanel painelAcervoConsulta = new PainelAcervoConsulta();

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][55.00][35.00px][27.00][34.00px][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 2,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		add(txtTitulo, "cell 1 3 3 1,grow");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 4,alignx left,aligny center");
		
		textAutor = new JTextField();
		add(textAutor, "cell 1 5 2 1,grow");
		textAutor.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 6,alignx left,aligny top");
		
		textEditora = new JTextField();
		add(textEditora, "cell 1 7 2 1,grow");
		textEditora.setColumns(10);
		
		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 8,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 4,alignx left,aligny center");
		
		JComboBox cbAno = new JComboBox();
		add(cbAno, "cell 3 5,grow");
		
		txtSessao = new JTextField();
		add(txtSessao, "cell 1 9 3 1,grow");
		txtSessao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnCadastrar, "cell 2 11,grow");

	}
}
