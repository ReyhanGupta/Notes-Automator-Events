package com.example.db_listview;

//import com.example.smartblurtoothchat.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyScheduledReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		boolean bluet=arg1.getExtras().getBoolean("bluet");
		boolean wif=arg1.getExtras().getBoolean("wif");
		boolean mob=arg1.getExtras().getBoolean("mob");
		boolean lou=arg1.getExtras().getBoolean("lou");
		boolean vib=arg1.getExtras().getBoolean("vib");
		boolean sil=arg1.getExtras().getBoolean("sil");
		boolean air=arg1.getExtras().getBoolean("air");
		boolean gps=arg1.getExtras().getBoolean("gps");
		boolean low=arg1.getExtras().getBoolean("low");
		boolean med=arg1.getExtras().getBoolean("med");
		boolean hig=arg1.getExtras().getBoolean("hig");

		Intent i= new Intent(arg0, ProfileService.class);
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


		arg0.startService(i);
	}

}
