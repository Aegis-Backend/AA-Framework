package kobley.ap.utility.security;

import kobley.ap.utility.misc.RandomUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SeasoningUtil {

	//Is this buttass? Maybe.
	public static String getSalt(int bytes) {
		//number of bytes, all the character-sets should be ascii so ~ one byte for each char.
		return RandomUtil.string(RandomUtil.CharsetType.ALPHANUMERIC, bytes);
	}

	//Honestly might change. But I like how this feels + I don't have to store the pepper.
	public static String getPepper(char[] chars) {
		//Scramble input. Using V2 as to not change length of chars array.
		String scrambled = GarbleUtil.garbleChars(GarbleUtil.GarbleVersion.V2, chars, 16, false);

		//Hash scrambled input.
		//Initializing MessageDigest in function bad but this is only used to initially hash->store password, and when verifying. So I guess its okay?
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(scrambled.toString().getBytes(StandardCharsets.UTF_8));

		byte[] digest = md.digest();
		StringBuilder finalPepper = new StringBuilder(digest.length * 2);
		for (byte b : digest) {
			finalPepper.append(String.format("%02x", b));
		}

		return finalPepper.toString();
	}
}
