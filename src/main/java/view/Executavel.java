package view;

import java.util.Arrays;

public class Executavel {

	public static void main(String[] args) {
		
		int[] idsLivros = new int[2];
		idsLivros[0] = 1;
		idsLivros[1] = 2;
		String sql = "SELECT * FROM EXEMPLAR WHERE idLivro IN (" + Arrays.toString(idsLivros) + ")";
		sql = sql.replaceAll("\\[|\\]", "");
		System.out.println(sql);
	}

}
