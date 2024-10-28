package kobley.ap.authentication.methods;

import kobley.ap.authentication.AuthResult;
import kobley.ap.authentication.AuthenticationMethod;

public class TokenAuthentication extends AuthenticationMethod {
	private final String jwtToken;

	public TokenAuthentication(final String token) {
		this.jwtToken = token;
	}

	public String getToken() {
		return jwtToken;
	}

	@Override
	public boolean verify() {
		return false;
	}

	@Override
	public AuthResult authenticate() {
		AuthResult result = new AuthResult(false, "Authentication Not Reached.");

		/*
			TODO: actually implement logic for jwt token authentication/authorization. But first, do user-pass.
		 */

		result.setSuccessful(true);
		result.setMessage("Successful!");

		return result;
	}
}
