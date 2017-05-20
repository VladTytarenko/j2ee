package com.tytarenko.Connection;
	
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
	
public class Database {
	
	private static Connection mysqlConnect;
	//private static InitialContext ic;
	//private static DataSource ds;
	
	/*public static Connection getConnection() {
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
			if(mysqlConnect == null)
				mysqlConnect = ds.getConnection();
		} catch(SQLException ex) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NamingException ex) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return mysqlConnect;
	}*/
	
//}
	
	private static String dbURI = "mysql://b12ca426a8c345:f895f57a@us-cdbr-iron-east-03.cleardb.net/heroku_554c77521d30b6c";
	
	/*public Database(String dbURI) {
		this.dbURI = dbURI;
		init();
	}*/
	
	/*public void init() {
		if(mysqlConnect == null){
			try{
				mysqlConnect = getConnection(dbURI);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	public void finalize() {
		try {
			mysqlConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public ResultSet query(String query) {
		ResultSet result = null;
		try {
			Statement stmt = mysqlConnect.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateQuery(String query) {
		try {
			Statement stmt = mysqlConnect.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	    
	//"mysql://b12ca426a8c345:f895f57a@us-cdbr-iron-east-03.cleardb.net/heroku_554c77521d30b6c"
	////System.getenv("DATABASE_URL"));
	public static Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(dbURI);
	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	/*public static void main(String[] args) {
		Database db = new Database("mysql://b12ca426a8c345:f895f57a@us-cdbr-iron-east-03.cleardb.net/heroku_554c77521d30b6c");
		ResultSet rs = db.query("SELECT * FROM book");
		try {
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}