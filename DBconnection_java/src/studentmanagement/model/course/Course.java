package studentmanagement.model.course;

public class Course {
	private CourseId courseId;
	private CourseName courseName;

	public Course(
			CourseId courseId,
			CourseName courseName
			) {
		this.courseId = courseId;
		this.courseName = courseName;
	}


	public CourseId getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseId courseId) {
		this.courseId = courseId;
	}
	public CourseName getCourseName() {
		return courseName;
	}
	public void setCourseName(CourseName CourseName) {
		this.courseName = CourseName;
	}


	@Override
	public String toString() {
		return String.format("Course [courseId=%s, courseName=%s]", courseId, courseName);
	}

}

