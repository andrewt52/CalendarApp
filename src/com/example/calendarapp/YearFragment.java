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

public class YearFragment extends Fragment {
	
	private Button januaryButton;
	private Button februaryButton;
	private Button marchButton;
	private Button aprilButton;
	private Button mayButton;
	private Button juneButton;
	private Button julyButton;
	private Button augustButton;
	private Button septemberButton;
	private Button octoberButton;
	private Button novemberButton;
	private Button decemberButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_year, parent,false);
           	januaryButton = (Button)v.findViewById(R.id.button_january);
           	januaryButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,1,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	februaryButton = (Button)v.findViewById(R.id.button_february);
           	februaryButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,2,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	marchButton = (Button)v.findViewById(R.id.button_march);
           	marchButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,3,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	aprilButton = (Button)v.findViewById(R.id.button_april);
           	aprilButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,4,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	mayButton = (Button)v.findViewById(R.id.button_may);
           	mayButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,5,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	juneButton = (Button)v.findViewById(R.id.button_june);
           	juneButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,6,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	julyButton = (Button)v.findViewById(R.id.button_july);
           	julyButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,7,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	augustButton = (Button)v.findViewById(R.id.button_august);
           	augustButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,8,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	septemberButton = (Button)v.findViewById(R.id.button_september);
           	septemberButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,9,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	octoberButton = (Button)v.findViewById(R.id.button_october);
           	octoberButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,10,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	novemberButton = (Button)v.findViewById(R.id.button_november);
           	novemberButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,11,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
           	decemberButton = (Button)v.findViewById(R.id.button_december);
           	decemberButton.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Calendar calendar = Calendar.getInstance();
   				calendar.set(2014,12,1);
   				Date d = calendar.getTime();
   				Intent i = new Intent(getActivity(), MonthActivity.class);
   				i.putExtra("date",d.getTime());
   				startActivity(i);
   				}
   			}
   		);
		return v;
	}
}	

