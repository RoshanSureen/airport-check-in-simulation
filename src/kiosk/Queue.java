package kiosk;

import passengers.*;
import utility.*;
import flight.*;

public class Queue implements Runnable {
	
	private PassengerMap psgQueue = new PassengerMap();
	private FlightMap flightQueue = new FlightMap();
	
	public Queue() {
		this.loadUpData();
	}
	
	public void loadUpData() {
		flightQueue.processFlightFile("Flight.csv");
		flightQueue.outputFlightResults();
		psgQueue.processPassengerFile("Passenger.csv");
		psgQueue.outputPassengerResults();
	}
	
	@Override
	public void run() {
		
	}
	
}
