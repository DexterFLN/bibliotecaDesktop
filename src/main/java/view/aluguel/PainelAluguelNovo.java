package view.aluguel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PainelAluguelNovo extends JPanel {
		private JTextField txtTitulo;
		private JButton btnCadastrar;
		private JTextField txtCodigoLivro;
		private JTextField textField;
		private JTextField txtCodigoUser;
		private JTextField txtNome;
		private JTextField txtRosseto;
		private JTextField txtDataNascimento;

		/**
		 * Create the panel.
		 */
		public PainelAluguelNovo() {
				setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][29.00][35.00px][27.00][34.00px][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));
				
				JLabel lblExcluir = new JLabel("Digite o código do Livro");
				add(lblExcluir, "cell 1 1,alignx center,aligny center");
				
				txtCodigoLivro = new JTextField();
				txtCodigoLivro.setText("4127653");
				add(txtCodigoLivro, "cell 2 1,grow");
				txtCodigoLivro.setColumns(10);
				
				
				JButton btnPesquisar = new JButton("Pesquisar");
				add(btnPesquisar, "cell 3 1,grow");

				JLabel lblTitulo = new JLabel("Titulo");
				add(lblTitulo, "cell 1 2,alignx left,aligny center");

				txtTitulo = new JTextField();
				txtTitulo.setText("Deuses do Olimpo");
				add(txtTitulo, "cell 1 3 2 1,grow");
				txtTitulo.setColumns(10);

				JLabel lblAutor = new JLabel("Data Devolução");
				add(lblAutor, "cell 3 2,alignx left,aligny center");
				
				textField = new JTextField();
				textField.setText("25/06/2020");
				add(textField, "cell 3 3,grow");
				textField.setColumns(10);
				
				JLabel lblDigiteOCdigo = new JLabel("Digite o código do Usuário");
				add(lblDigiteOCdigo, "cell 1 5,alignx center,aligny center");
				
				txtCodigoUser = new JTextField();
				txtCodigoUser.setText("09630985");
				add(txtCodigoUser, "cell 2 5,grow");
				txtCodigoUser.setColumns(10);
				
				JButton btnPesquisarUser = new JButton("Pesquisar Usuário");
				add(btnPesquisarUser, "cell 3 5,grow");
				
				JLabel lblNome = new JLabel("Nome");
				add(lblNome, "cell 1 6");
				
				JLabel lblSobrenome = new JLabel("Sobrenome");
				add(lblSobrenome, "cell 2 6,alignx left");
				
				txtNome = new JTextField();
				txtNome.setText("Vitor");
				add(txtNome, "cell 1 7,grow");
				txtNome.setColumns(10);
				
				txtRosseto = new JTextField();
				txtRosseto.setText("Ribeiro");
				add(txtRosseto, "cell 2 7,grow");
				txtRosseto.setColumns(10);
				
				txtDataNascimento = new JTextField();
				txtDataNascimento.setText("19/01/2000");
				add(txtDataNascimento, "cell 3 7,grow");
				txtDataNascimento.setColumns(10);
				
				JButton btnAlugar = new JButton("Alugar");
				add(btnAlugar, "cell 2 11,grow");

				this.addListeners();

			}
		
		private void addListeners() {
			
		}
	}
