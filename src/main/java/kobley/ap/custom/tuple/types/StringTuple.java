package kobley.ap.custom.tuple.types;

import kobley.ap.custom.tuple.Tuple;

import java.util.Objects;

// Specifically for holding hash+salt for completed hashes. this might change because verification doesn't require the salt again.
public class StringTuple extends Tuple<String, String> {
	private final String hash;
	private final String salt;

	public StringTuple(String key1, String key2) {
		super(key1, key2);
		this.hash = key1;
		this.salt = key2;
	}

	public String getHash() {
		return hash;
	}

	public String getSalt() {
		return salt;
	}

	@Override
	public int compareTo(Tuple<String, String> other) {
		int comparison = hash.compareTo(other.getKey1());
		if (comparison != 0) {
			return comparison;
		}
		return salt.compareTo(other.getKey2());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tuple<?, ?> tuple = (Tuple<?, ?>) o;
		return (Objects.equals(hash, tuple.getKey1())) &&
				(Objects.equals(salt, tuple.getKey2()));
	}

	@Override
	public int hashCode() {
		int result = (hash != null) ? hash.hashCode() : 0;
		result = 31 * result + ((salt != null) ? salt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "StringTuple{" +
				"hash=" + this.getHash() +
				", salt=" + this.getSalt() +
				'}';
	}
}