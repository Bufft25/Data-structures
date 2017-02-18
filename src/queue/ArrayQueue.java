package queue;

import list.ArrayList;
import list.List;

/**
 * @author Travis Buff
 *
 * @param <E>
 */
public class ArrayQueue<E> implements QueueADT<E> {
	List<E> values;
	int qSize = 0;
	int front = 0;
	int back = 0; // Next avaliable position

	public ArrayQueue() {
		values = new ArrayList<E>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		if (qSize == values.size()) {
			values.add(back, value);
			front = (front + 1) % values.size();
		} else {
			values.set(back, value);
		}
		back = (back + 1) % values.size();
		qSize++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#remove()
	 */
	@Override
	public E remove() {
		E result = values.get(front);
		front = (front + 1) % values.size();
		qSize--;
		return result;
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
		}
		return values.get(front);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String queue = "[";
		for (int i = 0; i < (qSize); i++) {
			if ((front + i) < values.size()) {
				queue = queue + values.get(front + i);
				if (i == (qSize - 1)) {
					queue = queue + "]";
				} else {
					queue = queue + ",";
				}
			} else {
				int position = (front + i) % values.size();
				if (back == 0) {
					queue = queue + values.get((values.size() - 1));
					if (i == (qSize - 1)) {
						queue = queue + "]";
					} else {
						queue = queue + ",";
					}
				} else {
					queue = queue + values.get(position);
					if (i == (qSize - 1)) {
						queue = queue + "]";
					} else {
						queue = queue + ",";
					}
				}
			}
		}
		return queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see queue.QueueADT#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return qSize == 0;
	}

	@Override
	public int size() {
		return qSize;
	}
}
