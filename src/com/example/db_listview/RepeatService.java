package com.example.db_listview;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.view.View;

public class RepeatService extends android.app.Service{
View v;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		Rpt_Time obj= new Rpt_Time();
		obj.test();
        return START_NOT_STICKY;
    }


}
