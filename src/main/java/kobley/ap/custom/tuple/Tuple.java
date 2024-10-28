package kobley.ap.custom.tuple;

import java.util.Objects;

public class Tuple<K1 extends Comparable<K1>, K2 extends Comparable<K2>> implements Comparable<Tuple<K1, K2>> {
	private final K1 key1;
	private final K2 key2;

	public Tuple(K1 key1, K2 key2) {
		this.key1 = key1;
		this.key2 = key2;
	}

	public K1 getKey1() {
		return key1;
	}

	public K2 getKey2() {
		return key2;
	}

	@Override
	public int compareTo(Tuple<K1, K2> other) {
		int comparison = key1.compareTo(other.key1);
		if (comparison != 0) {
			return comparison;
		}
		return key2.compareTo(other.key2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tuple<?, ?> tuple = (Tuple<?, ?>) o;
		return (Objects.equals(key1, tuple.key1)) &&
				(Objects.equals(key2, tuple.key2));
	}

	@Override
	public int hashCode() {
		int result = (key1 != null) ? key1.hashCode() : 0;
		result = 31 * result + ((key2 != null) ? key2.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"key1=" + getKey1() +
				", key2=" + getKey2() +
				'}';
	}
}