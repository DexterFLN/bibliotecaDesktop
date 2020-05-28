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

	/**
	 * Create the panel.
	 */
	public PainelPesquisaGeral() {
		setLayout(new MigLayout("", "[161.00px,grow][50px,grow][21px,grow][41px,grow][144px,grow][92px,grow]", "[58.00px][50.00px][30.00px][544.00px]"));
		
		JLabel lblPesquisa = new JLabel("Digite um termo para pesquisa");
		add(lblPesquisa, "cell 0 1 2 1,growx,aligny center");
		
		txtPesquisar = new JTextField();
		add(txtPesquisar, "cell 2 1 3 1,growx,aligny center");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 0 2,alignx right,aligny center");
		
		JComboBox cbBuscar = new JComboBox();
		add(cbBuscar, "cell 1 2 2 1,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 2,grow");
		
		JComboBox cbAno = new JComboBox();
		add(cbAno, "cell 4 2,grow");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Roboto", Font.PLAIN, 12));
		add(menuBar, "cell 0 0,grow");
		
		JMenu mnPesquisaGeral = new JMenu("Pesquisa Geral");
		mnPesquisaGeral.setForeground(Color.BLACK);
		menuBar.add(mnPesquisaGeral);
		
		btnPesquisar = new JButton("Pesquisar");
		
		add(btnPesquisar, "cell 5 1,grow");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 0 3 6 1,grow");
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[1145.00px,grow,fill]", "[58.00px,grow,fill]"));
		
		tableResultadoPesquisa = new JTable();
		tableResultadoPesquisa.setBounds(0, 0, 500, 500);
		
		panel.add(tableResultadoPesquisa, "cell 0 0,grow");
		
		this.addListeners();
		
	}
	
	
	private void addListeners() {
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sessao sessao = new Sessao("Mitologia", null);
				Livro livro = new Livro(1,"Atlas", "Atlas", "Arqueiro", 20, 2019, sessao, null);
				
				Exemplar exemplar = new Exemplar();
				exemplar.setId(30);
				exemplar.setLivro(livro);
				
				ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
				exemplares.add(exemplar);
				
				livro.setExemplares(exemplares);
				
				System.out.println(livro.toString());
				livros.add(livro);
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
			novaLinhaDaTabela[0] = "teste";
			novaLinhaDaTabela[1] = "teste";
			novaLinhaDaTabela[2] = "teste";
			novaLinhaDaTabela[3] = "teste";
			
			model.addRow(novaLinhaDaTabela);
		}
		
	}
	
	
	

}
