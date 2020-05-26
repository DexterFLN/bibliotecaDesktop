package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtSessao;

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(56, 70, 26, 14);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 67, 393, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(56, 116, 46, 14);
		add(lblAutor);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(56, 164, 46, 14);
		add(lblEditora);
		
		JLabel lblSessao = new JLabel("Sesssao");
		lblSessao.setBounds(56, 220, 46, 14);
		add(lblSessao);
		
		JLabel lblNewLabel_3 = new JLabel("Ano");
		lblNewLabel_3.setBounds(375, 116, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setBounds(375, 141, 122, 22);
		add(cbAno);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 285, 22);
		add(menuBar);
		
		JMenu mnAcervo = new JMenu("Acervo");
		menuBar.add(mnAcervo);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenu mnConsultar = new JMenu("Consultar ");
		menuBar.add(mnConsultar);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(120, 113, 193, 20);
		add(txtAutor);
		txtAutor.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(120, 161, 193, 20);
		add(txtEditora);
		txtEditora.setColumns(10);
		
		txtSessao = new JTextField();
		txtSessao.setBounds(120, 217, 399, 20);
		add(txtSessao);
		txtSessao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(249, 271, 89, 23);
		add(btnCadastrar);

	}
}
