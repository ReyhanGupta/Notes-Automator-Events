package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyEventReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		String type=arg1.getExtras().getString("type");
		int phone=arg1.getExtras().getInt("phone");
		String event=arg1.getExtras().getString("desc");
		
		
		Intent i= new Intent(arg0, EventService.class);
		i.putExtra("type", type);
		i.putExtra("phone", phone);
		i.putExtra("desc", event);
		
		arg0.startService(i);
	}

}
