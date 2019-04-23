package studentmanagement.model.course;

public class CourseName {
private String name;

public CourseName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return String.format("CourseName [name=%s]", name);
}


}
