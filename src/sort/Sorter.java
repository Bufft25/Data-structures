package sort;

import list.*;

/**
 * A sorter is sorting algorithm.
 * 
 * @author Travis Buff
 * @version 3/1/2015
 * @param <E>
 */
public interface Sorter<E extends Comparable> {

	/**
	 * Method will sort differently depending on sort class used.
	 * 
	 * @param list
	 *            to be sorted.
	 */
	void sort(List<E> list);
}
