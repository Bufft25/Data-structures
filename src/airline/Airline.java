package airline;

import stack.*;
import list.*;
import map.*;
import java.util.Scanner;
import java.io.*;
import set.*;

/**
 * Is made up of a collection of direct flights. Can give you path from one
 * airport to another, if such a path exists.
 * 
 * @author Travis buff
 */
public class Airline {
	List<Flight> flights;
	Map<String, Airport> map;

	public static void main(String[] args) {
		Airline airline = new Airline();

		airline.getFlights();

		System.out.println("Flights:" + airline.flights);

		System.out.println("Path from PHL to SFO");
		System.out.println(airline.path("PHL", "SFO"));

		System.out.println("Path from JFK to LAX");
		System.out.println(airline.path("JFK", "LAX"));

		System.out.println("Path from LAX to SFO");
		System.out.println(airline.path("LAX", "SFO"));

		System.out.println("Path from LAG to SFO");
		System.out.println(airline.path("LAG", "SFO"));

	}

	/**
	 * uses text file to initialize the list of flights.
	 */
	private void getFlights() {
		File inFile = new File("flights.txt");
		flights = new ArrayList<Flight>();
		map = new HashMap<String, Airport>();
		try {
			Scanner scan = new Scanner(inFile);
			String flight, origin, dest;
			Airport o, d;
			while (scan.hasNextLine()) {
				flight = scan.nextLine();
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
				if (map.containsKey(origin)) {
					o = map.get(origin);
				} else {
					o = new Airport(origin);
					map.put(origin, o);
				}
				if (map.containsKey(dest)) {
					d = map.get(dest);
				} else {
					d = new Airport(dest);
					map.put(dest, d);
				}
				flights.add(new Flight(o, d));
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}

	/**
	 * @return a list of airports from origin to dest, or empty list if no path
	 *         exists
	 */
	public Stack<Airport> path(String origin, String dest) {
		Stack<Airport> result = new Stack<Airport>();
		//List<Airport> result = new LinkedList<Airport>();
		Airport o = map.get(origin);
		Airport d = map.get(dest);

		// result = path (o, d);

		result.push(o);
		o.visited = true;
		result = getNextAirport(result, o, d);

		clearAirports();
		return result;
	}

	private Stack<Airport> getNextAirport(Stack<Airport> stack, Airport origin,
			Airport dest) {
		Airport port = origin;

		while (!stack.isEmpty()) {
			if (stack.peek().equals(dest)) // base case
			{

				return stack;
			}

			List<Airport> directs = getDirect(port);

			if (directs.get(0) == null) {
				Airport temp = stack.peek();

				if (getDirect(temp).size() == 0) {
					stack.pop();
				} else {
					port = temp;
				}

			} else {
				stack.push(directs.get(0));
				directs.get(0).visited = true;
				port = directs.get(0);
			}

			// port = stack.peek();
		}

		return stack;
	}

	/**
	 * @param origin
	 *            is the starting airport.
	 * @param dest
	 *            is the ending airport.
	 * @return List of airports that were visited during flight. Or empty if
	 *         none.
	 */
	private List<Airport> path(Airport origin, Airport dest) {
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		if (origin.equals(dest)) {
			result.add(origin);
			return result;
		}

		Airport port;
		// cycle through all Airports directly accessible from origin.
		Iterator<Airport> itty = getDirect(origin).iterator();
		while (itty.hasNext()) {
			port = itty.next();
			result = path(port, dest);
			if (result.size() > 0) {
				result.add(0, origin);
				return result;
			}
		}
		return result;
	}

	/**
	 * @return List of Airports directly accessible to this origin and have not
	 *         been visited.
	 */
	private List<Airport> getDirect(Airport origin) {
		List<Airport> result = new LinkedList<Airport>();
		Iterator<Flight> itty = flights.iterator();
		Flight flight;
		while (itty.hasNext()) {
			flight = itty.next();
			if (flight.origin.equals(origin) && !flight.destination.visited)
				result.add(flight.destination);
		}
		return result;
	}

	// Clear all the visited flags.
	private void clearAirports() {
		Set<String> names = map.keySet();
		Airport port;
		Iterator<String> itty = names.iterator();
		while (itty.hasNext()) {
			port = map.get(itty.next());
			port.visited = false;
		}
	}

}
