package studentmanagement.model.result;

import studentmanagement.model.course.Course;

public class CourseResult {
	private Result result;
	private Course course;
	private ResultId resultId;

	public CourseResult(
			Result result,
			Course course,
			ResultId resultId) {
		this.result = result;
		this.course = course;
		this.resultId = resultId;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	public ResultId getResultId() {
		return resultId;
	}

	public void setResultId(ResultId resultId) {
		this.resultId = resultId;
	}

	@Override
	public String toString() {
		return String.format("CourseResult [result=%s, course=%s, resultId=%s]", result, course, resultId);
	}


}
