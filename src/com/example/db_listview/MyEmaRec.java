package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyEmaRec extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String type=arg1.getExtras().getString("type");
		String email=arg1.getExtras().getString("name");
		String sub=arg1.getExtras().getString("desc");
		String bod=arg1.getExtras().getString("bod");
		
		Intent i= new Intent(arg0, EmailService.class);
		i.putExtra("type", type);
		i.putExtra("name", email);
		i.putExtra("desc", sub);
		i.putExtra("bod", bod);
		arg0.startService(i);
	}

}
