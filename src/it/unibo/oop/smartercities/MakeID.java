package it.unibo.oop.smartercities;

public class MakeID {
	private static MakeID MAKE_ID = null;
	private int count;
	
	private MakeID() {
		this.count = 0;
	}
	
	public static synchronized MakeID getMaker() {
		if(MAKE_ID == null){
			MAKE_ID = new MakeID();
		}
		return MAKE_ID;
	}
	
	public int getID() {
		return this.count++;
	}
}
