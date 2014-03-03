package com.example.calendarapp;

import android.support.v4.app.Fragment;

public class AddEventActivity extends SingleFragmentActivity {
	
	@Override
	protected Fragment createFragment(){
		return new AddEventFragment();
	}

}
