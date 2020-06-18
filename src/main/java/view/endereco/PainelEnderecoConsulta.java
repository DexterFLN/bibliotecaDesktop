package view.endereco;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PainelEnderecoConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	/**
	 * Create the panel.
	 */
	public PainelEnderecoConsulta() {
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[31.00px][30.00px][544.00px]"));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);
		
		
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
