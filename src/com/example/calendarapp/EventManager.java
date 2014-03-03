package com.example.calendarapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import android.content.Context;

public class EventManager {
	//singleton
	private static EventManager sEventManager;
	private Context mAppContext;
	private ArrayList<Event> mEventList;
	
	private EventManager(Context AppContext){
		mAppContext = AppContext;
		mEventList = new ArrayList<Event>();
		//test values so event list isn't empty
		String en1 = "test1";
		String l1 = "test loc1";
		String d1 = "test desc1";
		Calendar c1 = Calendar.getInstance();
		c1.set(2014,2,5,10,30);
		Date dt1 = c1.getTime();
		String en2 = "test2";
		String l2 = "test loc2";
		String d2 = "test desc2";
		Calendar c2 = Calendar.getInstance();
		c2.set(2014,2,7,10,30);
		Date dt2 = c2.getTime();
		Event e1 = new Event(en1,dt1,l1,d1);
		Event e2 = new Event(en2,dt2,l2,d2);
		mEventList.add(e1);
		mEventList.add(e2);
	}
	
	public static EventManager get(Context c){
		if (sEventManager == null){
			sEventManager = new EventManager(c.getApplicationContext());
		}
		return sEventManager;
	}
	
	/**
	 * @return the EventList
	 */
	public ArrayList<Event> getEventList() {
		return mEventList;
	}
	
	/**
	 * @return the EventList
	 */
	public ArrayList<Event> getEventListByDate(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE,0);
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(d);
		calendarEnd.set(Calendar.HOUR, 23);
		calendarEnd.set(Calendar.MINUTE,59);
		
		ArrayList<Event> events = new ArrayList<Event>();
		
		for (Event e:mEventList){
			if ((e.getDate().compareTo(calendar) > 0)&&(e.getDate().compareTo(calendarEnd) < 0))
				events.add(e);
		}
		return events;
	}
	
	
	public boolean AddEvent(String en,String loc,Date d,String desc){
		//add code
		boolean success = false;
		Event e = new Event(en,d,loc,desc);
		if (e != null)
			success = true;
		EventManager.sEventManager.mEventList.add(e);
		
		return success;
	}
	
	public void EditEvent(UUID i){
		//add code
	}
	
	public void DeleteEvent(UUID i){
		//add code
	}
	
	
}
