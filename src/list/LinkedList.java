package list;

import java.util.HashSet;
import java.util.Set;

import queens.Position;

/**
 * Implementation of List optimized for changing size(adding and removing).
 * 
 * @author Travis Buff
 * @version 2/1/2015
 * @param <E>
 */
public class LinkedList<E> implements List<E> {
	Node<E> head = new Node<E>(null, null, null);
	Node<E> tail = new Node<E>(null, null, head);;
	int size = 0;
	private Node<E> ref;

	/**
	 * makes sure when initialized that heads next node points to tail.
	 */
	public LinkedList() {
		head.next = tail;
	}

	/**
	 * @param listCopy is the LinkedList<E> to be copied to this LinkedList.
	 */
	public LinkedList(List<E> listCopy) {
		this();
		LinkedList<E> copy = (LinkedList<E>) listCopy;
		if(copy.head != null){
			Iterator<E> itty = copy.iterator();
			while(itty.hasNext()){
				add(itty.next());
			}
		}		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}

	/**
	 * chooses the quickest way to reach index'd element by comparing the size
	 * and index together. index being less than size will cause the for loop to
	 * search from head. if index is greater or equal to size than the for loop
	 * will search from tail.
	 * 
	 * @param indx
	 *            the position at which an element is being set for this ref.
	 */
	private void setRef(int indx) {
		if (indx < (size / 2)) {
			ref = head;
			for (int i = 0; i <= indx; i++) {
				ref = ref.next;
			}
		} else {
			ref = tail;
			for (int i = size; i > indx; i--) {
				ref = ref.prev;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E value) {
		this.setRef(index);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		ref.prev = temp;
		temp.prev.next = temp;
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#get(int)
	 */
	@Override
	public E get(int index) {
		this.setRef(index);
		return ref.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E value) {
		this.setRef(index);
		E result = ref.value;
		ref.value = value;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#remove(int)
	 */
	@Override
	public E remove(int index) {
		this.setRef(index);
		ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		size--;
		return ref.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#clear()
	 */
	@Override
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
		ref = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object value) {
		ref = head;
		for (int i = 0; i < size; i++) {
			ref = ref.next;
			if (ref.value.equals(value)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object value) {
		ref = head;
		for (int i = 0; i < size; i++) {
			ref = ref.next;
			if (ref.value.equals(value)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String outPut = "[";
		if (size == 0) {
			return outPut + "]";
		}
		ref = head;
		for (int i = 0; i < ((this.size) - 1); i++) {
			ref = ref.next;
			outPut = outPut + ref.value + ",";
		}
		ref = ref.next;
		outPut = outPut + ref.value + "]";
		return outPut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true; // points to the same reference.
		}
		if (!(other instanceof List)) {
			return false; // isn't a list.
		}
		if (this.size() == ((List<E>) other).size()) {
			Iterator<E> l1 = this.iterator();
			Iterator l2 = ((List) other).iterator();

			while (l1.hasNext()) {
				Object obj1 = l1.next();
				Object obj2 = l2.next();
				if (!(obj1.equals(obj2))) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true; // lists have the same elements and size as each other.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object obj) {
		int index = this.indexOf(obj);
		if (index < 0) {
			return false;
		}
		this.remove(index);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#listIterator()
	 */
	@Override
	public ListIterator<E> listIterator() {
		return new RefListIterator<E>(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#listIterator(int)
	 */
	@Override
	public ListIterator<E> listIterator(int indx) {
		return new RefListIterator<E>(this, indx);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#hasDuplicates()
	 */
	@Override
	public boolean hasDuplicates() {
		Set<E> checkDups = new HashSet<E>();
		RefListIterator<E> it = (RefListIterator<E>) listIterator();
		while (it.hasNext()) {
			E value = it.next();
			checkDups.add(value);
		}
		if (checkDups.size() < this.size()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Pre: this list must have comparalbe elements in it. sort this list in
	 * ascending order.
	 */
	public void bubbleSort() {
		Node<E> ref = head;
		if (size < 2) {
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			ref = head.next;
			for (int j = 0; j < size - i - 1; j++) {
				if (((Comparable) ref.value).compareTo(ref.next.value) > 0) {
					swap(ref);
				}
				ref = ref.next;
			}
		}
	}

	/**
	 * Used by bubbleSort() method. swaps the value in the node of ref with its
	 * neighbor.
	 */
	private void swap(Node<E> ref) {
		E temp = ref.value;
		ref.value = ref.next.value;
		ref.next.value = temp;
	}
}
