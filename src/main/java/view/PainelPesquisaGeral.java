package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.vo.Exemplar;
import model.vo.Livro;
import model.vo.Sessao;
import net.miginfocom.swing.MigLayout;

public class PainelPesquisaGeral extends JPanel {
	
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
	public PainelPesquisaGeral() {
		setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px][]", "[58.00px][31.00px][30.00px][544.00px]"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Roboto", Font.PLAIN, 12));
		add(menuBar, "cell 1 0,alignx leading,growy");
		
		JMenu mnPesquisaGeral = new JMenu("Pesquisa Geral");
		mnPesquisaGeral.setBackground(new Color(2,  83, 83));
		menuBar.add(mnPesquisaGeral);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
		add(txtPesquisar, "cell 1 1 6 1,grow");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 2 1,alignx right,aligny center");
		
		cbBuscar = new JComboBox();
		this.preenchercbBuscarPor();
		add(cbBuscar, "cell 2 2,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 2,alignx right,growy");
		
		cbAno = new JComboBox();
		this.preenchercbAno();
		add(cbAno, "cell 4 2,grow");
		
		btnPesquisar = new JButton("Pesquisar");
		
		add(btnPesquisar, "cell 7 1,grow");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 3 8 1,grow");
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[1145.00px,grow,fill]", "[58.00px,grow,fill]"));
		
		tableResultadoPesquisa = new JTable();
		tableResultadoPesquisa.setBounds(0, 0, 500, 500);
		panel.add(tableResultadoPesquisa, "cell 0 0,grow");
		
		this.addListeners();
		
	}
	
	
	private void preenchercbAno() {
		for (int i = 2020; i >= 1500; i--) {
			cbAno.addItem(i);
		}
	}
	
	private void preenchercbBuscarPor() {
		cbBuscar.addItem("Autor");
		cbBuscar.addItem("Título");
		cbBuscar.addItem("Editora");
		cbBuscar.addItem("Sessão");
		
		
	}

	private void addListeners() {
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				atualizarTabelaResultadoPesquisa();
			}
		});
	}
	
	private void limparTabelaResultadoPesquisa() {
		tableResultadoPesquisa.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaResultadoPesquisa() {
		limparTabelaResultadoPesquisa();
		DefaultTableModel model = (DefaultTableModel) tableResultadoPesquisa.getModel();
		
		for (int i = 0; i < 3; i++) {
			
			Object[] novaLinhaDaTabela = new Object[4];
			novaLinhaDaTabela[0] = "Deuses Do Olimpo";
			novaLinhaDaTabela[1] = "teste";
			novaLinhaDaTabela[2] = "teste";
			novaLinhaDaTabela[3] = btnPesquisar;
			
			
			model.addRow(novaLinhaDaTabela);
		}
		
	}
	
	
	

}
