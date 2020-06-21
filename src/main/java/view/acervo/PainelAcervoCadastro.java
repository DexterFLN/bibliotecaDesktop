package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ExemplarController;
import controller.LivroController;
import model.vo.Livro;
import model.vo.Sessao;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JButton btnCadastrar;
	private JTextField txtEdicao;
	private JComboBox cbSessao;
	private JComboBox cbAno;
	private JComboBox cbQuantidade;

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][35.00px][29.00][38.00px][27.00px][38.00px][29.00px][38.00][29.00px][29.00px][37.00][grow][][]"));
		
		JLabel lblTitulo = new JLabel("Título");
		add(lblTitulo, "cell 1 1,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		txtTitulo.setText("");
		add(txtTitulo, "cell 1 2 2 1,grow");
		txtTitulo.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 3,alignx left,aligny center");
		
		JLabel lblEdicao = new JLabel("Edição");
		add(lblEdicao, "cell 3 3");
		
		txtEditora = new JTextField();
		txtEditora.setText("");
		add(txtEditora, "cell 1 4 2 1,grow");
		txtEditora.setColumns(10);
		
		txtEdicao = new JTextField();
		add(txtEdicao, "cell 3 4,grow");
		txtEdicao.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 5,alignx left,aligny center");
		
		JLabel lblQuantidade = new JLabel("Quantidade de Exemplares");
		add(lblQuantidade, "cell 3 5");
		
		txtAutor = new JTextField();
		txtAutor.setText("");
		add(txtAutor, "cell 1 6 2 1,grow");
		txtAutor.setColumns(10);
		
		cbQuantidade = new JComboBox();
		for(int i = 1; i <= 20; i++) {
			cbQuantidade.addItem("" + i + "");
			add(cbQuantidade, "cell 3 6,grow");
		}
		
		JLabel lblSessao = new JLabel("Sessão");
		add(lblSessao, "cell 1 7,alignx left,aligny center");
		
		JLabel lblAno = new JLabel("Ano");
		add(lblAno, "cell 3 1,alignx left,aligny center");
		
		cbAno = new JComboBox();
		for(int i = 1990; i <= 2020; i++) {
			cbAno.addItem("" + i + "");
			add(cbAno, "cell 3 2,grow");
		}
		
		cbSessao = new JComboBox();
		cbSessao.addItem("Ficção");
		cbSessao.addItem("Literatura Clássica");
		cbSessao.addItem("Romance");
		cbSessao.addItem("Auto Ajuda");
		cbSessao.addItem("Suspense");
		cbSessao.addItem("Técnicos");
		
		add(cbSessao, "cell 1 8 3 1,grow");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 2 10,grow");
		
		this.addListeners();

	}
	
	private void addListeners() {
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Cadastrar livro '" + txtTitulo.getText() +"'?", "Cadastrar Livro", JOptionPane.YES_NO_CANCEL_OPTION);
				String mensagem = "";
				LivroController livroController = new LivroController();
				ExemplarController exemplarController = new ExemplarController();
				Sessao sessao = new Sessao();
				Livro livro;
				sessao.setId(livroController.validarSessao((String) cbSessao.getSelectedItem()));
				mensagem += livroController.validarCampos(txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(), txtEdicao.getText());
				if(mensagem.isEmpty()) {
					livro = livroController.salvarLivro(txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(), txtEdicao.getText(), (String) cbAno.getSelectedItem(), sessao);
					exemplarController.salvarExemplar(livro, (String)cbQuantidade.getSelectedItem(), false);
				}
			}
		});
		
	}
}
