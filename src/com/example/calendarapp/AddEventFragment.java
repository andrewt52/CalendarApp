package com.example.calendarapp;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddEventFragment extends Fragment {
	
	private TextView addEvent;
	private EditText eventTitle;
	private EditText eventLocation;
	private DatePicker eventStartDate;
	private TimePicker eventStartTime;
	private EditText eventDescription;
	private Button submitButton;
	private String mEventName;
	private String mLocation;
	private Date mDate;
	private String mDescription;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.add_event_fragment,parent,false);
		addEvent = (TextView)v.findViewById(R.id.form_textView);
		eventTitle = (EditText)v.findViewById(R.id.form_editText_title);
		eventLocation = (EditText)v.findViewById(R.id.form_editText_location);
		eventStartDate = (DatePicker)v.findViewById(R.id.form_datePicker_start);
		eventStartTime = (TimePicker)v.findViewById(R.id.form_timePicker_start);
		eventDescription = (EditText)v.findViewById(R.id.form_editText_description);
		submitButton = (Button)v.findViewById(R.id.form_button_submit);
		addEvent.setText("Add Event");
		/*
		 * set calendar picker date to same date picked on main activity
		 * keeps setting to jan 1 for some reason regardless of input, need to fix
		 * 
		 */
		
		
		submitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * To do:
				 * get information from form variables listed above and create an event"
				 */
				

				mEventName = eventTitle.getText().toString();
				mLocation = eventLocation.getText().toString();
				mDate = getDateFromDatePicker(eventStartDate,eventStartTime);
				mDescription = eventDescription.getText().toString();
				EventManager.get(getActivity()).AddEvent(mEventName,mLocation,mDate,mDescription);
				Toast toast = Toast.makeText(getActivity(), "Event added.", Toast.LENGTH_SHORT); 
				toast.show();
   				getActivity().finish();
				}
			
		});
		return v;
	}
	
	/**
	 * Taken from stackoverflow
	 * author andrescanavesi
	 * @param datePicker
	 * @return
	 */
	public static java.util.Date getDateFromDatePicker(DatePicker datePicker,TimePicker timePicker){
		int year = datePicker.getYear();
		int month = datePicker.getMonth();
		int day = datePicker.getDayOfMonth();
		int hour = timePicker.getCurrentHour();
		int minute = timePicker.getCurrentMinute();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month,day,hour,minute);
		return calendar.getTime();
	}

}