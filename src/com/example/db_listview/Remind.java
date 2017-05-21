package com.example.db_listview;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
//import android.support.v4.widget.SearchViewCompatIcs.MySearchView;
//import android.support.v4.widget.SearchViewCompatIcs.MySearchView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Remind extends Activity{
Button sets, terminates;
AlarmManager alrmman;
TimePicker tpp;
TextView tv,tv2;
Context context;
PendingIntent pi;
int o=90;
View v;
static final int dialog=1;
int year, day, month;
//Intent myInt=new Intent(Remind.this, Alarm_Rec.class);
final Calendar cal= Calendar.getInstance();
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		call();

		
		
		
		if (android.os.Build.VERSION.SDK_INT >= 11)

			
			
			
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.alarm);
		
		
		String passedArg=getIntent().getExtras().getString("arg");
		String newss=getIntent().getExtras().getString("args");
		tv=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv.setText(passedArg);
		tv2.setText(newss);
		
		//Toast.makeText(Remind.this, newss, 1000).show();
		this.context=this;
		
		alrmman=(AlarmManager)getSystemService(ALARM_SERVICE);
		
		
		tpp=(TimePicker)findViewById(R.id.timePicker1);
		
		////tpp.get
		
		
		final Calendar cal= Calendar.getInstance();
		
		Intent myInt=new Intent(Remind.this, Alarm_Rec.class);
		
		
		
	}
	private void call() {
		// TODO Auto-generated method stub
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getPref.getBoolean("check", false); //if nothing has been set yet, set default value as true
		if(music==true)
			{requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		else
			Toast.makeText(this, "false", 1000);
	}
	
	public void cals(View v)
	{
		set();
	}
	
	public void goDate()
	{
		Calendar today= Calendar.getInstance();
		year=today.get(Calendar.YEAR);
		day=today.get(Calendar.DAY_OF_MONTH);
		month=today.get(Calendar.MONTH);
		showDialog(dialog);
		
		
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
	
	
	
	public void set()
	{
		
		cal.set(Calendar.HOUR_OF_DAY, tpp.getCurrentHour());
		cal.set(Calendar.MINUTE, tpp.getCurrentMinute());
		
		int hour=tpp.getCurrentHour();
		int min=tpp.getCurrentMinute();
		String h=String.valueOf(hour);
		String m=String.valueOf(min);
		if(hour>12)
		{
			h=String.valueOf(hour-12);
		}
		
		if(hour<10)
		{
			h="0"+String.valueOf(hour);
		}
		
		if(min<10)
		{
			m="0"+String.valueOf(min);
		}
		Toast.makeText(Remind.this, "Alarm Set For: "+h+" : "+m, Toast.LENGTH_LONG).show();
		String passedArg=getIntent().getExtras().getString("arg");
		Intent myInt=new Intent(Remind.this, Alarm_Rec.class);
		myInt.putExtra("extra", "alarm on");
		myInt.putExtra("arg", passedArg);
		
	pi= PendingIntent.getBroadcast(Remind.this, 0, myInt, PendingIntent.FLAG_UPDATE_CURRENT);
	alrmman.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
	
	
	
	
		
		
	}
	
	public void terminate()
	{
		Toast.makeText(Remind.this, "Alarm Stopped", Toast.LENGTH_LONG).show();
		
		
		
		
		alrmman.cancel(pi);
		Intent myInt=new Intent(Remind.this, Alarm_Rec.class);
		
		myInt.putExtra("extra", "alarm off");
		sendBroadcast(myInt);
		
	}
	
	public void back()
	{
		
		Intent i= new Intent(Remind.this, Functional.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blow= getMenuInflater();
		blow.inflate(R.menu.menu_remind, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		
		
		case R.id.back:
			
			back();
			break;
//			
		
			
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);

		
		break;
//			
		
			
		case R.id.datess:
			goDate();
			break;
			
		}
		return false;
	}


	

}
