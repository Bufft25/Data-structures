package queue;

/**
 * FIFO Data Structure
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
public interface QueueADT<E> {

	/**
	 * @param value
	 *            is added to the back of queue.
	 */
	void add(E value);

	/**
	 * removes value from the front of the queue
	 * 
	 * @return value that was removed from queue. pre: queue is NOT empty.
	 */
	E remove();

	/**
	 * @return value at front of queue or null reference if empty.
	 */
	E peek();

	/**
	 * @return a String of this queue.
	 */
	@Override
	String toString();

	/**
	 * Checks to see if this List is empty or not. True if empty. False if not
	 * empty.
	 * 
	 * @return boolean value of empty check for this List.
	 */
	boolean isEmpty();

	/**
	 * @return the size of this queue.
	 */
	int size();

}
