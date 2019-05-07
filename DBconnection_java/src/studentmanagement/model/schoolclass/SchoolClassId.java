package studentmanagement.model.schoolclass;

public class SchoolClassId {

private Integer id ;

public SchoolClassId() {
}
public SchoolClassId(Integer id) {
	this.id = id ;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public boolean isEmpty() {
	if(id == null)
		return true;
	return false;
}

@Override
public String toString() {
	return String.format("SchoolClassId [id=%s]", id);
}

}
