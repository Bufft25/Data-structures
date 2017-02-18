package sort;

import list.*;

/**
 * Pre: List is sorted and list is of type ArrayList. Uses binary search to find
 * target element.
 * 
 * @author Travis Buff
 * @version 3/10/2015
 * @param <E>
 */
public class BinarySearch<E extends Comparable<E>> {
	List<E> list;

	public BinarySearch(List<E> list) {
		this.list = list;
	}

	/**
	 * @param target
	 *            is the element the list is being searched for.
	 * @return position where element is located.
	 */
	public int search(E target) {
		this.list = list;
		return finder(0, list.size() - 1, target);
	}

	/**
	 * used by search to find target location.
	 * 
	 * @param start
	 *            index where the binary search starts from.
	 * @param end
	 *            index where the binary search stops.
	 * @param target
	 *            element being searched for.
	 * @return position at which target element is located.
	 */
	private int finder(int start, int end, E target) {
		if (start > end) {
			return -1; // list does not contain target element
		}

		int mid = (start + end) / 2;
		int cmp = target.compareTo(list.get(mid));

		if (cmp == 0) {
			return mid;
		} else if (cmp < 0) {
			return finder(start, mid - 1, target);
		} else {
			return finder(mid + 1, end, target);
		}
	}
}
