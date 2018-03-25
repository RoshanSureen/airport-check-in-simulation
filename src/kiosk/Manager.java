package kiosk;

import passengers.*;
import utility.*;
import flight.*;

public class Manager implements Runnable {
	
	private PassengerMap psgQueue = new PassengerMap();
	private Passenger p;
	private FlightMap flightQueue = new FlightMap();
	private DeskMap desks = new DeskMap();
	private Thread[] deskThreads;
	private int deskID;
	private static int noOfDesks = 2;
	
	public Manager() {
		for (int index = 0; index < noOfDesks; index++) {
			Desk d = new Desk(index, this);
			desks.addDesk(d.getDeskID(), d);
		}
		this.loadUpData();
		System.out.println("Simulation Data Loaded in Maps");
	}
	
	public void loadUpData() {
		flightQueue.processFlightFile("Flight.csv");
		psgQueue.processPassengerFile("Passenger.csv");
		
	}
	
	public DeskMap getDeskMap() {
		return desks;
	}
	
	@Override
	public void run() {
		deskThreads = new Thread[desks.getSize()];
		for (int i = 0; i < desks.getSize(); i++) {
			deskThreads[i] = new Thread(desks.get(i));
			deskThreads[i].start();
		}
	}
	
	public boolean checkQueueEmpty() {
		if (psgQueue.isEmpty() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public synchronized Flight getNextFlight(Passenger p) {
		this.p = p;
		String flightCode = p.getFlightCode();
		Flight f = flightQueue.getFlight(flightCode);
		return f;
	}
	
	public synchronized Passenger sendNextPassenger() {
		Passenger p = psgQueue.getFirst();
		psgQueue.removeOne(p);
		return p;
	}
	
}
