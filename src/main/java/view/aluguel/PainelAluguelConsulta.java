package view.aluguel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.AluguelController;
import controller.ExemplarController;
import model.seletor.AluguelSeletor;
import model.vo.Aluguel;
import model.vo.Livro;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelAluguelConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private String[] nomesColunas = {"Codigo Exemplar", "Titulo", "Autor", "Usuario", "Devolucao Prevista", "Devolucao Efetiva"};
	private ArrayList<Livro> livros;
	private ArrayList<Aluguel> alugueis;
	private JComboBox cbBuscar;

	/**
	 * Create the panel.
	 */
	public PainelAluguelConsulta() {
		
		setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[31.00px][30.00px][544.00px,grow]"));
		
		txtPesquisar = new JTextField();
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 1,alignx right,aligny center");
		
		cbBuscar = new JComboBox();
		cbBuscar.addItem("SELECIONE");
		cbBuscar.addItem("Atrasados");
		cbBuscar.addItem("Codigo Usuario");
		cbBuscar.addItem("Codigo Exemplar");
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
		
		this.addListeners();
	}
	
	private void addListeners() {
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelSeletor aluguelSeletor = new AluguelSeletor();
				
				aluguelSeletor.setTermoPesquisa(txtPesquisar.getText());
				aluguelSeletor.setBuscarPor((String) cbBuscar.getSelectedItem());
				
				AluguelController aluguelController = new AluguelController();
				alugueis = aluguelController.consultarAluguelSeletor(aluguelSeletor);
				System.out.println(alugueis.toString());
				atualizarTabelaResultadoPesquisa();
				
			}
			
		});
	}
	
	private void limparTabelaResultadoPesquisa() {
		tableResultadoPesquisa.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaResultadoPesquisa() {
		limparTabelaResultadoPesquisa();
		DefaultTableModel model = (DefaultTableModel) tableResultadoPesquisa.getModel();
		
		for (Aluguel aluguel : alugueis) {
			
			if(ExemplarController.existeIdDeExemplar(aluguel.getExemplar())) {
				Object[] novaLinhaDaTabela = new Object[6];
				novaLinhaDaTabela[0] = aluguel.getExemplar().getId();
				novaLinhaDaTabela[1] = aluguel.getExemplar().getLivro().getNome();
				novaLinhaDaTabela[2] = aluguel.getExemplar().getLivro().getAutor();
				novaLinhaDaTabela[3] = aluguel.getUsuario().getNome();
				novaLinhaDaTabela[4] = aluguel.getDevolucaoPrevista();
				novaLinhaDaTabela[5] = aluguel.getDevolucaoEfetiva();

				model.addRow(novaLinhaDaTabela);
			}
			
			
		}
		
		
	}
}
