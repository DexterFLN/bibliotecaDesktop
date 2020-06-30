package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorTexto {

	/**
	 * Verifica se um email e valido.
	 * 
	 * @param String email a  ser validado.
	 * @return false se o email nao e valido, e true caso texto seja valido.
	 */
	public static boolean emailIsValid(String email) {
		String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
				+ "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	/**
	 * Verifica se uma String e valida, uma String sera¡ valida se nao possuir
	 * numeros e nao estiver vazia.
	 * 
	 * @param String texto a  ser validado.
	 * @return false se o texto nao e valido, e true caso texto seja valido.
	 */
	public static boolean isValidString(String string) {
		String regex = "\\d";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return !matcher.find() && !string.isEmpty();
	}

}
