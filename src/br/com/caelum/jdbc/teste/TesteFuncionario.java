package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteFuncionario {

	public static void main(String[] args) throws ClassNotFoundException {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionarios = null;
		
		for(int i = 1; i < 5; i++) {
			Funcionario funcionario = new Funcionario();
			
			funcionario.setNome("Nome_" + String.valueOf(i));
			funcionario.setUsuario("Usuario_" + String.valueOf(i));
			funcionario.setSenha("Senha_" + String.valueOf(i));
			
			funcionarioDAO.adiciona(funcionario);
		}
		
		funcionarios = funcionarioDAO.getLista();
		for(Funcionario f : funcionarios) {
			System.out.println("Id [" + f.getId() + "]");
			System.out.println("Nome [" + f.getNome() + "]");
			System.out.println("Usuario [" + f.getUsuario() + "]");
			System.out.println("Senha [" + f.getSenha() + "]");
		}
	}

}
