package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDAO {

	public static void main(String[] args) throws ClassNotFoundException {
		Calendar cal = Calendar.getInstance();
		
		ContatoDAO conDAO = new ContatoDAO();
		Contato contato = new Contato();

		contato.setNome("Marco Hamada");
		contato.setEndereco("EnderecoMarcos");
		contato.setEmail("EmailMarcos");
		contato.setDataNascimento(cal);
		
		conDAO.adiciona(contato);
	}

}
