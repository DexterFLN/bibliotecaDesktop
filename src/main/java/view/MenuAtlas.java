package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuAtlas extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private TelaInternaPesquisaGeral telaInternaPesquisaGeral;
	private PainelPesquisaGeral painelPesquisaGeral;
	private PainelTelefone painelTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAtlas frame = new MenuAtlas();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuAtlas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1300, 100, 1050, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setBackground(new java.awt.Color(2, 83, 83));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new java.awt.Color(229, 229, 229, 240));
		menuBar.setLayout(new GridLayout(10,1, 0, -50));
		menuBar.setBounds(0, 0, 66, 1200);
		setJMenuBar(menuBar);
		contentPane.add(menuBar);
			
			JMenuItem mntmPesquisa = new JMenuItem("");
		mntmPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if (painelPesquisaGeral == null) {
//				painelPesquisaGeral = new PainelPesquisaGeral();
//				}
//				 if(!painelPesquisaGeral.isVisible()) {
//					setContentPane(painelPesquisaGeral);
//					revalidate();
//					painelPesquisaGeral.setVisible(true);
//				}
					
					painelTelefone = new PainelTelefone();
					setContentPane(painelTelefone);
					revalidate();
				
			}
		});
		
		ImageIcon iconSearchMenu = new ImageIcon(MenuAtlas.class.getResource("/icons/searchFine.png"));
		Image imageIconSearchMenu = iconSearchMenu.getImage();
		Image newimg = imageIconSearchMenu.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
		iconSearchMenu = new ImageIcon(newimg);
		
		mntmPesquisa.setIcon(iconSearchMenu);
		menuBar.add(mntmPesquisa);
		
			JMenuItem mntmLivros = new JMenuItem("");
		
		ImageIcon iconBooksMenu = new ImageIcon(MenuAtlas.class.getResource("/icons/books.png"));
		Image imageIconBooksMenu = iconBooksMenu.getImage();
		Image newimgIconBook = imageIconBooksMenu.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
		iconBooksMenu = new ImageIcon(newimgIconBook);
		
		mntmLivros.setIcon(iconBooksMenu);
		menuBar.add(mntmLivros);
		
//		desktopPane = new JDesktopPane();
//		desktopPane.setBounds(100, 50, 1000, 800);
//		getContentPane().add(desktopPane);
	}
}
