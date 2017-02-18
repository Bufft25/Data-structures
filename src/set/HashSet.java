package set;
import hash.*;
import list.Iterator;

public class HashSet<E> implements Set<E> {
	HashTable<E> tableSet = new HashTable<E>();
	
	public int size() {
		return tableSet.size();
	}

	
	public boolean contains(Object obj) {
		return tableSet.containsKey(obj);
	}

	public boolean add(E value) {
		if(tableSet.containsKey(value)){
			return false;
		}
		tableSet.put(value);
		return true;
	}

	public void clear() {
		tableSet.clear();
	}

	public boolean remove(Object obj) {
		return tableSet.remove(obj);
	}

	public Iterator<E> iterator() {
		return tableSet.iterator();
	}

	public boolean isEmpty() {
		return tableSet.isEmpty();
	}
	
	public String toString(){
		Iterator<E> itty = this.iterator();
		String setString = "[";
		E valueCurrent;
		while (itty.hasNext()) {
			valueCurrent = itty.next();
			setString = setString + valueCurrent + ",";
		}
		setString =  setString.substring(0, setString.length() - 1) +"]";

		return setString;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Set) {
			Set set = (Set) obj;
			if(this.size() != set.size()){
				return false;
			}
			Iterator<E> itty = set.iterator();
			while (itty.hasNext()) {
				if (!(this.contains(itty.next()))) {
					return false;
				}
			}
		}
		return true;

	}

	/* (non-Javadoc)
	 * @see set.Set#subsetOf(set.Set)
	 */
	public boolean subsetOf(Set<E> other) {
		if (this == other)
			return true;

			if(!(other.size() >= this.size())){
				return false;
			}
			Iterator<E> itty = this.iterator();
			while (itty.hasNext()) {
				if (!(other.contains(itty.next()))) {
					return false;
				}
			}
		return true;
	}



	/* (non-Javadoc)
	 * @see set.Set#intersection(set.Set)
	 */
	public Set<E> intersection(Set<E> set) {
		Set<E> intersecting = new HashSet<E>();
		Iterator<E> itty = this.iterator();
		while(itty.hasNext()){
			E val = itty.next();
			if(set.contains(val)){
				intersecting.add(val);
			}
		}
		return intersecting;
	}

}
