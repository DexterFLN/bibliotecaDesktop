package view.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.AluguelController;
import model.dao.AluguelDAO;
import model.dao.ExemplarDAO;
import model.dao.UsuarioDAO;
import model.vo.Aluguel;
import model.vo.Exemplar;
import model.vo.Usuario;
import net.miginfocom.swing.MigLayout;
import util.ConversorData;

public class PainelAluguelNovo extends JPanel {
		private JTextField txtTitulo;
		private JButton btnCadastrar;
		private JTextField txtCodigoLivro;
		private JTextField txtCodigoUser;
		private JTextField txtNome;
		private JTextField txtSobrenome;
		private JFormattedTextField txfDataNascimento;
		private JFormattedTextField txfDataDevolucao;
		private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		
		/**
		 * Create the panel.
		 * @throws ParseException 
		 */
		public PainelAluguelNovo() {
				setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][29.00][35.00px][27.00][34.00px][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));
				
				JLabel lblExcluir = new JLabel("Digite o c\u00F3digo do Exemplar");
				add(lblExcluir, "cell 1 1,alignx center,aligny center");
				
				txtCodigoLivro = new JTextField();
				txtCodigoLivro.setText("");
				add(txtCodigoLivro, "cell 2 1,grow");
				txtCodigoLivro.setColumns(10);
				
				JButton btnPesquisarLivro = new JButton("Pesquisar Livro");
				btnPesquisarLivro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ExemplarDAO dao = new ExemplarDAO();
						Exemplar exemplarSelecionado = new Exemplar();
						exemplarSelecionado.setId(Integer.valueOf(txtCodigoLivro.getText()));
						exemplarSelecionado = dao.consultarExemplar(exemplarSelecionado.getId());
						txtTitulo.setText(exemplarSelecionado.getLivro().getNome());
					}
				});
				add(btnPesquisarLivro, "cell 3 1,grow");

				JLabel lblTitulo = new JLabel("T\u00EDtulo");
				add(lblTitulo, "cell 1 2,alignx left,aligny center");
				
				JLabel lblDataDevolucao = new JLabel("Data Devolu\u00E7\u00E3o:");
				add(lblDataDevolucao, "cell 3 2");

				txtTitulo = new JTextField();
				txtTitulo.setText("");
				add(txtTitulo, "cell 1 3 2 1,grow");
				txtTitulo.setColumns(10);

				
				
				try {
					
					MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
					txfDataDevolucao = new JFormattedTextField(maskFormatter);
					add(txfDataDevolucao, "cell 3 3,grow");
				} catch (ParseException e1){
					 System.out.println("Erro na máscara de formatação de data no painel de cadastro de usuário.");
			         e1.printStackTrace();
				}
				
				
			
				
				
				
				
				
				
								
				JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo do Usu\u00E1rio");
				add(lblDigiteOCdigo, "cell 1 5,alignx center,aligny center");
				
				txtCodigoUser = new JTextField();
				txtCodigoUser.setText("");
				add(txtCodigoUser, "cell 2 5,grow");
				txtCodigoUser.setColumns(10);
				txtCodigoUser.setEnabled(false);
				
				
				JButton btnPesquisarUsuario = new JButton("Pesquisar Usu\u00E1rio");
				btnPesquisarUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						UsuarioDAO dao = new UsuarioDAO();
						Usuario usuarioSelecionado = new Usuario();
						ArrayList<Usuario> usuarios = dao.consultarTodosUsuarios(10);

						
						usuarioSelecionado = (Usuario) JOptionPane.showInputDialog(null, "Selecione um usuário", "Usuários",
								JOptionPane.QUESTION_MESSAGE, null, usuarios.toArray(), null);
						txtCodigoUser.setText(Integer.toString(usuarioSelecionado.getId())); 
						txtNome.setText(usuarioSelecionado.getNome());
						txtSobrenome.setText(usuarioSelecionado.getSobrenome());
						LocalDate nascimento = usuarioSelecionado.getDataNascimento();
						String formattedDate = nascimento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
						txfDataNascimento.setText(formattedDate);
						txtCodigoUser.setEnabled(false);
						
					}
				});
				add(btnPesquisarUsuario, "cell 3 5,grow");
				
				JLabel lblNome = new JLabel("Nome");
				add(lblNome, "cell 1 6");
				
				JLabel lblSobrenome = new JLabel("Sobrenome");
				add(lblSobrenome, "cell 2 6,alignx left");
				
				JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
				add(lblDataDeNascimento, "cell 3 6");
				
				txtNome = new JTextField();
				txtNome.setText("");
				add(txtNome, "cell 1 7,grow");
				txtNome.setColumns(10);
				
				txtSobrenome = new JTextField();
				txtSobrenome.setText("");
				add(txtSobrenome, "cell 2 7,grow");
				txtSobrenome.setColumns(10);
				
				try {
					MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
					txfDataNascimento = new JFormattedTextField(maskFormatter);
					add(txfDataNascimento, "cell 3 7,grow");
					
					
					
				} catch (ParseException e1) {
					System.out.println("Erro na máscara de formatação de data no painel de cadastro de usuário.");
			        e1.printStackTrace();
				}
				

				JButton btnAlugar = new JButton("ALUGAR");
				btnAlugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AluguelController controller = new AluguelController();
						Aluguel aluguel = new Aluguel();
						Exemplar exemplar = new Exemplar();
						Usuario usuario = new Usuario();
						
						String mensagem = "";
						mensagem += controller.validarCamposAlugar(txtCodigoLivro.getText(), txtCodigoUser.getText(), txfDataDevolucao.getText());
						if(mensagem.isEmpty()) {
							exemplar.setId(Integer.parseInt(txtCodigoLivro.getText()));
							usuario.setId(Integer.parseInt(txtCodigoUser.getText()));
							aluguel.setDataLocacao(LocalDate.now());
							aluguel.setDevolucaoPrevista(ConversorData.converterTextoEmData(txfDataDevolucao.getText()));
							aluguel.setExemplar(exemplar);
							aluguel.setUsuario(usuario);
							
							try {
								controller.salvarAluguel(aluguel);
							} catch (Exception ex) {
								System.out.println("Erro ao registrar o aluguel: " + ex.getMessage());
							}
						}
						
							
					}
				});
				add(btnAlugar, "cell 2 11,grow");
				
			}
		
	}
