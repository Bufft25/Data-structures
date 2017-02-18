/**
 * 
 */
package set;
import list.*;
import tree.*;
/**
 * Implements set with BinaryTree.
 * Values of this set will be in ASCENDING order.
 * @author Travis buff
 */
public class TreeSet<E extends Comparable<E>> implements Set<E> {
	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;
	
	/* (non-Javadoc)
	 * @see set.Set#size()
	 */
	public int size() {
		return size;
	}

	/* (non-Javadoc)
	 * @see set.Set#contains(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(Object obj) {
		E value;
		try{
			value = (E) obj;
			return tree.containsKey(value);
		}catch(ClassCastException cce){
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see set.Set#add(java.lang.Object)
	 */
	public boolean add(E value) {
		if(tree.containsKey(value)){
			return false;
		}
		tree = tree.add(value); //switching from EBST to BST.
		size++;
		return true;
	}

	/* (non-Javadoc)
	 * @see set.Set#clear()
	 */
	public void clear() {
		tree = new EmptyBinarySearchTree<E>();
		size = 0;
	}

	/* (non-Javadoc)
	 * @see set.Set#remove(java.lang.Object)
	 */
	public boolean remove(Object obj) {
		if(!this.contains(obj)){
			return false;	
		}
		tree = tree.remove(obj);
		size--;
		return true;
	}

	/* (non-Javadoc)
	 * @see set.Set#iterator()
	 */
	public Iterator<E> iterator() {
		return new TreeSetIterator<E>(this);
	}
	
	/* (non-Javadoc)
	 * @see set.Set#isEmpty()
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return tree.toString();
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
