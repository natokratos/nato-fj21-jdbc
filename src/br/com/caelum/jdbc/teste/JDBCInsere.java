package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
						
		try {
			// conectando
			con = new ConnectionFactory().getConnection();
			
			// cria um preparedStatement
			String sql = "insert into contatos" +
					" (nome,email,endereco,dataNascimento)" +
					" values (?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, "Miyuki");
			stmt.setString(2, "EmailMiyuki");
			stmt.setString(3, "EnderecoMiyuki");
			stmt.setDate(4, new java.sql.Date(
			Calendar.getInstance().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Gravado!");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {	
			con.close();
		}
	}
}
