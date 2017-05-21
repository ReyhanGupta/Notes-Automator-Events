package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

public class Alert extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		createNotification(arg0, "ToDO Alarm", "Click TO View More", "Alert");
	}

	private void createNotification(Context arg0, String msg,
			String msgText, String msgAlert) {
		// TODO Auto-generated method stub
		PendingIntent notifIntent= PendingIntent.getActivity(arg0, 0, new Intent(arg0,Remind.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(arg0)
		.setSmallIcon(R.drawable.td)
		.setContentTitle("ToDO Alarm")
		.setContentText("Click TO View More")
		.setTicker("ToDO Alarm").setContentIntent(notifIntent);
		
		mBuilder.setContentIntent(notifIntent);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		NotificationManager mNot= (NotificationManager)arg0.getSystemService(Context.NOTIFICATION_SERVICE);
		mNot.notify(1, mBuilder.build());
		
				
		
		
	}

}
