package passengers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import flight.FlightMap;
import utility.*;

public class PassengerMap {
	public HashMap<String, Passenger> passenger;
	UtilsPassenger u;
	
	/**
	 * constructor of class FlightMap 
	 */
	public PassengerMap() {
		passenger = new HashMap<String, Passenger>();
		u = new UtilsPassenger();
	}
	
	
	/**
	 * @param filename
	 * Function responsible for reading Passenger.csv
	 */
	public void processPassengerFile(String filename) {
		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String inputLine = scanner.nextLine();
				if(inputLine.length() != 0) {
					this.populatePassengerMap(inputLine);
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
	 * function creates a Passenger class Object
	 */
	private void populatePassengerMap(String line) {
		try {
			String parts[] = line.split(",");
			String bCode = parts[0];
			String firstName = parts[1];
			String lastName = parts[2];
			Name name = new Name(firstName, lastName);			
			String dest = parts[3];
			String checkedIn = parts[4];
			int totalWgt = Integer.parseInt(parts[5]);
			int length = Integer.parseInt(parts[6]);
			int breadth = Integer.parseInt(parts[7]);
			int height = Integer.parseInt(parts[8]);
			String fcode = u.getFCode(FlightMap.getFlight(), dest);
			Passenger p = new Passenger(fcode, dest, bCode, name, totalWgt, length, breadth, height, checkedIn);
			this.addPassengerToMap(p);
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
	
	/**
	 * @param Passenger p
	 * @return boolean
	 * Function adds Passenger object to passenger HashMap
	 */
	private boolean addPassengerToMap(Passenger p) {
		String id = p.getBookingCode();
		boolean inMap = passenger.containsKey(id);
		if(inMap == false) {
			passenger.put(p.getBookingCode(), p);
			return true;
		}
		return false;
	}
	
	
	public void outputPassengerResults() {
		
		for(Map.Entry<String, Passenger> kv: passenger.entrySet()) {
			
			String key = kv.getKey();
			Passenger value = kv.getValue();
			System.out.print(key);
			System.out.print(" : ");
			System.out.print(value.getPassengerDetails());
			System.out.println();
		}
	}
	
    public boolean isEmpty() 
    {
	    	if (passenger.size() == 0) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
    }
    
    public Passenger getFirst() {
    		String id = String.valueOf(passenger.keySet().toArray()[0]);
    		if (id != null)
    			return passenger.get(id);
    		else
    			return null;
    }
    
    public void removeOne(Passenger p) {
    		String id = p.getBookingCode();
    		passenger.remove(id);
    }
	
}
