package com.example.db_listview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Preferences extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//call();
		addPreferencesFromResource(R.xml.prefs);
		
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
			Toast.makeText(this,  "false", 1000).show();
	}
	
	
	

}
