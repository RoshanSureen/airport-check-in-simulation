package flight;

import utility.*;

/**
 * @author RoshanSureen
 */
public class Flight {
	private String flightCode;
	private String destination;
	private int maxPassengers;
	private int maxBagWgt;
	private int maxBagVol;
	private UtilsFlight u;
	
	/**
	 * this constructor sets the flight_code and destination
	 * It also declares an object of class Utils
	 * @param fCode the flight_code
	 * @param dest the destination
	 */
	public Flight(String fCode, String dest, int maxPasg, int maxBgWt, int maxBgVol) {
		u = new UtilsFlight();
		this.checkAndSetFCode(fCode, dest);
		this.destination = dest;
		this.maxPassengers = maxPasg;
		this.maxBagWgt = maxBgWt;
		this.maxBagVol = maxBgVol;
	}
	
	/**
	 * this function returns the flight_code
	 * @return returns the corresponding flight_code 
	 */
	public String getFlightCode() {
		return flightCode;
	}
	
	
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	/**
	 * this function sets the flight_code
	 * @param flightCode the flight_code
	 * @param destination the destination of the flight
	 */
	public void checkAndSetFCode(String flightCode, String destination) {
		String newCode = u.checkFlightCode(flightCode, destination);
		this.setFlightCode(newCode);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/** 
	 * Getters and Setters 
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public int getMaxBagWgt() {
		return maxBagWgt;
	}

	public void setMaxBagWgt(int maxBagWgt) {
		this.maxBagWgt = maxBagWgt;
	}

	public int getMaxBagVol() {
		return maxBagVol;
	}

	public void setMaxBagVol(int maxBagVol) {
		this.maxBagVol = maxBagVol;
	}
	
//	/**
//	 * @return returns the passenger details in a formatted String
//	 */
//	public String getPassengerDetails() {
//		String report = "Booking Code    Name             Flight Code   Checked-In\n";
//		report += String.format("%-15s", "");
//		report += String.format("%-14s", this.getBookingCode());
//		report += String.format("%-18s", this.getOwner().getFullName());
//		report += String.format("%-15s", this.getFlightCode());
//		report += this.getCheckedIn();
//		report += "\n";
//		return report;
//	}
//	
//	
	/**
	 * @return returns the flight details in a formatted String
	 */
	public String getFlightDetails() {
		String report = "Flight Code    Destination         Max Passenger Weight   Max Baggage Weight   Max Baggage Volume\n";
		report += String.format("%-9s", "");
		report += String.format("%-15s", this.getFlightCode());
		report += String.format("%-20s", this.getDestination());
		report += String.format("%-23s", this.getMaxPassengers());
		report += String.format("%-21s", this.getMaxBagWgt());
		report += this.getMaxBagVol();
		report += "\n";
		return report;
	}

}
