package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.vo.Usuario;

public class GeradorPlanilha {
	
	/**
	 * Método gerador de relatórios em xlsx
	 * 
	 * @param usuarios
	 * @param path
	 */
	public static void gerarPlanilhaUsuarios(List<Usuario> usuarios ,  String path) {
		//TODO completar com todos os campos de usuário e refatorar o método  para generics
		
		String[] nomesColunas = { "Nome", "Sobrenome", "Email"};
		
				// 1) Criar a planilha e uma aba
				XSSFWorkbook planilha = new XSSFWorkbook();
				XSSFSheet abaPlanilha = planilha.createSheet("Usuarios");

				// 2) Criar o cabeçalho (na primeira linha)
				Row linhaCabecalho = abaPlanilha.createRow(0);

				for (int i = 0; i < nomesColunas.length; i++) {
					Cell celula = linhaCabecalho.createCell(i);
					celula.setCellValue(nomesColunas[i]);
				}
				
				// 3) Criar as linhas com os clientes da lista
				int linhaAtual = 1;

				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				for (Usuario usuario : usuarios) {
					Row novaLinha = abaPlanilha.createRow(linhaAtual++);

					// Preencher a linha, célula a célula com os valores do objeto clienteAtual
					novaLinha.createCell(0).setCellValue(usuario.getNome());
					novaLinha.createCell(1).setCellValue(usuario.getSobrenome());
					novaLinha.createCell(2).setCellValue(usuario.getEmail());
				}

				// 4) Ajustar a largura das colunas
				for (int i = 0; i < nomesColunas.length; i++) {
					abaPlanilha.autoSizeColumn(i);
				}

				// 5) Salvar a planilha no disco
				salvarNoDisco(planilha, path, ".xlsx");
		
	}
	
	private static String salvarNoDisco(XSSFWorkbook planilha, String caminhoArquivo, String extensao) {
		String mensagem = "";
		FileOutputStream saida = null;

		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
		return mensagem;
	}
	

}
