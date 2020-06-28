package view.acervo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LivroController;
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
	private JComboBox cbAno;
	private JComboBox cbQuantidade;
	private JTextField txtCodigo;

	/**
	 * Create the panel.
	 */
	public PainelAcervoAlterar() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px][218px,grow,center][172.00px][144px,grow]",
				"[45.00px][35.00px][29.00][38.00px][27.00px][38.00px][29.00px][38.00][29.00px][29.00px][37.00][grow][][]"));

		JLabel lblDigiteCodigo = new JLabel("Digite o C\u00F3digo");
		add(lblDigiteCodigo, "cell 1 1,alignx left");

		txtCodigo = new JTextField();
		add(txtCodigo, "cell 2 1,grow");
		txtCodigo.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroController livroController = new LivroController();
				Livro livro = new Livro();

				int idLivro = Integer.valueOf(txtCodigo.getText());
				livro = livroController.consultarLivroPorId(idLivro);
				txtTitulo.setText(livro.getNome());
				txtEditora.setText(livro.getEditora());
				txtAutor.setText(livro.getAutor());
				txtEdicao.setText(Integer.toString(livro.getEdicao()));
				cbSessao.setSelectedItem(livro.getSessao());
				cbAno.setSelectedItem(livro.getAno());

			}
		});
		add(btnPesquisar, "cell 3 1,alignx center,growy");

		JLabel lblTitulo = new JLabel("T�tulo");
		add(lblTitulo, "cell 1 2,alignx left,aligny center");

		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 2,alignx left,aligny center");

		txtTitulo = new JTextField();
		add(txtTitulo, "cell 1 3 2 1,grow");
		txtTitulo.setColumns(10);

		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 4,alignx left,aligny center");

		JLabel lblEdicao = new JLabel("Edi��o");
		add(lblEdicao, "cell 3 4");

		txtEditora = new JTextField();
		add(txtEditora, "cell 1 5 2 1,grow");
		txtEditora.setColumns(10);

		cbQuantidade = new JComboBox();
		for (int i = 1; i <= 20; i++) {
			cbQuantidade.addItem("" + i + "");
			add(cbQuantidade, "cell 3 7,grow");
		}

		cbAno = new JComboBox();
		for (int i = 1990; i <= 2020; i++) {
			cbAno.addItem("" + i + "");
			add(cbAno, "cell 3 3,grow");
		}

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

		JLabel lblSessao = new JLabel("Sess�o");
		add(lblSessao, "cell 1 8,alignx left,aligny center");

		cbSessao = new JComboBox();
		cbSessao.addItem("Fic��o");
		cbSessao.addItem("Literatura Cl�ssica");
		cbSessao.addItem("Romance");
		cbSessao.addItem("Auto Ajuda");
		cbSessao.addItem("Suspense");
		cbSessao.addItem("T�cnicos");

		add(cbSessao, "cell 1 9 3 1,grow");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnSalvarAlteraes = new JButton("Salvar Alterações");
		btnSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroController livroController = new LivroController();
				String ano = (String) cbAno.getSelectedItem();
				livroController.salvarLivro(txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(),
						txtEdicao.getText(), ano, (Sessao) cbSessao.getSelectedItem());
			}
		});
		btnSalvarAlteraes.setBackground(new Color(173, 255, 47));
		add(btnSalvarAlteraes, "cell 2 10,aligny center");
		btnExcluir.setBackground(new Color(229, 13, 13, 90));
		add(btnExcluir, "cell 3 10,growx");

	}

	private void preenchercbAno() {
		for (int i = 2020; i >= 1500; i--) {
			cbAno.addItem(i);
		}
	}

}
