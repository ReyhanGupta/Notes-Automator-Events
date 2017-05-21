package com.example.db_listview;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Automator extends Activity {
RadioGroup select,Office, Sleep, None,Commute,Custom1, Custom2;
RadioButton radioButton;
View v;
final Context context=this;
SharedPreferences sharedpreferences;
public static final String MyPREFERENCES = "MyPrefs" ;
public static final String Name = "nameKey";
EditText ed1;
RadioButton homeR,officeR, sleepR, noneR,commuteR,custom1R,custom2R;
CheckBox one, two, three, four;
AudioManager audio;
Intent myIntent;
PendingIntent pendingIntent;
AlarmManager alarmManager; 
Switch bluetooth,wifi, mobile,loud,vibrate, silent,airplane,GPS,bloww,bmedd,bhighh;
boolean bluet,wif,mob,lou, vib, sil,air,gps,low,med,hig;

int mon, tue, wed, thu, fri, sat, sun, non;
int wifiS=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profiles2);
		 
		select=(RadioGroup)findViewById(R.id.rg);
		Office=(RadioGroup)findViewById(R.id.rgOffice);
		Sleep=(RadioGroup)findViewById(R.id.rgSleep);
		None=(RadioGroup)findViewById(R.id.rgNone);
		Commute=(RadioGroup)findViewById(R.id.rgCommute);
		Custom1=(RadioGroup)findViewById(R.id.rgCustom1);
	//	Custom2=(RadioGroup)findViewById(R.id.rgCustom2);

		
		homeR=(RadioButton)findViewById(R.id.Home);
		officeR=(RadioButton)findViewById(R.id.Office);
		sleepR=(RadioButton)findViewById(R.id.Sleep);
		noneR=(RadioButton)findViewById(R.id.None);
		commuteR=(RadioButton)findViewById(R.id.Commute);
		custom1R=(RadioButton)findViewById(R.id.Custom1);
	//	custom2R=(RadioButton)findViewById(R.id.Custom2);


		
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	    alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		load();
		
		  
		  
		  
		  bluetooth=(Switch)findViewById(R.id.bluetooth);
		  wifi=(Switch)findViewById(R.id.wifi);
		  mobile=(Switch)findViewById(R.id.mobile);
		  loud=(Switch)findViewById(R.id.loud);
		  vibrate=(Switch)findViewById(R.id.vibrate);
		  silent=(Switch)findViewById(R.id.silent);
		  airplane=(Switch)findViewById(R.id.airplane);
		  GPS=(Switch)findViewById(R.id.gps);
		  bloww=(Switch)findViewById(R.id.blow);
		  bmedd=(Switch)findViewById(R.id.bmed);
		  bhighh=(Switch)findViewById(R.id.bhigh);

		  
		  
		  // PERFORM DIFFERENT ACTIONS WHEN USER SELECTS DIFFERENT RADIO GROUPS
		  
		  
		  
		  select.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				

				switch (arg1) {
				case R.id.Home:
					if(homeR.isChecked())
					{
				profileSel_Home();
					}
					else
					{
						
					}
					break;
			
				default:
					break;
			}
			}	});
		  
		  
		  
		
		  Office.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				
				switch (arg1) {
				case R.id.Office:
					if(officeR.isChecked())
					{
				profileSel_Office();
					}
					else
					{
						
					}
					break;
			
				default:
					break;
			}
				}
				
			
		});
		  
		  
		 
		  
		  
		  Sleep.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					switch (arg1) {
					case R.id.Sleep:
						if(sleepR.isChecked())
						{
					profileSel_Sleep();
						}
						else
						{
							
						}
						break;
				
					default:
						break;
				}
				}
			});
		  
		  Commute.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					switch (arg1) {
					case R.id.Commute:
						if(commuteR.isChecked())
						{
					profileSel_Commute();
						}
						else
						{
							
						}
						break;
				
					default:
						break;
				}
				}
			});
		  
		  
		  
		  Custom1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					switch (arg1) {
					case R.id.Custom1:
						if(custom1R.isChecked())
						{
					profileSel_Custom1();
						}
						else
						{
							
						}
						break;
				
					default:
						break;
				}
				}
			});
		  
		  
		 /* Custom2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					switch (arg1) {
					case R.id.Custom2:
						if(custom2R.isChecked())
						{
					profileSel_Custom2();
						}
						else
						{
							
						}
						break;
				
					default:
						break;
				}
				}
			});
		  */
		  
		  
		  
		  None.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub
					
					switch (arg1) {
					case R.id.None:
						Toast.makeText(Automator.this, "None", 1000);
						Sleep.clearCheck();
						Office.clearCheck();
						select.clearCheck();
						None.clearCheck();
						Commute.clearCheck();
						Custom1.clearCheck();
						//Custom2.clearCheck();
						break;

					default:
						break;
					}
					
				}
			});
	
		  }
	
	       public void start() {
		// TODO Auto-generated method stub
	    	   
	    	   
		
	}


