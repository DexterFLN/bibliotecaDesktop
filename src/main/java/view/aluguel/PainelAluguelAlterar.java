package view.aluguel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PainelAluguelAlterar extends JPanel {
		private JTextField txtTitulo;
		private JButton btnCadastrar;
		private JTextField txtCodigoLivro;
		private JTextField textField;
		private JTextField txtNome;
		private JTextField txtRosseto;
		private JTextField txtDataNascimento;

		/**
		 * Create the panel.
		 */
		public PainelAluguelAlterar() {
				setLayout(new MigLayout("", "[159.00px,grow,fill][100px:154.00px,grow][218px,grow,center][172.00px,grow][144px,grow]", "[45.00px][29.00][35.00px][27.00][27.00px][19.00px][30.00px][][30.00px][29.00px][37.00][grow][]"));
				
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
				
				JLabel lblNome = new JLabel("Nome");
				add(lblNome, "cell 1 5");
				
				JLabel lblSobrenome = new JLabel("Sobrenome");
				add(lblSobrenome, "cell 2 5,alignx left");
				
				JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
				add(lblDataDeNascimento, "cell 3 5");
				
				txtNome = new JTextField();
				txtNome.setText("Vitor");
				add(txtNome, "cell 1 6,grow");
				txtNome.setColumns(10);
				
				txtRosseto = new JTextField();
				txtRosseto.setText("Ribeiro");
				add(txtRosseto, "cell 2 6,grow");
				txtRosseto.setColumns(10);
				
				txtDataNascimento = new JTextField();
				txtDataNascimento.setText("19/01/2000");
				add(txtDataNascimento, "cell 3 6,grow");
				txtDataNascimento.setColumns(10);
				
				JButton btnRenovar = new JButton("Renovar");
				btnRenovar.setBackground(new Color(173, 255, 47));
				add(btnRenovar, "cell 1 10,grow");

				JButton btnDevolver = new JButton("Devolver");
				btnDevolver.setBackground(new Color(229, 13, 13, 90));
				add(btnDevolver, "cell 3 10,grow");

				this.addListeners();

			}
		
		private void addListeners() {
			
		}
	}
