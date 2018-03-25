package checkInStand;

import java.util.Observable;
import java.util.Observer;

import kiosk.*;


public class CheckInMain implements Observer {
	DeskMap desks;
	int numberOfDesks;

	public static void main(String[] args) {
		Manager m = new Manager();
		
		DeskMap desks = m.getDeskMap();
		int numberOfDesks = desks.getSize();
		
		for(int i=0; i<numberOfDesks; i++) {
			Desk d = desks.get(i);
			d.addObserver(new CheckInMain());
			d.setSleepTimer(10000);
		}
		Thread thread = new Thread(m);
		thread.start();
		
	}

	@Override
	public synchronized void update(Observable o, Object arg) {

		for (int i=0; i<numberOfDesks; i++) {
			Desk d = desks.get(i);
			String output = d.getNextDestination().getLogReportDetailString();
			System.out.println("output: "+output);
			//w.clearWorker();

		}

	}
	
}
