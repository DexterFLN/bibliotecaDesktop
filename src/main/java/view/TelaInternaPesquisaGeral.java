package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class TelaInternaPesquisaGeral extends JInternalFrame {
	private JTextField txtPesquisa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaPesquisaGeral frame = new TelaInternaPesquisaGeral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInternaPesquisaGeral() {
		setBounds(100, 100, 1016, 659);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new java.awt.Color(229, 229, 229));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setText("Digite um termo para Pesquisa");
		txtPesquisa.setBounds(50, 68, 615, 28);
		getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(692, 67, 162, 28);
		getContentPane().add(btnPesquisar);
		
		JLabel lblPesquisa = new JLabel("Pesquisa Geral");
		lblPesquisa.setFont(new Font("Roboto", Font.PLAIN, 30));
		lblPesquisa.setBounds(28, 0, 273, 61);
		getContentPane().add(lblPesquisa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 108, 117, 24);
		getContentPane().add(comboBox);
		
		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		lblBuscarPor.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblBuscarPor.setBounds(60, 110, 130, 19);
		getContentPane().add(lblBuscarPor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(356, 108, 99, 24);
		getContentPane().add(comboBox_1);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblAno.setBounds(300, 112, 70, 15);
		getContentPane().add(lblAno);
		
		table = new JTable();
		table.setBounds(28, 162, 943, 397);
		getContentPane().add(table);

	}
}
