package studentmanagement.model.student;

public class StudentId {
 private Integer id ;

public StudentId(Integer id) {
	this.id = id;
}

@Override
public String toString() {
	return String.format("StudentId [id=%s]", id);
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}


}
