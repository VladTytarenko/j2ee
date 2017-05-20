package com.tytarenko.beans;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tytarenko.Connection.Database;

public class AuthorList {
	
	private ArrayList<Author> authorList = new ArrayList<Author>();
	
	private ArrayList<Author> getAuthors() {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			connection = Database.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM author ORDER BY fio");
			while(rs.next()) {
				Author author = new Author();
				author.setName(rs.getString("fio"));
				authorList.add(author);
			}
		} catch(SQLException e) {
			Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			try{
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
				if (connection != null) connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return authorList;
	}
	
	public ArrayList<Author> getAuthorList() {
		if(!authorList.isEmpty())
			return authorList;
		else
			return getAuthors();
	}
}