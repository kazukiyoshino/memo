package studentmanagement.service.studentlist;

import java.util.ArrayList;

import studentmanagement.dataaccess.student.CreateStudentList;
import studentmanagement.dataaccess.student.FindClassIdDataAccess;
import studentmanagement.model.schoolclass.SchoolClass;
import studentmanagement.model.schoolclass.SchoolClassId;
import studentmanagement.model.schoolclass.SchoolClassName;
import studentmanagement.model.student.Student;

public class GetStudentListService {

	public static ArrayList<Student> getStudentList(SchoolClassName schoolClassName) {
	
		SchoolClassId schoolClassId = FindClassIdDataAccess.findClassId(schoolClassName).get();
	
		SchoolClass schoolClass = new SchoolClass(schoolClassId,schoolClassName);
	
		return  CreateStudentList.createStudentList(schoolClass);
	}

}
