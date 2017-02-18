package list;

/**
 * Store a value and a reference to a node.
 * 
 * @author bufft25
 * @version 1/28/2015
 * @param <E>
 */
class Node<E> {
	E value;
	Node<E> next;
	Node<E> prev;

	/**
	 * @param value
	 */
	Node(E value, Node<E> next, Node<E> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

}
