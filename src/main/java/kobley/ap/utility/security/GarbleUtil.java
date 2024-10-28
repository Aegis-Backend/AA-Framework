package kobley.ap.utility.security;

import kobley.ap.utility.misc.RandomUtil;

public class GarbleUtil {

	private static final int[] PRIMES = {29, 31, 37, 41, 43, 47};

	//If random = true, it will not output the same thing each run. Random is set to false for the peppering for this reason.
	public static String garbleChars(GarbleVersion version, char[] chars, int rounds, boolean random) {
		StringBuilder scrambled = new StringBuilder(chars.length);

		switch (version) {
			//V1 can increase length of output, as its garbling multiple times and adding each round to the output.
			case V1 -> {
				for (int r = 0; r < rounds; r++) {
					for (int i = 0; i < chars.length; i++) {
						char c = chars[i];

						//rotation within 1-5 bits.
						int shift = (i % (random ? RandomUtil.number(2, 5) : 5)) + 1;
						//Multiply for pseudo-random key.
						int xorKey = (chars.length ^ (c * (random ? PRIMES[RandomUtil.number(0, 5)] : 31))) % 256;

						char newChar = (char) (((c << shift) | (c >>> (8 - shift))) ^ xorKey);
						scrambled.append(newChar);
					}
				}
			}
			//V2 will keep the initial length, but apply rounds properly to each new char.
			case V2 -> {
				for (int i = 0; i < chars.length; i++) {
					char c = chars[i];
					char newChar = 0;
					for (int r = 0; r < rounds; r++) {
						//rotation within 1-5 bits.
						int shift = (i % (random ? RandomUtil.number(2, 5) : 5)) + 1;
						//Multiply for pseudo-random key.
						int xorKey = (chars.length ^ (c * (random ? PRIMES[RandomUtil.number(0, 5)] : 31))) % 256;

						newChar = (char) ((((newChar == 0 ? c : newChar) << shift) | (c >>> (8 - shift))) ^ xorKey);
					}
					scrambled.append(newChar);
				}
			}
		}

		return scrambled.toString();
	}

	public enum GarbleVersion {
		V1, V2;
	}
}