public void music(View v)
{
	Intent x=new Intent(Automator.this, Music_Select.class);
	startActivity(x);
}




// WHAT TO SAVE AFTER USER HITS SAVE

public void deselect()
{
	RadioButton HO= (RadioButton)select.findViewById(R.id.Home);

	 HO.setChecked(false);
}
		public void profileSelect(View v)
	       {
	    	   SharedPreferences.Editor editor = sharedpreferences.edit();
	    	   int selectedId = select.getCheckedRadioButtonId();
	    	   int officeId= Office.getCheckedRadioButtonId();
	    	   int sleepId= Sleep.getCheckedRadioButtonId();
	    	   int noneId= None.getCheckedRadioButtonId();
	    	   int commuteId=Commute.getCheckedRadioButtonId();
	    	   int custome1Id=Custom1.getCheckedRadioButtonId();
	    	 //  int custome2Id=Custom2.getCheckedRadioButtonId();

	    	   
	    	   
	    	   editor.putInt("Key", selectedId);
	    	   editor.putInt("office", officeId);
	    	   editor.putInt("sleep", sleepId);
	    	   editor.putInt("none", noneId);
	    	   editor.putInt("commute", commuteId);
	    	   editor.putInt("custom1", custome1Id);
	    	  // editor.putInt("custom2", custome2Id);

	           editor.commit();
	          
	    	   }
	    	   

		
		
		
		
		
