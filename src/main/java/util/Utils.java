package util;

import javax.swing.JComboBox;

public class Utils {
	
	public static JComboBox preenchercbAno(JComboBox cbAno) {
		
		cbAno.addItem("SELECIONE");
		for (int i = 2020; i >= 1500; i--) {
			cbAno.addItem(i);
		}
		return cbAno;
	}
	
	public static JComboBox preenchercbBuscarPor(JComboBox cbBuscar) {

		cbBuscar.addItem("Título");
		cbBuscar.addItem("Autor");
		cbBuscar.addItem("Editora");
		cbBuscar.addItem("Sessão");
		
		return cbBuscar;
		
		
	}


}
