package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) throws ClassNotFoundException {
		ContatoDAO contato = new ContatoDAO();
		
		List<Contato> contatos= contato.getLista();
		
		for(Contato c : contatos) {
			System.out.println(c.getId());
			System.out.println(c.getNome());
			System.out.println(c.getEndereco());
			System.out.println(c.getEmail());
			System.out.println((new SimpleDateFormat()).format(c.getDataNascimento().getTime()) + "\n");
		}
	}
}
