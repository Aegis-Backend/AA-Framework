package kobley.ap.utility.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;
import kobley.ap.custom.tuple.types.StringTuple;

import java.nio.charset.StandardCharsets;

public class bCryptUtil {

	private static final BCrypt.Version VERSION = BCrypt.Version.VERSION_2X;

	public static StringTuple hash(String pw) {
		//Get randomly generated salt, SecureRandom seeded with another SecureRandom, which is initially seeded with 0xDEADBEEF.
		String salt = SeasoningUtil.getSalt(16);
		//Get pepper, then append to pw.
		String pepper = SeasoningUtil.getPepper(pw.toCharArray()); pw+=pepper;
		byte[] hashed = BCrypt.with(VERSION, LongPasswordStrategies.hashSha512(VERSION)).hash(
				16, //16 seems to be very beefy compared to what others online use. Should be good.
				salt.getBytes(StandardCharsets.UTF_8),
				pw.getBytes(StandardCharsets.UTF_8));

		return new StringTuple(new String(hashed, StandardCharsets.UTF_8), salt);
	}

	public static BCrypt.Result verify(String pw, StringTuple hash) {
		//Get and append pepper to pw.
		pw+=SeasoningUtil.getPepper(pw.toCharArray());
		//VerifyStrict to make sure VERSION(s) match.
		return BCrypt.verifyer(VERSION, LongPasswordStrategies.hashSha512(VERSION)).verifyStrict(
				pw.getBytes(StandardCharsets.UTF_8),
				hash.getHash().getBytes(StandardCharsets.UTF_8));
	}
}
