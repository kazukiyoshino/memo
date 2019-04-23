package studentmanagement.model.student;

public class StudentName {
private String name;

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

}
