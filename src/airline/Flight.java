package airline;

/**
 * Flight has origin and destination of which each is an airport
 * @author Travis Buff
 *
 */
public class Flight {
	Airport origin,destination;
	
	public Flight(Airport o, Airport d){
		origin = o;
		destination = d;
	}
	
	public String toString(){
		return "(" + origin + "->" + destination + ")";
	}
}
