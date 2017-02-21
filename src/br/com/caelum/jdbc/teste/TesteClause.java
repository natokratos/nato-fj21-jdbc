package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteClause {

	public static void main(String[] args) throws ClassNotFoundException {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		List<Contato> contatos = contatoDAO.getByClause("nome like 'M%'");

		for(Contato c : contatos) {
			System.out.println(c.getId());
			System.out.println(c.getNome());
			System.out.println(c.getEndereco());
			System.out.println(c.getEmail());
			System.out.println((new SimpleDateFormat()).format(c.getDataNascimento().getTime()) + "\n");
		}
	}

}
