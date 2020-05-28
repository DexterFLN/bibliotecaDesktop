package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PainelDevolucaoLivro extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PainelDevolucaoLivro() {
//		setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.UNRELATED_GAP_COLSPEC,
//				ColumnSpec.decode("101px"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("max(178dlu;default):grow"),},
//			new RowSpec[] {
//				FormSpecs.UNRELATED_GAP_ROWSPEC,
//				RowSpec.decode("22px"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "2, 2, fill, top");
		
		JMenu mnVoltar = new JMenu("Voltar");
		menuBar.add(mnVoltar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		add(lblTitulo, "2, 6");
		
		textField_2 = new JTextField();
		add(textField_2, "8, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblDataDevolucao = new JLabel("Data da devolucao");
		add(lblDataDevolucao, "2, 10");
		
		textField_1 = new JTextField();
		textField_1.setText("2020/05/15");
		add(textField_1, "8, 10, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		add(lblCodigo, "2, 14");
		
		textField = new JTextField();
		add(textField, "8, 14, fill, default");
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		add(lblUsuario, "2, 18");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "8, 18, fill, default");
		
	}

}
