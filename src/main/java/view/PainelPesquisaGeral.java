package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class PainelPesquisaGeral extends JPanel {
	private JTextField txtPesquisar;
	private JTable tblPesquisaGeral;

	/**
	 * Create the panel.
	 */
	public PainelPesquisaGeral() {
		setLayout(new MigLayout("", "[89px][10px][50px][10px][21px][37px][41px][144px][30px][92px]", "[22px][23px][23px][162px]"));
		
		JLabel lblPesquisa = new JLabel("Digite um termo para pesquisa");
		add(lblPesquisa, "cell 0 1 3 1,growx,aligny center");
		
		txtPesquisar = new JTextField();
		add(txtPesquisar, "cell 4 1 4 1,growx,aligny center");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 0 2,alignx right,aligny center");
		
		JComboBox cbBuscar = new JComboBox();
		add(cbBuscar, "cell 2 2 3 1,grow");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 6 2,grow");
		
		JComboBox cbAno = new JComboBox();
		add(cbAno, "cell 7 2,alignx left,growy");
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "cell 0 0,grow");
		
		JMenu mnPesquisaGeral = new JMenu("Pesquisa Geral");
		mnPesquisaGeral.setForeground(Color.BLACK);
		menuBar.add(mnPesquisaGeral);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnPesquisar, "cell 9 1,grow");
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 3 10 1,grow");
		
		tblPesquisaGeral = new JTable();
		panel.add(tblPesquisaGeral);

	}
}
