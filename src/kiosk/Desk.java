package kiosk;

import passengers.*;

import java.util.Observable;

import checkInStand.CheckInMain;
import flight.*;
import utility.*;


public class Desk extends Observable implements Runnable {

	private int deskID;
	private Manager manager;
	private Thread[] workerThreads;
	private int noOfDesks = 3;
	private int sleepTimer;
	private Passenger nextPassenger;
	private Flight nextFlight;
	private Destination nextDestination;
	
	private boolean isQueueOpen = true;
	
	public Desk (int deskID, Manager m) {
		this.deskID = deskID;
		this.manager = m;
	}
	

	public int getDeskID() {
		return deskID;
	}
	

	public void setSleepTimer(int s) {
		this.sleepTimer = s;
	}
	

	public synchronized void getNextPassenger(Passenger p) {
		this.nextPassenger = p;
	}
	
	public synchronized void getNextFlight(Flight f) {
		this.nextFlight = f;
	}
	
	public synchronized Destination getNextDestination() {
		return this.nextDestination;
	}
	
	public void setQueue(Boolean q) {
		this.isQueueOpen = q;
	}
	

	public boolean isBusy() {
		
		if (this.nextFlight == null || this.nextPassenger == null) {
			return false;
		}
		else {
			return true;
		}
	}


	public void run() {
		System.out.print("\n");
		System.out.print("DESK-" + this.deskID + " Started." + System.lineSeparator());

		while (!manager.checkQueueEmpty()) {
			
			//Sleep in between the worker thread loops	
			try {
				Thread.sleep(2000);
			}
			catch (Exception e) {
				System.out.print("Worker thread exception" + e.getStackTrace());
			}
			
			nextPassenger = manager.sendNextPassenger();
			System.out.println("DESK-" + this.deskID + " Processing Passenger: "+ nextPassenger.getOwner().getNameInitials() + System.lineSeparator());
//			nextFlight = manager.getNextFlight(nextPassenger);		
//			
//			nextDestination = new Destination (nextFlight, nextPassenger, deskID);
//			
//			String report = nextDestination.getLogReportDetailString();
//			System.out.println(report);
			
			String fee = nextPassenger.getfee();
			if (fee.equals("Invalid")) {
				String bookingID = nextPassenger.getBookingCode();
				System.out.println("Passenger "+ bookingID + " Not allowed to Check-in");
			} else {
				nextFlight = manager.getNextFlight(nextPassenger);		
				
				nextDestination = new Destination (nextFlight, nextPassenger, deskID);
				
				String report = nextDestination.getLogReportDetailString();
				System.out.println(report);
			}
			
			notifyObservers();
			System.out.println("DESK-" + this.deskID + " is open." + System.lineSeparator());
			
		}
		
		System.out.println("DESK-" + this.deskID +  " has Finished");
	}
	
}
