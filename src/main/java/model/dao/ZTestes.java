package model.dao;

import java.util.ArrayList;

import controller.SessaoController;
import model.vo.Aluguel;
import model.vo.Biblioteca;
import model.vo.Endereco;
import model.vo.Exemplar;
import model.vo.Livro;
import model.vo.Sessao;

public class ZTestes {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = new Endereco();
		Livro livro = new Livro();
		LivroDAO livroDAO = new LivroDAO();
		Sessao sessao = new Sessao();
		ExemplarDAO exemplarDAO = new ExemplarDAO();
		Exemplar exemplar = new Exemplar();
		ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
		AluguelDAO aluguelDAO = new AluguelDAO();
		SessaoController sessaoController = new SessaoController();
		
		
		/*
		sessao.setId(4);
		livro.setNome("Enciclopédia Barsa");
		livro.setAno(1991);
		livro.setAutor("Barsa");
		livro.setEdicao(1);
		livro.setEditora("Editora Barsa");
		livro.setSessao(sessao);
		int cont = 5;
		for (int i = 0; i < cont; i++) {
			exemplares.add(i, null);
		}
		livro.setExemplares(exemplares);
		
		System.out.println(livroDAO.salvar(livro));
		*/
		
		/*
		livro.setId(7);
		System.out.println(livroDAO.excluir(livro));
		*/
		
		
		/*
		livro.setNome("Maria, a Imperadora");
		livro.setAno(2019);
		livro.setAutor("Maria da Silva Sauro");
		livro.setEdicao(2);
		livro.setSessao(sessao);
		livro.setEditora("Saraiva");
		livro.setId(7);
		System.out.println(livroDAO.alterar(livro));
		*/
		
		/*
		endereco.setBairro("Centro");
		endereco.setCep("88095200");
		endereco.setRua("Rua das Oliveiras");
		endereco.setCidade("Nova Trento");
		endereco.setNumeroRua(100);
		endereco.setUf("SC");
		endereco.setId(6);
		System.out.println(enderecoDAO.alterar(endereco));
		*/
		
		/*
		System.out.println(exemplarDAO.consultarExemplarLivro(2));
		*/
		
		/*
		exemplar.setId(3);
		System.out.println(exemplarDAO.consultarStatus(exemplar));
		*/
		
		/*
		ArrayList<Aluguel> alugueis = aluguelDAO.consultarTodos(50);

        for (Aluguel aluguel : alugueis) {
            System.out.println("Retorno de alugueis: " + aluguel.getId());
        }
        */
		
		/*
		System.out.println(aluguelDAO.consultarTodos(30));
		*/
		
		/*
		System.out.println(exemplarDAO.consultarExemplar(15));
		*/
		
		/*
		sessao.setNome("Livros Raros");
		biblioteca.setId(1);
		sessao.setBiblioteca(biblioteca);
		System.out.println(SessaoController.salvarSessao(sessao));
		*/
		
		/*
		sessao.setNome("Língua Estrangeira");
		biblioteca.setId(1);
		sessao.setBiblioteca(biblioteca);
		System.out.println(SessaoController.alterarSessao(sessao, "Terror"));
		*/
		
		/*
		sessao.setId(1);
		System.out.println(SessaoController.excluirSessao(sessao));
		*/
		
		/*
		System.out.println(SessaoController.consultarSessao(5));
		*/
		
		/*
		System.out.println(SessaoController.consultarSessoes(6));
		*/
		
		livro.getExemplares().size();
	}

}
