package com.example.calendarapp;

import android.support.v4.app.Fragment;

public class EventListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new EventListFragment();
	}
	
	//@Override
	//protected Fragment createFragment2(){
	//	return null;
	//}

}
