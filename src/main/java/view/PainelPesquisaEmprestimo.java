package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class PainelPesquisaEmprestimo extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelPesquisaEmprestimo() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 101, 22);
		add(menuBar);
		
		JMenu mnEmprestimos = new JMenu("Emprestimos");
		menuBar.add(mnEmprestimos);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(171, 55, 235, 20);
		add(textField);
		
		JLabel lblDigiteUmTermo = new JLabel("Digite um termo para pesquisar");
		lblDigiteUmTermo.setBounds(10, 58, 151, 14);
		add(lblDigiteUmTermo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(436, 54, 89, 23);
		add(btnPesquisar);
		
		JLabel label_1 = new JLabel("Buscar por");
		label_1.setBounds(10, 94, 59, 15);
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(74, 90, 81, 22);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 540, 166);
		add(panel);
		
		table = new JTable();
		panel.add(table);

	}

}
