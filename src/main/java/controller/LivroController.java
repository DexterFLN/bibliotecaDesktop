package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public Livro salvarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String cbAno, Sessao sessao) {
        Livro livro = criarLivro(txtTitulo, txtAutor, txtEditora, txtEdicao, cbAno, sessao);
        livroBo.salvar(livro);
        return livro;
    }
	
	public String validarCampos(String titulo, String autor, String editora, String edicao) {
		String mensagem = "O(s) campo(s): ";
		
		if(titulo.isEmpty()) {
			mensagem += "T�TULO";
		}
		
		if(autor.isEmpty()) {
			if(mensagem == "O(s) campo(s): ") {
				mensagem += "AUTOR ";
				
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
		
		if(mensagem == "O(s) campo(s): ") {
			mensagem = "";
			return mensagem;
		} else {
			mensagem += " n�o pode(m) ficar vazio(s).";
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
		
	}
	
	public int validarSessao(String cbSessao) {
		
		int sessao;
		
		if (cbSessao == "Fic��o" ) {
			sessao = 1;
		} else if (cbSessao == "Literatura Cl�ssica" ) {
			sessao = 2;
		} else if (cbSessao == "Romance" ) {
			sessao = 3;
		} else if (cbSessao == "Auto Ajuda" ) {
			sessao = 4;
		} else if (cbSessao == "Suspense" ) {
			sessao = 5;
		} else {
			sessao = 6;
		}
		
		return sessao;
	}
	
	public ArrayList<Livro> consultarLivrosPorSeletor(LivroSeletor seletor){
		return livroBo.consultarLivrosPorSeletor(seletor);
		
	}

	public Livro consultarLivroPorId(int id) {
		return livroBo.consultarLivroPorId(id);
	}
	
	
	
	
}
