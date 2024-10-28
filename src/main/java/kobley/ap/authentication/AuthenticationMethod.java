package kobley.ap.authentication;

public abstract class AuthenticationMethod {

	/*
		Is this a stupid way of doing it?
		AuthenticationMethod method = Token/UserPass(); seems nice and allows for polymorphism but just seems off to me for some reason.
	*/
	public abstract boolean verify();
	public abstract AuthResult authenticate();
}
