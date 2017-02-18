package airline;

/**
 * Has the name of Airport along with boolean value for being previously visited.
 * @author Travis Buff
 *
 */
public class Airport {
	String name;
	boolean visited = false;
	
	
	public Airport(String name){
		this.name = name;
	}
	
	public boolean equals(Object obj){
		if((obj == null) || (!(obj instanceof Airport)))
			return false;
		
		
		Airport airport = (Airport) obj;
		return name.equals(airport.name);
	}
	
	public String toString(){
		String result = name;
		return result;
	}
}
