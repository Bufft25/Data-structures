/**
 * 
 */
package set;
import list.*;

/**
 * SetADT is a collection. No order is required. NO DUPLICATES.
 * 
 * @author Travis Buff
 */
public interface Set<E> {

	/**
	 * @return size of this set.
	 */
	int size();
	
	/**
	 * @param obj being looked for in this set.
	 * @return If param obj is in this set return true, otherwise return false.
	 */
	boolean contains(Object obj);
	
	/**
	 * @param value to be added to this set.
	 * @return true if value is added, false otherwise.
	 */
	boolean add(E value);
	
	/**
	 * clear this set of values.
	 */
	void clear();
	
	/**
	 * @param obj to be removed from this set.
	 * @return true if obj was removed from this set, false otherwise.
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator of this set.
	 */
	Iterator<E> iterator();
	
	/**
	 * @return true if this set is empty, false otherwise.
	 */
	boolean isEmpty();
	
	/** @return All the elements in this set as a String in the following format:
    [a,b,c]
	 */
	String toString();
	
	/** @return true only if this Set is equal to the parameter, other */ 
	boolean equals (Object other);
	
	/** @return true only if this Set is a subset of the parameter, other */ 
	boolean subsetOf (Set<E> other);
	
	 /** @return A set which is the intersection of this Set with the given set */
	Set <E>  intersection (Set <E> set);
	
}
