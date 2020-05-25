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

public class MenuJframe extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuLateral;
	private JPanel painelDireito;
	private JMenuBar menuBar;
	private JMenuItem mntmMenu;
	private JMenuItem mntmAcervo;
	private PainelPesquisaGeral painelPesquisaGeral = null;
	private static final PainelTelefone painelTelefone = new PainelTelefone() ;

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
		contentPane.setLayout(null);

		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDosPaineis = (int) ((dimensoesTela.getWidth()) / 20);
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		System.out.println(larguraDosPaineis);
		System.out.println(alturaDaTela);

		panelMenuLateral = new JPanel();
		panelMenuLateral.setBackground(Color.GRAY);
		panelMenuLateral.setLayout(null);
//		panelMenuLateral.setBounds(0, 0, larguraDosPaineis, alturaDaTela);
		panelMenuLateral.setBounds(0, 0, 75, 758);
		contentPane.add(panelMenuLateral);

		menuBar = new JMenuBar();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new java.awt.Color(229, 229, 229, 240));
		menuBar.setLayout(new GridLayout(10, 1));
		menuBar.setBounds(0, 0, 75, 758);

		
		
		mntmAcervo = new JMenuItem("Acervo");
		mntmAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setContentPane(painelTelefone);
				revalidate();
				
//				painelPesquisaGeral = new PainelPesquisaGeral();
//				setContentPane(painelPesquisaGeral);
//				getContentPane().add(painelPesquisaGeral);
//				revalidate();
//				if(painelPesquisaGeral == null) {
//					painelPesquisaGeral = new PainelPesquisaGeral();
//					painelDireito.add(painelPesquisaGeral);
//					painelDireito.revalidate();
//				}else {
//					painelDireito.setVisible(true);
//				}
			}
		});
		menuBar.add(mntmAcervo);
//		setJMenuBar(menuBar);
//		contentPane.add(menuBar);

		mntmMenu = new JMenuItem("Menu");
		menuBar.add(mntmMenu);
		panelMenuLateral.add(menuBar);

		painelDireito = new JPanel();
		painelDireito.setBorder(new EmptyBorder(2, 2, 2, 2));
		painelDireito.setBounds(larguraDosPaineis, 0, larguraDosPaineis * 19, alturaDaTela);
		getContentPane().add(painelDireito);

	}
}
