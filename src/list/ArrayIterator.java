package list;

/**
 * Iterates through ArrayList
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
class ArrayIterator<E> implements Iterator<E> {
	int cursor;
	ArrayList<E> list;

	ArrayIterator(ArrayList<E> list) {
		this.list = list;
		cursor = -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return cursor < (list.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#next()
	 */
	@Override
	public E next() {
		cursor++;
		return list.get(cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.Iterator#remove()
	 */
	@Override
	public void remove() {
		list.remove(cursor);
		cursor--;

	}

}
