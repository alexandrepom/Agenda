package br.com.gonzaga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.gonzaga.agenda.Contato;

public class ContatoDAO {
	private Connection connection;
	
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO Contato"+
					"(nome, email, telefone)"+
					"values (?,?,?)";
		try {
			connection = ConnectionFactory.connect();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getTelefone());
			statement.execute();
			statement.close();
			connection.close();
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	
	public List<Contato> getLista(){
		String sql = "select * from contato";
		List<Contato> lista = new ArrayList<Contato>();
		Contato c=null;
		try {
			connection = ConnectionFactory.connect();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				c = new Contato();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setId(rs.getLong("id"));
				lista.add(c);
			}
			
			stm.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public void delete(long id) {
		
	        String sql = "DELETE FROM contato WHERE id = ?";
	 
	        try { 
	        	connection = ConnectionFactory.connect();
                PreparedStatement pstmt = connection.prepareStatement(sql);
	            // set the corresponding param
	            pstmt.setLong(1, id);
	            // execute the delete statement
	            pstmt.executeUpdate();
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    
	}
	
	public void update(Contato c) {
        String sql = "UPDATE contato SET nome = ?, email = ?, telefone = ? where id=?";
 
        try{
        	connection = ConnectionFactory.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefone());
            pstmt.setLong(4, c.getId());
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public Contato getContato(long id) {
		
		String sql = "select * from contato where id="+id;
		Contato c=null;
		try {
			connection = ConnectionFactory.connect();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				c = new Contato();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setId(rs.getLong("id"));
			}else
				System.out.println("Contato não localizado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
}
