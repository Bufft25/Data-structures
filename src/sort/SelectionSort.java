package sort;

import list.List;

/**
 * pre: List used should be ArrayList. Uses the selection sort algorithm to sort
 * specified List.
 * 
 * @author Travis Buff
 * @version 3/1/2015
 * @param <E>
 */
public class SelectionSort<E extends Comparable<E>> implements Sorter<E> {

	List<E> list;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sort.Sorter#sort(list.List)
	 */
	public void sort(List<E> list) {
		this.list = list;
		for (int i = 0; i < (list.size() - 1); i++) {
			swap(i, posSmallest(i));
		}
	}

	/**
	 * @param start
	 *            is the index of the current position to
	 * @return position of smallest element in list that pocedes start.
	 */
	private int posSmallest(int start) {
		int result = start; // starting position of smallest element found so
							// far.
		for (int i = start; i < list.size(); i++) {
			if ((list.get(i).compareTo(list.get(result))) < 0) {
				result = i;
			}
		}
		return result;
	}

	/**
	 * swaps the elements at the two given indexes.
	 * 
	 * @param i
	 *            to be swapped with element at index j.
	 * @param j
	 *            to be swapped with element at index i.
	 */
	private void swap(int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
