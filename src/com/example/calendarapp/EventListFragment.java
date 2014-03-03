//Every hosting GUI must contain EventListFragment.Callbacks

package com.example.calendarapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EventListFragment extends ListFragment {
	private ArrayList<Event> mEvents;
	private Callbacks mCallbacks;
	public static final String EXTRA_DATE = "com.example.calendarapp.date";

	public interface Callbacks {
		void onEventAdd();
	}

	/*@Override
	public void onResume(){
		super.onResume();
		((EventAdapter)getListAdapter()).notifyDataSetChanged();
	}*/

	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		mCallbacks = (Callbacks)activity;
	}

	@Override
	public void onDetach(){
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Date d = (Date)getArguments().getSerializable(EXTRA_DATE);
		ArrayList<Event> mEvents;
		if (d != null){
			mEvents = EventManager.get(getActivity()).getEventListByDate(d);
			}
		else {
			mEvents = EventManager.get(getActivity()).getEventList();
		}
			


		ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(
				getActivity(),android.R.layout.simple_list_item_1,mEvents);
		setListAdapter(adapter);

	}

	private class EventAdapter extends ArrayAdapter<Event>{

		public EventAdapter(ArrayList<Event> events){
			super(getActivity(),0,events);
		}

	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		if (convertView == null){
			convertView = getActivity().getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
		}
		return convertView;
		}
	}



	public static EventListFragment newInstance(Date d){
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE,d);
		EventListFragment fragment = new EventListFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    super.onListItemClick(l, v, position, id);
		ArrayList<Event> mEvents = EventManager.get(getActivity()).getEventList();
		UUID mEID = mEvents.get(position).getEID();

		long mostSignificantBits = mEID.getMostSignificantBits();
		long leastSignificantBits = mEID.getLeastSignificantBits();
		Intent i = new Intent(getActivity(), ViewEventActivity.class);
		i.putExtra("mostSignificantBits", mostSignificantBits);
		i.putExtra("leastSignificantBits", leastSignificantBits);
		startActivity(i);


	    Toast.makeText(getActivity(), "Hello + " + position, Toast.LENGTH_SHORT).show();
	}

}
