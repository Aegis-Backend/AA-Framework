package kobley.ap.utility.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;
import kobley.ap.custom.tuple.types.StringTuple;

import java.nio.charset.StandardCharsets;

public class bCryptUtil {

	private static final BCrypt.Version VERSION = BCrypt.Version.VERSION_2X;

	public static StringTuple hash(String pw) {
		String salt = SeasoningUtil.getSalt(16);
		String pepper = SeasoningUtil.getPepper(pw.toCharArray()); pw+=pepper;
		byte[] hashed = BCrypt.with(VERSION, LongPasswordStrategies.hashSha512(VERSION)).hash(
				16,
				salt.getBytes(StandardCharsets.UTF_8),
				pw.getBytes(StandardCharsets.UTF_8));

		return new StringTuple(new String(hashed, StandardCharsets.UTF_8), salt);
	}

	public static BCrypt.Result verify(String pw, StringTuple hash) {
		pw+=SeasoningUtil.getPepper(pw.toCharArray());
		return BCrypt.verifyer(VERSION, LongPasswordStrategies.hashSha512(VERSION)).verifyStrict(
				pw.getBytes(StandardCharsets.UTF_8),
				hash.getHash().getBytes(StandardCharsets.UTF_8));
	}
}
