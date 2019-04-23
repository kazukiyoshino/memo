package studentmanagement.model.course;

public class CourseId {
	private Integer id ;

	public CourseId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("CourseId [id=%s]", id);
	}


}
