package view.acervo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ExemplarController;
import controller.LivroController;
import controller.SessaoController;
import model.vo.Livro;
import model.vo.Sessao;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoAlterar extends JPanel {

	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtCodigoLivro;
	private JTextField txtEdicao;
	private JComboBox cbSessao;
	private JTextField txtCodigo;
	private JFormattedTextField txfAno;
	private JFormattedTextField txfQuantidade;

	/**
	 * Create the panel.
	 */
	public PainelAcervoAlterar(Livro livro) {
		setLayout(new MigLayout("",
				"[159.00px,grow,fill][100px:154.00px][218px,grow,center][172.00px,grow][144px,grow]",
				"[45.00px][35.00px][29.00][38.00px][27.00px][38.00px][29.00px][38.00][29.00px][29.00px][37.00][grow][][]"));

		JLabel lblDigiteCodigo = new JLabel("Digite o Codigo");
		add(lblDigiteCodigo, "cell 1 1,alignx center");

		txtCodigo = new JTextField();
		add(txtCodigo, "cell 2 1,grow");
		txtCodigo.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroController livroController = new LivroController();
				ExemplarController exemplarController = new ExemplarController();
				Livro livro = new Livro();

				int idLivro = Integer.valueOf(txtCodigo.getText());
				livro = livroController.consultarLivroPorId(idLivro);
				txtTitulo.setText(livro.getNome());
				txtEditora.setText(livro.getEditora());
				txtAutor.setText(livro.getAutor());
				txtEdicao.setText(Integer.toString(livro.getEdicao()));
				cbSessao.setSelectedItem(livro.getSessao());
				txfAno.setText(Integer.toString(livro.getAno()));
				// txfQuantidade.setText(Integer.toString(exemplarController.consultarQuantidade(idLivro)));

			}
		});
		add(btnPesquisar, "cell 3 1,grow");

		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 2,alignx left,aligny center");

		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 2,alignx left,aligny center");

		txtTitulo = new JTextField();
		add(txtTitulo, "cell 1 3 2 1,grow");
		txtTitulo.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("####");
			txfAno = new JFormattedTextField(maskFormatter);
			add(txfAno, "cell 3 3,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao de ano no painel de alterar livro.");
			e1.printStackTrace();
		}

		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 4,alignx left,aligny center");

		JLabel lblEdicao = new JLabel("Edicao");
		add(lblEdicao, "cell 3 4");

		txtEditora = new JTextField();
		add(txtEditora, "cell 1 5 2 1,grow");
		txtEditora.setColumns(10);

		txtEdicao = new JTextField();
		add(txtEdicao, "cell 3 5,grow");
		txtEdicao.setColumns(10);

		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 6,alignx left,aligny center");

		JLabel lblQuantidade = new JLabel("Quantidade de Exemplares");
		add(lblQuantidade, "cell 3 6");

		txtAutor = new JTextField();
		txtAutor.setHorizontalAlignment(SwingConstants.LEFT);
		add(txtAutor, "cell 1 7 2 1,grow");
		txtAutor.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("###");
			txfQuantidade = new JFormattedTextField(maskFormatter);
			add(txfQuantidade, "cell 3 7,grow");
		} catch (ParseException e1) {
			System.out.println("Erro na mascara de formatacao de quantidade no painel de alterar livro.");
			e1.printStackTrace();
		}

		JLabel lblSessao = new JLabel("Sessao");
		add(lblSessao, "cell 1 8,alignx left,aligny center");

		cbSessao = new JComboBox();
		cbSessao.addItem("Ficcao");
		cbSessao.addItem("Literatura Classica");
		cbSessao.addItem("Romance");
		cbSessao.addItem("Auto Ajuda");
		cbSessao.addItem("Suspense");
		cbSessao.addItem("Tecnicos");

		add(cbSessao, "cell 1 9 3 1,grow");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnSalvarAlteraes = new JButton("Salvar Alteracoes");
		btnSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroController livroController = new LivroController();
				// String ano = "ano";
				// livroController.salvarLivro(txtTitulo.getText(), txtAutor.getText(),
				// txtEditora.getText(),
				// txtEdicao.getText(), /*ano,*/ (Sessao) cbSessao.getSelectedItem());

				if (!ExemplarController
						.validarQuantidade(txfQuantidade, Integer.parseInt(txtCodigoLivro.getSelectedText()))
						.isEmpty()) {
					JOptionPane joptionpane = new JOptionPane();
					joptionpane.showMessageDialog(null, ExemplarController.validarQuantidade(txfQuantidade,
							Integer.parseInt(txtCodigoLivro.getSelectedText())));
				}
				;

			}
		});
		btnSalvarAlteraes.setBackground(new Color(173, 255, 47));
		add(btnSalvarAlteraes, "cell 2 10,grow");
		btnExcluir.setBackground(new Color(229, 13, 13, 90));
		add(btnExcluir, "cell 3 10,grow");
		
		this.preencherDadosDaTela(livro);

	}

	private void preencherDadosDaTela(Livro livro) {

		if(livro != null) {
			
//		txtCodigoLivro.setText(String.valueOf(livro.getId()));
		txtTitulo.setText(livro.getNome());
		txtAutor.setText(livro.getAutor());
		txtEditora.setText(livro.getEditora());
		txtEdicao.setText(String.valueOf(livro.getEdicao()));
		
		this.preencherSessao();
		cbSessao.setSelectedItem(livro.getSessao());
		
		txfAno.setText(String.valueOf(livro.getAno()));
		txfQuantidade.setText(String.valueOf(livro.getExemplares().size()));
		
		}

	}

	private void preencherSessao() {
		SessaoController sessaoController = new SessaoController();
		ArrayList<Sessao> sessoes = sessaoController.consultarSessoes(1000);
		
		for (Sessao sessao : sessoes) {
			cbSessao.addItem(sessao);
		}
		
	}

}
