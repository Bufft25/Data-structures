package list;

/**
 * @author Travis Buff
 *
 * @param <E>
 */
public class ArrayListIterator<E> extends ArrayIterator<E> implements
		ListIterator<E> {
	private boolean forward = true;

	ArrayListIterator(ArrayList<E> list) {
		super(list);
		super.cursor = 0; // cursor index
	}

	ArrayListIterator(ArrayList<E> list, int indx) {
		this(list);
		super.cursor = indx;
	}

	@Override
	public boolean hasNext() {
		return cursor < list.size();
	}

	@Override
	public E next() {
		cursor++;
		forward = true;
		return list.get(cursor - 1);
	}

	@Override
	public boolean hasPrevious() {
		return cursor > 0;
	}

	@Override
	public E previous() {
		forward = false;
		cursor--;
		return list.get(cursor);
	}

	@Override
	public void remove() {
		if (forward) {
			cursor--;
		}
		list.remove(cursor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.ListIterator#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		super.list.add(this.cursor, value);
		cursor++;
	}
}