// WHAT TO LOAD WHEN ACTIVITY STARTS
	
	
	public void load()
	{
		RadioButton HO= (RadioButton)select.findViewById(R.id.Home);
		int selected= sharedpreferences.getInt("Key", 0);
		if(selected>0)
		{
			 HO.setChecked(true);
			//radioButton = (RadioButton)select. findViewById(selected);
			//int yy= radioButton.getId();
			//Toast.makeText(Automator.this,"yy=  "+yy, 1000).show();
		    //radioButton.setChecked(true);
		}
		//else
	//	{
		//	 Toast.makeText(Automator.this,"works not", 1000).show();
		//}
		
		RadioButton OF= (RadioButton)Office.findViewById(R.id.Office);
		int office= sharedpreferences.getInt("office", 0);
		if(office>0)
		{
			OF.setChecked(true);
			//RadioButton radioButtonO = (RadioButton)Office. findViewById(office);
		 //radioButtonO.setChecked(true);
		}
		RadioButton SL= (RadioButton)Sleep.findViewById(R.id.Sleep);
		int sleep= sharedpreferences.getInt("sleep", 0);
		if(sleep>0)
		{
			//RadioButton radioButtonS = (RadioButton)Sleep. findViewById(sleep);
		 SL.setChecked(true);
		}
		
		RadioButton CO= (RadioButton)Commute.findViewById(R.id.Commute);
		int commute= sharedpreferences.getInt("commute", 0);
		if(commute>0)
		{
			//RadioButton radioButtonS = (RadioButton)Sleep. findViewById(sleep);
		 CO.setChecked(true);
		}
		
		RadioButton CU1= (RadioButton)Custom1.findViewById(R.id.Custom1);
		int custom11= sharedpreferences.getInt("custom1", 0);
		if(custom11>0)
		{
			//RadioButton radioButtonS = (RadioButton)Sleep. findViewById(sleep);
		 CU1.setChecked(true);
		}
		
		//RadioButton CU2= (RadioButton)Custom2.findViewById(R.id.Custom2);
		//int custom22= sharedpreferences.getInt("custom2", 0);
		//if(custom22>0)
		//{
			//RadioButton radioButtonS = (RadioButton)Sleep. findViewById(sleep);
		// CU2.setChecked(true);
		//}
		
		
		RadioButton NO= (RadioButton)None.findViewById(R.id.None);
		int noneS= sharedpreferences.getInt("none", 0);
		if(noneS>0)
		{
			//RadioButton radioButtonN = (RadioButton)None. findViewById(noneS);
		 NO.setChecked(true);
		NO.setChecked(false);
		}
		
	}

	
	/*public void profileSel_Custom2()
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Commute Profile");
		
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.edits);
		
		Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		 

			Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			Button Save=(Button)dialog.findViewById(R.id.saves);
			Save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					profileSelect(v);
					Intent i= new Intent(Automator.this, AutomatorNew.class);
					i.putExtra("bluet", bluet);
					i.putExtra("wif", wif);
					i.putExtra("mob", mob);
					i.putExtra("lou", lou);
					i.putExtra("vib", vib);
					i.putExtra("sil", sil);
					i.putExtra("air", air);
					i.putExtra("gps", gps);
					i.putExtra("low", low);
					i.putExtra("med", med);
					i.putExtra("hig", hig);


					startActivity(i);
				}
			});
			
			dialog.show();
		
	}*/
	
	public void profileSel_Custom1()
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Commute Profile");
		
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.edits);
		
		Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		 

			Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			Button Save=(Button)dialog.findViewById(R.id.saves);
			Save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					profileSelect(v);
					Intent i= new Intent(Automator.this, AutomatorNew.class);
					i.putExtra("bluet", bluet);
					i.putExtra("wif", wif);
					i.putExtra("mob", mob);
					i.putExtra("lou", lou);
					i.putExtra("vib", vib);
					i.putExtra("sil", sil);
					i.putExtra("air", air);
					i.putExtra("gps", gps);
					i.putExtra("low", low);
					i.putExtra("med", med);
					i.putExtra("hig", hig);


					startActivity(i);
					
					dialog.dismiss();

				}
			});
			
			dialog.show();
		
	}
	
	public void profileSel_Commute()
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Commute Profile");
		
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.car);
		
		Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		 

			Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			Button Save=(Button)dialog.findViewById(R.id.saves);
			Save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					profileSelect(v);
					Intent i= new Intent(Automator.this, AutomatorNew.class);
					i.putExtra("bluet", bluet);
					i.putExtra("wif", wif);
					i.putExtra("mob", mob);
					i.putExtra("lou", lou);
					i.putExtra("vib", vib);
					i.putExtra("sil", sil);
					i.putExtra("air", air);
					i.putExtra("gps", gps);
					i.putExtra("low", low);
					i.putExtra("med", med);
					i.putExtra("hig", hig);


					startActivity(i);
					
					dialog.dismiss();

				}
			});
			
			dialog.show();
		
		
	}
	
	public void profileSel_Sleep()
	
	
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Sleep Profile");
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.sleeping);
		
		Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		 

			Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			Button Save=(Button)dialog.findViewById(R.id.saves);
			Save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					profileSelect(v);
					Intent i= new Intent(Automator.this, AutomatorNew.class);
					i.putExtra("bluet", bluet);
					i.putExtra("wif", wif);
					i.putExtra("mob", mob);
					i.putExtra("lou", lou);
					i.putExtra("vib", vib);
					i.putExtra("sil", sil);
					i.putExtra("air", air);
					i.putExtra("gps", gps);
					i.putExtra("low", low);
					i.putExtra("med", med);
					i.putExtra("hig", hig);


					startActivity(i);
					
					dialog.dismiss();

				}
			});
			
			dialog.show();

		 
	}
	
	
	// DIALOGS AND SAVE BUTTON FUNCTIONS
	
	public void profileSel_Office()
	{
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Office Profile");
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.work);
		
		 Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		  

			Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			Button Save=(Button)dialog.findViewById(R.id.saves);
			Save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					profileSelect(v);
					Intent i= new Intent(Automator.this, AutomatorNew.class);
					i.putExtra("bluet", bluet);
					i.putExtra("wif", wif);
					i.putExtra("mob", mob);
					i.putExtra("lou", lou);
					i.putExtra("vib", vib);
					i.putExtra("sil", sil);
					i.putExtra("air", air);
					i.putExtra("gps", gps);
					i.putExtra("low", low);
					i.putExtra("med", med);
					i.putExtra("hig", hig);


					startActivity(i);
					
					dialog.dismiss();

				}
			});
			
			dialog.show();

	}
	
	public void profileSel_Home()
	{
		
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.profile_dialog);
		dialog.setTitle("Home Profile");

		// set the custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Select Options");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.house);
		
		 Switch bhighh=(Switch)dialog.findViewById(R.id.bhigh);
		 bhighh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		hig=true;
			    	}
			    	else
			    	{
			    		hig=false;

			    	}
			    }
			});
		
		 Switch bmedd=(Switch)dialog.findViewById(R.id.bmed);
		 bmedd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		med=true;
			    	}
			    	else
			    	{
			    		med=false;

			    	}
			    }
			});
		
		 Switch bloww=(Switch)dialog.findViewById(R.id.blow);
		 bloww.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		low=true;
			    	}
			    	else
			    	{
			    		low=false;

			    	}
			    }
			});
		
		 Switch GPS=(Switch)dialog.findViewById(R.id.gps);
		 GPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		gps=true;
			    	}
			    	else
			    	{
			    		gps=false;

			    	}
			    }
			});
		
		 Switch airplane=(Switch)dialog.findViewById(R.id.airplane);
		 airplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		air=true;
			    	}
			    	else
			    	{
			    		air=false;

			    	}
			    }
			});
		
		 Switch silent=(Switch)dialog.findViewById(R.id.silent);
		 silent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		sil=true;
			    	}
			    	else
			    	{
			    		sil=false;

			    	}
			    }
			});
		
		
		 Switch vibrate=(Switch)dialog.findViewById(R.id.vibrate);
		 vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		vib=true;
			    	}
			    	else
			    	{
			    		vib=false;

			    	}
			    }
			});
		
		
		Switch loud=(Switch)dialog.findViewById(R.id.loud);
		 loud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		lou=true;
			    	}
			    	else
			    	{
			    		lou=false;

			    	}
			    }
			});
		
		
		 Switch mobile=(Switch)dialog.findViewById(R.id.mobile);
		 mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    	mob=true;
			    	}
			    	else
			    	{
			    		mob=false;

			    	}
			    }
			});
		
		
		 Switch wifi=(Switch)dialog.findViewById(R.id.wifi);
		 wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		wif=true;
			    	}
			    	else
			    	{
			    		wif=false;

			    	}
			    }
			});
		
		 Switch bluetooth=(Switch)dialog.findViewById(R.id.bluetooth);
		
		  
		  
		 bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    	
			    	if(isChecked==true)
			    	{
			    		bluet=true;
			    	}
			    	else
			    	{
			    		bluet=false;

			    	}
			    }
			});
		  
		  
		
		Button dialogButton = (Button) dialog.findViewById(R.id.cancel);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		Button Save=(Button)dialog.findViewById(R.id.saves);
		Save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				profileSelect(v);
				Intent i= new Intent(Automator.this, AutomatorNew.class);
				i.putExtra("bluet", bluet);
				i.putExtra("wif", wif);
				i.putExtra("mob", mob);
				i.putExtra("lou", lou);
				i.putExtra("vib", vib);
				i.putExtra("sil", sil);
				i.putExtra("air", air);
				i.putExtra("gps", gps);
				i.putExtra("low", low);
				i.putExtra("med", med);
				i.putExtra("hig", hig);


				startActivity(i);
				
				dialog.dismiss();

			}
		});
		
		dialog.show();
		
		/*		final Dialog dialogs = new Dialog(context);
				dialogs.setContentView(R.layout.repeat);
//				CheckBox Monday= (CheckBox)dialogs.findViewById(R.id.Monday);
				dialogs.setTitle("Select Days");
				
				
			
				

				// set the custom dialog components - text, image and button
				//TextView text = (TextView) dialogs.findViewById(R.id.text);
				//text.setText("Android custom dialog example!");
				//ImageView image = (ImageView) dialogs.findViewById(R.id.image);
				//image.setImageResource(R.drawable.home);

				
				
				
				
				
				
				Button bSave = (Button) dialogs.findViewById(R.id.saveDay);
				bSave.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						Toast.makeText(Automator.this, "SAVE", 1000).show();
						profileSelect(v);
						final Dialog dialogTime = new Dialog(context);
						dialogTime.setContentView(R.layout.time_select);
						dialogTime.setTitle("Start Time");
						
						
						
						RadioGroup Monday= (RadioGroup)dialogs.findViewById(R.id.radioMon);
						RadioGroup Tuesday= (RadioGroup)dialogs.findViewById(R.id.radioTue);
						RadioGroup Wednesday= (RadioGroup)dialogs.findViewById(R.id.radioWed);
						RadioGroup Thursday= (RadioGroup)dialogs.findViewById(R.id.radioThu);
						RadioGroup Friday= (RadioGroup)dialogs.findViewById(R.id.radioFri);
						RadioGroup Saturday= (RadioGroup)dialogs.findViewById(R.id.radioSat);
						RadioGroup Sunday= (RadioGroup)dialogs.findViewById(R.id.radioSun);
						RadioGroup Nones= (RadioGroup)dialogs.findViewById(R.id.radioNon);
						
						
						
						if (Monday.getCheckedRadioButtonId() != -1)
						{
							Toast.makeText(Automator.this, "Monday", 1000).show();
						}
						else
						{
							Toast.makeText(Automator.this, "Monday", 1000).show();
						}
							
						if(Nones.isSelected())
						{
//							Monday.set;
//							Tuesday.setChecked(false);
//							Wednesday.setChecked(false);
//							Thursday.setChecked(false);
//							Friday.setChecked(false);
//							Saturday.setChecked(false);
//							Sunday.setChecked(false);
//							Nones.setChecked(false);
							Toast.makeText(Automator.this, "Monday", 1000).show();
						}

						// set the custom dialog components - text, image and button
						//TextView text = (TextView) dialogs.findViewById(R.id.text);
						//text.setText("Android custom dialog example!");
						//ImageView image = (ImageView) dialogs.findViewById(R.id.image);
						//image.setImageResource(R.drawable.home);

						
						
						
						
					Button bSavetr = (Button) dialogTime.findViewById(R.id.saveTime);
						bSavetr.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
								
								
								
								profileSelect(v);
								final Dialog dialog2 = new Dialog(context);
								dialog2.setContentView(R.layout.time_select2);
								dialog2.setTitle("End Time");

								// set the custom dialog components - text, image and button
								//TextView text = (TextView) dialogs.findViewById(R.id.text);
								//text.setText("Android custom dialog example!");
								//ImageView image = (ImageView) dialogs.findViewById(R.id.image);
								//image.setImageResource(R.drawable.home);

								Button bSave2 = (Button) dialog2.findViewById(R.id.save2);
								bSave2.setOnClickListener(new OnClickListener() {
									
									@Override
									public void onClick(View arg0) {
										// TODO Auto-generated method stub
										Toast.makeText(Automator.this, "save2 time", 1000).show();
									}
								});
								
								Button bCan2 = (Button) dialog2.findViewById(R.id.cancel2);
								bCan2.setOnClickListener(new OnClickListener() {
									
									@Override
									public void onClick(View arg0) {
										// TODO Auto-generated method stub
										dialog2.dismiss();
									}
								});
								
								
								dialog2.show();
								
								
								
								
								
								
								
								
							}
						});
						Button bCan = (Button) dialogTime.findViewById(R.id.cancelTime1);
						bCan.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
								dialogTime.dismiss();
								
								
							}
						});
						
						dialogTime.show();
						
						
						
						
					}
				});
				
				Button cancels=(Button) dialogs.findViewById(R.id.CancelDay);
				cancels.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						dialogs.dismiss();
					}
				});
				
				
				profileSelect(v);
				dialogs.show();
				
				//dialog.dismiss();
			}
		});

		dialog.show();
	
	  }*/
	
	
}}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


