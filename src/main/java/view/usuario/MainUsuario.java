package view.usuario;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class MainUsuario extends JPanel {

	protected JPanel painelUsuarioConsulta = new PainelUsuarioConsulta();
	protected JPanel painelUsuarioCadastro = new PainelUsuarioCadastro();
	protected JPanel painelUsuarioAlterar = new PainelUsuarioAlterar(null);
	private static JLayeredPane layeredPane;
	private JMenuBar menuBar;
	private JMenuItem mntmCadastro;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmAlterar;

	/**
	 * Create the panel.
	 */
	public MainUsuario() {
		setLayout(new MigLayout("", "[735.00,grow][grow]", "[49.00px][grow]"));

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

		mntmAlterar = new JMenuItem("Alterar");
		menuBar.add(mntmAlterar);

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		add(layeredPane, "cell 0 1 15 11,grow");

		layeredPane.add(painelUsuarioConsulta, "cell 0 0,grow");

		this.addListeners();
	}

	private void addListeners() {

		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelUsuarioCadastro);
			}
		});

		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelUsuarioConsulta);
			}
		});

		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(painelUsuarioAlterar);
			}
		});

	}

	protected static void switchPanel(JPanel panel) {
		System.out.println(panel.getClass());

		layeredPane.removeAll();
		panel.setBackground(Color.WHITE);
		panel.repaint();
		panel.revalidate();
		layeredPane.add(panel, "grow");
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	
}
