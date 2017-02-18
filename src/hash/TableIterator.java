package hash;
import list.*;
public class TableIterator<K> implements Iterator<K> {
	HashTable<K> table;
	Iterator<K> itty;
	int indx = 0;
	
	public TableIterator(HashTable<K> table){
		this.table = table;
		setItty(0);
	}
	
	private void setItty(int indx){
		itty = table.table.get(indx).iterator();
	}
	
	public boolean hasNext(){
		if(itty.hasNext()){
			return true;
		}
		for(indx++; indx<table.table.size(); indx++){
			if(!(table.table.get(indx).isEmpty())){
				setItty(indx);
				return true;
			}
		}
		return false;
	}
	
	public K next(){
		hasNext();
		return itty.next();
	}
	
	public void remove(){
		itty.remove();
		table.keyCount--;
	}
}
