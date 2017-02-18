package list;

/**
 * Iterate through LinkedLists
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
class RefIterator<E> implements Iterator<E> {
	Node<E> cursor;
	LinkedList<E> list;

	RefIterator(LinkedList<E> list) {
		this.list = list;
		cursor = this.list.head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return (cursor.next != list.tail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#next()
	 */
	@Override
	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#remove()
	 */
	@Override
	public void remove() {
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		cursor = cursor.prev;
		list.size--;
	}

}
