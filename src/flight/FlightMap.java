package flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import passengers.Passenger;

/**
 * @author rsureen
 * This class is responsible for storing data in HashMap
 */
public class FlightMap {
	public static HashMap<String, Flight> flight;
	
	
	/**
	 * constructor of class FlightMap 
	 */
	public FlightMap() {
		flight = new HashMap<String, Flight>();
	}

	
	
	public static HashMap<String, Flight> getFlight() {
		return flight;
	}



	public void processFlightFile(String filename) {
		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String inputLine = scanner.nextLine();
				if(inputLine.length() != 0) {
					this.populateFlightMap(inputLine);
				}
			}			
		}
		catch(FileNotFoundException fnf) {
			System.out.println(filename+ " not found ");
			System.exit(0);
		}
	}
	/**
	 * @param line
	 * 
	 */
	private void populateFlightMap(String line) {
		try {
			String parts[] = line.split(",");
			String fCode = parts[0];
			String dest = parts[1];
			int maxPsg = Integer.parseInt(parts[2]);
			int maxBagWgt = Integer.parseInt(parts[3]);
			int maxBagVol = Integer.parseInt(parts[4]);
			
			Flight f = new Flight(fCode, dest, maxPsg, maxBagWgt, maxBagVol);
			this.addFlightToMap(f);
		}
		catch(NumberFormatException nfe) {
			String error = "Number conversion error in '" + line + "' - "
					+ nfe.getMessage();
			System.out.println(error);
		}
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + line
			                        + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}

	private boolean addFlightToMap(Flight f) {
		String id = f.getFlightCode();
		boolean inMap = flight.containsKey(id);
		if(inMap == false) {
			flight.put(f.getFlightCode(), f);
			return true;
		}
		return false;
	}
	
	public void outputFlightResults() {
		
		for(Map.Entry<String, Flight> kv: flight.entrySet()) {
			
			String key = kv.getKey();
			Flight value = kv.getValue();
			System.out.print(key);
			System.out.print(" : ");
			System.out.print(value.getFlightDetails());
			System.out.println();
		}
	}
	
    public boolean isEmpty() 
    {
	    	if (flight.size() == 0) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
    }
    
    public Flight getFlight(String code) {
		String id = code;
		if (id != null)
			return flight.get(id);
		else
			return null;
    }

    public void removeOne(String code) {
//		String id = f.getFlightCode();
		flight.remove(code);
    }
}
