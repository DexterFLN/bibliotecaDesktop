package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class MenuJframe extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuLateral;
	private JPanel painelDireito;
	private JMenuBar menuBar;
	private PainelPesquisaGeral painelPesquisaGeral = null;
	private static final PainelTelefone painelTelefone = new PainelTelefone() ;
	private JButton btnAcervo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJframe frameMenu = new MenuJframe();
					frameMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public MenuJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);

		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDosPaineis = (int) ((dimensoesTela.getWidth()) / 20);
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		System.out.println(larguraDosPaineis);
		System.out.println(alturaDaTela);
		contentPane.setLayout(new MigLayout("", "[131.00px][627.00]", "[758px]"));

		panelMenuLateral = new JPanel();
		panelMenuLateral.setBackground(Color.GRAY);
		panelMenuLateral.setLayout(null);
		contentPane.add(panelMenuLateral, "cell 0 0,grow");

		menuBar = new JMenuBar();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new java.awt.Color(229, 229, 229, 240));
		menuBar.setLayout(new GridLayout(10, 1));
		menuBar.setBounds(0, 0, 109, 758);
		panelMenuLateral.add(menuBar);
		
		btnAcervo = new JButton("acervo");
		btnAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		menuBar.add(btnAcervo);

		painelDireito = new JPanel();
		painelDireito.setBorder(new EmptyBorder(2, 2, 2, 2));
		getContentPane().add(painelDireito, "cell 0 0,alignx left,aligny top");

	}
}
