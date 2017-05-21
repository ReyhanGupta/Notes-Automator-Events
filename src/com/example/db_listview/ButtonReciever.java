package com.example.db_listview;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ButtonReciever extends BroadcastReceiver{
	//Context context;

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
        int notificationId = arg1.getIntExtra("notificationId", 0);
        NotificationManager manager = (NotificationManager) arg0.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notificationId);
	}

}
