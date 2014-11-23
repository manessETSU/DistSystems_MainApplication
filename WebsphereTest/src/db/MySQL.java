package db;

import java.sql.*;

public class MySQL {
	public static Connection connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//return DriverManager.getConnection("jdbc:mysql://151.141.90.51","etakota","k3jFdSx");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/patient_info","root","root");
		} catch(Exception e) {
			throw new Error(e);
		}		
	}
	
	public static boolean close(Connection c){
		try{
			c.close();
			return true;			
		} catch(Exception e){
			return false;			
		}		
	}

}
