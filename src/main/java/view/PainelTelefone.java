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
		setLayout(null);
		
		JLabel lblCodigoDoPas = new JLabel("Código do País:");
		lblCodigoDoPas.setBounds(34, 32, 110, 15);
		add(lblCodigoDoPas);
		
		textCodPais = new JTextField();
		textCodPais.setBounds(163, 29, 237, 21);
		add(textCodPais);
		textCodPais.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(163, 68, 237, 21);
		txtDdd.setColumns(10);
		add(txtDdd);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(34, 108, 146, 15);
		add(lblNumero);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(34, 71, 35, 15);
		add(lblDdd);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(163, 105, 237, 21);
		add(txtNumero);
		
		chckbxMovel = new JCheckBox("Móvel");
		chckbxMovel.setBounds(163, 171, 129, 23);
		add(chckbxMovel);
		
		
		JLabel lblDonoopcional = new JLabel("Dono:  (opcional)");
		lblDonoopcional.setBounds(34, 140, 129, 15);
		add(lblDonoopcional);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(163, 224, 237, 25);
		add(btnLimpar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(34, 224, 117, 25);
		add(btnSalvar);

	}
}
