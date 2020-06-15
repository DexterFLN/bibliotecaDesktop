package util;

import java.time.LocalDate;

public class ConversorData {
	
	public static LocalDate converterTextoEmData(String texto) {
        String[] data = texto.split("/");
        String dataConvertida = data[2]+"-"+data[1]+"-"+data[0];
        return LocalDate.parse(dataConvertida);
    }
	
}
