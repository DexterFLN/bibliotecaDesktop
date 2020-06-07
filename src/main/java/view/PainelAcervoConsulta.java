package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.vo.Livro;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private String[] nomesColunas = {"Título", "Autor", "Ano", "Exemplares"};
	private ArrayList<Livro> livros;

	/**
	 * Create the panel.
	 */
	public PainelAcervoConsulta() {
		
//		JMenuBar menuBar = new JMenuBar();
//		add(menuBar, "cell 0 0 5 1,grow");
//		
//		JMenu mnAcervo = new JMenu("Acervo");
//		menuBar.add(mnAcervo);
//		
//		JMenu mnCadastro = new JMenu("Cadastro");
//		menuBar.add(mnCadastro);
//		
//		JMenu mnConsulta = new JMenu("Consulta");
//		menuBar.add(mnConsulta);
//		
//		JMenu mnExcluir = new JMenu("Excluir");
//		menuBar.add(mnExcluir);
//		
//		JLabel lblConsultar = new JLabel("Digite um termo para consultar");
//		add(lblConsultar, "cell 0 1 3 1,growx,aligny center");
//		
//		txtConsulta = new JTextField();
//		txtConsulta.setColumns(10);
//		add(txtConsulta, "cell 4 1 3 1,growx,aligny center");
//		
//		JButton btnConsultar = new JButton("Consultar");
//		btnConsultar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		add(btnConsultar, "cell 8 1,alignx left,growy");
//		
//		JLabel label_1 = new JLabel("Buscar por");
//		add(label_1, "cell 0 2,growx,aligny center");
//		
//		JComboBox comboBox = new JComboBox();
//		add(comboBox, "cell 2 2,grow");
//		
//		JLabel label_2 = new JLabel("Ano");
//		add(label_2, "cell 4 2 3 1,alignx left,growy");
//		
//		JComboBox comboBox_1 = new JComboBox();
//		add(comboBox_1, "cell 6 2,alignx left,growy");
//		
//		JPanel panel = new JPanel();
//		add(panel, "cell 0 3 9 1,grow");
//		
//		table = new JTable();
//		panel.add(table);
		
		setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[58.00px][31.00px][30.00px][544.00px]"));
		
		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setFont(new Font("Roboto", Font.PLAIN, 12));
//		add(menuBar, "cell 1 0,grow");
//		
//		JMenu mnAcervo = new JMenu("Acervo");
//		menuBar.add(mnAcervo);
//		
//		JMenu mnCadastro = new JMenu("Cadastro");
//		menuBar.add(mnCadastro);
//		
//		JMenu mnConsulta = new JMenu("Consulta");
//		menuBar.add(mnConsulta);
//		
//		JMenu mnExcluir = new JMenu("Excluir");
//		menuBar.add(mnExcluir);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
		add(txtPesquisar, "cell 1 1 6 1,grow");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 2 1,alignx right,aligny center");
		
		JComboBox cbBuscar = new JComboBox();
		add(cbBuscar, "cell 2 2,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 2,alignx right,growy");
		
		JComboBox cbAno = new JComboBox();
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
		

	}
}
