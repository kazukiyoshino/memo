package studentmanagement.model.student;

public class StudentName {
private String name;
public static final Integer MAX_LENGTH = 60;

	public StudentName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("StudentName [name=%s]", name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public  boolean validationStudentNameLength() {
		if(name.length()>MAX_LENGTH) {
			return false;
		}
		else return true;
	}
}
