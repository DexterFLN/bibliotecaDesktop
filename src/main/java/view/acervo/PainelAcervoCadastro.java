package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField textAutor;
	private JTextField textEditora;
	private JButton btnCadastrar;

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][35.00px][29.00][38.00px][27.00px][38.00px][29.00px][38.00][29.00px][29.00px][37.00][grow][]"));
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 1,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Mitologia Nórdica");
		add(txtTitulo, "cell 1 2 3 1,grow");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 3,alignx left,aligny center");
		
		textAutor = new JTextField();
		textAutor.setText("Neil Gaiman");
		add(textAutor, "cell 1 4 2 1,grow");
		textAutor.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 5,alignx left,aligny center");
		
		textEditora = new JTextField();
		textEditora.setText("Intrínseca");
		add(textEditora, "cell 1 6 2 1,grow");
		textEditora.setColumns(10);
		
		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 7,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 3,alignx left,aligny center");
		
		JComboBox cbAno = new JComboBox();
		cbAno.addItem("2019");
		add(cbAno, "cell 3 4,grow");
		
		JComboBox cbSessao = new JComboBox();
		cbSessao.addItem("Ficção");
		cbSessao.addItem("Literatura Clássica");
		cbSessao.addItem("Romance");
		
		add(cbSessao, "cell 1 8 3 1,grow");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 2 10,grow");
		
		this.addListeners();

	}
	
	private void addListeners() {
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showConfirmDialog(null, "Cadastrar livro 'Exemplo'?", "Cadastrar Livro", JOptionPane.YES_NO_CANCEL_OPTION);
				
			}
		});
		
	}
}
