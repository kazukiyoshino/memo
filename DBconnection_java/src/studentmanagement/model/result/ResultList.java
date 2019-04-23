package studentmanagement.model.result;
import java.util.ArrayList;

import studentmanagement.model.student.StudentId;

public class ResultList {
	private ArrayList<CourseResult> resultList;
	private StudentId studentId;

	public ResultList(ArrayList<CourseResult> resultList, StudentId studentId) {
		this.resultList = resultList;
		this.studentId = studentId;
	}

	public ArrayList<CourseResult> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<CourseResult> resultList) {
		this.resultList = resultList;
	}

//	public void addResultList(CourseResult courseResult){
//	resultList.add(courseResult);
//}



	public StudentId getStudentId() {
		return studentId;
	}


	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}


	@Override
	public String toString() {
		return String.format("ResultList [resultList=%s, studentId=%s]", resultList, studentId);
	}


}
