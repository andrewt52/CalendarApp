package com.example.calendarapp;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class CalendarFragment extends Fragment {
	
	private CalendarView calendar;
	private Button addEventButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_calendar, parent,false);
		calendar = (CalendarView)v.findViewById(R.id.calendar_view);
		calendar.setClickable(true);
		calendar.setOnDateChangeListener(new OnDateChangeListener(){
           @Override
            public void onSelectedDayChange(CalendarView view, int year,int month, int day) {
        	    FragmentManager fm = getActivity().getSupportFragmentManager();
  				FragmentTransaction ft = fm.beginTransaction();
  				Fragment oldList = fm.findFragmentById(R.id.fragmentContainer2);
  				Calendar cal = Calendar.getInstance();
  				cal.set(year,month,day);
  				Fragment newList = EventListFragment.newInstance(cal.getTime());
  				
  				if (oldList != null){
  					ft.remove(oldList);
  				}
  				
  				ft.add(R.id.fragmentContainer2, newList);
  				ft.commit();
            }
		});
           	addEventButton = (Button)v.findViewById(R.id.add_button);
           	addEventButton.setText("Add Event");
   			addEventButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Intent i = new Intent(getActivity(), AddEventActivity.class);
   				Date d = new Date(calendar.getDate());
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
   			
		return v;
	}
}	