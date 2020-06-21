package view.usuario;

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

import controller.UsuarioController;
import model.seletor.UsuarioSeletor;
import model.vo.Usuario;
import net.miginfocom.swing.MigLayout;

public class PainelUsuarioConsulta extends JPanel {
	private JTextField txtPesquisar;
	private JTable tableResultadoPesquisa;
	private JButton btnPesquisar;
	private JComboBox cbBuscarPor;
	private JLabel lblBuscarPor;
	private String[] nomesColunas = {"Código", "Nome", "Sobrenome", "Tipo", "Data de Nascimento", "Email", "Telefone Fixo", "Telefone Movel"};
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Create the panel.
	 */
	public PainelUsuarioConsulta() {
setLayout(new MigLayout("", "[][93.00px,grow][146.00px,grow][79.00px,grow][134.00px,grow][grow][41px,grow,right][144px,grow][92px]", "[31.00px][30.00px][544.00px]"));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setText("Digite um termo para Pesquisa");
		add(txtPesquisar, "cell 1 0 6 1,grow");
		txtPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		add(btnPesquisar, "cell 7 0,grow");
		
		lblBuscarPor = new JLabel("Buscar Por:");
		add(lblBuscarPor, "cell 1 1,alignx trailing");
		
		cbBuscarPor = new JComboBox();
		cbBuscarPor.addItem("Nome");
		cbBuscarPor.addItem("Código");
		add(cbBuscarPor, "cell 2 1,growx");
		
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
				UsuarioSeletor usuarioSeletor = new UsuarioSeletor();
				usuarioSeletor.setBuscarPor(cbBuscarPor.getSelectedItem().toString());
				usuarioSeletor.setTermoPesquisa(txtPesquisar.getText());
				
				UsuarioController usuarioController = new UsuarioController();
				usuarios = usuarioController.consultarUsuarioPorFiltro(usuarioSeletor);
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
		
		for (Usuario usuario : usuarios) {
			
			Object[] novaLinhaDaTabela = new Object[8];
			novaLinhaDaTabela[0] = usuario.getId();
			novaLinhaDaTabela[1] = usuario.getNome();
			novaLinhaDaTabela[2] = usuario.getSobrenome();
			novaLinhaDaTabela[3] = usuario.getTipo();
			novaLinhaDaTabela[4] = usuario.getDataNascimento();
			novaLinhaDaTabela[5] = usuario.getEmail();
			novaLinhaDaTabela[6] = usuario.getDddFixo() + usuario.getFoneFixo();
			novaLinhaDaTabela[7] = usuario.getDddMovel() + usuario.getFoneMovel();
			
			model.addRow(novaLinhaDaTabela);
		}
		
	}

}


