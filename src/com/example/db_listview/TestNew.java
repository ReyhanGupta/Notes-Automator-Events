package com.example.db_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TestNew extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
//String what= getIntent().getExtras().getString("sleep");
//String meditation= getIntent().getExtras().getString("meditate");
/*
		if(what.equals("sleep"))
		{
			stopService(new Intent(TestNew.this, SleepService.class));
			Intent i= new Intent(TestNew.this, Sleep.class);
			startActivity(i);
		}
		*/
		
		//if(meditation.equals("meditate"))
		//{
		stopService(new Intent(TestNew.this, MeditationService.class));
		Intent i= new Intent(TestNew.this, Meditation.class);
		startActivity(i);
		//}

	}
	
	
	

}
