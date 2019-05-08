package studentmanagement.model.student;

import studentmanagement.model.schoolclass.SchoolClass;

public class Student {
	private StudentId studentId;
	private StudentName studentName;
	private SchoolClass schoolClass;

	public Student(
			StudentId studentId,
			StudentName studentName,
			SchoolClass schoolClass) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.schoolClass = schoolClass;
	}

	public StudentId getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}

	public StudentName getStudentName() {
		return studentName;
	}

	public void setStudentName(StudentName studentName) {
		this.studentName = studentName;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	@Override
	public String toString() {
		return String.format("Student [studentId=%s, studentName=%s, schoolClass=%s]", studentId, studentName,
				schoolClass);
	}


}
