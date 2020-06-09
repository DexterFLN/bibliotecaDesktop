package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class PainelAcervoAlterar extends JPanel {

	private JTextField txtTitulo;
	private JTextField txtSessao;
	private JTextField textAutor;
	private JTextField textEditora;
	private JTextField txtCodigoLivro;

	/**
	 * Create the panel.
	 */
	public PainelAcervoAlterar() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][29.00][35.00px][27.00][34.00px][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));
		
		JLabel lblExcluir = new JLabel("Digite o código do Livro");
		add(lblExcluir, "cell 1 1,alignx center,aligny center");
		
		txtCodigoLivro = new JTextField();
		txtCodigoLivro.setText("4127653");
		add(txtCodigoLivro, "cell 2 1,grow");
		txtCodigoLivro.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		add(btnPesquisar, "cell 3 1,grow");

		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 2,alignx left,aligny center");

		txtTitulo = new JTextField();
		txtTitulo.setText("Deuses do Olimpo");
		add(txtTitulo, "cell 1 3 3 1,grow");
		txtTitulo.setColumns(10);

		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 4,alignx left,aligny center");

		textAutor = new JTextField();
		textAutor.setText("Dad Squarisi");
		add(textAutor, "cell 1 5 2 1,grow");
		textAutor.setColumns(10);

		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 6,alignx left,aligny top");

		textEditora = new JTextField();
		textEditora.setText("Arqueiro");
		add(textEditora, "cell 1 7 2 1,grow");
		textEditora.setColumns(10);

		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 8,alignx left,aligny center");

		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 4,alignx left,aligny center");

		JComboBox cbAno = new JComboBox();
		cbAno.addItem("2019");
		cbAno.setEditable(true);
		add(cbAno, "cell 3 5,grow");

		txtSessao = new JTextField();
		txtSessao.setText("Ficção");
		add(txtSessao, "cell 1 9 3 1,grow");
		txtSessao.setColumns(10);
		
		JButton btnSalvarAlteraes = new JButton("Salvar Alterações");
		btnSalvarAlteraes.setBackground(new Color(173, 255, 47));
		add(btnSalvarAlteraes, "cell 1 11,grow");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(229, 13, 13, 90));
		add(btnExcluir, "cell 3 11,grow");

		this.addListners();

	}

	private void addListners() {

	}

}
