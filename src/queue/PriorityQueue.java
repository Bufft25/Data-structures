package queue;
import list.*;

/**
 * uses heaping to allow for a priority queue.
 * @author Travis Buff
 */
public class PriorityQueue<E extends Comparable<E>> implements QueueADT<E> {
	List<E> values = new ArrayList<E>();
	int size = 0;
	
	/* (non-Javadoc)
	 * @see queue.QueueADT#add(java.lang.Object)
	 */
	public void add(E value) {
		int added = size;
		int parent = (size-1)/2;
		if(size == values.size()){
			values.add(value);
		}else{
			values.set(size,value);
		}
		size++;
		while((greater(added,parent)) && (added > 0)){
			swap(added,parent);
			added = parent;
			parent = (added-1)/2;
		}
	}

	
	/* (non-Javadoc)
	 * @see queue.QueueADT#remove()
	 */
	public E remove() {
		E result = values.get(0);
		int avail = 0;
		int bigger = biggerChild(avail);
		size--;
		while(((avail*2+1) < size) && greater(bigger,size)){
			values.set(avail,values.get(bigger));
			avail = bigger;
			bigger = biggerChild(avail);
		}
		values.set(avail,values.get(size));
		return result;
	}
	
	/* (non-Javadoc)
	 * @see queue.QueueADT#peek()
	 */
	public E peek() {
		if (values.isEmpty()) {
			return null;
		}
		return values.get(0);
	}

	
	/* (non-Javadoc)
	 * @see queue.QueueADT#isEmpty()
	 */
	public boolean isEmpty() {
		return size == 0;
	}


	/* (non-Javadoc)
	 * @see queue.QueueADT#size()
	 */
	public int size() {
		return size;
	}
	
	
    /**
     * @param parent is the location of root for this heap currently being compared to its children.
     * @return child that is bigger than the other child.
     */
    private int biggerChild(int parent)
    {   int left = 2*parent+1,
            right = 2*parent+2;
        if (right >= size)
            return left;
         if (greater (left,right))
            return left;
         return right;
    }
	
	/**
	 * @param i place of element in ArrayList.
	 * @param j place of element in ArrayList.
	 * @return true if the element from placement i in ArraYList is greater than element from placement j in ArrayList.
	 */
	private boolean greater(int i, int j){
		return values.get(i).compareTo(values.get(j)) > 0;
	}
	
	/**
	 * swaps to values.
	 */
	private void swap(int i, int j){
		E temp = values.get(i);
		values.set(i,values.get(j));
		values.set(j,temp);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String outPut = "[";
		if (size == 0) {
			return outPut + "]";
		}
		for (int i = 0; i < ((this.size) - 1); i++) {
			outPut = outPut + values.get(i) + ",";
		}
		outPut = outPut + values.get(size - 1) + "]";
		return outPut;
	}

}
