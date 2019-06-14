package studentmanagement.model.course;

public enum PCCategory {
	NOTE("ノートPC"),
	DESKTOP("デスクトップ");

	String name;

	private PCCategory(String name) {
		this.name = name;
	}
}
