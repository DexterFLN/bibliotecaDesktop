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
import net.miginfocom.swing.MigLayout;

public class PainelAcervoEditar extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtSessao;
	private JTextField textEditora;

	/**
	 * Create the panel.
	 */
	public PainelAcervoEditar() {
		setLayout(new MigLayout("", "[46px,grow][18px,grow][193px][19px,grow][187px,grow][grow]", "[52.00px][20px][33.00][46.00px][][51.00px][31.00px][32.00px][48.00px][][23px][grow]"));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "cell 0 0 3 1,alignx left,growy");
		
		JMenu mnVotlar = new JMenu("Voltar");
		menuBar.add(mnVotlar);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		textEditora = new JTextField();
		add(textEditora, "cell 1 6 3 1,grow");
		textEditora.setColumns(10);
		
		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 7,growx,aligny center");
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 5,growx,aligny bottom");
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 3,growx,aligny center");
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 1,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Deuses do Olimpo");
		txtTitulo.setColumns(10);
		add(txtTitulo, "cell 1 2 4 1,grow");
		
		txtAutor = new JTextField();
		txtAutor.setText("Dad Squarisi");
		txtAutor.setColumns(10);
		add(txtAutor, "cell 1 4 3 1,grow");
		
		txtSessao = new JTextField();
		txtSessao.setText("Fic\u00E7\u00E3o");
		txtSessao.setColumns(10);
		add(txtSessao, "cell 1 8 3 1,grow");
		
		JComboBox cbAno = new JComboBox();
		add(cbAno, "cell 4 4,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 4 3,alignx center,aligny center");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnSalvar, "cell 2 10,alignx center,growy");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setForeground(Color.RED);
		add(btnExcluir, "cell 4 10,alignx left,growy");

	}
}
