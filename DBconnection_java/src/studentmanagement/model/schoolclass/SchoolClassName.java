package studentmanagement.model.schoolclass;

public class SchoolClassName {
 private String name;

 public SchoolClassName(String name) {
	 this.name = name;
 }

	@Override
	public String toString() {
		return String.format("SchoolClassName [name=%s]", name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	}
