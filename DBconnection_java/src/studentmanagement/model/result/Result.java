package studentmanagement.model.result;

public class Result {
private Integer result;

public Result(Integer result) {
	this.result = result;
}

public Integer getResult() {
	return result;
}

public void setResult(Integer result) {
	this.result = result;
}

@Override
public String toString() {
	return String.format("Result [result=%s]", result);
	}

}
