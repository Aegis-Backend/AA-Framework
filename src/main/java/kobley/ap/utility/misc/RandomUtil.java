package kobley.ap.utility.misc;

import java.security.SecureRandom;

public class RandomUtil {

	private static final int SEED_BYTES = 32;
	private static final SecureRandom SEEDER = new SecureRandom(new byte[] {0x44, 0x45, 0x41, 0x44, 0x42, 0x45, 0x45, 0x46}); // DEADBEEF in unicode/utf-8.

	//Random int in given range.
	public static int number(int min, int max) {
		SecureRandom rand = new SecureRandom(SEEDER.generateSeed(SEED_BYTES));

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return rand.nextInt((max - min) + 1) + min;
	}

	//Random float in given range.
	public static float number(float min, float max) {
		SecureRandom rand = new SecureRandom(SEEDER.generateSeed(SEED_BYTES));

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return rand.nextFloat((max - min) + 1) + min;
	}

	//Random string of given length and character-set.
	public static String string(CharsetType type, int length) {
		SecureRandom rand = new SecureRandom(SEEDER.generateSeed(SEED_BYTES));
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(type.getCharset().length());
			sb.append(type.getCharset().charAt(index));
		}

		return sb.toString();
	}

	public enum CharsetType {
		ALPHA("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
		NUMERIC("0123456789"),
		ALPHANUMERIC("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

		private final String charset;

		CharsetType(String charset) {
			this.charset = charset;
		}

		public String getCharset() {
			return this.charset;
		}
	}
}
