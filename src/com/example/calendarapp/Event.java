package com.example.calendarapp;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Event {
	
	private String mName;
	private UUID mEID;
	private Calendar mDate;
	private String mLocation;
	private String mDescription;
	
	public Event(String n, Date d,String l,String desc){
		mEID = UUID.randomUUID();
		mName = n;
		mDate = Calendar.getInstance();
		mDate.setTime(d);
		mLocation = l;
		mDescription = desc;
	}

	/**
	 * @return the mName
	 */
	public String getName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the mDate
	 */
	public Calendar getDate() {
		return mDate;
	}

	/**
	 * @param mDate the mDate to set
	 */
	public void setDate(Date mD) {
		this.mDate.setTime(mD);
	}

	/**
	 * @return the mLocation
	 */
	public String getLocation() {
		return mLocation;
	}

	/**
	 * @param mLocation the mLocation to set
	 */
	public void setLocation(String mLocation) {
		this.mLocation = mLocation;
	}

	/**
	 * @return the mDescription
	 */
	public String getDescription() {
		return mDescription;
	}

	/**
	 * @param desc the mDescription to set
	 */
	public void setDescription(String desc) {
		this.mDescription = desc;
	}

	/**
	 * @return the mEID
	 */
	public UUID getEID() {
		return mEID;
	}
	
	@Override
	public String toString(){
		String s = "" + this.mName + " : " + this.mDate.getTime().toString(); 
		return s;
	}
	
}
