package com.example.db_listview;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Meditation_AutomatorNew extends Activity{
	RadioGroup Monday, Tuesday,Wednesday, Thursday, Friday, Saturday, Sunday, Nones;
	RadioButton mon, tue, wed, thu, fri, sat, sun, non;
	View v;
	SharedPreferences sharedMeditation;
	Context context;
	long interval;
	Calendar cals;
	public static final String MyPREFERENCES = "MyPrefs_Meditation" ;
	boolean monSel, tueSel, wedSel, thuSel, friSel, satSel, sunSel;
	int i=0;
	Rpt_Time obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repeat2);
		
		Monday= (RadioGroup)findViewById(R.id.radioMon);
		Tuesday= (RadioGroup)findViewById(R.id.radioTue);
		Wednesday= (RadioGroup)findViewById(R.id.radioWed);
		Thursday= (RadioGroup)findViewById(R.id.radioThu);
		Friday= (RadioGroup)findViewById(R.id.radioFri);
		Saturday= (RadioGroup)findViewById(R.id.radioSat);
		Sunday= (RadioGroup)findViewById(R.id.radioSun);
		Nones= (RadioGroup)findViewById(R.id.radioNon);
		
		
		
		mon= (RadioButton)findViewById(R.id.Mondays);
		tue= (RadioButton)findViewById(R.id.Tuesday);
		wed= (RadioButton)findViewById(R.id.Wednesday);
		thu= (RadioButton)findViewById(R.id.Thursdays);
		fri= (RadioButton)findViewById(R.id.Friday);
		sat= (RadioButton)findViewById(R.id.Saturday);
		sun= (RadioButton)findViewById(R.id.Sunday);
		non= (RadioButton)findViewById(R.id.Nones);

		sharedMeditation = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	
		load();
		
		

		  Monday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Mondays:
					
					if(mon.isChecked())
					{
						monSel=true;
					}
					else
					{
				 	   // Toast.makeText(AutomatorNew.this,"Mon deselcted",Toast.LENGTH_LONG).show();
						monSel=false;
					}

					break;
			
				default:
					break;
			}
			}	});
		  
		  

		  
		  Tuesday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Tuesday:
						tueSel=true;
					break;
			
				default:
					break;
			}
			}	});
		  

		  
		  Wednesday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Wednesday:
						wedSel=true;
					break;
			
				default:
					break;
			}
			}	});

		  
		  Thursday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Thursdays:
						thuSel=true;
					break;
			
				default:
					break;
			}
			}	});

		  
		  Friday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Friday:
						friSel=true;
					break;
			
				default:
					break;
			}
			}	});

		  
		  Saturday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Saturday:
						satSel=true;
					break;
			
				default:
					break;
			}
			}	});

		  
		  Sunday.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Sunday:
						sunSel=true;
					break;
			
				default:
					break;
			}
			}	});

		  
		
		  
		  Nones.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					
					switch (arg1) {
					case R.id.Nones:
						Toast.makeText(Meditation_AutomatorNew.this, "None", 1000).show();
						Monday.clearCheck();
						Tuesday.clearCheck();
						Wednesday.clearCheck();
						Thursday.clearCheck();
						Friday.clearCheck();
						Saturday.clearCheck();
						Sunday.clearCheck();
						
						
						Nones.clearCheck();
						break;

					default:
						break;
					}
					
				}
			});
	
		
	}
	
	public void profileSelect()
    {
 	//   String n  = ed1.getText().toString();
			 SharedPreferences.Editor editorMeditation = sharedMeditation.edit();
			 int monId = Monday.getCheckedRadioButtonId();
 
 	   int nonId=Nones.getCheckedRadioButtonId();
 	  editorMeditation.putInt("monday", monId);
 	
 	  editorMeditation.putInt("none", nonId);
 	  editorMeditation.commit();
 	    Toast.makeText(Meditation_AutomatorNew.this,"Thanks",Toast.LENGTH_LONG).show();
 		
 	   }
	
	

	private void load() {
		// TODO Auto-generated method stub
		
		RadioButton MO= (RadioButton)Monday.findViewById(R.id.Mondays);
			int selected= sharedMeditation.getInt("monday", 0);
		// Toast.makeText(Automator.this,"This is : "+selected, 1000).show();
		
		 
		  
			 if(selected>0)
		{
			 Toast.makeText(Meditation_AutomatorNew.this,"Inside toast with  "+selected, 1000).show();
			 MO.setChecked(true);
			
		}
			 RadioButton TU= (RadioButton)findViewById(R.id.Tuesday);
				int tues= sharedMeditation.getInt("tuesday", 0);
				if(tues>0)
				{
					TU.setChecked(true);
					
				}
				
				
				RadioButton WE= (RadioButton)findViewById(R.id.Wednesday);
				int wedn= sharedMeditation.getInt("wednesday", 0);
				if(wedn>0)
				{
				 WE.setChecked(true);
				}
				
				
				RadioButton TH= (RadioButton)findViewById(R.id.Thursdays);
				int thur= sharedMeditation.getInt("thursday", 0);
				if(thur>0)
				{
				 TH.setChecked(true);
				}
				
				
				
				RadioButton FR= (RadioButton)findViewById(R.id.Friday);
				int frid= sharedMeditation.getInt("friday", 0);
				if(frid>0)
				{
				 FR.setChecked(true);
				}
				
				
				
				RadioButton SA= (RadioButton)findViewById(R.id.Saturday);
				int satu= sharedMeditation.getInt("saturday", 0);
				if(satu>0)
				{
				 SA.setChecked(true);
				}
				
				
				
				RadioButton SU= (RadioButton)findViewById(R.id.Sunday);
				int sund= sharedMeditation.getInt("sunday", 0);
				if(sund>0)
				{
				 SU.setChecked(true);
				}
				

		
		RadioButton NO= (RadioButton)findViewById(R.id.Nones);
		int nonea= sharedMeditation.getInt("none", 0);
		if(nonea>0)
		{
		 NO.setChecked(false);
		}
		
		
	}
	
	
	
	public void saveDay(View v)
	{
		
	   SharedPreferences.Editor editorMeditation = sharedMeditation.edit();
	   int monId = Monday.getCheckedRadioButtonId();
	   int tueId= Tuesday.getCheckedRadioButtonId();
	   int wedId= Wednesday.getCheckedRadioButtonId();
 	   int thuId=Thursday.getCheckedRadioButtonId();
 	   int friId=Friday.getCheckedRadioButtonId();
 	   int satId=Saturday.getCheckedRadioButtonId();
 	   int sunId=Sunday.getCheckedRadioButtonId();
	   int nonId=Nones.getCheckedRadioButtonId();

	   
	
	   
	   editorMeditation.putInt("monday", monId);
	   editorMeditation.putInt("tuesday", tueId);
	   editorMeditation.putInt("wednesday", wedId);
	   editorMeditation.putInt("thursday", thuId);
	   editorMeditation.putInt("friday", friId);
	   editorMeditation.putInt("saturday", satId);
	   editorMeditation.putInt("sunday", sunId);

	  editorMeditation.putInt("none", nonId);
	  editorMeditation.commit();
	  Intent i= new Intent(Meditation_AutomatorNew.this, Meditation_Rpt_Time.class);
	  
		
	  
	  if(mon.isChecked())
		{ 
																
			monSel=true;
			i.putExtra("mon", monSel);
		}
		else
		{
			monSel=false;
			i.putExtra("mon", monSel);
		}
		
		
		
		if(tue.isChecked())
		{ 
																
			tueSel=true;
			i.putExtra("tue", tueSel);
		}
		else
		{
			tueSel=false;
			i.putExtra("tue", tueSel);
		}	
		
		
		
		
		if(wed.isChecked())
		{ 
																
			wedSel=true;
			i.putExtra("wed", wedSel);
		}
		else
		{
			wedSel=false;
			i.putExtra("wed", wedSel);
		}	
		
		
		
		if(thu.isChecked())
		{ 
																
			thuSel=true;
			i.putExtra("thu", thuSel);
		}
		else
		{
			thuSel=false;
			i.putExtra("thu", thuSel);
		}	
		
		
		
		if(fri.isChecked())
		{ 
																
			friSel=true;
			i.putExtra("fri", friSel);
		}
		else
		{
			friSel=false;
			i.putExtra("fri", friSel);
		}	
		
		
		
		if(sat.isChecked())
		{ 
																
			satSel=true;
			i.putExtra("sat", satSel);
		}
		else
		{
			satSel=false;
			i.putExtra("sat", satSel);
		}	
		
		
		
		if(sun.isChecked())
		{ 
																
			sunSel=true;
			i.putExtra("sun", sunSel);
		}
		else
		{
			sunSel=false;
			i.putExtra("sun", sunSel);
		}
		
		
	
		i.putExtra("ints", interval);
		startActivity(i);
		finish();
		
	}
	
	public void CancelDay (View v)
	{
		Intent ii= new Intent(Meditation_AutomatorNew.this, Music_Select.class);
		startActivity(ii);
	}
	

}
