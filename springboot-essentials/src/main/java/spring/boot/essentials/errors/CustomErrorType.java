package spring.boot.essentials.errors;

public class CustomErrorType {
	
	private String errorMessege;
	
	public CustomErrorType(String msg) {
		this.errorMessege = msg;
	}

	public String getErrorMessege() {
		return errorMessege;
	}

	public void setErrorMessege(String errorMessege) {
		this.errorMessege = errorMessege;
	}
	
	

}
