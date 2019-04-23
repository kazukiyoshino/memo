package studentmanagement.model.result;

public class ResultId {
	private Integer id;

	public ResultId(Integer id) {
		this.id = id ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("ResultId [id=%s]", id);
	}
}
