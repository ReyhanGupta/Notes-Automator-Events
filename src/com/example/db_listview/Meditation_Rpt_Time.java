package com.example.db_listview;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class Meditation_Rpt_Time extends Activity{
	TimePicker start, end;
	View v;
	int a;
	AlarmManager alrmman;
	final Calendar calendarE= Calendar.getInstance();

	final Calendar calendar= Calendar.getInstance();
	PendingIntent pi;
	Context context;
	long interval;
	final String pass= "Home Profile"; 
	boolean monSel, tueSel, wedSel, thuSel, friSel, satSel, sunSel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_select2);
		
		
		interval= getIntent().getExtras().getLong("ints");
		monSel=getIntent().getExtras().getBoolean("mon");
		tueSel=getIntent().getExtras().getBoolean("tue");
		wedSel=getIntent().getExtras().getBoolean("wed");
		thuSel=getIntent().getExtras().getBoolean("thu");
		friSel=getIntent().getExtras().getBoolean("fri");
		satSel=getIntent().getExtras().getBoolean("sat");
		sunSel=getIntent().getExtras().getBoolean("sun");
		

		start= (TimePicker)findViewById(R.id.startT);
		end= (TimePicker)findViewById(R.id.endT);
		
		//alrmman=(AlarmManager)getSystemService(ALARM_SERVICE);
		Toast.makeText(this, ""+interval, 1000).show();
		//final Calendar cal= Calendar.getInstance();

		//Intent myInt=new Intent(Rpt_Time.this, Profile_Rec.class);


		TimePicker start= (TimePicker)findViewById(R.id.startT);
		TimePicker end= (TimePicker)findViewById(R.id.endT);

		final Calendar calendar= Calendar.getInstance();
		final Calendar calendarE= Calendar.getInstance();

	}
	
	
	public void cancelT(View v)
	{
		//Automator o= new Automator();
		//o.deselect();
		Intent can= new Intent(Meditation_Rpt_Time.this, Music_Select.class);
		startActivity(can);
	}

	
	public void test()
	{
	int day = calendar.get(Calendar.DAY_OF_WEEK); 
	switch(day)
	{
	
	case Calendar.MONDAY:
		if(monSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),604800000 , pendingIntent);
				
				
				 
		         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
					calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
					calendarE.set(Calendar.SECOND, 0);
					calendarE.set(Calendar.MILLISECOND, 0);
					
				 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
		      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
		      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
		              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
		         
		         
			}
	break;
	
	
	
	
	case Calendar.TUESDAY:
		if(tueSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 3);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
		break;
		
		
		
	 case Calendar.WEDNESDAY:
			if(wedSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, 4);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
	         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
	         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	                 calendar.getTimeInMillis(),604800000 , pendingIntent);
	         
	         
	         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
				calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
				calendarE.set(Calendar.SECOND, 0);
				calendarE.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
	      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
	      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
	              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
	         
	         
			}
			break;
			
			
			
				 case Calendar.THURSDAY:
			if(thuSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, 5);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
	         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
	         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	                 calendar.getTimeInMillis(),604800000 , pendingIntent);
	         
	         
	         
	         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
				calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
				calendarE.set(Calendar.SECOND, 0);
				calendarE.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
	      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
	      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
	              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
	         
	         
			}
		break;
		
		
		
		
				 case Calendar.FRIDAY:
			if(friSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, 6);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
	         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
	         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	                 calendar.getTimeInMillis(),604800000 , pendingIntent);
	         
	         
	         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
				calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
				calendarE.set(Calendar.SECOND, 0);
				calendarE.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
	      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
	      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
	              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
	         
	         
			}
			
			
			
				 case Calendar.SATURDAY:
			if(satSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, 7);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
	         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
	         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	                 calendar.getTimeInMillis(),604800000 , pendingIntent);
	         
	         
	         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
				calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
				calendarE.set(Calendar.SECOND, 0);
				calendarE.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
	      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
	      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
	              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
	         
	         
			}
			break;
			
			
			
			
				 case Calendar.SUNDAY:
			if(sunSel==true)
			{
				calendar.set(Calendar.DAY_OF_WEEK, 1);

				calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
				calendar.set(Calendar.MINUTE, start.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntent = new Intent(getBaseContext(), MyScheduledReceiver.class);
	         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
	         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
	         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	                 calendar.getTimeInMillis(),604800000 , pendingIntent);
	         
	         
	         
	         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
				calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
				calendarE.set(Calendar.SECOND, 0);
				calendarE.set(Calendar.MILLISECOND, 0);
				
			 Intent myIntentE = new Intent(getBaseContext(), End_MyScheduleReciever.class);
	      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
	      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
	              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
	         
	         
			}
			break;
		
		
		
		
	}	
	}	
		
	
	public void saveT(View v)
	{
		
		int hour=start.getCurrentHour();
		int min=start.getCurrentMinute();
		
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
		
		Toast.makeText(Meditation_Rpt_Time.this, "Automated Profile Set For: "+h+" : "+m, Toast.LENGTH_LONG).show();
		
		
		
		
		
		
		
		
		
		
		int hourE=end.getCurrentHour();
		int minE=end.getCurrentMinute();
		
		String hE=String.valueOf(hourE);
		String mE=String.valueOf(minE);
		
		if(hourE>12)
		{
			hE=String.valueOf(hourE-12);
			
		}
		if(hourE<10)
		{
			hE="0"+String.valueOf(hourE);
		}
		
			
		
		if(minE<10)
		{
			mE="0"+String.valueOf(minE);
		}
		
		Toast.makeText(Meditation_Rpt_Time.this, "Automated Profile Ends At: "+hE+" : "+mE, Toast.LENGTH_LONG).show();
		
		
		
		
		//keep as it is
		Intent rpt = new Intent(getBaseContext(), RepeatReceiver.class);
        PendingIntent pen= PendingIntent.getBroadcast(getBaseContext(),0, rpt, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager ala= (AlarmManager)getSystemService(ALARM_SERVICE);
        ala.setRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),2700000 , pen);
		
        //end keep as it is
        
        
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		
		
		
		switch(day)
			{
			case Calendar.MONDAY:
				
				
				if(monSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			
		
		Toast.makeText(Meditation_Rpt_Time.this, "a is "+monSel, Toast.LENGTH_LONG).show();

		
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);

         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
     //    Calendar calendar = Calendar.getInstance();
    //   calendar.set(Calendar.HOUR_OF_DAY, hour);
 	//	calendar.set(Calendar.MINUTE, min);
 		
 		
      //   calendar.setTimeInMillis(System.currentTimeMillis());
        // calendar.add(Calendar.SECOND, 10);
         //long interval = 60 * 1000; //
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
         //remove these
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
		break;
			 case Calendar.TUESDAY:
		if(tueSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 3);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
        
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
         
         
         
         
		}
		break;
		
			 case Calendar.WEDNESDAY:
		if(wedSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 4);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
         
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
		break;
			 case Calendar.THURSDAY:
		if(thuSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 5);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
         
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
	break;
			 case Calendar.FRIDAY:
		if(friSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 6);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
			 case Calendar.SATURDAY:
		if(satSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 7);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
        
         
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
		break;
			 case Calendar.SUNDAY:
		if(sunSel==true)
		{
			calendar.set(Calendar.DAY_OF_WEEK, 1);

			calendar.set(Calendar.HOUR_OF_DAY, start.getCurrentHour());
			calendar.set(Calendar.MINUTE, start.getCurrentMinute());
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntent = new Intent(getBaseContext(), Meditation_ScheduledReciever.class);
         PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
         alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                 calendar.getTimeInMillis(),604800000 , pendingIntent);
         
         
        
         calendarE.set(Calendar.HOUR_OF_DAY, end.getCurrentHour());
			calendarE.set(Calendar.MINUTE, end.getCurrentMinute());
			calendarE.set(Calendar.SECOND, 0);
			calendarE.set(Calendar.MILLISECOND, 0);
			
		 Intent myIntentE = new Intent(getBaseContext(), End_MeditationScheduledReciever.class);
      PendingIntent pendingIntentE= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManagerE= (AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManagerE.setRepeating(AlarmManager.RTC_WAKEUP,
              calendarE.getTimeInMillis(),604800000 , pendingIntentE);
         
         
		}
		break;
		}
	
	Intent go=new Intent(Meditation_Rpt_Time.this,Music_Select.class);
	startActivity(go);
	finish();
	}
	
	
	
	
}


