package studentmanagement.dataaccess.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectionCreateDriverManagerDataAccess {

	public static Connection createConnection() {//データアクセス
		String url = "jdbc:postgresql://localhost:5432/training_dbconnection";
	    String user = "postgres";
	    String password = "postgres";

	    try {
	        return DriverManager.getConnection(url,user,password);
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    	throw new RuntimeException(e);
	    }
	}
}
