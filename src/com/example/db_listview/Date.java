package com.example.db_listview;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class Date extends Activity{
DatePicker dp;
static final int dialog=1; 
int year, day, month ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date);
		Calendar today= Calendar.getInstance();
		year=today.get(Calendar.YEAR);
		day=today.get(Calendar.DAY_OF_MONTH);
		month=today.get(Calendar.MONTH);
		showDialog(dialog);
		//dp=(DateP icker)findViewById(R.id.date);
		 
		
	}
	@Override
		@Deprecated
		protected Dialog onCreateDialog(int id) {
			// TODO Auto-generated method stub
	
		switch (id) {
		case dialog:
			
			return new DatePickerDialog(this, mDateSetListener, year, month, day);
			
			

		default:
			break;
		}
		
		
		
		return null;

			
		}
	
	
	public DatePickerDialog.OnDateSetListener mDateSetListener= new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker arg0, int yr, int mo, int da) {
			// TODO Auto-generated method stub
			
			
			year=yr;
			month= mo;
			day=da;
			Toast.makeText(getBaseContext(), "Date Set: "+day+" / "+""+month+" / "+year, 1000).show();
			
			
		}
	};
	public void setDate(View v)
	{
		/*int day= dp.getDayOfMonth();
		int month=dp.getMonth()+1;
		int year= dp.getYear();
		
		Toast.makeText(this, "Date Set: "+day+" / "+""+month+" / "+year, 10000).show();*/
	}

}
