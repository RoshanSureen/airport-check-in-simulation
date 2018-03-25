package passengers;

import java.util.Random;
import utility.*;

public class Passenger {
	private String flightCode;
	private String destination;
	private String bookingCode;
	private Name owner;
	private int totalWeight;
	private int length;
	private int breadth;
	private int height;
	private String fee;
	private UtilsPassenger u;
	
	public Passenger(String fCode, String dest, String bCode, Name name, int totWgt, int len, int brd, int hgt, String fee) {
		u = new UtilsPassenger();
		this.flightCode = fCode;
		this.destination = dest;
		this.checkAndSetBCode(bCode, name);
		this.owner = name;
		this.totalWeight = totWgt;
		this.length = len;
		this.breadth = brd;
		this.height = hgt;
		this.fee = fee;
	}

	public void checkAndSetBCode(String bookingCode, Name name) {
		String initails = name.getNameInitials();
		String bCode = u.checkBookingCode(bookingCode, initails);
		this.setBookingCode(bCode);
	}
	
	public String getBookingCode() {
		return bookingCode;
	}
	
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public Name getOwner() {
		return owner;
	}

	public void setOwner(Name owner) {
		this.owner = owner;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getfee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	/**
	 * @return String
	 * returns the details of the passengers flight info
	 */
	public String getPassengerDetails() {
		String L = Integer.toString(this.getLength());
		String B = Integer.toString(this.getBreadth());
		String H = Integer.toString(this.getHeight());
		String report = "Booking Code    Name             Flight Code   Destination   Total Weight   LxBxH\n";
		report += String.format("%-15s", "");
		report += String.format("%-14s", this.getBookingCode());
		report += String.format("%-18s", this.getOwner().getFullName());
		report += String.format("%-15s", this.getFlightCode());
		report += String.format("%-15s", this.getDestination());
		report += String.format("%-12s", this.getTotalWeight());
		report += L + "x" + B + "x" + H;
		report += "\n";
		return report;
	}
	
}
