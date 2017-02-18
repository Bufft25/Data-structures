package queue;

import list.LinkedList;
import list.List;

/**
 * @author Travis Buff
 *
 * @param <E>
 */
public class Queue<E> implements QueueADT<E> {
	List<E> values;

	public Queue() {
		values = new LinkedList<E>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		if(value != null){
			values.add(value);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#remove()
	 */
	@Override
	public E remove() {
		E value = values.remove(0);
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#peek()
	 */
	@Override
	public E peek() {
		if (values.isEmpty()) {
			return null;
		} else {
			return values.get(0);
		}
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
	 * @see queue.QueueADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	@Override
	public int size() {
		return values.size();
	}

}
