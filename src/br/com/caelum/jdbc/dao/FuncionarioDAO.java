package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDAO {
	private Connection connection;
	
	public FuncionarioDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Funcionario> getLista () {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto contato
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
			
			return funcionarios;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public List<Funcionario> getByClause (String where) {
		List<Funcionario> contatos = new ArrayList<Funcionario>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios where " + where);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto funcionario
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				contatos.add(funcionario);
			}
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public Funcionario getById (Long id) {
		Funcionario funcionario = null;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto funcionario
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
			
			return funcionario;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios " +
				"(nome, usuario, senha)" +
				" values (?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getUsuario());
			stmt.setString(3,funcionario.getSenha());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void altera(Funcionario funcionario) {
		String sql = "update funcionarios " +
				"set nome = ?, usuario = ?, senha = ?" +
				" where id = ?";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getUsuario());
			stmt.setString(3,funcionario.getSenha());
			
			stmt.setLong(5,funcionario.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void remove(Funcionario funcionario) {
		String sql = "delete from funcionarios " +
				" where id = ?";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setLong(1,funcionario.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
