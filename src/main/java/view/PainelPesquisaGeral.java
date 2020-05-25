package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class PainelPesquisaGeral extends JPanel {
	
	private JTextField txtPesquisa;
	private JTable table;


	/**
	 * Create the panel.
	 */
	public PainelPesquisaGeral() {
		setBackground(new java.awt.Color(229, 229, 229));
		setLayout(new MigLayout("", "[254px][18px][1px][55px][309px][27px][279px]", "[61px][29px][24px][397px]"));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setText("Digite um termo para Pesquisa");
		add(txtPesquisa, "cell 0 1 5 1,grow");
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		add(btnPesquisar, "cell 6 1,alignx left,growy");
		
		JLabel lblPesquisa = new JLabel("Pesquisa Geral");
		lblPesquisa.setFont(new Font("Roboto", Font.PLAIN, 30));
		add(lblPesquisa, "cell 0 0 3 1,grow");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 0 2,alignx right,aligny top");
		
		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		lblBuscarPor.setFont(new Font("Roboto", Font.PLAIN, 16));
		add(lblBuscarPor, "cell 0 2,alignx center,aligny top");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "cell 4 2,alignx left,aligny top");
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setFont(new Font("Roboto", Font.PLAIN, 16));
		add(lblAno, "cell 2 2 3 1,alignx left,aligny top");
		
		table = new JTable();
		add(table, "cell 0 3 7 1,grow");

	}

}
