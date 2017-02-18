package sort;

import list.*;

/**
 * @author Travis Buff
 */
public class HeapSort<E extends Comparable<E>> implements Sorter<E> {
	List<E> list;
	
	/* (non-Javadoc)
	 * @see sort.Sorter#sort(list.List)
	 */
	public void sort(List<E> list) {
		this.list = list;
		heapify(0);
		int last = list.size()-1;
		while(last > 0){
			swap(0,last);
			last--;
			percDown(0,last);
		}
	}
	
	private void heapify(int root){
		if((2*root + 1) > (list.size()-1)){
			return;
		}
		heapify(2*root+1);
		heapify(2*root+2);
		percDown(root,list.size()-1);
	}
	
	private void percDown(int root, int max){
		int bc = biggerChild(root,max);
		while((2*root+1 < max) && (greater(bc,root))){
			swap(root,bc);
			root = bc;
			bc = biggerChild(root,max);
		}
	}
	
	private int biggerChild(int root, int max){
		int left = 2*root+1;
		int right = 2*root+2;
		if(right > max)
			return left;
		if(greater(left,right))
			return left;
		return right;
	}
	
	private boolean greater(int i, int j){
		return list.get(i).compareTo(list.get(j)) > 0;
	}
	
	private void swap(int i, int j){
		E temp = list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}

}
