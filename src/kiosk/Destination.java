package kiosk;

import passengers.*;
import flight.*;

public class Destination {
	private Flight f;
	private Passenger p;
	private int deskID;
	
	public Destination(Flight f, Passenger p, int deskID) {
		this.f = f;
		this.p = p;
		this.deskID = deskID;
	}

	public Flight getF() {
		return f;
	}

	public void setF(Flight f) {
		this.f = f;
	}

	public Passenger getP() {
		return p;
	}

	public void setP(Passenger p) {
		this.p = p;
	}

	public int getDeskID() {
		return deskID;
	}
	
	public String getLogReportDetailString() {
		String record = String.format("%-4s", "D" + deskID);
		record += String.format("%-13s", "Destination: ");
		record += String.format("%-25s", this.getP().getDestination());
		record += String.format("%-11s", "Passenger Name: ");
		record += String.format("%-5s", this.getP().getOwner().getFullName() );
		record += String.format("%-6s", "Flight: ");
		record += String.format("%-6s", this.getF().getFlightCode());
		
		return record;
	}
}
