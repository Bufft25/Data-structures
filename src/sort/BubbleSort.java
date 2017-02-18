package sort;

import list.*;

/**
 * pre: Use ArrayList. uses bubble sort algorithm to sort specified List.
 * 
 * @author Travis Buff
 * @Version 3/1/2015
 */
public class BubbleSort<E extends Comparable> implements Sorter<E> {
	List<E> list;

	public void sort(List<E> list) {
		this.list = list;
		for (int i = 0; i < (list.size() - 1); i++) {
			for (int j = 0; j < ((list.size() - i) - 1); j++) {
				E value = list.get(j);
				if ((value.compareTo(list.get(j + 1))) > 0) {
					swap(j, j + 1);
				}
			}
		}
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
