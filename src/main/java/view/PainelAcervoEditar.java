package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelAcervoEditar extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtSessao;

	/**
	 * Create the panel.
	 */
	public PainelAcervoEditar() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 150, 22);
		add(menuBar);
		
		JMenu mnVotlar = new JMenu("Voltar");
		menuBar.add(mnVotlar);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JLabel lblSessao = new JLabel("Sesssao");
		lblSessao.setBounds(10, 206, 46, 14);
		add(lblSessao);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(10, 150, 46, 14);
		add(lblEditora);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 102, 46, 14);
		add(lblAutor);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 56, 26, 14);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Deuses do Olimpo");
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(74, 53, 393, 20);
		add(txtTitulo);
		
		txtAutor = new JTextField();
		txtAutor.setText("Dad Squarisi");
		txtAutor.setColumns(10);
		txtAutor.setBounds(74, 99, 193, 20);
		add(txtAutor);
		
		txtEditora = new JTextField();
		txtEditora.setText("Arqueiro");
		txtEditora.setColumns(10);
		txtEditora.setBounds(74, 147, 193, 20);
		add(txtEditora);
		
		txtSessao = new JTextField();
		txtSessao.setText("Fic\u00E7\u00E3o");
		txtSessao.setColumns(10);
		txtSessao.setBounds(74, 203, 399, 20);
		add(txtSessao);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setBounds(329, 127, 122, 22);
		add(cbAno);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(329, 102, 46, 14);
		add(lblAno);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(128, 250, 89, 23);
		add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setForeground(Color.RED);
		btnExcluir.setBounds(286, 250, 89, 23);
		add(btnExcluir);

	}
}
