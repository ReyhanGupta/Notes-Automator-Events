package com.example.db_listview;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class End_MeditationService extends Service{
View v;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
	//Meditation obj= new Meditation();
	//obj.pause(v);
		//MeditationService ms= new MeditationService();
		//ms.player.stop();
		//ms.stopSelf();
	    Intent it = new Intent(getApplicationContext(), MeditationService.class);
		stopService(it);
		Toast.makeText(this, "End", 1000).show();
        return START_NOT_STICKY;
    }


}
