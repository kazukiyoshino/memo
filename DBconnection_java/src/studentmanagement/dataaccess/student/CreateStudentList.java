package studentmanagement.dataaccess.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import studentmanagement.model.schoolclass.SchoolClass;
import studentmanagement.model.student.Student;
import studentmanagement.model.student.StudentId;
import studentmanagement.model.student.StudentName;

public class CreateStudentList {
	public static ArrayList<Student> createStudentList(SchoolClass schoolClass){
		ArrayList<Student> studentList = new ArrayList<Student>();

		String sql = "select student_id,name from student where schoolclass_id = ?";

    	try(Connection connection = DBconnectionCreateDriverManagerDataAccess.createConnection();
    		PreparedStatement statements = connection.prepareStatement(sql);){

	    	statements.setInt(1,schoolClass.getSchoolClassId().getId());
    		ResultSet resultSet= statements.executeQuery();

	    	while(resultSet.next()){
                StudentId studentId = new StudentId(resultSet.getInt(1));
    			StudentName studentName = new StudentName(resultSet.getString(2));
    			Student student = new Student(studentId,studentName,schoolClass);
                studentList.add(student);
    		}

		return studentList;
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
	}

}
