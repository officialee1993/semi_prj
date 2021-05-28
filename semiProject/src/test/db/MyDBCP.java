package test.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyDBCP {
	private static DataSource ds=null;
	
	static {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection con=ds.getConnection();
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) rs.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
