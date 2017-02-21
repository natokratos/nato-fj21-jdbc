package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteById {

	public static void main(String[] args) throws ClassNotFoundException {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato c = contatoDAO.getById(Long.valueOf(2));
		
		System.out.println(c.getId());
		System.out.println(c.getNome());
		System.out.println(c.getEndereco());
		System.out.println(c.getEmail());
		System.out.println((new SimpleDateFormat()).format(c.getDataNascimento().getTime()) + "\n");
	}

}
