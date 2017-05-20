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

public class BookList {
	
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	private ArrayList<Book> getBooks() {
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			connection = Database.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM book ORDER BY name");
			while(rs.next()){
				Book book = new Book(rs.getString("name"));
				bookList.add(book);
			}
		} catch(SQLException ex) {
			Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		return bookList;
	}
	
	public ArrayList<Book> getBookList() {
		if (bookList.isEmpty())
			return getBooks();
		return bookList;
	}
	
	public static void main(String[] args) {
		BookList bl = new BookList();
		for(Book b : bl.getBookList()) {
			System.out.println(b.getName());
		}
	}

}
