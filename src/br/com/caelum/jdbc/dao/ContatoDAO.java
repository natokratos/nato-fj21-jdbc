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

public class ContatoDAO {
	// a conexão com o banco de dados
	private Connection connection;
	
	public ContatoDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Contato> getLista () {
		List<Contato> contatos = new ArrayList<Contato>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				//montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public List<Contato> getByClause (String where) {
		List<Contato> contatos = new ArrayList<Contato>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where " + where);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				//montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public Contato getById (Long id) {
		Contato contato = null;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//criando o objeto contato
				contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				//montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			
			return contato;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
 	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void altera(Contato contato) {
		String sql = "update contatos " +
				"set nome = ?, email = ?, endereco = ?, dataNascimento = ?" +
				" where id = ?";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.setLong(5,contato.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void remove(Contato contato) {
		String sql = "delete from contatos " +
				" where id = ?";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setLong(1,contato.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
