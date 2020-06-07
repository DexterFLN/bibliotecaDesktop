package view.acervo;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.vo.Livro;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private String[] nomesColunas = {"Título", "Autor", "Ano", "Exemplares"};
	private ArrayList<Livro> livros;
	private JComboBox cbAno;
	private JComboBox cbBuscar;

	/**
	 * Create the panel.
	 */
	public PainelAcervoConsulta() {
		
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[31.00px][30.00px][544.00px]"));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 1,alignx right,aligny center");
		
		cbBuscar = new JComboBox();
		this.preenchercbBuscarPor();
		add(cbBuscar, "cell 2 1,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 1,alignx right,growy");
		
		cbAno = new JComboBox();
		this.preenchercbAno();
		add(cbAno, "cell 4 1,grow");
		
		
		btnPesquisar = new JButton("Pesquisar");
		
		add(btnPesquisar, "cell 7 0,grow");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 2 8 1,grow");
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[1145.00px,grow,fill]", "[58.00px,grow,fill]"));
		
		tableResultadoPesquisa = new JTable();
		tableResultadoPesquisa.setBounds(0, 0, 500, 500);
		
		panel.add(tableResultadoPesquisa, "cell 0 0,grow");
		

	}
	
	private void preenchercbAno() {
		//TODO combo ano de dois em dois?
		for (int i = 2020; i >= 1500; i--) {
			cbAno.addItem(i);
		}
	}
	
	private void preenchercbBuscarPor() {
		// TODO verificar se são só essas opções
		cbBuscar.addItem("Autor");
		cbBuscar.addItem("Título");
		cbBuscar.addItem("Editora");
		cbBuscar.addItem("Sessão");
		
		
	}

}
