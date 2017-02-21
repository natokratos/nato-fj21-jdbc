package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			System.out.println("Connection open!");
		} finally {
			con.close();
		}
	}

}
