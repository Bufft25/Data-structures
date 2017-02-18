package list;

/**
 * Can iterate backwards and forward through LinkedLists
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
public class RefListIterator<E> extends RefIterator<E> implements
		ListIterator<E> {
	private boolean forward = true;

	RefListIterator(LinkedList<E> list) {
		super(list);

	}

	RefListIterator(LinkedList<E> list, int indx) {
		super(list);
		for (int i = 0; i < indx; i++) {
			cursor = cursor.next; // cursor is a reference to the node last
									// obtained by a call to next or previous.
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.RefIterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (forward) {
			return cursor.next != list.tail;
		}
		forward = true;
		return (!list.isEmpty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.RefIterator#next()
	 */
	@Override
	public E next() {
		if (forward) {
			cursor = cursor.next;
		}
		forward = true;
		return cursor.value;
	}

	@Override
	public boolean hasPrevious() {
		if (!forward) {
			return cursor.prev != list.head;
		}
		return !(list.isEmpty());
	}

	@Override
	public E previous() {
		if (!forward) {
			cursor = cursor.prev;
		}
		forward = false;
		return cursor.value;
	}

	@Override
	public void remove() {
		super.remove();
		if (!forward)
			cursor = cursor.next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.ListIterator#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		Node<E> temp = new Node<E>(value,null,null);
		cursor.next.prev = temp.prev;
		cursor.prev.next = temp.next;
		list.size++;
		if(forward){
			cursor = cursor.next;
		}else{
			cursor = cursor.prev;
		}
	}

}
