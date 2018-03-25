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
		String record = String.format("%-8s", "DESK-" + deskID);
		record += String.format("%-13s", "Destination: ");
		record += String.format("%-14s", this.getP().getDestination());
		record += String.format("%-16s", "Passenger Name: ");
		record += String.format("%-18s", this.getP().getOwner().getFullName() );
		record += String.format("%-8s", "Flight: ");
		record += String.format("%-8s", this.getF().getFlightCode());
		record += String.format("%-12s", "Bagage Fee: ");
		record += String.format("%-12s", this.getP().getfee());
		
		return record;
	}
}
