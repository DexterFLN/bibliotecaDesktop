package view.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.LivroController;
import net.miginfocom.swing.MigLayout;

public class PainelAcervoCadastro extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JButton btnCadastrar;
	private JTextField txtEdicao;
	private JComboBox cbSessao;
	private JComboBox cbAno;

	/**
	 * Create the panel.
	 */
	public PainelAcervoCadastro() {
		setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][35.00px][29.00][38.00px][27.00px][38.00px][29.00px][38.00][29.00px][29.00px][37.00][grow][]"));
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "cell 1 1,alignx left,aligny center");
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Mitologia N√≥rdica");
		add(txtTitulo, "cell 1 2 3 1,grow");
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		add(lblAutor, "cell 1 3,alignx left,aligny center");
		
		txtAutor = new JTextField();
		txtAutor.setText("Neil Gaiman");
		add(txtAutor, "cell 1 4 2 1,grow");
		txtAutor.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		add(lblEditora, "cell 1 5,alignx left,aligny center");
		
		JLabel lblEdicao = new JLabel("Edi\u00E7\u00E3o");
		add(lblEdicao, "cell 3 5");
		
		txtEditora = new JTextField();
		txtEditora.setText("Intr√≠nseca");
		add(txtEditora, "cell 1 6 2 1,grow");
		txtEditora.setColumns(10);
		
		txtEdicao = new JTextField();
		add(txtEdicao, "cell 3 6,growx");
		txtEdicao.setColumns(10);
		
		JLabel lblSessao = new JLabel("Sesssao");
		add(lblSessao, "cell 1 7,alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Ano");
		add(lblNewLabel_3, "cell 3 3,alignx left,aligny center");
		
		cbAno = new JComboBox();
		for(int i = 1990; i <= 2020; i++) {
			cbAno.addItem("" + i + "");
			add(cbAno, "cell 3 4,grow");
		}
		//cbAno.addItem("2019");
		//add(cbAno, "cell 3 4,grow");
		
		cbSessao = new JComboBox();
		cbSessao.addItem("FicÁ„o");
		cbSessao.addItem("Literatura Cl·ssica");
		cbSessao.addItem("Romance");
		cbSessao.addItem("Auto Ajuda");
		cbSessao.addItem("Suspense");
		cbSessao.addItem("TÈcnicos");
		
		add(cbSessao, "cell 1 8 3 1,grow");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "cell 2 10,grow");
		
		this.addListeners();

	}
	
	private void addListeners() {
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Cadastrar livro 'Exemplo'?", "Cadastrar Livro", JOptionPane.YES_NO_CANCEL_OPTION);
				String mensagem = "";
				LivroController controller = new LivroController();
				int sessao = controller.validarSessao((String) cbSessao.getSelectedItem());
				mensagem += controller.validarCampos(txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(), txtEdicao.getText());
				if(mensagem.isEmpty()) {
					controller.salvarLivro(txtTitulo.getText(), txtAutor.getText(), txtEditora.getText(), txtEdicao.getText(), (String) cbAno.getSelectedItem(), sessao);
				}
			}
		});
		
	}
}
