package map;

import set.*;

/**
 * No Duplicate keys!
 * @author Travis Buff
 */
public interface Map<K, V> {

	/**
	 * @return true only if given key is in this map.
	 */
	boolean containsKey(K key);
	
	/**
	 * @return value corresponding to key in this Map, or return null if not in this Map.
	 */
	V get(K key);

	/**
	 * Put entry into Map, with given key and value.
	 * If key is already in this map than replace its value with given value.
	 * @return previous value, or null if not in map
	 */
	V put(K key, V value);
	
	/**
	 * @return true if this map has no entries, false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * @return number of entries in this Map.
	 */
	int size();
	
	/**
	 * Remove entry that has given key from this Map.
	 * @return value of entry that is removed, or null if not in this Map.
	 */
	V remove(K key);
	
	/**
	 * @return String for this Map.
	 */
	String toString();
	
	/** @return all the keys in this Map as a Set  */
	Set<K>  keySet ( );
}
