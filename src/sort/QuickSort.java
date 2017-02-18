package sort;

import list.ArrayList;
import list.List;

public class QuickSort<E extends Comparable> implements Sorter<E> {
	private List<E> list;
	static int counter = 0;

	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size() - 1);
	}

	/**
	 * Sorts list by using recursive calls.
	 */
	private void qSort(int start, int end) {
		if ((end - start) < 1) {
			return;
		}
		int p = partion(start, end);
		qSort(start, p - 1);
		qSort(p + 1, end);
	}

	/**
	 * sorts list with values less than pivot on left and values greater than or
	 * equal to pivot on right of list.
	 * 
	 * @return pivot position
	 */
	private int partion(int start, int end) {
		int p = start;
		// pivot position middle//
		counter++;
		// pivot position
		E temp = list.get(start);
		E temp2 = list.get(((end + start) / 2));
		list.set(start, temp2);
		list.set(((end + start) / 2), temp);
		// end of pivot position middle add on//

		E pivVal = list.get(p);
		for (int i = start + 1; i <= end; i++) {
			if (list.get(i).compareTo(pivVal) < 0) {
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		}

		list.set(p, pivVal);
		return p;
	}

	/**
	 * @return number of times partition is called.
	 */
	public int getCount() {
		return counter;
	}

	public void clearCount() {
		counter = 0;
	}

}
