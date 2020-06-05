package view;


import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JMenuItem;

public class MainAcervo extends JPanel {
	private JPanel painelAcervoConsulta = new PainelAcervoConsulta();
	private static JPanel panel_1;
	private static JLayeredPane layeredPane;
	private JMenuBar menuBar;
	private JMenuItem mntmCadastro;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmExcluir;


	/**
	 * Create the panel.
	 */
	public MainAcervo() {
		setLayout(new MigLayout("", "[735.00,grow][grow]", "[49.00px,grow][grow]"));
		
        this.initialize();
		
	}
	public void initialize() {
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0 2 1,grow");
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		menuBar = new JMenuBar();
		panel.add(menuBar);
		
		mntmCadastro = new JMenuItem("Cadastro");
		menuBar.add(mntmCadastro);
		
		mntmConsultar = new JMenuItem("Consultar");
		menuBar.add(mntmConsultar);
		
		mntmExcluir = new JMenuItem("Excluir");
		menuBar.add(mntmExcluir);
		layeredPane = new JLayeredPane();
        layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        layeredPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
        add(layeredPane, "cell 0 1 15 11,grow");
        
        layeredPane.add(painelAcervoConsulta, "cell 0 0,grow");
    }
	
	private void addListeners() {
	}
	
//	private boolean switchPanel(JPanel panel) {
//		panel_1.removeAll();
//		layeredPane.removeAll();
//		
//		layeredPane.setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
//		panel_1.setBackground(new Color(2, 83, 83));
//		panel_1.revalidate();
//		layeredPane.add(panel_1, "cell 1 1,grow");
//		panel_1.setLayout(new MigLayout("", "[985.00px,grow,fill]", "[168px,grow,fill]"));
//		panel_1.add(panel, "cell 0 0,alignx center,aligny top");
//		layeredPane.revalidate();
//    }

}
