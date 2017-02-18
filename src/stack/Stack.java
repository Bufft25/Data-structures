package stack;

import list.ArrayList;
import list.LinkedList;
import list.List;

/**
 * @author Travis Buff
 * @version 2/10/15
 * @param <E>
 */
public class Stack<E> implements StackADT<E> {
	List<E> values; // end of list is the top of this stack.

	public Stack() {
		this(true);
	}

	public Stack(boolean arrayBased) {
		if (arrayBased) {
			values = new ArrayList<E>();
		} else {
			values = new LinkedList<E>();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stack.StackADT#push(java.lang.Object)
	 */
	@Override
	public E push(E value) {
		values.add(value);
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stack.StackADT#pop()
	 */
	@Override
	public E pop() {
		return values.remove((values.size()) - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stack.StackADT#peek()
	 */
	@Override
	public E peek() {
		return values.get((values.size()) - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return values.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stack.StackADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stack.StackADT#clear()
	 */
	@Override
	public void clear() {
		values.clear();
	}

}
