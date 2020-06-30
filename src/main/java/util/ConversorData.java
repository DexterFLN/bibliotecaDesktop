package util;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class ConversorData {

	public static LocalDate converterTextoEmData(String texto) {
		String[] data = texto.split("/");
		String dataConvertida = data[2] + "-" + data[1] + "-" + data[0];
		return LocalDate.parse(dataConvertida);
	}

	public static String conferirDataVazia(String texto) {
		String[] data = texto.split("/");
		String mensagem = "";

		if (data[0].trim().isEmpty()) {
			mensagem = "\nA Data de Devolução informada está incorreta";
		} else {
			int dia = Integer.parseInt(data[0]);
			if (dia < 1 || dia > 31) {
				mensagem = "\nA Data de Devolução informada está incorreta";
			}
		}

		if (data[1].trim().isEmpty()) {
			if (mensagem == "") {
				mensagem = "\nA Data de Devolução informada está incorreta";

			} else {
				mensagem = "\nA Data de Devolução informada está incorreta";
				;
			}
		} else {
			int mes = Integer.parseInt(data[1]);
			if (mes < 1 || mes > 12) {
				if (mensagem == "") {
					mensagem = "\nA Data de Devolução informada está incorreta";

				} else {
					mensagem = "\nA Data de Devolução informada está incorreta";
				}
			}
		}

		if (data[2].trim().isEmpty()) {
			if (mensagem == "") {
				mensagem = "\nA Data de Devolução informada está incorreta";

			} else {
				mensagem = "\nA Data de Devolução informada está incorreta";
			}
		} else {
			int ano = Integer.parseInt(data[2]);
			if (ano < 1000) {
				if (mensagem == "") {
					mensagem = "\nA Data de Devolução informada está incorreta";

				} else {
					mensagem = "\nA Data de Devolução informada está incorreta";
				}
			}
		}

		return mensagem;

	}

}
