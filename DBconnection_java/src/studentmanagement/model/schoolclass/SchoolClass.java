package studentmanagement.model.schoolclass;

public class SchoolClass {
	private SchoolClassId schoolClassId;
	private SchoolClassName schoolClassName;

	public SchoolClass(
			SchoolClassId schoolClassId,
			SchoolClassName schoolClassName
			) {
		this.schoolClassId = schoolClassId;
		this.schoolClassName = schoolClassName;
	}


	public SchoolClassId getSchoolClassId() {
		return schoolClassId;
	}
	public void setSchoolClassId(SchoolClassId schoolClassId) {
		this.schoolClassId = schoolClassId;
	}
	public SchoolClassName getSchoolClassName() {
		return schoolClassName;
	}
	public void setSchoolClassName(SchoolClassName schoolClassName) {
		this.schoolClassName = schoolClassName;
	}


	@Override
	public String toString() {
		return String.format("SchoolClass [schoolClassId=%s, schoolClassName=%s]", schoolClassId, schoolClassName);
	}




//	public String className() {
//		student id
//		Schoolclassidで行を特定し、SchoolclassNameを返す
//
//		String className ="class名";
//		return className;
//	}
}
