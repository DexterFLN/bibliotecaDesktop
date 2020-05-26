package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;

public class PainelPesquisaGeral extends JPanel {
	private JTextField txtPesquisar;
	private JTable tblPesquisaGeral;

	/**
	 * Create the panel.
	 */
	public PainelPesquisaGeral() {
		setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Digite um termo para pesquisa");
		lblPesquisa.setBounds(10, 58, 145, 14);
		add(lblPesquisa);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(165, 55, 243, 20);
		add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		lblBuscar.setBounds(36, 101, 59, 15);
		add(lblBuscar);
		
		JComboBox cbBuscar = new JComboBox();
		cbBuscar.setBounds(105, 97, 81, 22);
		add(cbBuscar);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(223, 97, 41, 22);
		add(lblAno);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setBounds(264, 97, 81, 23);
		add(cbAno);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 6, 89, 22);
		add(menuBar);
		
		JMenu mnPesquisaGeral = new JMenu("Pesquisa Geral");
		mnPesquisaGeral.setForeground(Color.BLACK);
		menuBar.add(mnPesquisaGeral);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(438, 54, 89, 23);
		add(btnPesquisar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 127, 520, 162);
		add(panel);
		
		tblPesquisaGeral = new JTable();
		panel.add(tblPesquisaGeral);

	}
}
