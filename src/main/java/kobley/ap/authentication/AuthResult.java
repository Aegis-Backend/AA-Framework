package kobley.ap.authentication;

public class AuthResult {
	private boolean successful;
	private String message;

	//Constructor like this technically isn't needed.
	public AuthResult(boolean successful, String msg) {
		this.successful = successful;
		this.message = msg;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
