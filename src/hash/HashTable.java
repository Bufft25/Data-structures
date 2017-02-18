package hash;

import list.*;

/**
 * Allows quick access to data. Values stored are key(k).
 * 
 * @author Travis Buff
 * @param <K>
 */
public class HashTable<K> {
	protected List<List<K>> table = new ArrayList<>();
	int keyCount;

	public HashTable(int tableSize) {
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<K>());
		}
	}

	public HashTable() {
		this(10);
	}
	
	public List<List<K>> getArray(){
		return table;
	}

	/**
	 * @param obj
	 *            is the object being checked for in this hashtable.
	 * @return true if given object is in this hashtable.
	 */
	public boolean containsKey(Object obj) {
		K key;
		try {
			key = (K) obj;
			int code = this.getCode(key);
			List<K> list = table.get(code);
			return list.indexOf(key) >= 0;
		} catch (ClassCastException cce) {
			return false;
		}
	}

	/**
	 * @param key
	 *            : value being used.
	 * @return a valid position in this hashtable, using hashCode() on given
	 *         key.
	 */
	private int getCode(K key) {
		return Math.abs(key.hashCode()) % table.size();
	}

	/**
	 * @param key
	 *            : value being used.
	 * @return the key from this hashtable which is equal to the given key, or
	 *         null if not found.
	 */
	public K get(K key) {
		int code = getCode(key);
		int index = table.get(code).indexOf(key);
		if (index < 0) {
			return null;
		}
		return table.get(code).get(index);
	}

	/**
	 * enter key into this hashtable.
	 * 
	 * @param key
	 *            : value being used.
	 */
	public void put(K key) {
		int index = getCode(key);
		table.get(index).add(key);
		keyCount++;
	}

	public boolean isEmpty() {
		return keyCount == 0;
	}

	public int size() {
		return keyCount;
	}

	public boolean remove(Object obj) {
		K key;
		try {
			key = (K) obj;
			int index = getCode(key);
			if (table.get(index).remove(key)) {
				keyCount--;
				return true;
			}
			return false;
		} catch (ClassCastException CCE) {
			return false;
		}
	}

	/**
	 * method clears
	 */
	public void clear() {
		for (int i = 0; i < table.size() - 1; i++) {
			table.get(i).clear();
		}
		keyCount = 0;
	}
	
	public Iterator<K> iterator(){
		return new TableIterator<K>(this);
	}
	
	public String toString(){
		return table.toString();
	}

}
