package view.aluguel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class MainAluguel extends JPanel {

	private JPanel painelAluguelConsulta = new PainelAluguelConsulta();
	private JPanel painelAluguelCadastro = new PainelAluguelNovo();
	private JPanel painelAluguelAlterar = new PainelAluguelAlterar(null);
	private static JLayeredPane layeredPane;
	private JMenuBar menuBar;
	private JMenuItem mntmNovo;
	private JMenuItem mntmConsultar;

	/**
	 * Create the panel.
	 */
	public MainAluguel() {
		setLayout(new MigLayout("", "[735.00,grow][grow]", "[49.00px][grow]"));

		this.initialize();

	}

	public void initialize() {

		JPanel panel = new JPanel();
		add(panel, "cell 0 0 2 1,grow");
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		menuBar = new JMenuBar();
		panel.add(menuBar);

		mntmConsultar = new JMenuItem("Consultar");
		menuBar.add(mntmConsultar);

		mntmNovo = new JMenuItem("Novo");
		menuBar.add(mntmNovo);

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		add(layeredPane, "cell 0 1 15 11,grow");

		layeredPane.add(painelAluguelConsulta, "cell 0 0,grow");

		this.addListeners();
	}

	private void addListeners() {

		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelAluguelCadastro);
			}
		});

		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelAluguelConsulta);
			}
		});
	}

	protected static void switchPanel(JPanel panel) {
 
		layeredPane.removeAll();
		panel.setBackground(Color.WHITE);
		panel.repaint();
		panel.revalidate();
		layeredPane.add(panel, "grow");
		layeredPane.repaint();
		layeredPane.revalidate();
	}

}
