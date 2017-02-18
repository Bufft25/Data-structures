package set;
import tree.*;
public class TreeSetIterator<E extends Comparable<E>> extends TreeIterator<E> {
	TreeSet<E> set;
	
	TreeSetIterator(TreeSet<E> set){
		super(set.tree);
		this.set = set;
	}
	
	public void remove(){
		set.tree = set.tree.remove(getLastGotten());
		set.size--;
	}

}
