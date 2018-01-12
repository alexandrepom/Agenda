package br.com.gonzaga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe que fabrica conexão com o banco de dados
public class ConnectionFactory{
	
	public static Connection connect() throws SQLException {
		
		String URL = "jdbc:sqlite:C:/Users/alexa/eclipse-workspace/Agenda/WebContent/WEB-INF/SQLite/DB_Agenda.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
