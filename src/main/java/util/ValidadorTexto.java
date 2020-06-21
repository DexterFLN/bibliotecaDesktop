package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorTexto {

	/**
	 * Verifica se um email é válido.
	 * 
	 * @param String email à ser validado.
	 * @return false se o email não é válido, e true caso texto seja válido.
	 */
	public static boolean emailIsValid(String email) {
		String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
				+ "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	/**
	 * Verifica se uma String é válida, uma String será válida se não possuir
	 * números e não estiver vazia.
	 * 
	 * @param String texto à ser validado.
	 * @return false se o texto não é válido, e true caso texto seja válido.
	 */
	public static boolean isValidString(String string) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return !matcher.find() && !string.isEmpty();
	}

}
