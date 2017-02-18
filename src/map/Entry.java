package map;

/**
 * @author Travis Buff
 *
 */
public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
	K key;
	V value;
	
	Entry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Entry<K, V> other) {
		return this.key.compareTo(other.key);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Entry))
			return false;
		Entry<K,V> entry = (Entry)obj;
		return this.key.equals(entry.key);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return key.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return key + " = " + value;
	}
	
	public K getKey(){
		return key;
	}

}
