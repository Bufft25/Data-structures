package map;
import set.HashSet;
import set.Set;
import list.*;
import hash.*;
/**
 * @author Travis Buff
 *
 * @param <K> key
 * @param <V> value
 */
public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {
	HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
	
	public HashMap(){
		table = new HashTable<Entry<K,V>>(10);
	}
	
	/**
	 * @param capacity is the size the user wants the HashTable to be.
	 */
	public HashMap(int capacity){
		table = new HashTable<Entry<K,V>>(capacity);
	}
	
	
	/* (non-Javadoc)
	 * @see map.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key,null);
		return table.containsKey(entry);
	}

	
	/* (non-Javadoc)
	 * @see map.Map#get(java.lang.Object)
	 */
	public V get(K key) {	
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if(entry == null)
			return null;
		return entry.value;
	}

	
	/* (non-Javadoc)
	 * @see map.Map#put(java.lang.Object, java.lang.Object)
	 */
	public V put(K key, V value) {
		
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K,V> oldEntry = table.get(newEntry);
		if(oldEntry == null){
			table.put(newEntry);
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	
	/* (non-Javadoc)
	 * @see map.Map#isEmpty()
	 */
	public boolean isEmpty() {
		
		return table.isEmpty();
	}

	
	/* (non-Javadoc)
	 * @see map.Map#size()
	 */
	public int size() {
		
		return table.size();
	}

	
	/* (non-Javadoc)
	 * @see map.Map#remove(java.lang.Object)
	 */
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key,null);
		Entry<K,V> result = table.get(entry);
		if(table.remove(entry))
			return result.value;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String map = "[";
		Iterator<List<Entry<K, V>>> itty = table.getArray().iterator();
		while(itty.hasNext()){
			List<Entry<K,V>> entry = itty.next();
			if(!(entry.isEmpty())){
				map = map + entry + ",";
			}
		}
		map = map.substring(0, map.length() - 1) + "]";
		return map;
	}

	
	/* (non-Javadoc)
	 * @see map.Map#keySet()
	 */
	public Set<K> keySet() {
		Set<K> keys = new HashSet<K>();
		Iterator<Entry<K,V>> itty = table.iterator();
		while(itty.hasNext()){
			keys.add(itty.next().key);
		}
		return keys;
	}

}
