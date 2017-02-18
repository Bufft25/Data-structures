package list;

/**
 * Allow client to cycle through all elements in the List
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
public interface Iterator<E> {

	/**
	 * @return true only if there is more items in the List.
	 */
	boolean hasNext();

	/**
	 * @return the next item in the List. precondition: hasNext() is true.
	 */
	E next();

	/**
	 * remove last item obtained by Iterator precondition: next() has been
	 * called at least once. Also remove() CANNOT be called twice in a row
	 */
	void remove();

}
