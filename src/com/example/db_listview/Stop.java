package com.example.db_listview;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Stop extends Activity{
	AlarmManager alrmman;
Remind obj= new Remind();
MediaPlayer mp;
View v;
 final Calendar cal= Calendar.getInstance();
PendingIntent pi;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		call();
		
		
		if (android.os.Build.VERSION.SDK_INT >= 11)

		
		
		getActionBar().setDisplayHomeAsUpEnabled(true);


		
		
		
		
		
		setContentView(R.layout.copy);
		
		
	 alrmman=(AlarmManager)getSystemService(ALARM_SERVICE);
	
			
		
	}

public void stops(View v)
{
	terminate();
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
			Toast.makeText(this, "false", 1000).show();
	}


	public void  terminate() {
		// TODO Auto-generated method stub
		
		

		Intent myInt=new Intent(Stop.this, Alarm_Rec.class);
		
		myInt.putExtra("extra", "alarm off");
		//myInt.putExtra("arg", passedArg);
		
		
	pi= PendingIntent.getBroadcast(Stop.this, 0, myInt, PendingIntent.FLAG_UPDATE_CURRENT);
	alrmman.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
	
	
		
		
		
		alrmman.cancel(pi);
		//Intent myInt=new Intent(Stop.this, Alarm_Rec.class);
		
		//myInt.putExtra("extra", "alarm off");
		sendBroadcast(myInt);
		
	}

	
	public void back(View v) {
		// TODO Auto-generated method stub
		
		Intent i= new Intent(Stop.this, Functional.class);
		startActivity(i);
		finish();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blow= getMenuInflater();
		blow.inflate(R.menu.menu_stop, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		//case R.id.stop:
			//terminate(v);
			//break;
	

		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);

		
		break;
		}
		return false;
	}








	

}
