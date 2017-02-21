package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteAlteraRemove {

	public static void main(String[] args) throws ClassNotFoundException {
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato c, original = new Contato();
		List<Contato> contatos = new ArrayList<Contato>();
		
		c = contatoDAO.getById(Long.valueOf(2));
		System.out.println("Contact to be updated");
		System.out.println(c.getId());
		System.out.println(c.getNome());
		System.out.println(c.getEndereco());
		System.out.println(c.getEmail());
		System.out.println((new SimpleDateFormat()).format(c.getDataNascimento().getTime()) + "\n");

		original.copiar(c);
		
		c.setEndereco("----- Endereco");
		c.setNome("ooooooo Nome");
		contatoDAO.altera(c);
		c = contatoDAO.getById(Long.valueOf(2));
		System.out.println("Contact updated");
		System.out.println("[" + c.getId() + "] Original [" + original.getId() + "]");
		System.out.println("[" + c.getNome() + "] Original [" + original.getNome() + "]");
		System.out.println("[" + c.getEndereco() + "] Original [" + original.getEndereco() + "]");
		System.out.println("[" + c.getEmail() + "] Original [" + original.getEmail() + "]");
		System.out.println("[" + (new SimpleDateFormat()).format(c.getDataNascimento().getTime()) + "] Original [" + (new SimpleDateFormat()).format(original.getDataNascimento().getTime()) + "]\n");
		
		contatoDAO.remove(c);
		System.out.println("Contact removed");
		
		contatoDAO.adiciona(original);
		System.out.println("Contact restored");
		
		contatos = contatoDAO.getByClause("nome = '" + original.getNome() + "'");
		for(Contato contato : contatos) {
			System.out.println(contato.getId());
			System.out.println(contato.getNome());
			System.out.println(contato.getEndereco());
			System.out.println(contato.getEmail());
			System.out.println((new SimpleDateFormat()).format(contato.getDataNascimento().getTime()) + "\n");
		}
	}

}
