package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ExemplarController;
import controller.LivroController;
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import model.vo.Livro;
import net.miginfocom.swing.MigLayout;
import util.Utils;
import view.usuario.MainUsuario;

public class PainelAcervoConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private String[] nomesColunas = { "Titulo", "Autor", "Editora", "Ano", "Codigo" };
	private ArrayList<Exemplar> exemplares;
	private JComboBox cbAno;
	private JComboBox cbBuscar;
	private JPanel painelAcervoAlterar = null;


	/**
	 * Create the panel.
	 */
	public PainelAcervoConsulta() {

		setLayout(new MigLayout("",
				"[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]",
				"[31.00px][30.00px][544.00px]"));

		txtPesquisar = new JTextField();
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);

		JLabel lblBuscar = new JLabel("Buscar por");
		add(lblBuscar, "cell 1 1,alignx right,aligny center");

		cbBuscar = new JComboBox();
		cbBuscar = Utils.preenchercbBuscarPor(cbBuscar);
		add(cbBuscar, "cell 2 1,grow");

		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 1,alignx right,growy");

		cbAno = new JComboBox();
		cbAno = Utils.preenchercbAno(cbAno);
		add(cbAno, "cell 4 1,grow");

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
			public void actionPerformed(ActionEvent arg0) {
				LivroSeletor livroSeletor = new LivroSeletor();

				livroSeletor.setTermoPesquisa(txtPesquisar.getText());
				livroSeletor.setAno((String) cbAno.getSelectedItem().toString());
				livroSeletor.setBuscarPor((String) cbBuscar.getSelectedItem());

				ExemplarController exemplarController = new ExemplarController();
				exemplares = exemplarController.consultarExemplarLivroSeletor(livroSeletor);
				System.out.println(exemplares.toString());
				atualizarTabelaResultadoPesquisa();
			}
		});
		
		tableResultadoPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Cliquei na table na linha " + tableResultadoPesquisa.getSelectedRow());
				System.out.println(exemplares.get(tableResultadoPesquisa.getSelectedRow() - 1));
				
				LivroController  livroController = new LivroController();
				Livro  livroClicado = livroController.consultarLivroPorIdParaExemplares(exemplares.get(tableResultadoPesquisa.getSelectedRow() - 1).getLivro().getId());
				painelAcervoAlterar = new PainelAcervoAlterar(exemplares.get(tableResultadoPesquisa.getSelectedRow() - 1).getLivro());
				MainAcervo.switchPanel(painelAcervoAlterar);
				
			}
		});

	}

	private void limparTabelaResultadoPesquisa() {
		tableResultadoPesquisa.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}


	private void atualizarTabelaResultadoPesquisa() {
		limparTabelaResultadoPesquisa();
		DefaultTableModel model = (DefaultTableModel) tableResultadoPesquisa.getModel();

		for (Exemplar exemplar : exemplares) {

			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = exemplar.getLivro().getNome();
			novaLinhaDaTabela[1] = exemplar.getLivro().getAutor();
			novaLinhaDaTabela[2] = exemplar.getLivro().getEditora();
			novaLinhaDaTabela[3] = exemplar.getLivro().getAno();
			novaLinhaDaTabela[4] = exemplar.getId();

			model.addRow(novaLinhaDaTabela);
		}

	}

}
