package com.example.calendarapp;

import java.sql.Date;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.CalendarView.*;



public class MainActivity extends Activity {

	
	private CalendarView calendar;
	private Button addEventButton;
	private ListView eventList;
	private TextView dateText;
	private ArrayList<Integer> eventIDs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		calendar = (CalendarView) findViewById(R.id.calendarView1);
		addEventButton = (Button) findViewById(R.id.button_add_event);
		
		addEventButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, AddEventActivity.class);
				startActivity(i);
			}
		});
		
		eventList = (ListView) findViewById(R.id.listView1);
		dateText = (TextView) findViewById(R.id.text_date);
 		
		calendar.setClickable(true);
		refresh();
		calendar.setOnDateChangeListener(new OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                    int month, int day) {
            	refresh();
            }

    });
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*
	 * Changes the text for which date is displayed, also recreates the list of events
	 *
	 * To do:
	 * Update event list for events on certain day. Use Instances content provider
	 * Create onItemClickListner() which links to EditEventActiviy(not yet created); (Fill up eventIDs array list at the same time as events array list, 
	 * pass event id to EditEventActivity using intent.putExtra("eventID", eventIDs.get(index))
	 */
	
	public void refresh(){
		long d = calendar.getDate();
		Date todayDate = new Date(d);
		dateText.setText("Events for " + todayDate);
		ArrayList<String> events = new ArrayList<String>();
		
		for (int i =0; i < 5; i++){
			events.add("Sample event " + i + " for " + todayDate);
		}
		
		ArrayAdapter<String> eventArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, events);
		eventList.setAdapter(eventArrayAdapter);
	}

}
