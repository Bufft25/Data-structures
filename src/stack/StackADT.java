package stack;

/**
 * An ADT implements a LIFO data structure.
 * 
 * @author Travis Buff
 *
 * @param <E>
 */
public interface StackADT<E> {

	/**
	 * @param value
	 *            is added to top of this stack.
	 * @return the value added to top of this stack.
	 */
	E push(E value);

	/**
	 * Remove top value from this stack.
	 * 
	 * @return the value removed. Pre: Stack is NOT empty.
	 */
	E pop();

	/**
	 * @return top value of this stack. Pre: Stack is NOT empty.
	 */
	E peek();

	/**
	 * @return the elements of this Stack as a String, with elements separated
	 *         by commas, enclosed in square brackets. top element is the last
	 *         element in the string.
	 */
	@Override
	String toString();

	/**
	 * @return true if this Stack is empty, false otherwise.
	 */
	boolean isEmpty();

	/**
	 * clear stack of all elements.
	 */
	void clear();
}
