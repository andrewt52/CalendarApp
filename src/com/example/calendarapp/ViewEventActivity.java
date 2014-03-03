package com.example.calendarapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_event);
		Intent i = getIntent();

		long mostSignificantBits = i.getLongExtra("mostSignificantBits", 0);
		long leastSignificantBits = i.getLongExtra("leastSignificantBits", 0);
		
		if(leastSignificantBits == 0 && mostSignificantBits == 0){
			finish();
		}
		
		final UUID mEID = new UUID(mostSignificantBits, leastSignificantBits);
		
		ArrayList<Event> mEvents = EventManager.get(getApplicationContext()).getEventList();
		
		Event mEvent = null;
		
		for(Event e: mEvents){
			if(e.getEID().equals(mEID)){
				mEvent = e;
			}
		}
		
		if(mEvent == null){
			finish();
		}
		
		
		TextView eventTitle = (TextView) findViewById(R.id.view_text_title);
		TextView eventLocation = (TextView) findViewById(R.id.view_text_location);
		TextView eventDate = (TextView) findViewById(R.id.view_text_date);
		TextView eventTime = (TextView) findViewById(R.id.view_text_time);
		TextView eventDescription = (TextView) findViewById(R.id.view_text_description);
		Button editEvent = (Button) findViewById(R.id.view_button_edit);
		Button deleteEvent = (Button) findViewById(R.id.view_button_delete);
		
		eventTitle.setText("Title: " + mEvent.getName());
		eventLocation.setText("Location: " + mEvent.getLocation());
		eventDescription.setText("Description: " + mEvent.getDescription());
		
		Calendar c = mEvent.getDate();
		
		eventDate.setText("Date: " + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH) +"/" + c.get(Calendar.YEAR));
		String am = "AM";
		if(c.get(Calendar.AM_PM) == Calendar.PM){
			am = "PM";
		}
		eventTime.setText("Time: " + String.format("%02d",c.get(Calendar.HOUR)) + ":" + String.format("%02d",c.get(Calendar.MINUTE)) + " " + am);
		
		
		editEvent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			/*
			 * Intent i = new Intent(ViewEventActivity.this, EditEventActivity.class);
			 * startActivity(i);
			 */
			}
		});
		
		deleteEvent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			/*
			 * Make a confirm dialogue
			 */
				
				EventManager.get(getApplicationContext()).DeleteEvent(mEID);
				finish();
			}
		});
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_event, menu);
		return true;
	}

}
