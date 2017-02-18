package list;

/**
 * ListIterator has all the capabilities of an Iterator, plus: 1.) Can go from
 * the back of a list to the front. 2.) Can start from any given position.
 * 
 * @author Travis buff
 *
 * @param <E>
 */
public interface ListIterator<E> extends Iterator<E> {

	/**
	 * @param add
	 *            the given value at the cursor position. A subsequent call to
	 *            next() will be unaffected; a subsequent call to previous()
	 *            will return the value added
	 */
	void add(E value);

	/**
	 * @return true only if there are more elements toward the beginning of the
	 *         list.
	 */
	boolean hasPrevious();

	/**
	 * @return the element previous to the last one obtained precondition:
	 *         hasPrevious() is true.
	 */
	E previous();

	/**
	 * last value obtained by call to next or previous.
	 */
	@Override
	void remove();

}
