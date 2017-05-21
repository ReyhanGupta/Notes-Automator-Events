package com.example.db_listview;

//import com.example.database.DB_Helper;
//import com.example.database.R;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class ModifyEvent extends Activity{
	String one, type, pic, radio, radVal, repeat, two, three;
	int cid, phoneD;
	final Context context=this;
	int year, day, month, hour, min;
	int yearN, dayN, monthN, hourN, minN;
	final Calendar calendar= Calendar.getInstance();

	String yearS,dayS,monthS,hourS,minS,repeatN;
	Button btn2;
	boolean on,tw,th,fo,fi,si;
	RadioGroup rg;
	RadioButton onee,twoo,threee,four,five,six;
	boolean dateCheck=false,timeCheck=false,repeatCheck=false;


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_modify);
		
		cid=getIntent().getExtras().getInt("uid");
		type=getIntent().getExtras().getString("type");
		one=getIntent().getExtras().getString("one");
		two=getIntent().getExtras().getString("two");
		three=getIntent().getExtras().getString("three");
		
		
		phoneD=getIntent().getExtras().getInt("phonesss");
		
		
		radio=getIntent().getExtras().getString("radio");
		radVal=getIntent().getExtras().getString("radVal");
		repeat=getIntent().getExtras().getString("repeat");
		
		EditText phone=(EditText)findViewById(R.id.oneSMS);
		EditText desc=(EditText)findViewById(R.id.twoSMS);
		
		phone.setText(""+phoneD);
		desc.setText(one);
		
		
		dayS=radio.substring(0, radio.indexOf("/"));
		
		int starts=radio.indexOf("/");
		int ends=radio.indexOf("/", radio.indexOf("/") + 1);
		
		monthS=radio.substring(starts+1, ends);
		yearS=radio.substring(ends+1);

		btn2=(Button)findViewById(R.id.button2);
		
		day=Integer.parseInt(dayS);
		month=Integer.parseInt(monthS);
		year=Integer.parseInt(yearS);
		
		hourS=radVal.substring(0,radVal.indexOf(":"));
		minS=radVal.substring(radVal.indexOf(":")+1);
		
		hour=Integer.parseInt(hourS);
		min=Integer.parseInt(minS);
		Toast.makeText(this,hourS+minS, 1000).show();
		
		

		if(repeat.equals("on"))
		{
			on=true;
		}
		else if(repeat.equals("tw"))
		{
tw=true;		}
		else if(repeat.equals("th"))
		{
th=true;
		}
		else if(repeat.equals("fo"))
		{
fo=true;
		}
		else if(repeat.equals("fi"))
		{
fi=true;
		}
		else if(repeat.equals("si"))
		{
si=true;
		}
		
	}
	
	public void repeatNew(String rpt)	
	{
		
	}

	public void delete(View v)
	{
		DB_Helper db_helper_object=new DB_Helper(this);
		SQLiteDatabase sqlite= db_helper_object.getWritableDatabase();
		String whereD= DB_Helper.UID +" = " + cid;
		sqlite.delete(DB_Helper.TABLE_NAME, whereD, null);
		
		Intent n= new Intent(ModifyEvent.this, TimerTasks.class);
		startActivity(n);
		
	}
	
	
	public void deleteNow(int id)
	{
		//Message.message(context, ""+id);

		//DB_Helper db_helper_object=new DB_Helper(this);
		//SQLiteDatabase sqlite= db_helper_object.getWritableDatabase();
		/*String whereD= DB_Helper.UID +" = " + id;
		sqlite.delete(DB_Helper.TABLE_NAME, whereD, null);
		*/
		
	}
	
	public void selDateSMS(View v)
	{
		dateCheck=true;
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.simple);
		dialog.setTitle("Select Date");
		final DatePicker dapi=(DatePicker)dialog.findViewById(R.id.dapiDP);

		Button dialogButton = (Button) dialog.findViewById(R.id.saveDP);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				yearN=dapi.getYear();
				monthN=dapi.getMonth()+1;
				dayN=dapi.getDayOfMonth();
				Toast.makeText(ModifyEvent.this, "Date Set: "+dayN+" /"+monthN+" /"+yearN, 1000).show();
				dialog.dismiss();
				
				goNext();

			}
		});
		
		Button cancel=(Button)dialog.findViewById(R.id.cancelDP);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();

			}
		});
		
		dialog.show();
	}

	
	public void goNext()
	{
		timeCheck=true;
		final Dialog dialogs = new Dialog(context);
		dialogs.setContentView(R.layout.simple_time);
		dialogs.setTitle("Select Time");
		final TimePicker tapi=(TimePicker)dialogs.findViewById(R.id.tapi);
		Button save = (Button) dialogs.findViewById(R.id.saveTPP);
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				hourN=tapi.getCurrentHour();
				minN=tapi.getCurrentMinute();

				dialogs.dismiss();
				
			

			}
		});
		
		Button cancel=(Button)dialogs.findViewById(R.id.cancelTPP);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialogs.dismiss();

			}
		});
		
		dialogs.show();
		
	}
	
	
	public void repeats(View v)
	{				repeatCheck=true;

		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.rpt_events);
		dialog.setTitle("Repeatation Frequency");
		
		rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
		
		onee=(RadioButton)dialog.findViewById(R.id.one);
		twoo=(RadioButton)dialog.findViewById(R.id.two);
		threee=(RadioButton)dialog.findViewById(R.id.three);
		four=(RadioButton)dialog.findViewById(R.id.four);
		five=(RadioButton)dialog.findViewById(R.id.five);
		six=(RadioButton)dialog.findViewById(R.id.six);
		
		
		if(repeat.equals("on"))
		{
			
		}
		else if(repeat.equals("tw"))
		{
			twoo.setChecked(true);
		}
		else if(repeat.equals("th"))
		{
			threee.setChecked(true);

		}
		else if(repeat.equals("fo"))
		{
			four.setChecked(true);

		}
		else if(repeat.equals("fi"))
		{
			five.setChecked(true);

		}
		else if(repeat.equals("si"))
		{
			six.setChecked(true);

		}
		
		
		Button dialogButton = (Button) dialog.findViewById(R.id.saveFN);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				repeatCheck=true;
				
				rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
				
				onee=(RadioButton)dialog.findViewById(R.id.one);
				twoo=(RadioButton)dialog.findViewById(R.id.two);
				threee=(RadioButton)dialog.findViewById(R.id.three);
				four=(RadioButton)dialog.findViewById(R.id.four);
				five=(RadioButton)dialog.findViewById(R.id.five);
				six=(RadioButton)dialog.findViewById(R.id.six);
				
				
                int selectedId = rg.getCheckedRadioButtonId();
                
                switch(selectedId)
                {
                case R.id.one:
                	on=true;    
                	repeatN="on";
                	repeatNew("on");
					break;
                case R.id.two:
                	tw=true;    
                	repeatN="tw";
                	repeatNew("tw");


                	break;
                case R.id.three:
                	th=true;    
                	repeatN="th";
                	repeatNew("th");


    				break;
                case R.id.four:
                	fo=true;    
                	repeatN="fo";
                	repeatNew("fo");


    				break;
                case R.id.five:
                	fi=true;  
                	repeatN="fi";
                	repeatNew("fi");


    				break;
                case R.id.six:
                	si=true; 
                	repeatN="si";
                	repeatNew("si");


    				break;

                }
					  
				
				
				
				Toast.makeText(ModifyEvent.this, ""+selectedId, 1000).show();
				dialog.dismiss();
				

			}
		});
		
		Button cancel=(Button)dialog.findViewById(R.id.CancelFN);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();

			}
		});
		
		dialog.show();
	}


	public void saveSMS(View v)
	{
		Toast.makeText(this," "+day+" /"+" "+month+" /"+" "+year, 1000).show();

		//Toast.makeText(ModifyEvent.this, ""+dateCheck, 1000).show();
		EditText phone=(EditText)findViewById(R.id.oneSMS);
		EditText desc=(EditText)findViewById(R.id.twoSMS);
		
		String phoneNew=phone.getText().toString();
		String oneNew=desc.getText().toString();
		
			String where=DB_Helper.UID + " = "	+cid;		
			DB_Helper db_helper_object= new DB_Helper(this);
			SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
			
			
			
			
		if(repeatCheck==false)
			{
			
			
			if(on==true)
			{	
				Toast.makeText(this, "on=true", 1000).show();
				if(dateCheck==false)
				{
					Toast.makeText(this, "datecheck=false", 1000).show();
					Toast.makeText(this, ""+year+""+(month-1)+""+day, 1000).show();

					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
			
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.set(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis() , pendingIntent);
				

			}
			
			else if(tw==true)

			{				Toast.makeText(this, "tw=true", 1000).show();

				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),3600000  , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat hourly", 1000).show();
				

			}
			
			
			else if(th==true)
			{			
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),86400000   , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat daily", 1000).show();
				

			}
			
			else if(fo==true)
			{			

				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),604800000    , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat weekly", 1000).show();
				

			}
			
			else if(fi==true)
			{			

				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat monthly", 1000).show();
				

				
	}
			
			else if(si==true)
			{
				
				
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat yearly", 1000).show();
				

			}
			
			
			
		}
		
		else
		{
			if(repeatN.equals("on"))
			{	
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
			
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.set(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis() , pendingIntent);
				

			}
			
			else if(repeatN.equals("tw"))

			{
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),3600000  , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat hourly", 1000).show();
				

			}
			
			
			else if(repeatN.equals("th"))
			{			
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),86400000   , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat daily", 1000).show();
				

			}
			
			else if(repeatN.equals("fo"))
			{			

				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),604800000    , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat weekly", 1000).show();
				

			}
			
			else if(repeatN.equals("fi"))
			{			

				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat monthly", 1000).show();
				

				
	}
			
			else if(repeatN.equals("si"))
			{
				
				
				if(dateCheck==false)
				{
					calendar.set(Calendar.YEAR, year);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH, day);

				}
				else
				{
					calendar.set(Calendar.YEAR, yearN);
					calendar.set(Calendar.MONTH, monthN-1);
					calendar.set(Calendar.DAY_OF_MONTH, dayN);
				}
			
				if(timeCheck==false)
				{
					calendar.set(Calendar.HOUR_OF_DAY, hour);
					calendar.set(Calendar.MINUTE, min);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				else
				{
					calendar.set(Calendar.HOUR_OF_DAY, hourN);
					calendar.set(Calendar.MINUTE, minN);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					
				}
				
				
				Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
				myIntent.putExtra("type", type);
				myIntent.putExtra("phone", phoneNew);
				myIntent.putExtra("desc", oneNew);
				
				PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
				
				Toast.makeText(ModifyEvent.this, "Alarm set to repeat yearly", 1000).show();
				

			}
			
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			ContentValues content= new ContentValues();
			content.put(DB_Helper.TYPE, "sms");
			content.put(DB_Helper.ONE, oneNew);
			content.put(DB_Helper.TWO, "");
			content.put(DB_Helper.THREE, "");
			content.put(DB_Helper.PHONE_NO, phoneNew);
			if(dateCheck==false)
			{
			content.put(DB_Helper.RADIO, ""+day+"/"+month+"/"+year);
			}
			else
			{
				content.put(DB_Helper.RADIO, ""+dayN+"/"+monthN+"/"+yearN);

			}
			
			if(timeCheck==false)
			{
			content.put(DB_Helper.RADIO_VALUE, ""+hour+":"+min);
			}
			else
			{
				content.put(DB_Helper.RADIO_VALUE, ""+hourN+":"+minN);

			}
			if(repeatCheck==false)
			{
			content.put(DB_Helper.REPEAT, repeat);
			}
			else
			{
				content.put(DB_Helper.REPEAT, repeatN);

			}

			sqlite.update(DB_Helper.TABLE_NAME, content, where, null);
			//param=table name, new values, where, old values: updaate t2 where name ='ht'
			
			Intent i=new Intent(ModifyEvent.this, TimerTasks.class);
			startActivity(i);
		
	}
	

}
