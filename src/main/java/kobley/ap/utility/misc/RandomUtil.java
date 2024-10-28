package kobley.ap.utility.misc;

import java.security.SecureRandom;

public class RandomUtil {

	private static final int SEED_BYTES = 16;
	private static final SecureRandom seeder = new SecureRandom();

	public static int number(int min, int max) {
		SecureRandom rand = new SecureRandom(seeder.generateSeed(SEED_BYTES));

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return rand.nextInt((max - min) + 1) + min;
	}

	public static float number(float min, float max) {
		SecureRandom rand = new SecureRandom(seeder.generateSeed(SEED_BYTES));

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return rand.nextFloat((max - min) + 1) + min;
	}

	public static String string(CharsetType type, int length) {
		SecureRandom rand = new SecureRandom(seeder.generateSeed(SEED_BYTES));
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
