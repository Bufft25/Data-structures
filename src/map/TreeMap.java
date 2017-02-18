package map;
import list.Iterator;
import set.HashSet;
import set.Set;
import set.TreeSet;
import tree.*;
/**
 * @author Travis Buff
 * @param <E>
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	BinaryTree<Entry<K,V>> tree = new EmptyBinarySearchTree<Entry<K,V>>();
	int size = 0;
	
	/* (non-Javadoc)
	 * @see map.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		return tree.containsKey(entry);
	}
	
	/* (non-Javadoc)
	 * @see map.Map#get(java.lang.Object)
	 */
	public V get(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		return entry.value;
	}
	
	/* (non-Javadoc)
	 * @see map.Map#put(java.lang.Object, java.lang.Object)
	 */
	public V put(K key, V value){
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K,V> oldEntry = tree.get(newEntry);
		if(oldEntry == null){
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		V result = oldEntry.value;
		oldEntry.value = value;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see map.Map#remove(java.lang.Object)
	 */
	public V remove(K key){
		Entry<K,V>	entry = new Entry<K,V>(key,null);
		entry = tree.get(entry);
		if(entry == null){
			return null;
		}
		tree = tree.remove(entry);
		size--;
		return entry.value;
	}


	/* (non-Javadoc)
	 * @see map.Map#isEmpty()
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}


	/* (non-Javadoc)
	 * @see map.Map#size()
	 */
	public int size() {
		return size;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return tree.toString();
	}


	/* (non-Javadoc)
	 * @see map.Map#keySet()
	 */
	public Set<K> keySet() {
		Set<K> keys = new TreeSet<K>();
		Iterator<Entry<K,V>> itty = tree.iterator();
		while(itty.hasNext()){
			keys.add(itty.next().key);
		}
		return keys;
	}
	
}
