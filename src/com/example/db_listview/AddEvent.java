package com.example.db_listview;

import java.util.Calendar;

//import com.example.database.DB_Helper;
//import com.example.database.R;

//import com.example.database.DB_Helper;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AddEvent extends Activity {
int phone;
int cid, phoneddd;
String monthS,dayS;
///////String oneddd, type, pic, radio, radVal, repeat;

//////String event, desc;
//EditText one, two, three;
int year, day, month, hour, min;
static final int dialog=1;
RadioGroup rg;
RadioButton one,two,three,four,five,six;
boolean on,tw,th,fo,fi,si;
final Calendar calendar= Calendar.getInstance();
DB_Helper db_helper_object;

final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		DB_Helper db_helper_object= new DB_Helper(this);

	}
	
	public void changeNot(View v)
	{
	    setContentView(R.layout.add_event);
	}

	public void changeCal(View v)
	{
	    setContentView(R.layout.call);
	   
	}
	
	public void changeSms(View v)
	{
	    setContentView(R.layout.sms);
	     
	}
	public void changeEma(View v)
	{
	    setContentView(R.layout.email);
	}
	
	
	public void saveSMS(View v)
	{
		
		Toast.makeText(this, "sms", 1000).show();
		EditText et1= (EditText)findViewById(R.id.oneSMS);
		EditText et2= (EditText)findViewById(R.id.twoSMS);
		String event=et2.getText().toString();
		
		//if((et1.getText().toString()).equals("") || event.equals(""))
		//{
		//	Toast.makeText(this, "Please Fill All Details", 1000).show();

		//}
		//else
	//	{
		int phone= Integer.parseInt(et1.getText().toString());
	//	}
		
		if(on==false && tw==false && th==false && fo==false && fi==false && si==false)
		{
			Toast.makeText(AddEvent.this, "All False", 1000).show();
			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			saveToDbSMS("on",phone,event);

			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			//Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis() , pendingIntent);
			
//			saveToDbSMS("on",phone,event);
		}
		
		else if(on==true)
		{			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis() , pendingIntent);
			saveToDbSMS("on",phone,event);

		}
		
		else if(tw==true)
		{			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),3600000  , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat hourly", 1000).show();
			saveToDbSMS("tw",phone,event);

		}
		
		
		else if(th==true)
		{			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),86400000   , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat daily", 1000).show();
			saveToDbSMS("th",phone,event);

		}
		
		else if(fo==true)
		{			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),604800000    , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat weekly", 1000).show();
			saveToDbSMS("fo",phone,event);

		}
		
		else if(fi==true)
		{			String type="SMS";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat monthly", 1000).show();
			saveToDbSMS("fi",phone,event);

			
}
		
		else if(si==true)
		{
			String type="SMS";
			
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntent.putExtra("type", type);
			myIntent.putExtra("phone", phone);
			myIntent.putExtra("desc", event);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat yearly", 1000).show();
			saveToDbSMS("si",phone,event);

		}
		
		
		Intent i=new Intent(AddEvent.this, TimerTasks.class);
		startActivity(i);
	}
	
	public void selDateSMS(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.simple);
		dialog.setTitle("Select Date");
		final DatePicker dapi=(DatePicker)dialog.findViewById(R.id.dapiDP);
		Button dialogButton = (Button) dialog.findViewById(R.id.saveDP);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				year=dapi.getYear();
				month=dapi.getMonth()+1;
				
				day=dapi.getDayOfMonth();
				
				
				Toast.makeText(AddEvent.this, "Date Set: "+day+" /"+month+" /"+year, 1000).show();
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
		final Dialog dialogs = new Dialog(context);
		dialogs.setContentView(R.layout.simple_time);
		dialogs.setTitle("Select Time");
		final TimePicker tapi=(TimePicker)dialogs.findViewById(R.id.tapi);
		Button save = (Button) dialogs.findViewById(R.id.saveTPP);
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				hour=tapi.getCurrentHour();
				min=tapi.getCurrentMinute();

				Toast.makeText(AddEvent.this, "Time Set: "+hour+" : "+min, 1000).show();
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
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.rpt_events);
		dialog.setTitle("Repeatation Frequency");

		
		
		Button dialogButton = (Button) dialog.findViewById(R.id.saveFN);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
				
				one=(RadioButton)dialog.findViewById(R.id.one);
				two=(RadioButton)dialog.findViewById(R.id.two);
				three=(RadioButton)dialog.findViewById(R.id.three);
				four=(RadioButton)dialog.findViewById(R.id.four);
				five=(RadioButton)dialog.findViewById(R.id.five);
				six=(RadioButton)dialog.findViewById(R.id.six);
				
				
                int selectedId = rg.getCheckedRadioButtonId();
                
                switch(selectedId)
                {
                case R.id.one:
                	on=true;    				
					break;
                case R.id.two:
                	tw=true;    				
                	break;
                case R.id.three:
                	th=true;    				
    				break;
                case R.id.four:
                	fo=true;    				
    				break;
                case R.id.five:
                	fi=true;    				
    				break;
                case R.id.six:
                	si=true;    				
    				break;

                }
					  
					  
				
				
				
				Toast.makeText(AddEvent.this, ""+selectedId, 1000).show();
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


	public void saveToDbSMS(String radio,int phone, String event)
	{
		//Toast.makeText(this, ""+phone+""+event, 5000).show();

		DB_Helper db_helper_object= new DB_Helper(this);
		ContentValues content= new ContentValues();
		content.put(DB_Helper.TYPE, "sms");
		content.put(DB_Helper.PICTURE, R.drawable.ic_chat_bubble_black_48dp);
		content.put(DB_Helper.ONE, event);
		content.put(DB_Helper.TWO, "");
		content.put(DB_Helper.THREE, "");
		content.put(DB_Helper.PHONE_NO, phone);
		content.put(DB_Helper.RADIO, ""+day+"/"+month+"/"+year);
		content.put(DB_Helper.RADIO_VALUE, ""+hour+":"+min);
		content.put(DB_Helper.REPEAT, radio);
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		long id=sqlite.insert(DB_Helper.TABLE_NAME, null, content);
		
		if(id<0)
		{
			Toast.makeText(this, "Wrong", 1000).show();
		}
		else
		{
			Toast.makeText(this, "Right", 1000).show();

		}
				
		
		

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.PICTURE,DB_Helper.ONE, DB_Helper.PHONE_NO,
				DB_Helper.RADIO,DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
				
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
		StringBuffer sb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

			
		/*	cid= cursor.getInt(index_UID);
			type=cursor.getString(index_Type);
			pic=cursor.getString(index_Pic);
			oneddd=cursor.getString(index_One);
			phoneddd=cursor.getInt(index_Phone);
			radio=cursor.getString(index_Radio);
			radVal=cursor.getString(index_RadVal);
			repeat=cursor.getString(index_Repeat);

		
			sb.append(" "+cid+" "+type+" "+pic+" "+oneddd+""+phoneddd+""+radio+""+radVal+""+repeat+"\n");*/
		}
		//String prints=sb.toString();
		//Toast.makeText(this, prints, 5000).show();
		
		
		
		
	}
	
	
	
		
		

	
	
	
	



	public void saveCall(View v)
	{
	Toast.makeText(AddEvent.this, "Call", 1000).show();
	EditText et11= (EditText)findViewById(R.id.etEm2);
	EditText et22= (EditText)findViewById(R.id.etCall2);
	String event=et22.getText().toString();
	int phone= Integer.parseInt(et11.getText().toString());

	
	
	
	if(on==false && tw==false && th==false && fo==false && fi==false && si==false)
	{
		Toast.makeText(AddEvent.this, "All False", 1000).show();
		String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		saveToDbCal("on",phone,event);

		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		//Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis() , pendingIntent);
		
//		saveToDbSMS("on",phone,event);
	}
	
	else if(on==true)
	{			String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis() , pendingIntent);
		saveToDbCal("on",phone,event);

	}
	
	else if(tw==true)
	{			String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),3600000  , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat hourly", 1000).show();
		saveToDbCal("tw",phone,event);

	}
	
	
	else if(th==true)
	{			String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),86400000   , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat daily", 1000).show();
		saveToDbCal("th",phone,event);

	}
	
	else if(fo==true)
	{			String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),604800000    , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat weekly", 1000).show();
		saveToDbCal("fo",phone,event);

	}
	
	else if(fi==true)
	{			String type="Call";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat monthly", 1000).show();
		saveToDbCal("fi",phone,event);

		
}
	
	else if(si==true)
	{
		String type="Call";
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentC = new Intent(getBaseContext(), MyCallRec.class);
		myIntentC.putExtra("type", type);
		myIntentC.putExtra("phone", phone);
		myIntentC.putExtra("desc", event);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentC, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat yearly", 1000).show();
		saveToDbCal("si",phone,event);

	}
	
	
	Intent i=new Intent(AddEvent.this, TimerTasks.class);
	startActivity(i);
	}
	
	
	public void saveToDbCal(String rpt, int no, String eventa)
	{
		DB_Helper db_helper_object= new DB_Helper(this);
		ContentValues content= new ContentValues();
		content.put(DB_Helper.TYPE, "Call");
		content.put(DB_Helper.PICTURE, R.drawable.call);
		content.put(DB_Helper.ONE, eventa);
		content.put(DB_Helper.TWO, "");
		content.put(DB_Helper.THREE, "");
		content.put(DB_Helper.PHONE_NO, no);
		content.put(DB_Helper.RADIO, ""+day+"/"+month+"/"+year);
		content.put(DB_Helper.RADIO_VALUE, ""+hour+":"+min);
		content.put(DB_Helper.REPEAT, rpt);
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		long id=sqlite.insert(DB_Helper.TABLE_NAME, null, content);
		
		if(id<0)
		{
			Toast.makeText(this, "Wrong", 1000).show();
		}
		else
		{
			Toast.makeText(this, "Right", 1000).show();

		}
				
		
		

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.PICTURE,DB_Helper.ONE, DB_Helper.PHONE_NO,
				DB_Helper.RADIO,DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
				
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
		StringBuffer sb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

		}
	}

	public void selDatCal(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.simple);
		dialog.setTitle("Select Date");
		final DatePicker dapi=(DatePicker)dialog.findViewById(R.id.dapiDP);
		Button dialogButton = (Button) dialog.findViewById(R.id.saveDP);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				year=dapi.getYear();
				month=dapi.getMonth()+1;
				
				day=dapi.getDayOfMonth();
				
				
				Toast.makeText(AddEvent.this, "Date Set: "+day+" /"+month+" /"+year, 1000).show();
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

	public void repeatsCall(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.rpt_events);
		dialog.setTitle("Repeatation Frequency");

		
		
		Button dialogButton = (Button) dialog.findViewById(R.id.saveFN);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
				
				one=(RadioButton)dialog.findViewById(R.id.one);
				two=(RadioButton)dialog.findViewById(R.id.two);
				three=(RadioButton)dialog.findViewById(R.id.three);
				four=(RadioButton)dialog.findViewById(R.id.four);
				five=(RadioButton)dialog.findViewById(R.id.five);
				six=(RadioButton)dialog.findViewById(R.id.six);
				
				
                int selectedId = rg.getCheckedRadioButtonId();
                
                switch(selectedId)
                {
                case R.id.one:
                	on=true;    				
					break;
                case R.id.two:
                	tw=true;    				
                	break;
                case R.id.three:
                	th=true;    				
    				break;
                case R.id.four:
                	fo=true;    				
    				break;
                case R.id.five:
                	fi=true;    				
    				break;
                case R.id.six:
                	si=true;    				
    				break;

                }
					  
					  
				
				
				
				Toast.makeText(AddEvent.this, ""+selectedId, 1000).show();
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
	public void saveNot(View v)
	{
		Toast.makeText(this, "Not", 1000).show();
		EditText et1= (EditText)findViewById(R.id.oneNot);
		EditText et2= (EditText)findViewById(R.id.twoNot);
		String name=et1.getText().toString();
		String description=et2.getText().toString();
		
		
		if(on==false && tw==false && th==false && fo==false && fi==false && si==false)
		{
			Toast.makeText(AddEvent.this, "All False", 1000).show();
			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			saveToDbNot("on",name,description);

			Intent myIntentNot = new Intent(getBaseContext(), MyNotReceiver.class);
			//Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis() , pendingIntent);
			
//			saveToDbSMS("on",phone,event);
		}
		
		else if(on==true)
		{			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyNotReceiver.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis() , pendingIntent);
			saveToDbNot("on",name,description);

		}
		
		else if(tw==true)
		{			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyNotReceiver.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),3600000  , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat hourly", 1000).show();
			saveToDbNot("tw",name,description);

		}
		
		
		else if(th==true)
		{			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyNotReceiver.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),86400000   , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat daily", 1000).show();
			saveToDbNot("th",name,description);

		}
		
		else if(fo==true)
		{			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyNotReceiver.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),604800000    , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat weekly", 1000).show();
			saveToDbNot("fo",name,description);

		}
		
		else if(fi==true)
		{			String type="Notification";

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyEventReciever.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat monthly", 1000).show();
			saveToDbNot("fi",name,description);

			
}
		
		else if(si==true)
		{
			String type="Notification";
			
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month-1);
			calendar.set(Calendar.DAY_OF_MONTH, day);

			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, min);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			
			Intent myIntentNot = new Intent(getBaseContext(), MyEventReciever.class);
			myIntentNot.putExtra("type", type);
			myIntentNot.putExtra("name", name);
			myIntentNot.putExtra("desc", description);
			
			PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentNot, PendingIntent.FLAG_UPDATE_CURRENT);
			AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
			
			Toast.makeText(AddEvent.this, "Alarm set to repeat yearly", 1000).show();
			saveToDbNot("si",name,description);

		}
		
		
		Intent i=new Intent(AddEvent.this, TimerTasks.class);
		startActivity(i);

	}
	
	
	public void saveToDbNot(String rpt, String nam, String des)
	{
		DB_Helper db_helper_object= new DB_Helper(this);
		ContentValues content= new ContentValues();
		content.put(DB_Helper.TYPE, "Notification");
		content.put(DB_Helper.PICTURE, R.drawable.notify);
		content.put(DB_Helper.ONE, des);
		content.put(DB_Helper.TWO, des);
		content.put(DB_Helper.THREE, "");
		content.put(DB_Helper.PHONE_NO, nam);
		content.put(DB_Helper.RADIO, ""+day+"/"+month+"/"+year);
		content.put(DB_Helper.RADIO_VALUE, ""+hour+":"+min);
		content.put(DB_Helper.REPEAT, rpt);
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		long id=sqlite.insert(DB_Helper.TABLE_NAME, null, content);
		
		if(id<0)
		{
			Toast.makeText(this, "Wrong", 1000).show();
		}
		else
		{
			Toast.makeText(this, "Right", 1000).show();

		}
				
		
		

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.PICTURE,DB_Helper.ONE, DB_Helper.TWO,
				DB_Helper.RADIO,DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
				
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
		StringBuffer sb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

			
		/*	cid= cursor.getInt(index_UID);
			type=cursor.getString(index_Type);
			pic=cursor.getString(index_Pic);
			oneddd=cursor.getString(index_One);
			phoneddd=cursor.getInt(index_Phone);
			radio=cursor.getString(index_Radio);
			radVal=cursor.getString(index_RadVal);
			repeat=cursor.getString(index_Repeat);

		
			sb.append(" "+cid+" "+type+" "+pic+" "+oneddd+""+phoneddd+""+radio+""+radVal+""+repeat+"\n");*/
		}
		//String prints=sb.toString();
		//Toast.makeText(this, prints, 5000).show();
		
		
		
		
	}

	
	public void selDateNot(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.simple);
		dialog.setTitle("Select Date");
		final DatePicker dapi=(DatePicker)dialog.findViewById(R.id.dapiDP);
		Button dialogButton = (Button) dialog.findViewById(R.id.saveDP);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				year=dapi.getYear();
				month=dapi.getMonth()+1;
				
				day=dapi.getDayOfMonth();
				
				
				Toast.makeText(AddEvent.this, "Date Set: "+day+" /"+month+" /"+year, 1000).show();
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

	public void repeatsNot(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.rpt_events);
		dialog.setTitle("Repeatation Frequency");

		
		
		Button dialogButton = (Button) dialog.findViewById(R.id.saveFN);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
				
				one=(RadioButton)dialog.findViewById(R.id.one);
				two=(RadioButton)dialog.findViewById(R.id.two);
				three=(RadioButton)dialog.findViewById(R.id.three);
				four=(RadioButton)dialog.findViewById(R.id.four);
				five=(RadioButton)dialog.findViewById(R.id.five);
				six=(RadioButton)dialog.findViewById(R.id.six);
				
				
                int selectedId = rg.getCheckedRadioButtonId();
                
                switch(selectedId)
                {
                case R.id.one:
                	on=true;    				
					break;
                case R.id.two:
                	tw=true;    				
                	break;
                case R.id.three:
                	th=true;    				
    				break;
                case R.id.four:
                	fo=true;    				
    				break;
                case R.id.five:
                	fi=true;    				
    				break;
                case R.id.six:
                	si=true;    				
    				break;

                }
					  
					  
				
				
				
				Toast.makeText(AddEvent.this, ""+selectedId, 1000).show();
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
	public void saveEmail(View v)
	{
	Toast.makeText(AddEvent.this, "ema", 1000).show();
	EditText mail= (EditText)findViewById(R.id.etEm1);
	EditText sub= (EditText)findViewById(R.id.etEm2);
	EditText bod= (EditText)findViewById(R.id.etEm3);

	String email=mail.getText().toString();
	String subject=sub.getText().toString();
	String body=bod.getText().toString();
	
	
	if(on==false && tw==false && th==false && fo==false && fi==false && si==false)
	{
		Toast.makeText(AddEvent.this, "All False", 1000).show();
		String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		saveToDbEma("on",email,subject, body);

		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		//Intent myIntent = new Intent(getBaseContext(), MyEventReciever.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);
		
		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis() , pendingIntent);
		
//		saveToDbSMS("on",phone,event);
	}
	
	else if(on==true)
	{			String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis() , pendingIntent);
		saveToDbEma("on",email,subject,body);

	}
	
	else if(tw==true)
	{			String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),3600000  , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat hourly", 1000).show();
		saveToDbEma("tw",email,subject,body);

	}
	
	
	else if(th==true)
	{			String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),86400000   , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat daily", 1000).show();
		saveToDbEma("th",email,subject,body);

	}
	
	else if(fo==true)
	{			String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),604800000    , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat weekly", 1000).show();
		saveToDbEma("fo",email,subject,body);

	}
	
	else if(fi==true)
	{			String type="E-Mail";

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
	calendar.getTimeInMillis(), 2629746 *1000 , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat monthly", 1000).show();
		saveToDbEma("fi",email,subject,body);

		
}
	
	else if(si==true)
	{
		String type="E-Mail";
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		
		Intent myIntentE = new Intent(getBaseContext(), MyEmaRec.class);
		myIntentE.putExtra("type", type);
		myIntentE.putExtra("name", email);
		myIntentE.putExtra("desc", subject);
		myIntentE.putExtra("bod", body);

		PendingIntent pendingIntent= PendingIntent.getBroadcast(getBaseContext(),0, myIntentE, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
		calendar.getTimeInMillis(),31556952*1000    , pendingIntent);
		
		Toast.makeText(AddEvent.this, "Alarm set to repeat yearly", 1000).show();
		saveToDbEma("si",email,subject, body);

	}
	
	
	Intent i=new Intent(AddEvent.this, TimerTasks.class);
	startActivity(i);
	}
	
	public void saveToDbEma(String rpt,String em, String su, String bo)
	{
		DB_Helper db_helper_object= new DB_Helper(this);
		ContentValues content= new ContentValues();
		content.put(DB_Helper.TYPE, "Notification");
		content.put(DB_Helper.PICTURE, R.drawable.email);
		content.put(DB_Helper.ONE, su);
		content.put(DB_Helper.TWO, bo);
		content.put(DB_Helper.THREE, "");
		content.put(DB_Helper.PHONE_NO, em);
		content.put(DB_Helper.RADIO, ""+day+"/"+month+"/"+year);
		content.put(DB_Helper.RADIO_VALUE, ""+hour+":"+min);
		content.put(DB_Helper.REPEAT, rpt);
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		long id=sqlite.insert(DB_Helper.TABLE_NAME, null, content);
		
		if(id<0)
		{
			Toast.makeText(this, "Wrong", 1000).show();
		}
		else
		{
			Toast.makeText(this, "Right", 1000).show();

		}
				
		
		

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.PICTURE,DB_Helper.ONE, DB_Helper.TWO,
				DB_Helper.RADIO,DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
				
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
		StringBuffer sb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

			
		/*	cid= cursor.getInt(index_UID);
			type=cursor.getString(index_Type);
			pic=cursor.getString(index_Pic);
			oneddd=cursor.getString(index_One);
			phoneddd=cursor.getInt(index_Phone);
			radio=cursor.getString(index_Radio);
			radVal=cursor.getString(index_RadVal);
			repeat=cursor.getString(index_Repeat);

		
			sb.append(" "+cid+" "+type+" "+pic+" "+oneddd+""+phoneddd+""+radio+""+radVal+""+repeat+"\n");*/
		}
		//String prints=sb.toString();
		//Toast.makeText(this, prints, 5000).show();
		
		
	}

	public void selDatEma(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.simple);
		dialog.setTitle("Select Date");
		final DatePicker dapi=(DatePicker)dialog.findViewById(R.id.dapiDP);
		Button dialogButton = (Button) dialog.findViewById(R.id.saveDP);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				year=dapi.getYear();
				month=dapi.getMonth()+1;
				
				day=dapi.getDayOfMonth();
				
				
				Toast.makeText(AddEvent.this, "Date Set: "+day+" /"+month+" /"+year, 1000).show();
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

	public void repeatsEma(View v)
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.rpt_events);
		dialog.setTitle("Repeatation Frequency");

		
		
		Button dialogButton = (Button) dialog.findViewById(R.id.saveFN);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				rg=(RadioGroup)dialog.findViewById(R.id.rgRpt);
				
				one=(RadioButton)dialog.findViewById(R.id.one);
				two=(RadioButton)dialog.findViewById(R.id.two);
				three=(RadioButton)dialog.findViewById(R.id.three);
				four=(RadioButton)dialog.findViewById(R.id.four);
				five=(RadioButton)dialog.findViewById(R.id.five);
				six=(RadioButton)dialog.findViewById(R.id.six);
				
				
                int selectedId = rg.getCheckedRadioButtonId();
                
                switch(selectedId)
                {
                case R.id.one:
                	on=true;    				
					break;
                case R.id.two:
                	tw=true;    				
                	break;
                case R.id.three:
                	th=true;    				
    				break;
                case R.id.four:
                	fo=true;    				
    				break;
                case R.id.five:
                	fi=true;    				
    				break;
                case R.id.six:
                	si=true;    				
    				break;

                }
					  
					  
				
				
				
				Toast.makeText(AddEvent.this, ""+selectedId, 1000).show();
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
	
	
	
	
	
	
	
}
