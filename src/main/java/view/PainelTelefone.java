package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class PainelTelefone extends JPanel {
	private JTextField textCodPais;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cmbClientes;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JCheckBox chckbxMovel;

	/**
	 * Create the panel.
	 */
	public PainelTelefone() {
		setLayout(new MigLayout("", "[129px][237px]", "[21px][21px][21px][15px][23px][25px]"));
		
		JLabel lblCodigoDoPas = new JLabel("Código do País:");
		add(lblCodigoDoPas, "cell 0 0,alignx left,aligny center");
		
		textCodPais = new JTextField();
		add(textCodPais, "cell 1 0,grow");
		textCodPais.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setColumns(10);
		add(txtDdd, "cell 1 1,grow");
		
		JLabel lblNumero = new JLabel("Número:");
		add(lblNumero, "cell 0 2 2 1,alignx left,aligny center");
		
		JLabel lblDdd = new JLabel("DDD:");
		add(lblDdd, "cell 0 1,alignx left,aligny center");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		add(txtNumero, "cell 1 2,grow");
		
		chckbxMovel = new JCheckBox("Móvel");
		add(chckbxMovel, "cell 1 4,alignx left,aligny top");
		
		
		JLabel lblDonoopcional = new JLabel("Dono:  (opcional)");
		add(lblDonoopcional, "cell 0 3,growx,aligny top");
		
		btnLimpar = new JButton("Limpar");
		add(btnLimpar, "cell 1 5,growx,aligny top");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnSalvar, "cell 0 5,growx,aligny top");

	}
}
