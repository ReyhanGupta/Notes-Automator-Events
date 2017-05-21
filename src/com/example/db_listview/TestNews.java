package com.example.db_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TestNews extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//String what= getIntent().getExtras().getString("sleep");
	//	String meditation= getIntent().getExtras().getString("meditate");

	//if(what.equals("sleep"))
	//	{
	//		startService(new Intent(TestNews.this, SleepService.class));
	//		Intent i= new Intent(TestNews.this, Sleep.class);
	//		startActivity(i);
	//	}
		
		
	//	if(meditation.equals("meditate"))
		//{

		startService(new Intent(TestNews.this, MeditationService.class));

		Intent i= new Intent(TestNews.this, Meditation.class);
		startActivity(i);
		//}
	}

}
