package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame {

	private static final PainelPesquisaGeral painelPesquisaGeral = new PainelPesquisaGeral();
	private static final PainelAcervoCadastro painelAcervoCadastro = new PainelAcervoCadastro();
	private static JLayeredPane layeredPane;
	private JPanel panelMenuLateral;
	private JButton btnAcervo;
	private JButton btnPesquisaGeral;
	private JButton buttonEmprestimos;
	private static JPanel panel_1;

	public MainView() {

		this.setTitle("Principal Menu");
		this.setBounds(0, 0, 1163, 739);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(2, 83, 83));
		this.getContentPane().setLayout(new MigLayout("", "[96.00,fill][grow]", "[grow]"));

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setBackground(new Color(2, 83, 83));
		layeredPane.setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(2, 83, 83));
		layeredPane.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[985.00px,grow,fill]", "[168px,grow,fill]"));
		panel_1.add(painelPesquisaGeral, "cell 0 0,alignx center,aligny top");
		getContentPane().add(layeredPane, "cell 1 0, grow");

		this.initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.setExtendedState(MAXIMIZED_BOTH);
					window.setBackground(new Color(64, 64, 64));
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void switchPanel(JPanel panel) {
		panel_1.removeAll();
		layeredPane.removeAll();
		
		layeredPane.setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		panel_1.setBackground(new Color(2, 83, 83));
		panel_1.revalidate();
		layeredPane.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[985.00px,grow,fill]", "[168px,grow,fill]"));
		panel_1.add(panel, "cell 0 0,alignx center,aligny top");
		layeredPane.revalidate();

//		layeredPane.removeAll();
//		panel.setBackground(Color.WHITE);
//		panel.repaint();
//		panel.revalidate();
//		layeredPane.add(panel, "grow");
//		layeredPane.repaint();
//		layeredPane.revalidate();

	}

	private void initialize() {

		panelMenuLateral = new JPanel();
		panelMenuLateral.setBackground(new Color(229, 229, 229, 240));
		panelMenuLateral.setBounds(0, 0, 1000, 900);
		this.getContentPane().add(panelMenuLateral, "cell 0 0,grow");
		panelMenuLateral.setLayout(new MigLayout("", "[75px]", "[758px]"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(229, 229, 229, 240));
		menuBar.setLayout(new GridLayout(10, 1));
		panelMenuLateral.add(menuBar, "cell 0 0,grow");

		btnPesquisaGeral = new JButton("");
		ImageIcon iconSearchMenu = new ImageIcon(MainView.class.getResource("/icons/searchFine.png"));
		Image imageSearchMenu = iconSearchMenu.getImage();
		Image newimgIconSearchMenu= imageSearchMenu.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconSearchMenu = new ImageIcon(newimgIconSearchMenu);
		btnPesquisaGeral.setBackground(new Color(229, 229, 229, 240));
		btnPesquisaGeral.setIcon(iconSearchMenu);
		menuBar.add(btnPesquisaGeral);

		ImageIcon iconBooksMenu = new ImageIcon(MainView.class.getResource("/icons/books.png"));
		Image imageIconBooksMenu = iconBooksMenu.getImage();
		Image newimgIconBooksMenu = imageIconBooksMenu.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconBooksMenu = new ImageIcon(newimgIconBooksMenu);

		btnAcervo = new JButton("");
		btnAcervo.setBackground(new Color(229, 229, 229, 240));
		btnAcervo.setIcon(iconBooksMenu);
		menuBar.add(btnAcervo);
		
		buttonEmprestimos = new JButton("");
		ImageIcon iconEmprestimoMenu = new ImageIcon(MainView.class.getResource("/icons/verify.png"));
		Image imageEmprestimoMenu = iconEmprestimoMenu.getImage();
		Image newimgIconEmprestimoMenu = imageEmprestimoMenu.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconEmprestimoMenu = new ImageIcon(newimgIconEmprestimoMenu);
		buttonEmprestimos.setIcon(iconEmprestimoMenu);
		menuBar.add(buttonEmprestimos);

		this.addListeners();
	}

	private void addListeners() {

		btnPesquisaGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelPesquisaGeral);

			}
		});

		btnAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelAcervoCadastro);
			}
		});
	}

	private void arrumarTela() {
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDosPaineis = (int) ((dimensoesTela.getWidth()) / 20);
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		System.out.println(larguraDosPaineis);
		System.out.println(alturaDaTela);
	}
}