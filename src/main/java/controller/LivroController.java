package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.bo.LivroBO;
import model.seletor.LivroSeletor;
import model.vo.Livro;
import model.vo.Sessao;

public class LivroController {
	
	private LivroBO livroBo = new LivroBO();

	public Livro criarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String cbAno, Sessao sessao) {
		Livro livro = new Livro();
		livro.setNome(txtTitulo);
		livro.setAutor(txtAutor);
		livro.setEditora(txtEditora);
		livro.setEdicao(Integer.parseInt(txtEdicao));
		livro.setAno(Integer.parseInt(cbAno));
		livro.setSessao(sessao);

        return livro;
    }
	
	public Livro salvarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String ano, Sessao sessao) {
        Livro livro = criarLivro(txtTitulo, txtAutor, txtEditora, txtEdicao, ano, sessao);
        livroBo.salvar(livro);
        return livro;
    }
	
	public static String validarCampos(String titulo, String autor, String editora, String edicao, String ano) {
		String mensagem = "O(s) campo(s): ";
		
		if(titulo.isEmpty()) {
			mensagem += "TITULO";
		}
		
		if(autor.isEmpty()) {
			if(mensagem == "O(s) campo(s): ") {
				mensagem += "AUTOR";
				
			} else {
				mensagem += ", AUTOR";
			}
		}
		
		if(editora.isEmpty()) {
			if(mensagem == "O(s) campo(s): ") {
				mensagem += "EDITORA";
				
			} else {
				mensagem += ", EDITORA";
			}
		}
		
		if(edicao.isEmpty()) {
			if(mensagem == "O(s) campo(s): ") {
				mensagem += "EDICAO";
				
			} else {
				mensagem += ", EDICAO";
			}
		}
		
		if(ano.isEmpty()) {
			if(mensagem == "O(s) campo(s): ") {
				mensagem += "ANO";
				
			} else {
				mensagem += " e ANO";
			}
		}
		
		if(mensagem == "O(s) campo(s): ") {
			mensagem = "";
			return mensagem;
		} else {
			mensagem += " nao pode(m) ficar vazio(s).";
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
		
	}
	
	public Sessao validarSessao(Sessao sessao) {
		return SessaoController.consultarSessao(sessao.getId());
	}
	
	public ArrayList<Livro> consultarLivrosPorSeletor(LivroSeletor seletor){
		return livroBo.consultarLivrosPorSeletor(seletor);
	}

	public Livro consultarLivroPorId(int id) {
		return livroBo.consultarLivroPorId(id);
	}

	public Livro consultarLivroPorIdParaExemplares(int id) {
		return livroBo.consultarLivroPorIdParaExemplares(id);
	}

	public static boolean excluir(Livro livro) {
		boolean excluiu = LivroBO.excluir(livro);
		return excluiu;
	}

	public static void alterar(Livro livro, Livro dadosNovos) {
		LivroBO.alterar(livro, dadosNovos);
	}
	
}
