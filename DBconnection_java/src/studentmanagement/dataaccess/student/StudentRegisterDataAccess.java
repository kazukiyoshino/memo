package studentmanagement.dataaccess.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import studentmanagement.model.student.Student;

public class StudentRegisterDataAccess {//データアクセス(書き込み)
	static Connection connection = DBconnectionCreateDriverManagerDataAccess.createConnection();

	public static void studentRegister(Student student) {

    	String sql = "insert into student values(?,?,?,current_timestamp,current_timestamp)";
    	try(PreparedStatement statements = connection.prepareStatement(sql);){
	        statements.setInt(1,student.getStudentId().getId());
	        statements.setInt(2,student.getSchoolClass().getSchoolClassId().getId());
	        statements.setString(3,student.getStudentName().getName());
	        connection.setAutoCommit(false);
	        statements.executeUpdate();
	        connection.commit();

	      }
	    catch (SQLException e){
	          e.printStackTrace();
	          throw new RuntimeException(e);
	          }
    }
}
