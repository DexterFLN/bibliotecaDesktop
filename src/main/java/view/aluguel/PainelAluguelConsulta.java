package view.aluguel;

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

public class PainelAluguelConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private String[] nomesColunas = {"Título", "Autor", "Ano", "Exemplares"};
	private ArrayList<Livro> livros;

	/**
	 * Create the panel.
	 */
	public PainelAluguelConsulta() {
		
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[31.00px][30.00px][544.00px]"));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite o termo para Pesquisa");
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 1,alignx right,aligny center");
		
		JComboBox cbBuscar = new JComboBox();
		cbBuscar.addItem("Atrasados");
		cbBuscar.addItem("Código Usuário");
		cbBuscar.addItem("Código Livro");
		add(cbBuscar, "cell 2 1,grow");
		
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
}
