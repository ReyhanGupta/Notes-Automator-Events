package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyNotReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String type=arg1.getExtras().getString("type");
		String name=arg1.getExtras().getString("name");
		String desc=arg1.getExtras().getString("desc");
		
		
		Intent i= new Intent(arg0, NotService.class);
		i.putExtra("type", type);
		i.putExtra("name", name);
		i.putExtra("desc", desc);
		
		arg0.startService(i);
	}

}
