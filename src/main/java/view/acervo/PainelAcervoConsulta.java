package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import model.seletor.LivroSeletor;
import model.vo.Exemplar;
import net.miginfocom.swing.MigLayout;
import util.Utils;

public class PainelAcervoConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
<<<<<<< HEAD
	private String[] nomesColunas = { "Título", "Autor", "Ano", "Exemplares" };
	private ArrayList<Livro> livros;
=======
	private String[] nomesColunas = { "Título", "Autor", "Editora", "Ano", "Código" };
	private ArrayList<Exemplar> exemplares;
>>>>>>> 97c2d2f0be9874defe906b3f6fe040744a53c623
	private JComboBox cbAno;
	private JComboBox cbBuscar;

	/**
	 * Create the panel.
	 */
	public PainelAcervoConsulta() {

		setLayout(new MigLayout("",
				"[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]",
				"[31.00px][30.00px][544.00px]"));

		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
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
<<<<<<< HEAD

	}

	private void preenchercbAno() {
		for (int i = 2020; i >= 1500; i--) {
			cbAno.addItem(i);
		}
	}

	private void preenchercbBuscarPor() {
		cbBuscar.addItem("Autor");
		cbBuscar.addItem("Título");
		cbBuscar.addItem("Editora");
		cbBuscar.addItem("Sessão");
=======

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

>>>>>>> 97c2d2f0be9874defe906b3f6fe040744a53c623
	}

}
