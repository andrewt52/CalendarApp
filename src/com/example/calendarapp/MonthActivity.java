package com.example.calendarapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



public class MonthActivity extends SingleFragmentActivity implements EventListFragment.Callbacks{
	@Override
	protected Fragment createFragment(){
		return new CalendarFragment();
	}
	
	protected Fragment createFragment2(){
		return new EventListFragment();
	}
	
	@Override
	protected int getLayoutResId(){
		return R.layout.activity_fragment_twopane;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResId());
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null){
			fragment = createFragment();
			fm.beginTransaction()
			.add(R.id.fragmentContainer, fragment)
			.commit();
		}
		
	}
	
	@Override
	public void onEventAdd(){
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment oldList = fm.findFragmentById(R.id.fragmentContainer2);
		Fragment newList = new EventListFragment();
		
		if (oldList != null){
			ft.remove(oldList);
		}
		
		ft.add(R.id.fragmentContainer2, newList);
		ft.commit();
	}
}