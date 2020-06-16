package controller;

import javax.swing.JOptionPane;
import model.bo.LivroBO;
import model.vo.Livro;
import model.vo.Sessao;

public class LivroController {

	public Livro criarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String cbAno, Sessao sessao) {
		Livro livro = new Livro ();
		livro.setNome(txtTitulo);
		livro.setAutor(txtAutor);
		livro.setEditora(txtEditora);
		livro.setEdicao(Integer.parseInt(txtEdicao));
		livro.setAno(Integer.parseInt(cbAno));
		livro.setSessao(sessao);

        return livro;
    }
	
	public Livro salvarLivro(String txtTitulo, String txtAutor, String txtEditora, String txtEdicao, String cbAno, Sessao sessao) {
        LivroBO bo = new LivroBO();
        Livro livro = criarLivro(txtTitulo, txtAutor, txtEditora, txtEdicao, cbAno, sessao);
        bo.salvar(livro);
        return livro;
    }
	
	public String validarCampos(String titulo, String autor, String editora, String edicao) {
		String mensagem = "O(s) campo(s): ";
		
		if(titulo.isEmpty()) {
			mensagem += "TÍTULO";
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
			mensagem += " não pode(m) ficar vazio(s).";
			JOptionPane.showMessageDialog(null, mensagem);
			return mensagem;
		}
		
	}
	
	public int validarSessao(String cbSessao) {
		
		int sessao;
		
		if (cbSessao == "Ficção" ) {
			sessao = 1;
		} else if (cbSessao == "Literatura Clássica" ) {
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
	
}
