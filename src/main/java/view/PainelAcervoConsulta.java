package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenu;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class PainelAcervoConsulta extends JPanel {
	private JTextField txtConsulta;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelAcervoConsulta() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(9, 11, 228, 22);
		add(menuBar);
		
		JMenu mnAcervo = new JMenu("Acervo");
		menuBar.add(mnAcervo);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		JLabel lblConsultar = new JLabel("Digite um termo para consultar");
		lblConsultar.setBounds(9, 62, 151, 14);
		add(lblConsultar);
		
		txtConsulta = new JTextField();
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(170, 59, 235, 20);
		add(txtConsulta);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(435, 58, 89, 23);
		add(btnConsultar);
		
		JLabel label_1 = new JLabel("Buscar por");
		label_1.setBounds(9, 98, 59, 15);
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(73, 94, 81, 22);
		add(comboBox);
		
		JLabel label_2 = new JLabel("Ano");
		label_2.setBounds(206, 94, 41, 22);
		add(label_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(244, 94, 81, 23);
		add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 140, 550, 189);
		add(panel);
		
		table = new JTable();
		panel.add(table);

	}
}
