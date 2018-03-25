package kiosk;

import java.util.HashMap;

public class DeskMap {
	private HashMap<Integer, Desk> DeskThreads;
	
	public DeskMap() {
		DeskThreads = new HashMap<Integer, Desk>();
	}
	
	public void addDesk(int deskID, Desk d) {
		DeskThreads.put(deskID, d);
	}
	
	public Desk getDeskThread(int id) {
		boolean inMap = DeskThreads.containsKey(id);
		if (inMap == false)
			return null;
		else
			return DeskThreads.get(id);
	}
	
	public Desk get(int i) {
		return DeskThreads.get(i);
	}
	
	public int getSize() {
		return DeskThreads.size();
	}
	
}
