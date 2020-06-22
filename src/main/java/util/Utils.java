package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static boolean emailValido(String email){
		    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
		 }

	public static final String executeRegexp(final String text, final String er, final int group, int pattern) {
		final Matcher matcher = Pattern.compile(er, pattern).matcher(text);
		final boolean match = matcher.find();
		if (!match) {
			System.out.println("no match " + er);
			return "";
		}
		return matcher.group(group);
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

}
