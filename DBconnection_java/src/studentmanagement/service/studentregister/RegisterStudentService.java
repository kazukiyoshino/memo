package studentmanagement.service.studentregister;

import studentmanagement.dataaccess.student.FindClassIdDataAccess;
import studentmanagement.dataaccess.student.FindRegisterStudenIdDataAccess;
import studentmanagement.dataaccess.student.StudentRegisterDataAccess;
import studentmanagement.model.schoolclass.SchoolClass;
import studentmanagement.model.schoolclass.SchoolClassId;
import studentmanagement.model.schoolclass.SchoolClassName;
import studentmanagement.model.student.Student;
import studentmanagement.model.student.StudentId;
import studentmanagement.model.student.StudentName;

public class RegisterStudentService {
	public void registerStudent(StudentName studentName,SchoolClassName schoolClassName) {

		StudentId studentId = FindRegisterStudenIdDataAccess.findRegisterStudentId();

		SchoolClassId schoolClassId = FindClassIdDataAccess.findClassId(schoolClassName).get();


		SchoolClass schoolClass = new SchoolClass(schoolClassId,schoolClassName);
		Student student = new Student(studentId,studentName,schoolClass);

		StudentRegisterDataAccess.studentRegister(student);

	}

}
