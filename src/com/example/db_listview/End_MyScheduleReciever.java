package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class End_MyScheduleReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		
		boolean wif=arg1.getExtras().getBoolean("wif");
		boolean bluet=arg1.getExtras().getBoolean("bluet");
		boolean mob=arg1.getExtras().getBoolean("mob");

		Intent i= new Intent(arg0, End_ProfileService.class);
		i.putExtra("wif", wif);
		i.putExtra("bluet", bluet);
		i.putExtra("mob", mob);

		arg0.startService(i);
	}

}
