package kobley.ap.authentication.methods;

import at.favre.lib.crypto.bcrypt.BCrypt;
import kobley.ap.authentication.AuthResult;
import kobley.ap.authentication.AuthenticationMethod;
import kobley.ap.custom.tuple.types.StringTuple;
import kobley.ap.utility.security.bCryptUtil;

public class UserPassAuthentication extends AuthenticationMethod {
	private final String username;
	private final String password;
	private final StringTuple retrievedHash = null;
	//private final PredictedUser(extends standard User class) user

	public UserPassAuthentication(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	// here ! // retrieve & parse user for verification+authentication

	@Override
	public boolean verify() {
		return false;
	}

	@Override
	public AuthResult authenticate() {
		AuthResult result = new AuthResult();
		//actually rewrite when db shit done
		StringTuple hash = bCryptUtil.hash(this.getPassword());
		BCrypt.Result res = bCryptUtil.verify(this.getPassword(), hash);

		result.setSuccessful(res.verified);
		result.setMessage("Successful!"); // set to any errors to be specific;

		return result;
	}
}
