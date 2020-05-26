package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class MainView extends JFrame {

	private static final PainelTelefone painelTelefone = new PainelTelefone();
	private static final PainelPesquisaGeral painelPesquisaGeral = new PainelPesquisaGeral();
	private static JLayeredPane layeredPane;
	private JPanel panelMenuLateral;
	private JButton btnAcervo;
	private JButton btnPesquisaGeral;
	private JButton buttonEmprestimos;

	public MainView() {

		this.setTitle("Principal Menu");
		this.setBounds(100, 100, 1163, 739);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new MigLayout("", "[75px][grow]", "[grow]"));

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane.setBackground(new Color(64, 64, 64));
		layeredPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		layeredPane.add(painelTelefone, "cell 0 0");
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

		layeredPane.removeAll();
		panel.setBackground(Color.WHITE);
		panel.repaint();
		panel.revalidate();
		layeredPane.add(panel, "grow");
		layeredPane.repaint();
		layeredPane.revalidate();

	}

	private void initialize() {

		panelMenuLateral = new JPanel();
		panelMenuLateral.setBackground(Color.GRAY);
		panelMenuLateral.setLayout(null);
		this.getContentPane().add(panelMenuLateral, "cell 0 0,grow");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(229, 229, 229, 240));
		menuBar.setLayout(new GridLayout(10, 1));
		menuBar.setBounds(0, 0, 75, 758);
		panelMenuLateral.add(menuBar);

		btnPesquisaGeral = new JButton("");
		ImageIcon iconSearchMenu = new ImageIcon(MenuAtlas.class.getResource("/icons/searchFine.png"));
		Image imageSearchMenu = iconSearchMenu.getImage();
		Image newimgIconSearchMenu= imageSearchMenu.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconSearchMenu = new ImageIcon(newimgIconSearchMenu);
		btnPesquisaGeral.setBackground(new Color(229, 229, 229, 240));
		btnPesquisaGeral.setIcon(iconSearchMenu);
		menuBar.add(btnPesquisaGeral);

		ImageIcon iconBooksMenu = new ImageIcon(MenuAtlas.class.getResource("/icons/books.png"));
		Image imageIconBooksMenu = iconBooksMenu.getImage();
		Image newimgIconBooksMenu = imageIconBooksMenu.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconBooksMenu = new ImageIcon(newimgIconBooksMenu);

		btnAcervo = new JButton("");
		btnAcervo.setBackground(new Color(229, 229, 229, 240));
		btnAcervo.setIcon(iconBooksMenu);
		menuBar.add(btnAcervo);
		
		buttonEmprestimos = new JButton("");
		ImageIcon iconEmprestimoMenu = new ImageIcon(MenuAtlas.class.getResource("/icons/verify.png"));
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
				switchPanel(painelTelefone);
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