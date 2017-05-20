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

public class GenreList {
	
	ArrayList<Genre> genreList = new ArrayList<Genre>();
	
	private ArrayList<Genre> getGenres() {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			connection = Database.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM gengre ORDER BY name");
			while (rs.next()) {
				Genre genre = new Genre();
				genre.setName(rs.getString("name"));
				genreList.add(genre);
			}
		} catch (SQLException e){
			Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			try{
				if (connection != null) connection.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, e);
			}
		}
			
		return genreList;
	}
	
	public ArrayList<Genre> getGenreList() {
		if (genreList.isEmpty())
			return getGenres();
		return genreList;
	}
}