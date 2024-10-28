package kobley.ap.utility.security;

import kobley.ap.utility.misc.RandomUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SeasoningUtil {

	public static String getSalt(int bytes) {
		return RandomUtil.string(RandomUtil.CharsetType.ALPHANUMERIC, bytes);
	}

	public static String getPepper(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			int mod = c ^ chars.length;
			char newChar = (char) ((int) c%2 == 0 ? (c - mod) : (c + mod));
			sb.append(newChar);
		}

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		md.update(sb.toString().getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		StringBuilder sb2 = new StringBuilder();
		for (byte b : digest) {
			sb2.append(String.format("%02x", b));
		}
		return sb2.toString();
	}
}
