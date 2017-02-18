package list;

/**
 * A list is a collection order is maintained duplicates permitted
 * 
 * @author Travis Buff
 * @version 1/26/2015
 */
public interface List<E> {

	/**
	 * Takes param value and adds it to the end of the List.
	 * 
	 * @param value
	 *            will be added to the end of the List
	 */
	void add(E value);

	/**
	 * Takes param value and inserts it at param index in the list. Note: if
	 * there is already a value in place at the specified index that value will
	 * be shifted and the size of the array will increase by one.
	 * 
	 * @param index
	 *            place value will be stored in list
	 * @param Value
	 *            is the type that will be stored
	 */
	void add(int index, E Value);

	/**
	 * Returners value from specified index.
	 * 
	 * @param index
	 *            location that value will be retrieved from
	 * @return type retrieved from index specified
	 */
	E get(int index);

	/**
	 * Changes the current value at specified index to new param value.
	 * 
	 * @param index
	 *            position where value is to be replaced
	 * @param value
	 *            new value that will take the old values position
	 */
	E set(int index, E value);

	/**
	 * Removes value from specified index.
	 * 
	 * @param index
	 *            position at which the value is to be removed
	 * @return value that is removed is returned by this method
	 */
	E remove(int index);

	/**
	 * Clears the array of all values.
	 */
	void clear();

	/**
	 * Checks to see if this List is empty or not. True if empty. False if not
	 * empty.
	 * 
	 * @return boolean value of empty check for this List.
	 */
	boolean isEmpty();

	/**
	 * gets size of this ArrayList and returns it. WARNING: DOES NOT RETURN THE
	 * LENGTH OF THE ARRAYLIST.
	 * 
	 * @return integer size of elements in this ArrayList.
	 */
	int size();

	/**
	 * @return the postion of the first occurrence of the value in this List, or
	 *         -1 if not found
	 */
	int indexOf(Object value);

	/** @return true only if value is contained in this List */
	boolean contains(Object value);

	/**
	 * @return the elements of this List as a String, with elements separated by
	 *         commas, enclosed in square brackets: [a,b,c]
	 */
	@Override
	String toString();

	/** @return true only if this List is equal to the (parameter sent in) other */
	@Override
	boolean equals(Object other);

	/**
	 * @return iterator for this List
	 */
	Iterator<E> iterator();

	/**
	 * @return ListIterator for this List.
	 */
	ListIterator<E> listIterator();

	/**
	 * @param indx
	 *            where you want this list to start iterating from.
	 * @return ListIterator for specific location specified by user.
	 */
	ListIterator<E> listIterator(int indx);

	/**
	 * Remove the first occurrence of obj from this List if possible.
	 * 
	 * @return true only if obj was removed.
	 */
	boolean remove(Object obj);

	/**
	 * @return true only if this List has at least one duplicate value
	 */
	boolean hasDuplicates();
}
