package kobley.ap.authentication;

public abstract class AuthenticationMethod {

	public abstract boolean verify();
	public abstract AuthResult authenticate();
}
