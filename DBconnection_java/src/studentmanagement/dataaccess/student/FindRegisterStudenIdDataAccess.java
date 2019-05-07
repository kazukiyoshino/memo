package studentmanagement.dataaccess.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentmanagement.model.student.StudentId;

public class FindRegisterStudenIdDataAccess {
	static Connection connection = DBconnectionCreateDriverManagerDataAccess.createConnection();

	public static StudentId findRegisterStudentId(){//データアクセス
        String sql = "select nextval('student_id_seq')";

    	try(PreparedStatement statement = connection.prepareStatement(sql);
    	    ResultSet resultSet = statement.executeQuery();){

	        resultSet.next();
    	return  new StudentId(resultSet.getInt(1));

    	}
	    catch (SQLException e){
	         e.printStackTrace();
	         throw new RuntimeException(e);

           }
    	}


}
