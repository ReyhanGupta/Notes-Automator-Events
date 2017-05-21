package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Meditation_ScheduledReciever extends BroadcastReceiver{
	

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		
		Intent i= new Intent(arg0, MeditationService.class);
		//i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		arg0.startService(i);
	}

}
