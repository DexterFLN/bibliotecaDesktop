package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PainelPesquisaGeral extends JPanel {
	
	private JTextField txtPesquisa;
	private JTable table;


	/**
	 * Create the panel.
	 */
	public PainelPesquisaGeral() {
		setLayout(null);
//		setBounds(500, 500, 116, 159);
		setBackground(new java.awt.Color(229, 229, 229));
		// teste git
		txtPesquisa = new JTextField();
		txtPesquisa.setText("Digite um termo para Pesquisa");
		txtPesquisa.setBounds(50, 68, 615, 28);
		add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(692, 67, 162, 28);
		add(btnPesquisar);
		
		JLabel lblPesquisa = new JLabel("Pesquisa Geral");
		lblPesquisa.setFont(new Font("Roboto", Font.PLAIN, 30));
		lblPesquisa.setBounds(28, 0, 273, 61);
		add(lblPesquisa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 108, 117, 24);
		add(comboBox);
		
		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		lblBuscarPor.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblBuscarPor.setBounds(60, 110, 130, 19);
		add(lblBuscarPor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(356, 108, 99, 24);
		add(comboBox_1);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblAno.setBounds(300, 112, 70, 15);
		add(lblAno);
		
		table = new JTable();
		table.setBounds(28, 162, 943, 397);
		add(table);

	}

}
