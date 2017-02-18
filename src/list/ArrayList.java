package list;

/**
 * Implements List, uses an array
 * @author Travis Buff
 *@version 1/26/2015
 */
/**
 * @author Travis Buff
 * @version 1/30/2015
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
	E[] values;
	int size = 0;

	/**
	 * Makes the length of this ArrayList 10 when object is initialized.
	 */
	public ArrayList() {
		this(10); // avoids duplicate code
	}

	/**
	 * This ArrayList's length will be set to specified capacity.
	 * 
	 * @param capacity
	 *            length this ArrayList will be set to start at
	 */
	public ArrayList(int capacity) {
		values = (E[]) new Object[capacity];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E value) {
		if (size == values.length) {
			alloc();
		}
		for (int i = size - 1; i >= index; i--) {
			values[i + 1] = values[i];
		}
		values[index] = value;
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#add(java.lang.Object)
	 */
	@Override
	public void add(E value) {
		add(size, value); // avoids code duplication
	}

	/**
	 * This method is invoked when this ArrayList if full. This method will
	 * double the length of this ArrayList.
	 */
	private void alloc() {
		E[] temp = (E[]) new Object[values.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#get(int)
	 */
	@Override
	public E get(int index) {
		return values[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E value) {
		if (values[index] == null) {
			size++;
		}
		E sendBack = values[index];
		values[index] = value;
		return sendBack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#remove(int)
	 */
	@Override
	public E remove(int index) {
		E result = values[index];
		if (result == null) {
			return result;
		}
		for (int i = index; i < size; i++) {
			values[i] = values[i + 1];
		}
		size--;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#clear()
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size - 1; i++) {
			values[i] = null;
		}
		size = 0;
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
	 * @see list.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object value) {
		for (int i = 0; i < this.size; i++) {
			if (values[i].equals(value)) {
				return i;
			}
		}
		return -1; // if Object isn't located in this ArrayList
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object value) {
		int check = this.indexOf(value);
		if (check >= 0) {
			return true;
		} else {
			return false;
		}
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
		for (int i = 0; i < ((this.size) - 1); i++) {
			outPut = outPut + values[i] + ",";
		}
		outPut = outPut + values[(size - 1)] + "]";
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
		List<E> list = (List<E>) other;
		if (this.size() == list.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (!(this.get(i).equals(list.get(i)))) {
					return false; // elements not the same.
				}
			}
		} else {
			return false; // size is not the same.
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
		return new ArrayIterator<E>(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index < 0) {
			return false;
		}
		remove(index);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#listIterator()
	 */
	@Override
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E>(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see list.List#listIterator(int)
	 */
	@Override
	public ListIterator<E> listIterator(int indx) {
		return new ArrayListIterator<E>(this, indx);
	}

	@Override
	public boolean hasDuplicates() {
		// TODO Auto-generated method stub
		return false;
	}
}
